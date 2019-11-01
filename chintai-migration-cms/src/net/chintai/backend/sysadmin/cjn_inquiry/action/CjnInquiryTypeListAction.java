/*
 * $Id: CjnInquiryTypeListAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.chintai.backend.sysadmin.cjn_inquiry.action.view.CjnInquiryTypeListView;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryTypeListService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryTypeListOutServiceBean;
import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.ApplicationContext;

/**
 * 問い合せ種別一覧画面を表示するアクション。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryTypeListAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        CjnInquiryTypeListService service =
                (CjnInquiryTypeListService) ac.getBean("cjnInquiryTypeListService");

        // ----- Service Execute ----- //
        // 問い合せ種別一覧取得
        List<CjnInquiryTypeListOutServiceBean> rsList = service.selectTypeList();
        
        // 問い合せ閲覧可能ユーザリストのリスト取得
        Map<Integer, List<String>> readableUsersMap = service.selectReadableUsersListsMap();
        
        // 現ユーザのCHINTAI問い合せ種別を取得
        String userId = context.getSessionBean().getUserId();
        String cjnAccountType = service.selectAccountType(userId);
        
        // 現ユーザの閲覧可能問い合せ種別一覧を取得
        List<Integer> kindSeqList = service.selectKindSeqList(userId);
        
        // ----- Create ViewHelper -----//
        List<CjnInquiryTypeListView.CjnInquiryTypeListDetailView> viewList =
                new ArrayList<CjnInquiryTypeListView.CjnInquiryTypeListDetailView>();
        CjnInquiryTypeListView view = new CjnInquiryTypeListView();

        for (int i = 0; i < rsList.size(); i++) {
            
            // 問い合せ種別情報
            CjnInquiryTypeListView.CjnInquiryTypeListDetailView viewDetail = view.new CjnInquiryTypeListDetailView();
            BeanUtils.copyProperties(viewDetail, rsList.get(i));

            // 現ユーザはこの問い合せ種別を閲覧可能か？
            if (kindSeqList.contains(rsList.get(i).getCjnInqKindSeq())) {
                viewDetail.setEnabled(true);
            } else {
                viewDetail.setEnabled(false);
            }
            
            // 閲覧可能ユーザ名一覧
            List<String> readableUserList = readableUsersMap.get(rsList.get(i).getCjnInqKindSeq());
            viewDetail.setReadableUserList(readableUserList);

            viewList.add(viewDetail);
        }
        view.setInquiryTypeList(viewList);
        view.setCjnAccountType(cjnAccountType);

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
