/*
 * $Id: ProflieUpdatePageBackAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/10  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.profile.action;

import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.profile.action.view.ProfileUpdateView;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;

/**
 * プロフィル更新画面に戻るアクション
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ProflieUpdatePageBackAction extends BaseActionSupport {

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {
        
        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm)context.getForm();
        ProfileUpdateView view = new ProfileUpdateView();

        // 更新時入力されたデータをViewHelperにコピー
        BeanUtils.copyProperties(view, form);

        context.setForward("success",view);
    }

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        return true; // 共通メニューのため権限チェック不要
    }
}