package net.chintai.backend.sysadmin.crnwl.controller.shop_bukken;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.Validator;

import jp.co.interoffice.util.Utils;
import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.session.SessionBean;
import net.chintai.backend.sysadmin.common.session.SessionBeanManager;
import net.chintai.backend.sysadmin.crnwl.controller.support.BaseController;
import net.chintai.backend.sysadmin.crnwl.controller.support.BaseController.errorMsgComparator;
import net.chintai.backend.sysadmin.crnwl.dto.ShopImage;
import net.chintai.backend.sysadmin.crnwl.exception.InProcessingException;
import net.chintai.backend.sysadmin.crnwl.form.shop_bukken.ShopImageUpdateForm;
import net.chintai.backend.sysadmin.crnwl.form.shop_bukken.ShopImageUpdateForm.Img;
import net.chintai.backend.sysadmin.crnwl.service.MasterService;
import net.chintai.backend.sysadmin.crnwl.service.ShopService;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.batch.common.ImgUpdateKbn;
import net.chintai.batch.common.domain.MstImgCategory;
import net.chintai.batch.common.domain.MstImgKbn;
import net.chintai.batch.common.domain.ShopRireki;
import net.chintai.batch.common.domain.ShopRirekiImg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * <pre>
 * ShopImageUpdateController
 * </pre>
 * @author hasegawa
 * @lastModified $Date: 2014-10-14 17:59:47 +0900 (火, 14 10 2014) $ by $Author: kentaro.araya $
 * @version $Revision: 5906 $
 * @since 1.0
 */
@Controller
@RequestMapping(value = "/shop_bukken")
public class ShopImageUpdateController extends BaseController {
	@Autowired
	private ShopService shopService;

	@Autowired
	private MasterService masterService;

	@Autowired
	private Validator validator;

