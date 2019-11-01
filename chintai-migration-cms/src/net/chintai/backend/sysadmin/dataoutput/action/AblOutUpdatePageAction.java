/*
 * $Id: AblOutUpdatePageAction.java 4711 2013-11-05 07:34:37Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/11     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;
import net.chintai.backend.sysadmin.dataoutput.action.view.AblOutSettingView;
import net.chintai.backend.sysadmin.dataoutput.service.AblOutSettingService;
import net.chintai.backend.sysadmin.dataoutput.service.bean.AblOutSettingOutServiceBean;

import org.springframework.context.ApplicationContext;

/**
 * エイブル担当店/取扱店出力情報設定画面表示Action
 * @author KAMEDA Takuma
 * @version $Revision: 4711 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AblOutUpdatePageAction extends BaseActionSupport{

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

        // Injection
        ApplicationContext ac = getWebApplicationContext();

        // サービスの呼び出し
        AblOutSettingService ablOutSettingService = (AblOutSettingService) ac.getBean("ablOutSettingService");

        List<AblOutSettingOutServiceBean> ablOutSettingOutList = ablOutSettingService.getAblOutDateList();

        AblOutSettingView view = new AblOutSettingView();
        List<AblOutSettingView.AblDetailView> ablDetailViewList = new ArrayList<AblOutSettingView.AblDetailView>();

        // 取得した他社データ連携種類分繰り返す(E-0034_0035_他社データ連携出力(スマイティ)_追加改修時　1件｛スマイティ｝)
        for (AblOutSettingOutServiceBean outBean : ablOutSettingOutList){
            // 取得した情報を画面出力用のBeanにコピーする
            AblOutSettingView.AblDetailView datailView = view.new AblDetailView();
            BeanUtilsWrapper.copyProperties(datailView,outBean);
            ablDetailViewList.add(datailView);

        }

        view.setAblSettingViewList(ablDetailViewList);

        context.setForward("success",view);
    }

}

