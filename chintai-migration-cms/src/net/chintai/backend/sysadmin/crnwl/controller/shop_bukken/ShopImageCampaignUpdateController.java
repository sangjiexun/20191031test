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
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.Validator;

import jp.co.interoffice.util.Utils;
import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.ConstValues;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.session.SessionBean;
import net.chintai.backend.sysadmin.common.session.SessionBeanManager;
import net.chintai.backend.sysadmin.crnwl.MstCommentKbn;
import net.chintai.backend.sysadmin.crnwl.controller.support.BaseController;
import net.chintai.backend.sysadmin.crnwl.controller.support.BaseController.errorMsgComparator;
import net.chintai.backend.sysadmin.crnwl.dto.ShopImageCampaign;
import net.chintai.backend.sysadmin.crnwl.exception.InProcessingException;
import net.chintai.backend.sysadmin.crnwl.form.shop_bukken.ShopImageCampaignUpdateForm;
import net.chintai.backend.sysadmin.crnwl.form.shop_bukken.ShopImageCampaignUpdateForm.Comment;
import net.chintai.backend.sysadmin.crnwl.service.MasterService;
import net.chintai.backend.sysadmin.crnwl.service.ShopService;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.batch.common.ImgCategory;
import net.chintai.batch.common.ImgUpdateKbn;
import net.chintai.batch.common.ShopBukkenKbn;
import net.chintai.batch.common.domain.MstImgKbn;
import net.chintai.batch.common.domain.ShopRireki;
import net.chintai.batch.common.domain.ShopRirekiCampaign;
import net.chintai.batch.common.domain.ShopRirekiComment;
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
 * ShopImageCampaignUpdateController
 * </pre>
 * @author hasegawa
 * @lastModified $Date: 2014-10-14 17:59:47 +0900 (火, 14 10 2014) $ by $Author: kentaro.araya $
 * @version $Revision: 5906 $
 * @since 1.0
 */
@Controller
@RequestMapping(value = "/shop_bukken")
public class ShopImageCampaignUpdateController extends BaseController {
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
	@RequestMapping(value = "ShopImageCampaignUpdate.admin", method = RequestMethod.GET)
	public ModelAndView edit(final ShopImageCampaignUpdateForm input, final HttpServletRequest request,
			final HttpServletResponse response) throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		final ModelAndView mv = new ModelAndView();
		final ShopRireki shopRireki = this.shopService.selectShopRirekiByShopcd(input.getShopcd());
		input.setShopcd(shopRireki.getShopcd());
		input.setImgId(this.shopService.getImgId(input.getShopcd()));
		input.setShopKanriUpdDt(this.shopService.selectShopKanriByPrimaryKey(input.getShopcd()).getUpdDt());

		List<String> campaigImgKbns = new ArrayList<>();
		for (MstImgKbn kbn : masterService.selectMstImgKbnByShopBukkenKbnAndImgCategory(ShopBukkenKbn.SHOP.getValue(),
				ImgCategory.CAMPAIGN.getValue())) {
			campaigImgKbns.add(kbn.getImgKbn());
		}
		int maxCampaign = campaigImgKbns.size();

		Map<String, ShopRirekiImg> imgMap = Utils.toKeyObject(
				this.shopService.selectShopRirekiImgByPkShopRireki(shopRireki.getPkShopRireki()), "imgKbn");

		List<String> existsImgKbn = new ArrayList<>();
		for (final ShopRirekiCampaign shopRirekiCampaign : shopService.selectShopRirekiCampaignByPkShopRireki(shopRireki
				.getPkShopRireki())) {
			final ShopImageCampaignUpdateForm.Campaign campaign = new ShopImageCampaignUpdateForm.Campaign();
			Utils.copyProperties(shopRirekiCampaign, campaign);
			//campaign.setDel(false);
			campaign.setExistCurrentShopRirekiCampaign(true);
			if("99991231".equals(campaign.getCampaignEndYmd())){
				campaign.setCampaignEndYmd(null);
			}
			if (imgMap.containsKey(campaign.getImgKbn())) {
				Utils.copyProperties(imgMap.get(campaign.getImgKbn()), campaign);
				existsImgKbn.add(campaign.getImgKbn());
			}
			input.getCampaigns().put(shopRirekiCampaign.getEntryNo().intValue(), campaign);

		}
		// 空をつくる
		for (int i = input.getCampaigns().size() + 1; i <= maxCampaign; i++) {
			input.getCampaigns().put(i, new ShopImageCampaignUpdateForm.Campaign());
		}
		// あいているimgkbnをセット
		campaigImgKbns.removeAll(existsImgKbn);
		for (Map.Entry<Integer, ShopImageCampaignUpdateForm.Campaign> e : input.getCampaigns().entrySet()) {
			ShopImageCampaignUpdateForm.Campaign campaign = e.getValue();
			if (!StringUtils.hasText(campaign.getImgKbn())) {
				campaign.setImgKbn(campaigImgKbns.remove(0));
			}
		}

