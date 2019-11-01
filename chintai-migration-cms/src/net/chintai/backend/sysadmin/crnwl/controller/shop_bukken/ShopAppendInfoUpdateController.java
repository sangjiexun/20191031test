package net.chintai.backend.sysadmin.crnwl.controller.shop_bukken;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.session.SessionBean;
import net.chintai.backend.sysadmin.common.session.SessionBeanManager;
import net.chintai.backend.sysadmin.crnwl.controller.support.BaseController;
import net.chintai.backend.sysadmin.crnwl.dto.ShopAppendInfo;
import net.chintai.backend.sysadmin.crnwl.exception.InProcessingException;
import net.chintai.backend.sysadmin.crnwl.form.shop_bukken.ShopAppendInfoUpdateForm;
import net.chintai.backend.sysadmin.crnwl.form.shop_bukken.ShopAppendInfoUpdateForm.Area;
import net.chintai.backend.sysadmin.crnwl.form.shop_bukken.ShopAppendInfoUpdateForm.CharComment;
import net.chintai.backend.sysadmin.crnwl.form.shop_bukken.ShopAppendInfoUpdateForm.Comment;
import net.chintai.backend.sysadmin.crnwl.form.shop_bukken.ShopAppendInfoUpdateForm.Eki;
import net.chintai.backend.sysadmin.crnwl.service.MasterService;
import net.chintai.backend.sysadmin.crnwl.service.ShopService;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.batch.common.GenericFlg;
import net.chintai.batch.common.domain.MstShopCharacter;
import net.chintai.batch.common.domain.MstShopCharacterExclGroup;
import net.chintai.batch.common.domain.ShopRireki;
import net.chintai.batch.common.domain.ShopRirekiCharacter;
import net.chintai.batch.common.domain.ShopRirekiComment;
import net.chintai.batch.common.domain.ShopRirekiProudArea;
import net.chintai.batch.common.domain.ShopRirekiProudEki;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * <pre>
 * ShopAppendInfoUpdate
 * </pre>
 * @author hasegawa
 * @lastModified $Date: 2014-08-07 15:08:25 +0900 (木, 07 8 2014) $ by $Author: hasegawa $
 * @version $Revision: 4294 $
 * @since 1.0
 */
