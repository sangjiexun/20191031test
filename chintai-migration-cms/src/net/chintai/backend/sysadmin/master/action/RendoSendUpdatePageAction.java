package net.chintai.backend.sysadmin.master.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.util.DateUtil;
import net.chintai.backend.sysadmin.crnwl.service.MasterService;
import net.chintai.backend.sysadmin.demand.DemandUtils;
import net.chintai.backend.sysadmin.master.action.view.RendoSendUpdateView;
import net.chintai.backend.sysadmin.master.service.RendoSendService;
import net.chintai.backend.sysadmin.master.service.bean.RendoSendInServiceBean;
import net.chintai.backend.sysadmin.master.service.bean.RendoSendInfoOutServiceBean;
import net.chintai.batch.common.GenericFlg;
import net.chintai.batch.common.domain.MstRendo;
import net.chintai.batch.common.domain.MstShopKeiyakuKanri;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * 連動元出稿許可情報の編集ページ
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RendoSendUpdatePageAction extends BaseActionSupport {

	@Autowired
	MasterService masterService;

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
	 */
	protected void doExecute(BusinessContext context) throws Exception {
		// 画面データ取得
		DynaValidatorForm form = (DynaValidatorForm) context.getForm();
		RendoSendInServiceBean inBean = new RendoSendInServiceBean();
		BeanUtils.copyProperties(inBean, form);

		// injection
		ApplicationContext ac = getWebApplicationContext();
		RendoSendService service = (RendoSendService) ac.getBean("rendoSendService");

		// viewHelper設定
		RendoSendUpdateView view = new RendoSendUpdateView();
		BeanUtils.copyProperties(view, form);
		MstShopKeiyakuKanri mstShopKeiyakuKanri = masterService.selectMstShopKeiyakuKanriByPrimaryKey(inBean.getKeiyakuCd(), inBean.getKeiyakuSubCd());
		if (mstShopKeiyakuKanri == null || mstShopKeiyakuKanri.getRendoSendKanriFlg().equals(GenericFlg.OFF.getValue())) {
			throw new ApplicationException("FETAL.M.SYSTEM.0001");
		}
		view.setKeiyakuName(mstShopKeiyakuKanri.getRendoSendDispName());
		MstRendo mstRendo = masterService.selectMstRendoByPrimaryKey(inBean.getRendoCd());
		if (mstRendo == null || mstRendo.getSendKanriFlg().equals(GenericFlg.OFF.getValue())) {
			throw new ApplicationException("FETAL.M.SYSTEM.0001");
		}
		BeanUtils.copyProperties(view, mstRendo);

		view.setApplyYearList(DemandUtils.getYearList());
		view.setNowDate(DateUtil.getToday("yyyyMMddHHmmss"));

		// 連動元出稿情報取得
		List<RendoSendInfoOutServiceBean> outBeanInfo = new ArrayList<RendoSendInfoOutServiceBean>();
		// 許可番号があれば更新処理
		if (!StringUtils.isEmpty(inBean.getRendoSendNo())) {
			view.setProcKbn("update");
			outBeanInfo = service.getRendoSendInfo(inBean);
			// 戻るボタンなどでformの情報を保持したい場合はスキップ
			if (!form.get("repeatFlg").equals(GenericFlg.ON.getValue())){
				BeanUtils.copyProperties(view, outBeanInfo.get(0));
			}
			// 出稿許可開始日を編集できるか
			if (outBeanInfo.get(0).getPermitStartDt().compareTo(view.getNowDate()) >= 0) {
				view.setPermitStartEditFlg(GenericFlg.ON.getValue());
			}
		// 許可番号なければ登録処理
		} else {
			view.setProcKbn("insert");
			view.setPermitStartEditFlg(GenericFlg.ON.getValue());
		}

		view.setPermitStartDtForDisplay(DemandUtils.convertDateAll(view.getPermitStartDt()));
		view.setPermitEndDtForDisplay(DemandUtils.convertDateAll(view.getPermitEndDt()));
		view.setApplyYearList(DemandUtils.getYearList());

		context.setForward("success", view);
	}

	@Override
	protected boolean isAuthorized(String userId) {
		ApplicationContext ac = getWebApplicationContext();
		AuthService auth = (AuthService) ac.getBean("authService");
		return auth.authenticate(userId, AuthorityId.MASTER);
	}
}
