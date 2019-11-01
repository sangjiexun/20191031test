package net.chintai.backend.sysadmin.crnwl.controller.shop_bukken;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import jp.co.interoffice.util.Utils;
import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.session.SessionBean;
import net.chintai.backend.sysadmin.common.session.SessionBeanManager;
import net.chintai.backend.sysadmin.crnwl.controller.support.BaseController;
import net.chintai.backend.sysadmin.crnwl.dto.Shop;
import net.chintai.backend.sysadmin.crnwl.exception.InProcessingException;
import net.chintai.backend.sysadmin.crnwl.form.shop_bukken.ShopApprovalUpdateForm;
import net.chintai.backend.sysadmin.crnwl.service.MasterService;
import net.chintai.backend.sysadmin.crnwl.service.ShopService;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.batch.common.domain.MstArea;
import net.chintai.batch.common.domain.MstCity;
import net.chintai.batch.common.domain.MstEki;
import net.chintai.batch.common.domain.MstEnsen;
import net.chintai.batch.common.domain.MstPref;
import net.chintai.batch.common.domain.MstRendo;
import net.chintai.batch.common.domain.ShopRireki;
import net.chintai.batch.common.domain.ShopRirekiEki;
import net.chintai.batch.common.domain.VAspGroupShop;
import net.chintai.batch.common.domain.VShopKeiyakuDetail;
import net.chintai.batch.common.service.MailService;
import net.chintai.batch.common.util.CryptUtils;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

/**
 * <pre>
 * ShopApprovalUpdateController
 * </pre>
 * @author hasegawa
 * @lastModified $Date: 2017-06-23 16:45:23 +0900 (金, 23 6 2017) $ by $Author: hiromaru.yoshii $
 * @version $Revision: 7641 $
 * @since 1.0
 */
@Controller
@RequestMapping(value = "/shop_bukken")
public class ShopApprovalUpdateController extends BaseController {
	@Autowired
	private ShopService shopService;

    @Autowired
    private MasterService masterService;

    @Autowired
    private MailService mailService;

    private static final String MAILCD_SHOP_APPROVAL = "SHOP_APPROVAL";

