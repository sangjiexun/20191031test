/*
 * $Id: FudousanUpdateConfirmAction.java 3570 2007-12-14 08:55:47Z t-kojima $
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
import net.chintai.backend.sysadmin.common.properties.ApplicationResources;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.demand.action.view.FudousanUpdateView;
import net.chintai.backend.sysadmin.demand.service.FudousanUpdateConfirmService;
import net.chintai.backend.sysadmin.demand.service.PrefNameSearchService;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanUpdateConfirmInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.PrefNameSearchInServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 不動産会社更新確認を表示するアクション
 * 
 * @author TAKAHASHI Yuki
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanUpdateConfirmAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        FudousanUpdateView view = new FudousanUpdateView();
        FudousanUpdateConfirmInServiceBean inBean = new FudousanUpdateConfirmInServiceBean();
        BeanUtils.copyProperties(view, form);
        BeanUtils.copyProperties(inBean, form);

        ApplicationContext ac = getWebApplicationContext();
        FudousanUpdateConfirmService service =
                (FudousanUpdateConfirmService) ac.getBean("fudousanUpdateConfirmService");

        int resultCnt = service.confirmKaisyaInfo(inBean);

        if (resultCnt == 0) {
            if (StringUtils.isNotEmpty(view.getPrefCd())) {
                // 都道府県名称を取得
                PrefNameSearchInServiceBean prefNameSearchInBean =
                        new PrefNameSearchInServiceBean();
                prefNameSearchInBean.setPrefCd(view.getPrefCd());
                PrefNameSearchService commonService =
                        (PrefNameSearchService) ac.getBean("prefNameSearchService");
                view.setPrefName((commonService.getPrefName(prefNameSearchInBean)).getPrefName());
            }

            // 二重更新防止トークンをセット
            saveToken(context.getRequest());
            context.setForward("success", view);

        } else {
            context.setError("WARN.M.DEMAND.0124", ApplicationResources
                    .getProperty("demand.fudousanInfo"));
            context.setForward("fail", view);
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
        return auth.authenticate(userId, AuthorityId.DEMAND);
    }

}
