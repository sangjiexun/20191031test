package net.chintai.backend.sysadmin.crnwl.controller.shop_bukken;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import net.chintai.backend.sysadmin.crnwl.dto.ShopImageStaff;
import net.chintai.backend.sysadmin.crnwl.exception.InProcessingException;
import net.chintai.backend.sysadmin.crnwl.form.shop_bukken.ShopImageStaffUpdateForm;
import net.chintai.backend.sysadmin.crnwl.service.MasterService;
import net.chintai.backend.sysadmin.crnwl.service.ShopService;
import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.batch.common.ImgCategory;
import net.chintai.batch.common.ImgUpdateKbn;
import net.chintai.batch.common.ShopBukkenKbn;
import net.chintai.batch.common.domain.MstImgKbn;
import net.chintai.batch.common.domain.ShopRireki;
import net.chintai.batch.common.domain.ShopRirekiImg;
import net.chintai.batch.common.domain.ShopRirekiStaff;

import org.springframework.beans.factory.annotation.Autowired;
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
 * ShopImageStaffUpdateController
 * </pre>
 * @author hasegawa
 * @lastModified $Date: 2014-10-14 17:59:47 +0900 (火, 14 10 2014) $ by $Author: kentaro.araya $
 * @version $Revision: 5906 $
 * @since 1.0
 */
@Controller
@RequestMapping(value = "/shop_bukken")
public class ShopImageStaffUpdateController extends BaseController {
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
	@RequestMapping(value = "ShopImageStaffUpdate.admin", method = RequestMethod.GET)
	public ModelAndView edit(final ShopImageStaffUpdateForm input, final HttpServletRequest request,
			final HttpServletResponse response) throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		final ModelAndView mv = new ModelAndView();
		final ShopRireki shopRireki = this.shopService.selectShopRirekiByShopcd(input.getShopcd());
		input.setShopcd(shopRireki.getShopcd());
		input.setImgId(this.shopService.getImgId(input.getShopcd()));
		input.setShopKanriUpdDt(this.shopService.selectShopKanriByPrimaryKey(input.getShopcd()).getUpdDt());

		List<String> staffImgKbns = new ArrayList<>();
		for (MstImgKbn kbn : masterService.selectMstImgKbnByShopBukkenKbnAndImgCategory(ShopBukkenKbn.SHOP.getValue(),
				ImgCategory.STAFF.getValue())) {
			staffImgKbns.add(kbn.getImgKbn());
		}
		int maxStaff = staffImgKbns.size();

		Map<String, ShopRirekiImg> imgMap = Utils.toKeyObject(
				this.shopService.selectShopRirekiImgByPkShopRireki(shopRireki.getPkShopRireki()), "imgKbn");