	/**
	 * @param input
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "ShopApprovalUpdate.admin", method = RequestMethod.GET)
	public ModelAndView get(final ShopApprovalUpdateForm input, final HttpServletRequest request,
			final HttpServletResponse response) {
		final ModelAndView mv = new ModelAndView();
		final ShopRireki shopRireki = this.shopService.selectShopRirekiByShopcd(input.getShopcd());
		input.setCertifyFlg(shopRireki.getCertifyFlg());
		input.setShopKanriUpdDt(this.shopService.selectShopKanriByPrimaryKey(input.getShopcd()).getUpdDt());
		return mv;
	}

	/**
	 * @param input
	 * @param result
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "ShopApprovalUpdateConfirm.admin", method = RequestMethod.POST)
	public ModelAndView confirm(@Valid
	final ShopApprovalUpdateForm input, final BindingResult result, final HttpServletRequest request,
			final HttpServletResponse response) {
		final ModelAndView mv = new ModelAndView();
		if (isCancelled(request)) {
			final RedirectView view = new RedirectView("/shop_bukken/ShopInfo.do?shopCd=" + input.getShopcd(), true);
			mv.setView(view);
			return mv;
		}
		if (result.hasErrors()) {
			mv.setViewName("shop_bukken/ShopApprovalUpdate");
			return mv;
		}
		saveToken(request);
		return mv;
	}

	/**
	 * @param input
	 * @param result
	 * @param request
	 * @param response
	 * @param redirectAttrs
	 * @return
	 */
	@RequestMapping(value = "ShopApprovalUpdateCommit.admin", method = RequestMethod.POST)
	public ModelAndView commit(@Valid
	final ShopApprovalUpdateForm input, final BindingResult result, final HttpServletRequest request,
			final HttpServletResponse response, final RedirectAttributes redirectAttrs) {
		final ModelAndView mv = new ModelAndView();
		if (result.hasErrors() || isCancelled(request)) {
			mv.setViewName("shop_bukken/ShopApprovalUpdate");
			return mv;
		}

		final RedirectView view = new RedirectView("/shop_bukken/ShopInfo.do?shopCd=" + input.getShopcd(), true);
		mv.setView(view);

		// 画面リロード対策
		if (isTokenInValid(request, true)) {
			return mv;
		}

		resetToken(request);

		// 更新者のＩＤを設定
		final SessionBean sessionBean = SessionBeanManager.getSessionBean(request);
		final String operUserId = sessionBean.getUserId();

		final Shop dto = new Shop();
		Utils.copyProperties(input, dto);
		ShopRireki shopRireki = this.shopService.selectShopRirekiByShopcd(input.getShopcd());
		Utils.copyProperties(input, shopRireki);
		dto.setShopRireki(shopRireki);

		try {
			final Integer pkShopRireki = this.shopService.updateShopRireki(dto);

			if ("1".equals(input.getCertifyFlg())) {
				//メール送信
				final Map<String, Object> model = new HashMap<>();
				final Map<Integer, ShopRirekiEki> rirekiEki  = new TreeMap<>();
				final Map<String, MstEki> ekis = new TreeMap<>();
				final Map<String, MstEnsen> ensens = new TreeMap<>();
				final Map<String, VShopKeiyakuDetail> keiyakus = new TreeMap<>();
				final Map<String, String> groups = new TreeMap<>();
				final Map<String, String> emailKbnName = new TreeMap<>();

				// 区分フラグをプロパティから取得
				MstRendo mstRendo = masterService.selectMstRendoByPrimaryKey(shopRireki.getRendoCd());
				model.put("shopBasicInfo", dto);
				model.put("password", CryptUtils.decypt(shopRireki.getPasswordEnc()));
				model.put("companyKbnName", getPropertyName("SHOPBUKKEN_COMPANY_KBN_VALUE" ,mstRendo.getCompanyKbn()));
				model.put("telKbnName", getPropertyName("SHOPBUKKEN_SHOP_TEL_KBN_VALUE" ,shopRireki.getTelDispKbn()));
				model.put("telKbnNameAbl", getPropertyName("SHOPBUKKEN_SHOP_TEL_KBN_VALUE" ,shopRireki.getTelDispKbnAbl()));
				model.put("redoCdName", mstRendo.getRendoName());
				model.put("fmKbnName", getPropertyName("SHOPBUKKEN_FM_KBN_VALUE" ,shopRireki.getFmKbn()));
				model.put("ctStatusName", getPropertyName("SHOPBUKKEN_CT_FLG_VALUE" ,shopRireki.getCtStatus()));
				model.put("ablStatusName", getPropertyName("SHOPBUKKEN_ABL_FLG_VALUE" ,shopRireki.getAblStatus()));
				model.put("shopStatusName", getPropertyName("SHOPBUKKEN_SHOP_STATUS_VALUE" ,shopRireki.getShopStatus()));
				model.put("emailKbnName1", "");
				model.put("emailKbnName2", "");
				model.put("emailKbnName3", "");
				model.put("emailKbnName4", "");
				model.put("emailKbnName5", "");

				MstArea mstArea = masterService.selectMstAreaByPrimaryKey(shopRireki.getAreacd());
				MstPref mstPref = masterService.selectMstPrefByPrimaryKey(shopRireki.getPrefcd());
				MstCity mstCity = masterService.selectMstCityByPrimaryKey(shopRireki.getPrefcd(), shopRireki.getCitycd());
				if(mstArea != null){
					model.put("areaName", mstArea.getAreaname());
				}
				if(mstPref != null){
					model.put("prefName", mstPref.getPrefname());
				}
				if(mstCity != null){
					model.put("cityName", mstCity.getCityname());
				}

				//
				final BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(shopRireki);
				for (int i = 1; i < 6; i++) {
					String emailKbn = (String)bw.getPropertyValue("emailUseKbn" + i);
					if (StringUtils.hasText(emailKbn)) {
						model.put("emailKbnName"+i, getPropertyName("SHOPBUKKEN_EMAIL_USE_KBN_VALUE" ,emailKbn));
					}
				}

				//最寄駅取得
				model.put("rirekiEki",rirekiEki);
				model.put("ensens",ensens);
				model.put("ekis",ekis);
				for (final ShopRirekiEki shopRirekiEki : this.shopService.selectShopRirekiEkiByPkShopRireki(shopRireki.getPkShopRireki())) {
					rirekiEki.put((int) shopRirekiEki.getEntryNo(), shopRirekiEki);

				// 沿線と駅のマップ作成
				if (shopRirekiEki.getEnsencd() != null) {
					MstEnsen mstEnsen = masterService.selectMstEnsenByPrimaryKey(shopRirekiEki.getEnsencd());
					ensens.put(shopRirekiEki.getEnsencd(),mstEnsen);
				}
				if (shopRirekiEki.getEkicd() != null) {
					MstEki mstEki = masterService.selectMstEkiByPrimaryKey(shopRirekiEki.getEnsencd(),shopRirekiEki.getEkicd());
   					ekis.put(shopRirekiEki.getEnsencd() + shopRirekiEki.getEkicd(),mstEki);
				}
				}
				model.put("mstShisya", this.masterService.selectMstCtShisyaByPrimaryKey(shopRireki.getCtShisyaCd()));
				model.put("nayose",this.shopService.selectCtNayoseSkipShopByPrimaryKey(shopRireki.getShopcd()) != null ? "0" : "1");

				//契約一覧情報・契約明細取得
				model.put("keiyakus",keiyakus);
				for (VShopKeiyakuDetail vShopKeiyakuDetail: shopService.selectVShopKeiyakuDetailCmsDispByShopcd(shopRireki.getShopcd())) {
					keiyakus.put(vShopKeiyakuDetail.getKeiyakuCd()+vShopKeiyakuDetail.getKeiyakuSubCd(), vShopKeiyakuDetail);
				}

				//不動産Asp取得(グループ一覧取得)
				model.put("groups",groups);
				String port = request.getServerPort() != 80 ? ":" + request.getServerPort()   :  "";
				String url = "https://" + request.getServerName() + port + request.getContextPath() +  "/shop_bukken/ShopInfo.do?shopCd=";
				for (VAspGroupShop vAspGroupShop  : shopService.selectVAspGroupShopByGroupShopcd(shopRireki.getShopcd())) {
					groups.put(vAspGroupShop.getShopcd(),url + vAspGroupShop.getShopcd());
				}

				final String emailTo = shopRireki.getNoticeEmail();
				this.mailService.sendMail(MAILCD_SHOP_APPROVAL, model, emailTo);
			}

			// 更新成功ログ、メッセージ設定
			this.loggingService.write("01001", operUserId, SessionStatus.SUCCESS, "店舗コード " + input.getShopcd(), this
					.getClass().getName());
			saveMsg(request, "INFO.M.SHOP_BUKKEN.0002", ApplicationResources.getProperty("shop.shopRegistrationStatus"));
		}
		catch (final InProcessingException e) {
			saveErrMsg(request, "ERROR.M.SHOP_BUKKEN.0010");
			this.loggingService.write("01001", operUserId, SessionStatus.FAILURE,
					ApplicationResources.getProperty("shop.code") + shopRireki.getShopcd(), this.getClass().getName());
		}
		catch (/* ApplicationException */final Exception e) {
			// 更新失敗ログ
			this.loggingService.write("01001", operUserId, SessionStatus.FAILURE, "店舗コード " + input.getShopcd(), this
					.getClass().getName());
			saveErrMsg(request, "FETAL.M.SYSTEM.0001");
		}

		return mv;
	}

