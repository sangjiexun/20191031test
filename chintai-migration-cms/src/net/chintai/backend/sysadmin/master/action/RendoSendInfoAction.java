package net.chintai.backend.sysadmin.master.action;

import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.util.DateUtil;
import net.chintai.backend.sysadmin.crnwl.service.MasterService;
import net.chintai.backend.sysadmin.demand.DemandUtils;
import net.chintai.backend.sysadmin.master.action.view.RendoSendInfoView;
import net.chintai.backend.sysadmin.master.action.view.RendoSendInfoView.RendoSendInfo;
import net.chintai.backend.sysadmin.master.service.RendoSendService;
import net.chintai.backend.sysadmin.master.service.bean.RendoSendInServiceBean;
import net.chintai.backend.sysadmin.master.service.bean.RendoSendInfoOutServiceBean;
import net.chintai.batch.common.GenericFlg;
import net.chintai.batch.common.domain.MstRendo;
import net.chintai.batch.common.domain.MstShopKeiyakuKanri;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * 連動元出稿許可情報ページ
 *
 * @author
 * @version $Revision:
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RendoSendInfoAction extends BaseActionSupport {

	@Autowired
	MasterService masterService;

	/*
	 * (non-Javadoc)
	 * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
	 */
	@Override
	protected void doExecute(BusinessContext context) throws Exception {

		// 画面データ取得
		DynaValidatorForm form = (DynaValidatorForm) context.getForm();
		RendoSendInServiceBean inBean = new RendoSendInServiceBean();
		BeanUtils.copyProperties(inBean, form);
		inBean.setRendoSendNo(null);

		// injection
		ApplicationContext ac = getWebApplicationContext();
		RendoSendService service = (RendoSendService) ac.getBean("rendoSendService");

		// 連動元別の出稿許可情報一覧を取得
		List<RendoSendInfoOutServiceBean> outBeanInfo = service.getRendoSendInfo(inBean);

		// viewHelper設定
		RendoSendInfoView view = new RendoSendInfoView();
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

		// 現在適用中の許可情報を探す為、現在日時を取得
		String nowTimestamp = DateUtil.getToday("yyyyMMddHHmmss");
		Boolean isFoundApply = false;

		// viewに出稿許可情報を設定
		for (int i = 0; i < outBeanInfo.size(); i++) {
			RendoSendInfo viewChild = view.new RendoSendInfo();
			BeanUtils.copyProperties(viewChild, outBeanInfo.get(i));
			String startDt = viewChild.getPermitStartDt();
			String endDt = viewChild.getPermitEndDt();
			// 許可情報を削除できるか
			if (startDt.compareTo(nowTimestamp) > 0 ) {
				viewChild.setDelFlg(GenericFlg.ON.getValue());
			}
			viewChild.setLinkFlg(GenericFlg.OFF.getValue());
			viewChild.setAppliedFlg(GenericFlg.OFF.getValue());
			// 許可情報を編集できるか
			if (!endDt.equals("") && endDt.compareTo(nowTimestamp) <= 0) {
				isFoundApply = true;
			} else if (!isFoundApply) {
				viewChild.setLinkFlg(GenericFlg.ON.getValue());
				// 適用中の出稿管理か
				if (nowTimestamp.compareTo(startDt) >= 0) {
					viewChild.setAppliedFlg(GenericFlg.ON.getValue());
					isFoundApply = true;
				}
			}
			viewChild.setPermitStartYmForDisplay(DemandUtils.convertDateAll(viewChild.getPermitStartDt()));
			viewChild.setPermitEndYmForDisplay(DemandUtils.convertDateAll(viewChild.getPermitEndDt()));
			view.setRendoSendDetailList(viewChild);
		}

		context.setForward("success", view);
	}

	/*
	 * (non-Javadoc)
	 * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
	 */
	@Override
	protected boolean isAuthorized(String userId) {
		ApplicationContext ac = getWebApplicationContext();
		AuthService auth = (AuthService) ac.getBean("authService");
		return auth.authenticate(userId, AuthorityId.MASTER);
	}

}
