/*
 * $Id: CjnUserListAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/12  BGT)楊恩美     新規作成
 * 2007/10/18  BGT)児島       メッセージを設定
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.cjn_inquiry.action.view.CjnUserListView;
import net.chintai.backend.sysadmin.cjn_inquiry.action.view.CjnUserListView.CjnUserListViewDetail;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnUserListService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnUserListOutServiceBean;
import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;

/**
 * 問い合せユーザ一覧アクション。
 * 
 * @author Yang-EunMi
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserListAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        CjnUserListService service = (CjnUserListService) ac.getBean("cjnUserListService");

        // 問い合せユーザリストを取得
        List<CjnUserListOutServiceBean> userList = service.selectCjnUserList();

        // ViewHelperにセット
        List<CjnUserListViewDetail> viewList = new ArrayList<CjnUserListViewDetail>();
        CjnUserListView view = new CjnUserListView();

        if (userList.size() > 0) {
            for (int i = 0; i < userList.size(); i++) {
                CjnUserListViewDetail viewDetail = view.new CjnUserListViewDetail();
                BeanUtils.copyProperties(viewDetail, userList.get(i));
                viewList.add(viewDetail);
            }
        } else {
            context.setError("WARN.M.CJN_INQUIRY.0036");
        }

        view.setUserList(viewList);
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
        return auth.authenticate(userId, AuthorityId.CJN_INQUIRY) && auth.isAdminCjnAccountType(userId);
    }

}
