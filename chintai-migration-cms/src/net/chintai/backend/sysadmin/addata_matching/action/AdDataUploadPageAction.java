/*
 * $Id: AdDataUploadPageAction.java 4550 2012-09-27 02:10:00Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/08/24     BGT)石井       新規作成
 *
 */
package net.chintai.backend.sysadmin.addata_matching.action;


import java.text.SimpleDateFormat;
import java.util.Calendar;

import net.chintai.backend.sysadmin.addata_matching.action.view.AdDataUploadView;
import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;


/**
 * ADデータアップロード画面表示アクション
 * @author e-ishii
 * @version $Revision: 4550 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AdDataUploadPageAction extends BaseActionSupport {


    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.
     * BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {


        // トークンの生成
        saveToken(context.getRequest());

        DynaValidatorForm form = (DynaValidatorForm) context.getForm();

        // ViewHelper
        AdDataUploadView view = new AdDataUploadView();

        BeanUtilsWrapper.copyProperties(view, form);

        if(StringUtils.isEmpty((String)form.get("uploadYear"))){
            // 前月の日付を取得
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.MONTH,-1);

            // 対象年月の初期値として前月の日付を設定します。
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
            view.setUploadYear(sdf.format(cal.getTime()).substring(0,4));
            view.setUploadMonth(sdf.format(cal.getTime()).substring(4,6));
        }

        context.setForward("success", view);

    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.
     * BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.ADDATA_MATCHING);
    }

}