    /**
     * @param kbn
     * @return
     */
    private String getPropertyName(final String propertyName ,final String kbn) {
        final String[] outValues = (SystemProperties.getProperty(propertyName)).split(",");
        final String[] outNames = (SystemProperties.getProperty(propertyName.replaceAll("_VALUE", "_NAME"))).split(",");

        String outValue = "";

        for (int i = 0; (i < outValues.length) && (outValue.length() == 0); i++) {
            if (kbn.equals(outValues[i])) {
                outValue = outNames[i];
            }
        }
        return outValue;
    }

	/**
	 * @param shopcd
	 * @return
	 */
	@ModelAttribute
	protected ShopApprovalUpdateForm getForm(final String shopcd) {
		final ShopApprovalUpdateForm form = new ShopApprovalUpdateForm();
		return form;
	}

	/**
	 * referenceData
	 *
	 * @return Map
	 */
	@ModelAttribute("refData")
	protected Map<Object, Object> referenceData(final String shopcd) {
		final Map<Object, Object> m = new HashMap<Object, Object>();
		m.put("shopRireki", this.shopService.selectShopRirekiByShopcd(shopcd));
		return m;
	}

	/*
	 * (非 Javadoc)
	 *
	 * @see net.chintai.backend.sysadmin.crnwl.controller.support.BaseController#getAuthorityId()
	 */
	@Override
	public AuthorityId getAuthorityId() {
		return AuthorityId.SHOP_BUKKEN;
	}

}
