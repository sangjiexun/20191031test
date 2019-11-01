package net.chintai.backend.sysadmin.dataoutput.action;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.dataoutput.action.view.ShopSkipSettingView;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;


/**
 * 店舗別データ元出力設定画面初期表示Action
 * @author watanabe
 * @version $Revision: 4737 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopSkipSettingInfoAction extends BaseActionSupport {

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
	 */
	@Override
	protected boolean isAuthorized(String userId) {
		ApplicationContext ac = getWebApplicationContext();
		AuthService auth = (AuthService) ac.getBean("authService");
		return auth.authenticate(userId, AuthorityId.DATA_OUTPUT);
	}

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
	 */
	@Override
	protected void doExecute(BusinessContext context) throws Exception {
		// 画面データの取得
		DynaValidatorForm form = (DynaValidatorForm) context.getForm();

		// 取得した検索条件をViewHelperにセットする。
		ShopSkipSettingView view = new ShopSkipSettingView();
		BeanUtils.copyProperties(view, form);
		context.setForward("success", view);
	}

}
