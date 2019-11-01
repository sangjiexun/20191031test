/*
 * $Id: FudousanUpdatePageAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/29     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.action;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.demand.action.view.FudousanUpdateView;
import net.chintai.backend.sysadmin.demand.service.FudousanUpdatePageService;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanUpdatePageOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.ApplicationContext;

/**
 * 不動産会社情報更新を表示するアクション
 * 
 * @author TAKAHASHI Yuki
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanUpdatePageAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // パラメータから不動産会社コード、詳細画面現在位置を取得
        String fudousanCd = context.getRequest().getParameter("fudousanCd");
        int offSet = Integer.parseInt(context.getRequest().getParameter("offSet"));

        FudousanUpdatePageInServiceBean inServiceBean = new FudousanUpdatePageInServiceBean();
        inServiceBean.setFudousanCd(fudousanCd);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        FudousanUpdatePageService fudousanUpdatePageService =
                (FudousanUpdatePageService) ac.getBean("fudousanUpdatePageService");

        FudousanUpdatePageOutServiceBean rs =
                fudousanUpdatePageService.fudousanUpdatePage(inServiceBean);
        FudousanUpdateView view = new FudousanUpdateView();
        BeanUtils.copyProperties(view, rs);

        view.setOffSet(offSet);

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
        return auth.authenticate(userId, AuthorityId.DEMAND);
    }

}