		List<String> existsImgKbn = new ArrayList<>();
		for (final ShopRirekiStaff shopRirekiStaff : shopService.selectShopRirekiStaffByPkShopRireki(shopRireki
				.getPkShopRireki())) {
			final ShopImageStaffUpdateForm.Staff staff = new ShopImageStaffUpdateForm.Staff();
			Utils.copyProperties(shopRirekiStaff, staff);
			//staff.setDel(false);
			staff.setExistCurrentShopRirekiStaff(true);
			if (imgMap.containsKey(staff.getImgKbn())) {
				Utils.copyProperties(imgMap.get(staff.getImgKbn()), staff);
				existsImgKbn.add(staff.getImgKbn());
			}
			input.getStaffs().put(shopRirekiStaff.getEntryNo().intValue(), staff);

		}
		// 空をつくる
		for (int i = input.getStaffs().size() + 1; i <= maxStaff; i++) {
			input.getStaffs().put(i, new ShopImageStaffUpdateForm.Staff());
		}
		// あいているimgkbnをセット
		staffImgKbns.removeAll(existsImgKbn);
		for (Map.Entry<Integer, ShopImageStaffUpdateForm.Staff> e : input.getStaffs().entrySet()) {
			ShopImageStaffUpdateForm.Staff staff = e.getValue();
			if (!StringUtils.hasText(staff.getImgKbn())) {
				staff.setImgKbn(staffImgKbns.remove(0));
			}
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
	@RequestMapping(value = "ShopImageStaffUpdateConfirm.admin", method = RequestMethod.POST)
	public ModelAndView confirm(@Valid
	final ShopImageStaffUpdateForm input, final BindingResult result, final HttpServletRequest request,
			final HttpServletResponse response) throws IllegalStateException, IOException {

		additionalValidation(input, result);

		final ModelAndView mv = new ModelAndView();
		if (isCancelled(request)) {

			// delete tmp
			final List<String> delList = new ArrayList<>();
			for (final Map.Entry<Integer, ShopImageStaffUpdateForm.Staff> e : input.getStaffs().entrySet()) {
				final ShopImageStaffUpdateForm.Staff img = e.getValue();
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

			mv.setViewName("shop_bukken/ShopImageStaffUpdate");
			return mv;
		}

		// save img
		final String imgId = input.getImgId();
		for (final Map.Entry<Integer, ShopImageStaffUpdateForm.Staff> e : input.getStaffs().entrySet()) {
			final ShopImageStaffUpdateForm.Staff img = e.getValue();
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
	@RequestMapping(value = "ShopImageStaffUpdateCommit.admin", method = RequestMethod.POST)
	public ModelAndView commit(@Valid
	final ShopImageStaffUpdateForm input, final BindingResult result, final HttpServletRequest request,
			final HttpServletResponse response) {

		additionalValidation(input, result);

		final ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			//エラーメッセージのソート用リスト。
			sortErrors(result, request);
		}
		if (result.hasErrors() || isCancelled(request)) {
			mv.setViewName("shop_bukken/ShopImageStaffUpdate");
			return mv;
		}

		final RedirectView view = new RedirectView("/shop_bukken/ShopInfo.do?shopCd=" + input.getShopcd(), true);
		mv.setView(view);

		// 画面リロード対策
		if (isTokenInValid(request, true)) {
			return mv;
		}

		resetToken(request);

		final ShopImageStaff dto = new ShopImageStaff();
		Utils.copyProperties(input, dto);

		final ShopRireki shopRireki = this.shopService.selectShopRirekiByShopcd(input.getShopcd());
		Utils.copyProperties(input, shopRireki);
		dto.setShopRireki(shopRireki);

		final List<Path> images = new ArrayList<>();
		short i = 1;
		for (final Map.Entry<Integer, ShopImageStaffUpdateForm.Staff> e : input.getStaffs().entrySet()) {
			final ShopImageStaffUpdateForm.Staff staff = e.getValue();
			if (!staff.isDel() && !staff.isNoValidate()) {

				ShopRirekiStaff shopRirekiStaff = new ShopRirekiStaff();
				Utils.copyProperties(staff, shopRirekiStaff);
				shopRirekiStaff.setEntryNo(i);
				dto.getShopRirekiStaffs().add(shopRirekiStaff);
				i++;

				if (StringUtils.hasText(staff.getImgFileNm()) || StringUtils.hasText(staff.getImgOuterUrl())) {
					final ShopRirekiImg shopRirekiImg = new ShopRirekiImg();
					Utils.copyProperties(staff, shopRirekiImg, "imgVerDt", "imgUrlPath", "imgFileNm", "imgIdLast");
					dto.getShopRirekiImgs().add(shopRirekiImg);
					shopRirekiImg.setImgUpdateKbn(ImgUpdateKbn.NO_UPDATE.getValue());
					if (staff.getImgUrlPath().startsWith("/tmp/img/")) {
						images.add(Paths.get(this.servletContext.getRealPath("/tmp/img/") + File.separator
								+ staff.getImgFileNm()));
						shopRirekiImg.setImgUpdateKbn(ImgUpdateKbn.UPDATE.getValue());
					}
					if (StringUtils.hasText(shopRirekiImg.getImgOuterUrl())) {
						shopRirekiImg.setImgUpdateKbn(ImgUpdateKbn.UPDATE.getValue());
					}
				}else{
					shopRirekiStaff.setImgKbn(null);
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
			final Integer pkShopRireki = this.shopService.updateShopImageStaff(dto);
			// 更新成功ログ、メッセージ設定
			this.loggingService.write("01020", operUserId, SessionStatus.SUCCESS,
					ApplicationResources.getProperty("shop.code") + input.getShopcd(), this.getClass().getName());

			saveMsg(request, "INFO.M.SHOP_BUKKEN.0016", ApplicationResources.getProperty("shop.staffUpdate"));

		}
		catch (final InProcessingException e) {
			saveErrMsg(request, "ERROR.M.SHOP_BUKKEN.0010");
			this.loggingService.write("01020", operUserId, SessionStatus.FAILURE,
					ApplicationResources.getProperty("shop.code") + shopRireki.getShopcd(), this.getClass().getName());
		}
		catch (final Exception e) {
			this.logger.error(e.getMessage(), e);
			// 更新失敗ログ
			this.loggingService.write("01020", operUserId, SessionStatus.FAILURE,
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
	private void additionalValidation(final ShopImageStaffUpdateForm input, final BindingResult result) {
	}

	/**
	 * @param shopcd
	 * @return
	 */
	@ModelAttribute
	protected ShopImageStaffUpdateForm getForm(final String shopcd) {
		final ShopImageStaffUpdateForm input = new ShopImageStaffUpdateForm();
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