		for (final ShopRirekiComment comment : this.shopService.selectShopRirekiCommentByPkShopRireki(shopRireki
				.getPkShopRireki())) {
			final ShopImageCampaignUpdateForm.Comment c = new ShopImageCampaignUpdateForm.Comment();
			Utils.copyProperties(comment, c);
			input.getComments().put(comment.getCommentKbn(), c);
		}

		return mv;
	}

	/**
	 * @param input
	 * @param result
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	@RequestMapping(value = "ShopImageCampaignUpdateConfirm.admin", method = RequestMethod.POST)
	public ModelAndView confirm(@Valid
	final ShopImageCampaignUpdateForm input, final BindingResult result, final HttpServletRequest request,
			final HttpServletResponse response) throws IllegalStateException, IOException {

		additionalValidation(input, result);

		final ModelAndView mv = new ModelAndView();
		if (isCancelled(request)) {

			// delete tmp
			final List<String> delList = new ArrayList<>();
			for (final Map.Entry<Integer, ShopImageCampaignUpdateForm.Campaign> e : input.getCampaigns().entrySet()) {
				final ShopImageCampaignUpdateForm.Campaign img = e.getValue();
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

			mv.setViewName("shop_bukken/ShopImageCampaignUpdate");
			return mv;
		}

		// save img
		final String imgId = input.getImgId();
		for (final Map.Entry<Integer, ShopImageCampaignUpdateForm.Campaign> e : input.getCampaigns().entrySet()) {
			final ShopImageCampaignUpdateForm.Campaign img = e.getValue();
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
	@RequestMapping(value = "ShopImageCampaignUpdateCommit.admin", method = RequestMethod.POST)
	public ModelAndView commit(@Valid
	final ShopImageCampaignUpdateForm input, final BindingResult result, final HttpServletRequest request,
			final HttpServletResponse response) {

		additionalValidation(input, result);

		final ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			//エラーメッセージのソート用リスト。
			sortErrors(result, request);
		}
		if (result.hasErrors() || isCancelled(request)) {
			mv.setViewName("shop_bukken/ShopImageCampaignUpdate");
			return mv;
		}

		final RedirectView view = new RedirectView("/shop_bukken/ShopInfo.do?shopCd=" + input.getShopcd(), true);
		mv.setView(view);

		// 画面リロード対策
		if (isTokenInValid(request, true)) {
			return mv;
		}

		resetToken(request);

		final ShopImageCampaign dto = new ShopImageCampaign();
		Utils.copyProperties(input, dto);

		final ShopRireki shopRireki = this.shopService.selectShopRirekiByShopcd(input.getShopcd());
		Utils.copyProperties(input, shopRireki);
		dto.setShopRireki(shopRireki);

		final List<Path> images = new ArrayList<>();
		short i = 1;
		for (final Map.Entry<Integer, ShopImageCampaignUpdateForm.Campaign> e : input.getCampaigns().entrySet()) {
			final ShopImageCampaignUpdateForm.Campaign campaign = e.getValue();
			if (!campaign.isDel() && !campaign.isNoValidate()) {

				ShopRirekiCampaign shopRirekiCampaign = new ShopRirekiCampaign();
				Utils.copyProperties(campaign, shopRirekiCampaign);
				shopRirekiCampaign.setEntryNo(i);
				if(!StringUtils.hasText(shopRirekiCampaign.getCampaignEndYmd())){
					shopRirekiCampaign.setCampaignEndYmd("99991231");
				}
				dto.getShopRirekiCampaigns().add(shopRirekiCampaign);
				i++;

				if (StringUtils.hasText(campaign.getImgFileNm()) || StringUtils.hasText(campaign.getImgOuterUrl())) {
					final ShopRirekiImg shopRirekiImg = new ShopRirekiImg();
					Utils.copyProperties(campaign, shopRirekiImg, "imgVerDt", "imgUrlPath", "imgFileNm", "imgIdLast");
					dto.getShopRirekiImgs().add(shopRirekiImg);
					shopRirekiImg.setImgUpdateKbn(ImgUpdateKbn.NO_UPDATE.getValue());
					if (campaign.getImgUrlPath().startsWith("/tmp/img/")) {
						images.add(Paths.get(this.servletContext.getRealPath("/tmp/img/") + File.separator
								+ campaign.getImgFileNm()));
						shopRirekiImg.setImgUpdateKbn(ImgUpdateKbn.UPDATE.getValue());
					}
					if (StringUtils.hasText(campaign.getImgOuterUrl())) {
						shopRirekiImg.setImgUpdateKbn(ImgUpdateKbn.UPDATE.getValue());
					}
				}else{
					shopRirekiCampaign.setImgKbn(null);
				}

			}
		}

		final List<ShopRirekiComment> shopRirekiComments = new ArrayList<>();
		for (final Entry<String, Comment> e : input.getComments().entrySet()) {
			final Comment comment = e.getValue();
			if (StringUtils.hasText(comment.getCommentText())) {
				final ShopRirekiComment shopRirekiComment = new ShopRirekiComment();
				Utils.copyProperties(comment, shopRirekiComment);
				shopRirekiComment.setCommentKbn(e.getKey());
				shopRirekiComments.add(shopRirekiComment);
			}
		}
		dto.setShopRirekiComments(shopRirekiComments);

		// upload
		if (!CollectionUtils.isEmpty(images)) {
			this.shopService.uploadShopImage(images);
		}

		// 更新者のＩＤを設定
		final SessionBean sessionBean = SessionBeanManager.getSessionBean(request);
		final String operUserId = sessionBean.getUserId();

		try {
			final Integer pkShopRireki = this.shopService.updateShopImageCampaign(dto);
			// 更新成功ログ、メッセージ設定
			this.loggingService.write("01021", operUserId, SessionStatus.SUCCESS,
					ApplicationResources.getProperty("shop.code") + input.getShopcd(), this.getClass().getName());

			saveMsg(request, "INFO.M.SHOP_BUKKEN.0016", ApplicationResources.getProperty("shop.campaignUpdate"));

		}
		catch (final InProcessingException e) {
			saveErrMsg(request, "ERROR.M.SHOP_BUKKEN.0010");
			this.loggingService.write("01021", operUserId, SessionStatus.FAILURE,
					ApplicationResources.getProperty("shop.code") + shopRireki.getShopcd(), this.getClass().getName());
		}
		catch (final Exception e) {
			this.logger.error(e.getMessage(), e);
			// 更新失敗ログ
			this.loggingService.write("01021", operUserId, SessionStatus.FAILURE,
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
	private void additionalValidation(final ShopImageCampaignUpdateForm input, final BindingResult result) {
		/*
		{
			Map<String, net.chintai.batch.common.domain.MstCommentKbn> map;
			try {
				map = Utils.toKeyObject(
						this.masterService.selectMstCommentKbnByDataKbn(MstCommentKbn.DATA_KBN_SHOP.getValue()),
						"commentKbn");
			}
			catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
			for (final Map.Entry<String, ShopImageCampaignUpdateForm.Comment> e : input.getComments().entrySet()) {
				if (ConstValues.FLG_ON.equals(map.get(e.getKey()).getCommentRequiredFlg())) {
					if (!StringUtils.hasText(e.getValue().getCommentText())) {
						result.rejectValue(
								"comments[" + e.getKey() + "].commentText",
								"WARN.MSG.0001",
								new Object[] { new DefaultMessageSourceResolvable(new String[] {
										"comments[" + e.getKey() + "].commentText", "commentText" }, "comments["
										+ e.getKey() + "].commentText") }, "");
					}
				}

			}
		}
		*/
	}

	/**
	 * @param shopcd
	 * @return
	 */
	@ModelAttribute
	protected ShopImageCampaignUpdateForm getForm(final String shopcd) {
		final ShopImageCampaignUpdateForm input = new ShopImageCampaignUpdateForm();
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

		m.put("campaignRiyoutaisyos", SystemProperties.getProperty("CAMPAIGN_RIYOUTAISYO").split("\\|"));
		m.put("campaignTokutens", SystemProperties.getProperty("CAMPAIGN_TOKUTEN").split("\\|"));
		m.put("campaignJoukens", SystemProperties.getProperty("CAMPAIGN_JOUKEN").split("\\|"));
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
