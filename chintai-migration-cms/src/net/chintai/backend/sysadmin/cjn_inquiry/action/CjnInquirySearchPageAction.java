/*
 * $Id: CjnInquirySearchPageAction.java 3662 2007-12-19 06:47:12Z sim-jongyeon $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/09/29   BGT)児島      新規作成
 * 2007/10/05   BGT)楊恩美    更新
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.action;

import net.chintai.backend.sysadmin.cjn_inquiry.action.view.CjnInquirySearchListView;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryAccessControlService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquirySearchDisposeCountService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquirySearchDisposeCountOutServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquirySearchDisposeCountPageInServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquirySearchInServiceBean;
import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.session.SessionSearchKey;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 問い合せ検索画面を表示するアクション
 * 
 * @author KOJIMA Takanori
 * @author Yang-EunMi
 * @version $Revision: 3662 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquirySearchPageAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // セッションに保持されている検索条件を削除
        context.getSessionBean().getSearchConditionMap().remove(SessionSearchKey.CJN_INQUIRY_SEARCH);
        
        // 検索条件を取得(sequenceを取得)
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        CjnInquirySearchDisposeCountPageInServiceBean inServiceBean =
                new CjnInquirySearchDisposeCountPageInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);
        
        CjnInquirySearchInServiceBean inSearchBean = new CjnInquirySearchInServiceBean();
        BeanUtils.copyProperties(inSearchBean, form);

        // ページング状態を設定
        BasePagerCondition condition = new BasePagerCondition();

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        // アクセス権限チェック
        CjnInquiryAccessControlService acl =
                (CjnInquiryAccessControlService) ac.getBean("cjnInquiryAccessControlService");
        if (!acl.isAccessibleForKindSeq(context.getSessionBean().getUserId(), inServiceBean.getCjnInqKindSeq())) {
            throw new ApplicationException("ERROR.M.APP.0003");
        }

        // 問い合せ件数取得サービス
        CjnInquirySearchDisposeCountService service =
                (CjnInquirySearchDisposeCountService) ac.getBean("cjnInquirySearchDisposeCountService");

        // ViewHelperにセット
        CjnInquirySearchDisposeCountOutServiceBean outServiceBean = service.selectDisposeCountList(inServiceBean);
        outServiceBean.setCjnInqKindSeq(inServiceBean.getCjnInqKindSeq());
        CjnInquirySearchListView view = new CjnInquirySearchListView(condition);
        BeanUtils.copyProperties(view, outServiceBean);
        BeanUtils.copyProperties(view, inSearchBean);

        // 検索結果の出力方法を初期化
        // ソートキーのデフォルト値を「問い合せ日時」に設定
        view.setSortKey("2");
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
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.CJN_INQUIRY);
    }

}
