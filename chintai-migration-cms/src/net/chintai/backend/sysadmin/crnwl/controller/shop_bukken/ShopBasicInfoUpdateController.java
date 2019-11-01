package net.chintai.backend.sysadmin.crnwl.controller.shop_bukken;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import net.chintai.backend.sysadmin.crnwl.dto.ShopBasicInfo;
import net.chintai.backend.sysadmin.crnwl.exception.InProcessingException;
import net.chintai.backend.sysadmin.crnwl.form.shop_bukken.ShopBasicInfoUpdateForm;
import net.chintai.backend.sysadmin.crnwl.service.MasterService;
import net.chintai.backend.sysadmin.crnwl.service.ShopService;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.batch.common.ClientSystemType;
import net.chintai.batch.common.Cmdcd;
import net.chintai.batch.common.CtAblStatus;
import net.chintai.batch.common.GenericFlg;
import net.chintai.batch.common.InsKbn;
import net.chintai.batch.common.PpcUseKbn;
import net.chintai.batch.common.ReceiveFormatKbn;
import net.chintai.batch.common.ShopStatus;
import net.chintai.batch.common.domain.MstRendo;
import net.chintai.batch.common.domain.ShopReserve;
import net.chintai.batch.common.domain.ShopRireki;
import net.chintai.batch.common.domain.ShopRirekiEki;
import net.chintai.batch.common.service.MailService;
import net.chintai.batch.support.ppc.PpcException;
import net.chintai.batch.support.ppc.PpcSupportService;
import net.chintai.batch.common.util.CryptUtils;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * <pre>
 * ShopBasicInfoUpdate
 * </pre>
 * @author hasegawa
 * @lastModified $Date: 2015-04-28 18:22:53 +0900 (火, 28 4 2015) $ by $Author: kentaro.araya $
 * @version $Revision: 6945 $
 * @since 1.0
 */
@Controller
@RequestMapping(value = "/shop_bukken")
public class ShopBasicInfoUpdateController extends BaseController {
	@Autowired
	private ShopService shopService;

	@Autowired
	private MasterService masterService;

	@Qualifier("crsplusShopService")
	@Autowired
	private net.chintai.receive.crsplus.service.ShopService crsplusShopService;

	@Autowired
	private MailService mailService;

	@Autowired
	private PpcSupportService ppcSupportService;

	private static final String MAILCD_SHOP_BASICINFOADD = "SHOP_BASICINFOADD";