	/**
	 * @param input
	 * @param request
	 * @param response
	 * @return
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	@RequestMapping(value = "ShopImageUpdate.admin", method = RequestMethod.GET)
	public ModelAndView edit(final ShopImageUpdateForm input, final HttpServletRequest request,
			final HttpServletResponse response) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		final ModelAndView mv = new ModelAndView();
		final ShopRireki shopRireki = this.shopService.selectShopRirekiByShopcd(input.getShopcd());
		final Map<String,ShopRirekiImg> rirekiImgMap = Utils.toKeyObject(this.shopService.selectShopRirekiImgByPkShopRireki(shopRireki
				.getPkShopRireki()),"imgKbn");
		final Map<String,MstImgCategory> imgCategoryMap = Utils.toKeyObject(this.masterService.selectMstImgCategoryByShopBukkenKbn("1")
				,"imgCategory");
		final Map<String,MstImgKbn> imgKbnMap = Utils.toKeyObject(this.masterService
				.selectMstImgKbnByShopBukkenKbnAndImgCategory("1","02","03","09","13","06"),"imgKbn");

				input.setShopcd(shopRireki.getShopcd());
		input.setImgId(this.shopService.getImgId(input.getShopcd()));
		input.setShopKanriUpdDt(this.shopService.selectShopKanriByPrimaryKey(input.getShopcd()).getUpdDt());

		// ヘッダー 不動産会社ロゴ画像 インフォメーション動画1
		for (MstImgKbn mstImgKbn : masterService.selectMstImgKbnByShopBukkenKbnAndImgCategory("1","07","08")) {
			if (rirekiImgMap.get(mstImgKbn.getImgKbn()) == null) {
				ShopImageUpdateForm.Img img = new ShopImageUpdateForm.Img();
				img.setImgKbn(mstImgKbn.getImgKbn());
				img.setExistCurrentShopRirekiImg(false);
				img.setImgCategoryName(imgCategoryMap.get(mstImgKbn.getImgCategory()).getImgCategoryName());
				img.setImgCategory(mstImgKbn.getImgCategory());
				input.getImgs().add(img);
			} else {
				ShopImageUpdateForm.Img img = new ShopImageUpdateForm.Img();
				Utils.copyProperties(rirekiImgMap.get(mstImgKbn.getImgKbn()) , img);
				img.setExistCurrentShopRirekiImg(true);
				img.setImgCategory(mstImgKbn.getImgCategory());
				img.setImgCategoryName(imgCategoryMap.get(mstImgKbn.getImgCategory()).getImgCategoryName());
				input.getImgs().add(img);
			}
		}

		//
		for (final Map.Entry<String, ShopRirekiImg> e : rirekiImgMap.entrySet()) {
			ShopRirekiImg shopRirekiImg = e.getValue();
			for (MstImgKbn mstImgKbn : masterService.selectMstImgKbnByShopBukkenKbnAndImgCategory("1","02","03","09","13","06")) {
				if (shopRirekiImg.getImgKbn().equals(mstImgKbn.getImgKbn())){
					ShopImageUpdateForm.Img img = new ShopImageUpdateForm.Img();
					Utils.copyProperties(shopRirekiImg , img);
					img.setImgCategory(imgKbnMap.get(shopRirekiImg.getImgKbn()).getImgCategory());
					img.setExistCurrentShopRirekiImg(true);
					input.getImgs().add(img);
				}
			}
		}

		for (int i = input.getImgs().size() -1; i < 11; i++) {
			ShopImageUpdateForm.Img img = new ShopImageUpdateForm.Img();
			img.setExistCurrentShopRirekiImg(false);
			input.getImgs().add(img);
		}

		/*
		 * Map<String,ShopRirekiCampaign> campaignMap =
		 * Utils.toKeyObject(shopService.selectShopRirekiCampaignByPkShopRireki(shopRireki.getPkShopRireki()),"imgKbn");
		 *
		 * for (final ShopRirekiImg shopRirekiImg :
		 * this.shopService.selectShopRirekiImgByPkShopRireki(shopRireki.getPkShopRireki())) {
		 * if(ImgCategory.STAFF_GROUP_PHOTO.getValue().equals(shopRirekiImg.getImgKbn())){ ShopImageUpdateForm.Staff
		 * staff = new ShopImageUpdateForm.Staff(); Utils.copyProperties(shopRirekiImg, staff);
		 * input.getImgs().put(shopRirekiImg.getImgKbn(), staff); }else
		 * if(ImgCategory.CAMPAIGN.getValue().equals(shopRirekiImg.getImgKbn())){ ShopImageUpdateForm.Campaign campaign
		 * = new ShopImageUpdateForm.Campaign(); Utils.copyProperties(shopRirekiImg, campaign); ShopRirekiCampaign
		 * shopRirekiCampaign =campaignMap.get(shopRirekiImg.getImgKbn()); if(shopRirekiCampaign != null)
		 * Utils.copyProperties(shopRirekiCampaign, campaign); //input.getImgs().put(shopRirekiCampaign.gete, campaign);
		 * }else{ ShopImageUpdateForm.Img img = new ShopImageUpdateForm.Img(); } }
		 */
		return mv;
	}

	/**
	 * @param input
	 * @param result
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "ShopImageUpdateConfirm.admin", method = RequestMethod.POST)
	public ModelAndView confirm(@Valid
	final ShopImageUpdateForm input, final BindingResult result, final HttpServletRequest request,
			final HttpServletResponse response) throws IllegalStateException, IOException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {

		additionalValidation(input, result);

		final ModelAndView mv = new ModelAndView();
		if (isCancelled(request)) {

			// delete tmp
			final List<String> delList = new ArrayList<>();
			for (final  ShopImageUpdateForm.Img img : input.getImgs()) {
				if (img.getImgUrlPath().startsWith("/tmp/img/")) {
					delList.add(img.getImgUrlPath() + img.getImgFileNm());
				}
			}
			for (final String string : delList) {
				final Path path = Paths.get(this.servletContext.getRealPath(string));
				try {
					Files.delete(path);
				}
				catch (final IOException e1) {
					this.logger.warn(e1.getMessage(), e1);
				}
			}

			final RedirectView view = new RedirectView("/shop_bukken/ShopInfo.do?shopCd=" + input.getShopcd(), true);
			mv.setView(view);
			return mv;
		}
		if (result.hasErrors()) {
			//エラーメッセージのソート用リスト。
			sortErrors(result, request);

			mv.setViewName("shop_bukken/ShopImageUpdate");
			return mv;
		}

		final Map<String,MstImgCategory> imgCategoryNameMap = Utils.toKeyObject(this.masterService.selectMstImgCategoryByShopBukkenKbn("1")
				,"imgCategory");
		// makeImgKbnMap
		Map<String,Map<Object,MstImgKbn>> imgCategoryMap = new TreeMap<String, Map<Object,MstImgKbn>>();
		for (Map.Entry<String,MstImgCategory> e : imgCategoryNameMap.entrySet()) {
			MstImgCategory mstImgCategory = e.getValue();
			imgCategoryMap.put(mstImgCategory.getImgCategory(),
					Utils.toKeyObject(masterService.selectMstImgKbnByShopBukkenKbnAndImgCategory("1", mstImgCategory.getImgCategory()),"imgKbn"));
		}

		for (Img img :input.getImgs()) {
			if (StringUtils.hasText(img.getImgKbn())
					&& StringUtils.hasText(img.getImgCategory())) {
				imgCategoryMap.get(img.getImgCategory()).remove(img.getImgKbn());
				img.setImgCategoryName(imgCategoryNameMap.get(img.getImgCategory()).getImgCategoryName());
			}
		}

		for (Img img :input.getImgs()) {
			if (StringUtils.isEmpty(img.getImgKbn())
					&& StringUtils.hasText(img.getImgCategory())) {
				for(Map.Entry<Object, MstImgKbn>  map : imgCategoryMap.get(img.getImgCategory()).entrySet()) {
					img.setImgKbn(map.getKey().toString());
					img.setImgCategoryName(imgCategoryNameMap.get(img.getImgCategory()).getImgCategoryName());
					break;
				}
				imgCategoryMap.get(img.getImgCategory()).remove(img.getImgKbn());
			}
		}

		// save img
		final String imgId = input.getImgId();
		for (final  ShopImageUpdateForm.Img img : input.getImgs()) {
			if (!img.isDel() && (img.getFile() != null) && (img.getFile().getSize() > 0)) {
				final String fileName = this.shopService.toShopImgName(input.getShopcd(), img.getImgKbn(), imgId, img
						.getFile().getOriginalFilename());
				final File f = new File(this.servletContext.getRealPath("/tmp/img/") + File.separator + fileName);
				img.getFile().transferTo(f);
				img.setImgUrlPath("/tmp/img/");
				img.setImgFileNm(fileName);
			}
		}

		saveToken(request);
		return mv;
	}

	/**
	 * @param input
	 * @param result
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "ShopImageUpdateCommit.admin", method = RequestMethod.POST)
	public ModelAndView commit(@Valid
	final ShopImageUpdateForm input, final BindingResult result, final HttpServletRequest request,
			final HttpServletResponse response) {

		additionalValidation(input, result);

		final ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			//エラーメッセージのソート用リスト。
			sortErrors(result, request);
		}
		if (result.hasErrors() || isCancelled(request)) {
			mv.setViewName("shop_bukken/ShopImageUpdate");
			return mv;
		}

		final RedirectView view = new RedirectView("/shop_bukken/ShopInfo.do?shopCd=" + input.getShopcd(), true);
		mv.setView(view);

		// 画面リロード対策
		if (isTokenInValid(request, true)) {
			return mv;
		}

		resetToken(request);

		final ShopImage dto = new ShopImage();
		Utils.copyProperties(input, dto);

		final ShopRireki shopRireki = this.shopService.selectShopRirekiByShopcd(input.getShopcd());
		Utils.copyProperties(input, shopRireki);
		dto.setShopRireki(shopRireki);

		final List<Path> images = new ArrayList<>();
		for (final  ShopImageUpdateForm.Img img : input.getImgs()) {
			if (!img.isDel() && !img.isNoValidate()) {

				final ShopRirekiImg shopRirekiImg = new ShopRirekiImg();
				Utils.copyProperties(img, shopRirekiImg, "imgVerDt", "imgUrlPath", "imgFileNm", "imgIdLast");
				dto.getShopRirekiImgs().add(shopRirekiImg);
				shopRirekiImg.setImgUpdateKbn(ImgUpdateKbn.NO_UPDATE.getValue());
				if (img.getImgUrlPath().startsWith("/tmp/img/")) {
					images.add(Paths.get(this.servletContext.getRealPath("/tmp/img/") + File.separator
							+ img.getImgFileNm()));
					shopRirekiImg.setImgUpdateKbn(ImgUpdateKbn.UPDATE.getValue());
				}
				if (StringUtils.hasText(img.getImgOuterUrl())) {
					shopRirekiImg.setImgUpdateKbn(ImgUpdateKbn.UPDATE.getValue());
				}
				if (shopRirekiImg.getImgPriority() == Short.MIN_VALUE) {
					shopRirekiImg.setImgPriority(null);
				}
			}
		}

		// upload
		if (!CollectionUtils.isEmpty(images)) {
			this.shopService.uploadShopImage(images);
		}

		// 更新者のＩＤを設定
		final SessionBean sessionBean = SessionBeanManager.getSessionBean(request);
		final String operUserId = sessionBean.getUserId();

		try {
			final Integer pkShopRireki = this.shopService.updateShopImage(dto);
			// 更新成功ログ、メッセージ設定
			this.loggingService.write("01009", operUserId, SessionStatus.SUCCESS,
					ApplicationResources.getProperty("shop.code") + input.getShopcd(), this.getClass().getName());

			saveMsg(request, "INFO.M.SHOP_BUKKEN.0016", ApplicationResources.getProperty("shop.basicInfo"));

		}
		catch (final InProcessingException e) {
			saveErrMsg(request, "ERROR.M.SHOP_BUKKEN.0010");
			this.loggingService.write("01009", operUserId, SessionStatus.FAILURE,
					ApplicationResources.getProperty("shop.code") + shopRireki.getShopcd(), this.getClass().getName());
		}
		catch (final Exception e) {
			this.logger.error(e.getMessage(), e);
			// 更新失敗ログ
			this.loggingService.write("01009", operUserId, SessionStatus.FAILURE,
					ApplicationResources.getProperty("shop.code") + input.getShopcd(), this.getClass().getName());
			saveErrMsg(request, "FETAL.M.SYSTEM.0001");
		}

		return mv;
	}

	/**
	 * @param result
	 * @param request
	 */
	private void sortErrors(final BindingResult result, final HttpServletRequest request){
		final List<String> sortErrorsList = new ArrayList<String>();
		List<FieldError> feList = result.getFieldErrors();
		for(final FieldError fe: feList){
			sortErrorsList.add(fe.getField());
		}
		Collections.sort(sortErrorsList, new errorMsgComparator());
		request.setAttribute("sortErrorsList", sortErrorsList);
	}

	/**
	 * @param input
	 * @param result
	 */
	private void additionalValidation(final ShopImageUpdateForm input, final BindingResult result) {
		int loopCnt = 0;
		for (final  ShopImageUpdateForm.Img img : input.getImgs()) {
			if (!img.isDel() && !img.isNoValidate()) {
				if (StringUtils.hasText(img.getImgUrlPath()) || ((img.getFile() != null) && (img.getFile().getSize() > 0))) {

				}else if(StringUtils.hasText(img.getImgOuterUrl())){

				}else{
					result.rejectValue("imgs[" + loopCnt + "].file", "WARN.MSG.0001",
							new Object[]{new DefaultMessageSourceResolvable(new String[]{ "imgs[" +loopCnt + "].requiredFileOrUrl","requiredFileOrUrl"},"imgs[" + loopCnt + "].requiredFileOrUrl")} , "");
				}
			}
			loopCnt++;
		}
	}

	/**
	 * @param shopcd
	 * @return
	 */
	@ModelAttribute
	protected ShopImageUpdateForm getForm(final String shopcd) {
		final ShopImageUpdateForm input = new ShopImageUpdateForm();
		return input;
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
