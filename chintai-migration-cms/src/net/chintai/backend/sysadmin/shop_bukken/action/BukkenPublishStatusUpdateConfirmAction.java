/*
 * $Id: BukkenPublishStatusUpdateConfirmAction.java 3953 2008-05-30 09:41:09Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/03  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.action;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.shop_bukken.action.view.BukkenInfoView;
import net.chintai.backend.sysadmin.shop_bukken.action.view.BukkenPublishStatusUpdateView;
import net.chintai.backend.sysadmin.shop_bukken.service.BukkenInfoService;
import net.chintai.backend.sysadmin.shop_bukken.service.BukkenPublishStatusUpdatePageService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenInfoOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenPublishStatusUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenPublishStatusUpdatePageOutServiceBean;

/**
 * 物件掲載状態変更確認アクション。
 *
 * @author Kim Dong Jin
 * @version $Revision: 3953 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class BukkenPublishStatusUpdateConfirmAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm)context.getForm();
        BukkenInfoInServiceBean inServiceBean = new BukkenInfoInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        BukkenInfoService bukkenInfoService =
            (BukkenInfoService)ac.getBean("BukkenInfoService");

        // 物件掲載状態変更画面に遷移Serviceを行う
        BukkenInfoOutServiceBean rs =
                bukkenInfoService.bukkenInfo(inServiceBean);

        final String ablStopDt = rs.getAblStopDt();
        final String ctStopDt = rs.getCtStopDt();
        final String bukkenStatus= (String)form.get("bukkenStatus");

        if(((ctStopDt == null || ablStopDt == null) && "1".equals(bukkenStatus)) || ((ctStopDt != null && ablStopDt != null) && "0".equals(bukkenStatus))){
        	// 通常→通常 または、停止→停止はエラーメッセージを表示
        	// メッセージ設定
            context.setError("WARN.M.SHOP_BUKKEN.0232", ApplicationResources.getProperty("shop_bukken.publishStatus"));
        	context.setForward("error");
        }else{

	        // 物件掲載状態変更画面に遷移ViewHelperに設定
	        BukkenInfoView view = new BukkenInfoView();
	        BeanUtils.copyProperties(view, inServiceBean);
	        BeanUtils.copyProperties(view, rs);

	        // 二重更新防止トークンをセット
	        saveToken(context.getRequest());
	        context.setForward("success", view);
        }
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
        return auth.authenticate(userId, AuthorityId.SHOP_BUKKEN);
    }
}