	/**
	 * @param input
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = { "ShopBasicInfoAdd.admin", "ShopBasicInfoUpdate.admin" }, method = RequestMethod.GET)
	public ModelAndView edit(final ShopBasicInfoUpdateForm input, final HttpServletRequest request,
			final HttpServletResponse response) {

		final boolean isAdd = ((String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE))
				.indexOf("Add") > -1;

		final ModelAndView mv = new ModelAndView();
		mv.setViewName("shop_bukken/ShopBasicInfoUpdate");

		final ShopRireki shopRireki = this.shopService.selectShopRirekiByShopcd(input.getShopcd());
		if (shopRireki != null) {
			Utils.copyProperties(shopRireki, input);
			final DecimalFormat df = new DecimalFormat("#.0#####");
			if (shopRireki.getLocationX() != null) {
				input.setLocationX(df.format(shopRireki.getLocationX()));
			}
			if (shopRireki.getLocationY() != null) {
				input.setLocationY(df.format(shopRireki.getLocationY()));
			}
			for (final ShopRirekiEki shopRirekiEki : this.shopService.selectShopRirekiEkiByPkShopRireki(shopRireki
					.getPkShopRireki())) {
				final ShopBasicInfoUpdateForm.Eki eki = new ShopBasicInfoUpdateForm.Eki();
				Utils.copyProperties(shopRirekiEki, eki);
				input.getEkis().put((int) shopRirekiEki.getEntryNo(), eki);
			}
			final BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(shopRireki);
			for (int i = 1; i <= 5; i++) {
				final ShopBasicInfoUpdateForm.Hp hp = new ShopBasicInfoUpdateForm.Hp();
				hp.setUrl((String) bw.getPropertyValue("hpUrl" + i));
				hp.setName((String) bw.getPropertyValue("hpName" + i));
				input.getHps().put(i, hp);
			}
			for (int i = 1; i <= 5; i++) {
				final ShopBasicInfoUpdateForm.Mail mail = new ShopBasicInfoUpdateForm.Mail();
				mail.setEmail((String) bw.getPropertyValue("email" + i));
				mail.setUseKbn((String) bw.getPropertyValue("emailUseKbn" + i));
				input.getMails().put(i, mail);
			}
			input.setShopKanriUpdDt(this.shopService.selectShopKanriByPrimaryKey(input.getShopcd()).getUpdDt());

			if (isAdd) {
				final RedirectView view = new RedirectView("/shop_bukken/ShopSearchPage.do", true);
				mv.setView(view);
			}

			input.setNayoseSkip(this.shopService.selectCtNayoseSkipShopByPrimaryKey(shopRireki.getShopcd()) != null);
			if(StringUtils.hasText(shopRireki.getTelFreeCt())){
				input.setTelFreeCtKbn("1");//フリーコール（CHINTAI）用TEL 使用する
			}else{
				input.setTelFreeCtKbn("0");//フリーコール（CHINTAI）用TEL 使用しない
			}

			if(StringUtils.hasText(shopRireki.getTelMagazine())){
				input.setTelMagazineKbn("1");//フリーコール（雑誌）用TEL 使用する
			}else{
				input.setTelMagazineKbn("0");//フリーコール（雑誌）用TEL 使用しない
			}

			if(StringUtils.hasText(shopRireki.getTelFreeAbl())){
				input.setTelFreeAblKbn("1");//フリーコール（エイブル）用TEL 使用する
			}else{
				input.setTelFreeAblKbn("0");//フリーコール（エイブル）用TEL 使用しない
			}
		}
		else {
			input.setNayoseSkip(true);
			input.setShopcd(null);
			input.setTelFreeCtKbn("0");//フリーコール（CHINTAI）用TEL 使用しない
			input.setTelMagazineKbn("0");//フリーコール（雑誌）用TEL 使用しない
			input.setTelFreeAblKbn("0");//フリーコール（エイブル）用TEL 使用しない
			if (!isAdd) {
				final RedirectView view = new RedirectView("/shop_bukken/ShopSearchPage.do", true);
				mv.setView(view);
			}
		}
		if (!StringUtils.hasText(input.getTelDispKbn())) {
			input.setTelDispKbn("2");//デフォルト値：フリーコール（CHINTAI）
		}
		if (!StringUtils.hasText(input.getTelDispKbnAbl())) {
			input.setTelDispKbnAbl("1");//デフォルト値：フリーコール（反響）
		}

		return mv;
	}

	/**
	 * @param input
	 * @param result
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = { "ShopBasicInfoAddConfirm.admin", "ShopBasicInfoUpdateConfirm.admin" }, method = RequestMethod.POST)
	public ModelAndView confirm(@Valid
	final ShopBasicInfoUpdateForm input, final BindingResult result, final HttpServletRequest request,
			final HttpServletResponse response) {
		final boolean isAdd = ((String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE))
				.indexOf("Add") > -1;

		final ModelAndView mv = new ModelAndView();
		if (isCancelled(request)) {
			final RedirectView view;
			if (isAdd) {
				view = new RedirectView("/shop_bukken/ShopSearchPage.do", true);
			}
			else {
				view = new RedirectView("/shop_bukken/ShopInfo.do?shopCd=" + input.getShopcd(), true);
			}

			mv.setView(view);
			return mv;
		}

		additionalValidation(input, result);

		if (result.hasErrors()) {
			mv.setViewName("shop_bukken/ShopBasicInfoUpdate");
			return mv;
		}
		saveToken(request);

		mv.setViewName("shop_bukken/ShopBasicInfoUpdateConfirm");

		return mv;
	}

	/**
	 * @param input
	 * @param result
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = { "ShopBasicInfoAddCommit.admin", "ShopBasicInfoUpdateCommit.admin" }, method = RequestMethod.POST)
	public ModelAndView commit(@Valid
	final ShopBasicInfoUpdateForm input, final BindingResult result, final HttpServletRequest request,
			final HttpServletResponse response) {

		final boolean isAdd = ((String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE))
				.indexOf("Add") > -1;

		additionalValidation(input, result);

		final ModelAndView mv = new ModelAndView();
		if (result.hasErrors() || isCancelled(request)) {
			mv.setViewName("shop_bukken/ShopBasicInfoUpdate");
			return mv;
		}

		RedirectView view;
		String operationId;
		if (isAdd) {
			view = new RedirectView("/shop_bukken/ShopBasicInfoAdd.admin", true);
			operationId = "01013";
		}
		else {
			view = new RedirectView("/shop_bukken/ShopInfo.do?shopCd=" + input.getShopcd(), true);
			operationId = "01012";
		}

		// 画面リロード対策
		if (isTokenInValid(request, true)) {
			mv.setView(view);
			return mv;
		}

		resetToken(request);

		// 更新者のＩＤを設定
		final SessionBean sessionBean = SessionBeanManager.getSessionBean(request);
		final String operUserId = sessionBean.getUserId();
		final ShopBasicInfo dto = new ShopBasicInfo();
		Utils.copyProperties(input, dto);

		final ShopRireki shopRireki;

		final MstRendo mstRendo = this.masterService.selectMstRendoByPrimaryKey(input.getRendoCd());

		if (isAdd) {
			shopRireki = new ShopRireki();

			Utils.copyProperties(input, shopRireki);

			shopRireki.setShopcd(this.crsplusShopService.getShopCd(mstRendo.getClientsystemType()));
			shopRireki.setCmdcdShop(Cmdcd.CREATE.getValue());
			shopRireki.setInsKbn(InsKbn.INSERT.getValue());
			shopRireki.setPasswordEnc(CryptUtils.encypt(RandomStringUtils.randomAlphanumeric(8)));
			shopRireki.setCtStatus(CtAblStatus.VALID.getValue());
			shopRireki.setAblStatus(ClientSystemType.ANS.getValue().equals(mstRendo.getClientsystemType()) ? CtAblStatus.VALID.getValue() : CtAblStatus.INVALID.getValue());
			shopRireki.setCertifyFlg(GenericFlg.OFF.getValue());
			shopRireki.setShopStatus(ShopStatus.NORMAL.getValue());
			shopRireki.setSyokaiShinsaSkipFlg(GenericFlg.OFF.getValue());
			shopRireki.setTeikiShinsaSkipFlg(GenericFlg.OFF.getValue());
			shopRireki.setMailSendSkipFlg(GenericFlg.OFF.getValue());
			shopRireki.setAutodelSkipFlg(GenericFlg.OFF.getValue());
			shopRireki.setHasshinTm(new DateTime().toDate());
			shopRireki.setClientsystemType(mstRendo.getClientsystemType());
			shopRireki.setReceiveFormatKbn(ReceiveFormatKbn.NEW_AND_OLD.getValue());

			//044_エイブルWeb用のフリーコール番号追加 part1対応
			//shopRireki.setTelDispKbnAbl("1");
		}
		else {
			shopRireki = this.shopService.selectShopRirekiByShopcd(input.getShopcd());
			Utils.copyProperties(input, shopRireki);
			shopRireki.setLocationX(StringUtils.hasText(input.getLocationX()) ? new BigDecimal(input.getLocationX())
					: null);
			shopRireki.setLocationY(StringUtils.hasText(input.getLocationY()) ? new BigDecimal(input.getLocationY())
					: null);
			shopRireki.setClientsystemType(mstRendo.getClientsystemType());
		}

		final Map<String, String> address = this.masterService.getAddress(shopRireki.getZip());
		shopRireki.setAreacd(address.get("areacd"));
		shopRireki.setPrefcd(address.get("prefcd"));
		shopRireki.setCitycd(address.get("citycd"));

		// フリーコール ※SHOP_RESERVEに予約がある場合は更新しない
		boolean isPpcException = false;
		boolean isExistsShopReserve = shopService.isExistsShopReserve(shopRireki.getShopcd());
		if(!isExistsShopReserve){

			// フリーコール(CHINTAI)
			if ("1".equals(input.getTelFreeCtKbn())) {
				if (GenericFlg.ON.getValue().equals(shopRireki.getCtStatus()) && GenericFlg.ON.getValue().equals(shopRireki.getShopStatus())) {
					try {
						shopRireki.setTelFreeCt(this.ppcSupportService.getPpcNum(shopRireki, PpcUseKbn.CHINTAI));
					} catch (PpcException e1) {
						isPpcException = true;
					}
				} else if (!StringUtils.hasText(shopRireki.getTelFreeCt())){
					try {
						shopRireki.setTelFreeCt(this.ppcSupportService.getPpcNum(shopRireki, PpcUseKbn.CHINTAI));
					} catch (PpcException e1) {
						isPpcException = true;
					}
				}
			} else {
				shopRireki.setTelFreeCt(null);
			}

			// フリーコール(雑誌)
			if ("1".equals(input.getTelMagazineKbn())) {
				if (GenericFlg.ON.getValue().equals(shopRireki.getShopStatus())) {
					try {
						shopRireki.setTelMagazine(this.ppcSupportService.getPpcNum(shopRireki, PpcUseKbn.MAGAZINE));
					} catch (PpcException e1) {
						isPpcException = true;
					}
				} else if (!StringUtils.hasText(shopRireki.getTelMagazine())){
					try {
						shopRireki.setTelMagazine(this.ppcSupportService.getPpcNum(shopRireki, PpcUseKbn.MAGAZINE));
					} catch (PpcException e1) {
						isPpcException = true;
					}
				}
			} else {
				shopRireki.setTelMagazine(null);
			}

			// フリーコール(エイブル)
			if ("1".equals(input.getTelFreeAblKbn())) {
				if (GenericFlg.ON.getValue().equals(shopRireki.getAblStatus()) && GenericFlg.ON.getValue().equals(shopRireki.getShopStatus())) {
					try {
						shopRireki.setTelFreeAbl(this.ppcSupportService.getPpcNum(shopRireki, PpcUseKbn.ABLE));
					} catch (PpcException e1) {
						isPpcException = true;
					}
				} else if (!StringUtils.hasText(shopRireki.getTelFreeAbl())) {
					try {
						shopRireki.setTelFreeAbl(this.ppcSupportService.getPpcNum(shopRireki, PpcUseKbn.ABLE));
					} catch (PpcException e1) {
						isPpcException = true;
					}
				}
			} else {
				shopRireki.setTelFreeAbl(null);
			}
		} else {
			if (!isAdd) {//店舗更新
				final ShopRireki previousShopRireki = this.shopService.selectShopRirekiByShopcd(input.getShopcd());
				if (previousShopRireki != null) {

					final String previousTelInq = previousShopRireki.getTelInq();
					final String previousTelFreeCt = previousShopRireki.getTelFreeCt();
					final String previousTelMagazine = previousShopRireki.getTelMagazine();
					final String previousTelFreeAbl = previousShopRireki.getTelFreeAbl();

					if (!shopRireki.getTelInq().equals(previousTelInq)) {
						// フリーコール(CHINTAI)
						if (GenericFlg.ON.getValue().equals(shopRireki.getCtStatus()) && GenericFlg.ON.getValue().equals(shopRireki.getShopStatus()) && StringUtils.hasText(previousTelFreeCt)) {
							try {
								this.ppcSupportService.getPpcNum(shopRireki, PpcUseKbn.CHINTAI);
							} catch (PpcException e1) {
								isPpcException = true;
							}
						}

						// フリーコール(雑誌)
						if (GenericFlg.ON.getValue().equals(shopRireki.getShopStatus()) && StringUtils.hasText(previousTelMagazine)) {
							try {
								this.ppcSupportService.getPpcNum(shopRireki, PpcUseKbn.MAGAZINE);
							} catch (PpcException e1) {
								isPpcException = true;
							}
						}

						// フリーコール(エイブル)
						if (GenericFlg.ON.getValue().equals(shopRireki.getAblStatus()) && GenericFlg.ON.getValue().equals(shopRireki.getShopStatus()) && StringUtils.hasText(previousTelFreeAbl)) {
							try {
								this.ppcSupportService.getPpcNum(shopRireki, PpcUseKbn.ABLE);
							} catch (PpcException e1) {
								isPpcException = true;
							}
						}
					}
				}
			}
		}

		if(isPpcException){//エラーの場合、店舗系の登録・更新は行わない。
			saveErrMsg(request, "INFO.M.SHOP_BUKKEN.0031");
			this.loggingService.write(operationId, operUserId, SessionStatus.FAILURE,
					ApplicationResources.getProperty("shop.code") + shopRireki.getShopcd(), this.getClass().getName());
			view = new RedirectView("/shop_bukken/ShopSearchPage.do", true);
			mv.setView(view);

			return mv;
		}

		final BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(shopRireki);
		// hp
		for (final Map.Entry<Integer, ShopBasicInfoUpdateForm.Hp> e : input.getHps().entrySet()) {
			final ShopBasicInfoUpdateForm.Hp hp = e.getValue();
			bw.setPropertyValue("hpName" + e.getKey(), hp.getName());
			bw.setPropertyValue("hpUrl" + e.getKey(), hp.getUrl());
		}
		// mail
		for (final Map.Entry<Integer, ShopBasicInfoUpdateForm.Mail> e : input.getMails().entrySet()) {
			final ShopBasicInfoUpdateForm.Mail mail = e.getValue();
			bw.setPropertyValue("email" + e.getKey(), mail.getEmail());
			bw.setPropertyValue("emailUseKbn" + e.getKey(), mail.getUseKbn());
		}

		dto.setShopRireki(shopRireki);

		for (final Map.Entry<Integer, ShopBasicInfoUpdateForm.Eki> e : input.getEkis().entrySet()) {
			final ShopRirekiEki shopRirekiEki = new ShopRirekiEki();
			Utils.copyProperties(e.getValue(), shopRirekiEki);
			shopRirekiEki.setEntryNo((short) (int) e.getKey());
			dto.getShopRirekiEkis().add(shopRirekiEki);
		}

		try {
			final Integer pkShopRireki = this.shopService.updateShopBasicInfo(dto);

			// mail
			if (isAdd) {
				final Map<String, Object> model = new HashMap<>();
				model.put("shopRireki", dto.getShopRireki());
				model.put("password", CryptUtils.decypt(shopRireki.getPasswordEnc()));
				model.put("companyKbnName", getCompanyKbnName(mstRendo.getCompanyKbn()));
				final String emailTo = shopRireki.getNoticeEmail();
				this.mailService.sendMail(MAILCD_SHOP_BASICINFOADD, model, emailTo);
			}

			// ここまで来たら詳細に変更
			view = new RedirectView("/shop_bukken/ShopInfo.do?shopCd=" + shopRireki.getShopcd(), true);

			// 更新成功ログ、メッセージ設定
			this.loggingService.write(operationId, operUserId, SessionStatus.SUCCESS,
					ApplicationResources.getProperty("shop.code") + shopRireki.getShopcd(), this.getClass().getName());

			saveMsg(request, isAdd ? "INFO.M.SHOP_BUKKEN.0026" : (isExistsShopReserve ? "INFO.M.SHOP_BUKKEN.0030":"INFO.M.SHOP_BUKKEN.0016"),
					ApplicationResources.getProperty("shop.basicInfo"));
		}
		catch (final InProcessingException e) {
			saveErrMsg(request, "ERROR.M.SHOP_BUKKEN.0010");
			this.loggingService.write(operationId, operUserId, SessionStatus.FAILURE,
					ApplicationResources.getProperty("shop.code") + shopRireki.getShopcd(), this.getClass().getName());
		}
		catch (final Exception e) {
			this.logger.error(e.getMessage(), e);
			// 更新失敗ログ
			this.loggingService.write(operationId, operUserId, SessionStatus.FAILURE,
					ApplicationResources.getProperty("shop.code") + shopRireki.getShopcd(), this.getClass().getName());
			saveErrMsg(request, "FETAL.M.SYSTEM.0001");
		}

		mv.setView(view);

		return mv;
	}

	/**
	 * @param kbn
	 * @return
	 */
	private String getCompanyKbnName(final String kbn) {
		final String[] outNames = (SystemProperties.getProperty("SHOPBUKKEN_COMPANY_KBN_NAME")).split(",");
		final String[] outValues = (SystemProperties.getProperty("SHOPBUKKEN_COMPANY_KBN_VALUE")).split(",");

		String outValue = "";

		for (int i = 0; (i < outValues.length) && (outValue.length() == 0); i++) {
			if (kbn.equals(outValues[i])) {
				outValue = outNames[i];
			}
		}
		return outValue;
	}

	/*
	 * (非 Javadoc)
	 *
	 * @see
	 * net.chintai.backend.sysadmin.crnwl.controller.support.BaseController#initDataBinder(org.springframework.validation
	 * .DataBinder, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public void initDataBinder(final DataBinder binder, final HttpServletRequest request) {
		super.initDataBinder(binder, request);
		binder.registerCustomEditor(String.class, "locationX", new StringTrimmerEditor(true));
		binder.registerCustomEditor(String.class, "locationY", new StringTrimmerEditor(true));
	}

	/**
	 * @param input
	 * @param result
	 */
	private void additionalValidation(final ShopBasicInfoUpdateForm input, final BindingResult result) {

	}

	/**
	 * @param shopcd
	 * @return
	 */
	@ModelAttribute
	protected ShopBasicInfoUpdateForm getForm(final String shopcd) {
		final ShopBasicInfoUpdateForm form = new ShopBasicInfoUpdateForm();
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
