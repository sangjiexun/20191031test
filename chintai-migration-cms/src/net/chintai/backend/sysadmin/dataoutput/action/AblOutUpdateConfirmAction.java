/*
 * $Id: AblOutUpdateConfirmAction.java 4775 2014-01-09 08:22:06Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/18     BGT)亀田       新規作成
 * 2014/1/7       BGT)亀田       E-0053_スマイティ用データ抽出　市区・駅対応 docNameの処理追加
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
import net.chintai.backend.sysadmin.dataoutput.action.view.AblOutSettingUpdateBean;
import net.chintai.backend.sysadmin.dataoutput.action.view.AblOutSettingView;

import org.apache.struts.action.DynaActionForm;
import org.springframework.context.ApplicationContext;

/**
 * エイブル担当店/取扱店出力情報設定画面表示Action
 * @author KAMEDA Takuma
 * @version $Revision: 4775 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AblOutUpdateConfirmAction extends BaseActionSupport{

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

        DynaActionForm form = (DynaActionForm) context.getForm();

        AblOutSettingUpdateBean formBean = new AblOutSettingUpdateBean();

        BeanUtilsWrapper.copyProperties(formBean, form);

        // 物件出力区分がカンマ区切りの文字列の場合、配列に格納（ラジオボタン設定時）
        if (formBean.getBukkenOutKbnArray() != null &&
            formBean.getBukkenOutKbnArray().length > 0 &&
            formBean.getBukkenOutKbnArray()[0].length() > 1){
            String[] newBukkenOutKbnArray = formBean.getBukkenOutKbnArray()[0].split(",");
            formBean.setBukkenOutKbnArray(newBukkenOutKbnArray);
        }

        AblOutSettingView view = new AblOutSettingView();

        List<AblOutSettingView.AblDetailView> ablDetailViewList = new ArrayList<AblOutSettingView.AblDetailView>();

        // 取得した他社データ連携種類分繰り返す
        for (int i = 0; i < formBean.getDcoTypeArray().length; i++){
            // 取得した情報を画面出力用の内部Beanに設定する（1レコ－ドずつ）
            AblOutSettingView.AblDetailView ablDetail = view.new AblDetailView();
            ablDetail.setBukkenOutKbn(formBean.getBukkenOutKbnArray()[i]);
            ablDetail.setDcoType(formBean.getDcoTypeArray()[i]);
            ablDetail.setUpdDt(formBean.getUpdDtArray()[i]);
            // MST_DCOからDcoNameを取得するようになったため、新たに設定する処理を追加 2014/1/7
            ablDetail.setDcoName(formBean.getDcoNameArray()[i]);
            ablDetailViewList.add(ablDetail);
        }
        view.setAblSettingViewList(ablDetailViewList);

        context.setForward("success", view);

        // 二重更新防止トークンをセット
        saveToken(context.getRequest());

    }






}