package net.chintai.backend.sysadmin.master.action;
import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.master.action.view.RendoSendListView;
import net.chintai.backend.sysadmin.master.action.view.RendoSendListView.RendoSendList;
import net.chintai.backend.sysadmin.master.service.RendoSendService;
import net.chintai.backend.sysadmin.master.service.bean.RendoSendListOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.ApplicationContext;

/**
 * 連動元別出稿管理リスト
 * @author watanabe
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RendoSendListAction extends BaseActionSupport {

	/*
	 * (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
	 */
	@Override
	protected void doExecute(BusinessContext context) throws Exception {

		// Injection
		ApplicationContext ac = getWebApplicationContext();

		RendoSendListView view = new RendoSendListView();
		RendoSendService service= (RendoSendService) ac.getBean("rendoSendService");

		// 全連動元の出稿許可リスト取得
		List<RendoSendListOutServiceBean> outBeanList = service.getRendoSendList(null);

		for (RendoSendListOutServiceBean outBean : outBeanList) {
			RendoSendList viewChild = view.new RendoSendList();
			BeanUtils.copyProperties(viewChild, outBean);
			// 既に同じ連動元があれば追加しない
			if (view.getRendoSendDetailMap() == null || !view.getRendoSendDetailMap().containsKey(outBean.getRendoCd())) {
				view.setRendoSendDetailMap(outBean.getRendoCd(), viewChild);
			}
			view.getRendoSendDetailMap().get(outBean.getRendoCd())
				.setPermitInfoMap(outBean.getKeiyakuCd(), outBean.getKeiyakuSubCd(), new String[]{outBean.getPermitFlg(), outBean.getReserveCnt()});
			view.setKeiyakuNameMap(outBean.getKeiyakuCd(), outBean.getKeiyakuSubCd(), outBean.getRendoSendDispName());
		}
		context.setForward("success", view);
	}

	/*
	 * (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
	 */
	@Override
	protected boolean isAuthorized(String userId) {
		// 権限チェック
		ApplicationContext ac = getWebApplicationContext();
		AuthService auth = (AuthService) ac.getBean("authService");
		return auth.authenticate(userId, AuthorityId.MASTER);
	}
}