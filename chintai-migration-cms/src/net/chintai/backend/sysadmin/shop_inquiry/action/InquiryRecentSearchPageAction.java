/*
 * $Id: InquiryRecentSearchPageAction.java 3663 2007-12-19 06:50:48Z sim-jongyeon $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/05  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_inquiry.action;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.session.SessionSearchKey;
import net.chintai.backend.sysadmin.shop_inquiry.action.view.InquiryRecentListView;

/**
 * 問い合せ情報検索画面に遷移アクション
 * 
 * @author Kim Dong Jin
 * @version $Revision: 3663 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class InquiryRecentSearchPageAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {
        
        // セッションに保持している検索条件を削除
        context.getSessionBean().getSearchConditionMap().remove(SessionSearchKey.SHOP_INQUIRY_LOGOPERATION);
        
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();

        // ページング状態を設定
        BasePagerCondition condition = new BasePagerCondition();
        InquiryRecentListView view = new InquiryRecentListView(condition);

        BeanUtils.copyProperties(view, form);

        // 検索結果の出力方法を初期化
        // 表示順のデフォルト値を「降順」に設定
        view.setOrderBy("desc");

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
        return auth.authenticate(userId, AuthorityId.SHOP_INQUIRY);
    }
}