@Controller
@RequestMapping(value = "/shop_bukken")
public class ShopAppendInfoUpdateController extends BaseController {
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
	 */
	@RequestMapping(value = "ShopAppendInfoUpdate.admin", method = RequestMethod.GET)
	public ModelAndView edit(final ShopAppendInfoUpdateForm input, final HttpServletRequest request,
			final HttpServletResponse response) {
		final ModelAndView mv = new ModelAndView();
		final ShopRireki shopRireki = this.shopService.selectShopRirekiByShopcd(input.getShopcd());
		input.setShopcd(shopRireki.getShopcd());
		input.setShopKanriUpdDt(this.shopService.selectShopKanriByPrimaryKey(input.getShopcd()).getUpdDt());

		for (final ShopRirekiComment comment : this.shopService.selectShopRirekiCommentByPkShopRireki(shopRireki
				.getPkShopRireki())) {
			final ShopAppendInfoUpdateForm.Comment c = new ShopAppendInfoUpdateForm.Comment();
			Utils.copyProperties(comment, c);
			input.getComments().put(comment.getCommentKbn(), c);
		}

		int i = 0;
		for (final ShopRirekiCharacter comment : this.shopService.selectShopRirekiCharacterByPkShopRireki(shopRireki
				.getPkShopRireki())) {
			final ShopAppendInfoUpdateForm.CharComment c = new ShopAppendInfoUpdateForm.CharComment();
			Utils.copyProperties(comment, c);
			input.getCharComments().put(comment.getCharKbn(), c);
			if (GenericFlg.ON.getValue().equals(c.getPriorityDispFlg())) {
				i++;
			}
			if (i > 3) {
				c.setPriorityDispFlg(GenericFlg.OFF.getValue());
			}
		}

		for (final ShopRirekiProudArea rec : this.shopService.selectShopRirekiProudAreaByPkShopRireki(shopRireki
				.getPkShopRireki())) {
			final ShopAppendInfoUpdateForm.Area c = new ShopAppendInfoUpdateForm.Area();
			Utils.copyProperties(rec, c);
			input.getAreas().put((int) rec.getEntryNo(), c);
		}

		for (final ShopRirekiProudEki rec : this.shopService.selectShopRirekiProudEkiByPkShopRireki(shopRireki
				.getPkShopRireki())) {
			final ShopAppendInfoUpdateForm.Eki c = new ShopAppendInfoUpdateForm.Eki();
			Utils.copyProperties(rec, c);
			input.getEkis().put((int) rec.getEntryNo(), c);
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
	@RequestMapping(value = "ShopAppendInfoUpdateConfirm.admin", method = RequestMethod.POST)
	public ModelAndView confirm(@Valid
	final ShopAppendInfoUpdateForm input, final BindingResult result, final HttpServletRequest request,
			final HttpServletResponse response) {

		additionalValidation(input, result);

		final ModelAndView mv = new ModelAndView();
		if (isCancelled(request)) {
			final RedirectView view = new RedirectView("/shop_bukken/ShopInfo.do?shopCd=" + input.getShopcd(), true);
			mv.setView(view);
			return mv;
		}
		if (result.hasErrors()) {
			mv.setViewName("shop_bukken/ShopAppendInfoUpdate");
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
	 * @return
	 */
	@RequestMapping(value = "ShopAppendInfoUpdateCommit.admin", method = RequestMethod.POST)
	public ModelAndView commit(@Valid
	final ShopAppendInfoUpdateForm input, final BindingResult result, final HttpServletRequest request,
			final HttpServletResponse response) {

		additionalValidation(input, result);

		final ModelAndView mv = new ModelAndView();
		if (result.hasErrors() || isCancelled(request)) {
			mv.setViewName("shop_bukken/ShopAppendInfoUpdate");
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

		final ShopAppendInfo dto = new ShopAppendInfo();
		Utils.copyProperties(input, dto);
		final ShopRireki shopRireki = this.shopService.selectShopRirekiByShopcd(input.getShopcd());
		Utils.copyProperties(input, shopRireki);
		dto.setShopRireki(shopRireki);

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

		final List<ShopRirekiProudArea> shopRirekiProudAreas = new ArrayList<>();
		for (final Entry<Integer, Area> e : input.getAreas().entrySet()) {
			final Area area = e.getValue();
			final ShopRirekiProudArea shopRirekiProudArea = new ShopRirekiProudArea();
			Utils.copyProperties(area, shopRirekiProudArea);
			shopRirekiProudArea.setEntryNo((short) (int) e.getKey());
			shopRirekiProudAreas.add(shopRirekiProudArea);
		}
		dto.setShopRirekiProudAreas(shopRirekiProudAreas);

		final List<ShopRirekiProudEki> shopRirekiProudEkis = new ArrayList<>();
		for (final Entry<Integer, Eki> e : input.getEkis().entrySet()) {
			final Eki eki = e.getValue();
			final ShopRirekiProudEki shopRirekiProudEki = new ShopRirekiProudEki();
			Utils.copyProperties(eki, shopRirekiProudEki);
			shopRirekiProudEki.setEntryNo((short) (int) e.getKey());
			shopRirekiProudEkis.add(shopRirekiProudEki);
		}
		dto.setShopRirekiProudEkis(shopRirekiProudEkis);

		final List<ShopRirekiCharacter> shopRirekiCharacters = new ArrayList<>();
		for (final Entry<String, CharComment> e : input.getCharComments().entrySet()) {
			final CharComment character = e.getValue();
			final ShopRirekiCharacter shopRirekiCharacter = new ShopRirekiCharacter();
			Utils.copyProperties(character, shopRirekiCharacter);
			shopRirekiCharacter.setCharKbn(e.getKey());
			shopRirekiCharacters.add(shopRirekiCharacter);
		}
		dto.setShopRirekiCharacters(shopRirekiCharacters);

		try {
			final Integer pkShopRireki = this.shopService.updateShopAppendInfo(dto);
			// 更新成功ログ、メッセージ設定
			this.loggingService.write("01015", operUserId, SessionStatus.SUCCESS, "店舗コード " + input.getShopcd(), this
					.getClass().getName());
			saveMsg(request, "INFO.M.SHOP_BUKKEN.0028", ApplicationResources.getProperty("shop.appendInfo"));
		}
		catch (final InProcessingException e) {
			saveErrMsg(request, "ERROR.M.SHOP_BUKKEN.0010");
			this.loggingService.write("01015", operUserId, SessionStatus.FAILURE,
					ApplicationResources.getProperty("shop.code") + shopRireki.getShopcd(), this.getClass().getName());
		}
		catch (/* ApplicationException */final Exception e) {
			// 更新失敗ログ
			this.loggingService.write("01015", operUserId, SessionStatus.FAILURE, "店舗コード " + input.getShopcd(), this
					.getClass().getName());
			saveErrMsg(request, "FETAL.M.SYSTEM.0001");
		}

		return mv;
	}

	/**
	 * @param input
	 * @param result
	 */
	private void additionalValidation(final ShopAppendInfoUpdateForm input, final BindingResult result) {

		{
			Map<String, MstShopCharacter> map;
			try {
				map = Utils.toKeyObject(this.masterService.selectMstShopCharacter(), "charKbn");
			}
			catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
				throw new RuntimeException(e.getMessage(), e);
			}

			final List<String> list = new ArrayList<>();
			for (final Map.Entry<String, ShopAppendInfoUpdateForm.CharComment> e : input.getCharComments().entrySet()) {
				final MstShopCharacter mstShopCharacter = map.get(e.getKey());
				if (StringUtils.hasText(mstShopCharacter.getCharExclusiveGroupKbn())) {
					if (!list.contains(mstShopCharacter.getCharExclusiveGroupKbn())) {
						list.add(mstShopCharacter.getCharExclusiveGroupKbn());
					}
					else {

						final MstShopCharacterExclGroup exclGroup = this.masterService
								.selectMstShopCharacterExclGroupByPrimaryKey(mstShopCharacter
										.getCharExclusiveGroupKbn());

						result.rejectValue(
								"charComments[" + e.getKey() + "].charComment",
								"WARN.MSG.000x",
								new Object[] { new DefaultMessageSourceResolvable(new String[] {
										"charComments[" + e.getKey() + "].charComment", "charComment" },
										"charComments[" + e.getKey() + "].charComment") },
								"特徴条件データの"
										+ (exclGroup != null ? exclGroup.getCharExclusiveGroupName() : mstShopCharacter
												.getCharExclusiveGroupKbn()) + "はいずれか1つを設定してください。");

					}
				}
			}
		}

		// {
		// Map<String, MstShopCharacter> map;
		// try {
		// map = Utils.toKeyObject(this.masterService.selectMstShopCharacter(), "charKbn");
		// }
		// catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
		// throw new RuntimeException(e.getMessage(), e);
		// }
		// for (final Map.Entry<String, ShopAppendInfoUpdateForm.CharComment> e : input.getCharComments().entrySet()) {
		// if (ConstValues.FLG_ON.equals(map.get(e.getKey()).getCharCommentRequiredFlg())) {
		// if (!StringUtils.hasText(e.getValue().getCharComment())) {
		// result.rejectValue(
		// "charComments[" + e.getKey() + "].charComment",
		// "WARN.MSG.0001",
		// new Object[] { new DefaultMessageSourceResolvable(new String[] {
		// "charComments[" + e.getKey() + "].charComment", "charComment" },
		// "charComments[" + e.getKey() + "].charComment") }, "");
		//
		// }
		// }
		//
		// }
		// }
		// {
		// Map<String, net.chintai.batch.common.domain.MstCommentKbn> map;
		// try {
		// map = Utils.toKeyObject(
		// this.masterService.selectMstCommentKbnByDataKbn(MstCommentKbn.DATA_KBN_SHOP.getValue()),
		// "commentKbn");
		// }
		// catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
		// throw new RuntimeException(e.getMessage(), e);
		// }
		// for (final Map.Entry<String, ShopAppendInfoUpdateForm.Comment> e : input.getComments().entrySet()) {
		// if (ConstValues.FLG_ON.equals(map.get(e.getKey()).getCommentRequiredFlg())) {
		// if (!StringUtils.hasText(e.getValue().getCommentText())) {
		// result.rejectValue(
		// "comments[" + e.getKey() + "].commentText",
		// "WARN.MSG.0001",
		// new Object[] { new DefaultMessageSourceResolvable(new String[] {
		// "comments[" + e.getKey() + "].commentText", "commentText" }, "comments["
		// + e.getKey() + "].commentText") }, "");
		// }
		// }
		//
		// }
		// }
	}

	/**
	 * @param shopcd
	 * @return
	 */
	@ModelAttribute
	protected ShopAppendInfoUpdateForm getForm(final String shopcd) {
		final ShopAppendInfoUpdateForm input = new ShopAppendInfoUpdateForm();
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
