/*
 * $Id: TorihikisakiListAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/13  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.session.SessionSearchKey;
import net.chintai.backend.sysadmin.common.util.CsvExportUtil;
import net.chintai.backend.sysadmin.common.util.CsvStatusBean;
import net.chintai.backend.sysadmin.common.util.DateUtil;
import net.chintai.backend.sysadmin.demand.action.view.TorihikisakiListView;
import net.chintai.backend.sysadmin.demand.action.view.TorihikisakiListView.TorihikisakiListDetailView;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiListService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiListInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiListOutServiceBean;

/**
 * 取引先一覧の検索アクション
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiListAction extends BaseActionSupport {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データ取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        TorihikisakiListInServiceBean inBean = new TorihikisakiListInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // 検索ボタンで実行される場合セッションに検索条件を格納
        context.getSessionBean().getSearchConditionMap().put(
                SessionSearchKey.DEMAND_TORIHIKISAKI_LIST, inBean);

        // ページング状態を設定
        BasePagerCondition condition = new BasePagerCondition();
        condition.setLimit(Integer.parseInt(SystemProperties
                .getProperty("C_TORIHIKISAKI_LIST_DISPLAY_LIMIT")));
        condition.setOffset(inBean.getOffSet());

        //Injection
        ApplicationContext ac = getWebApplicationContext();
        TorihikisakiListService service =
                (TorihikisakiListService) ac.getBean("torihikisakiListService");

        //検索開始
        List<TorihikisakiListOutServiceBean> rsList =
                service.getTorihikisakiList(inBean, condition);

        // viewHelper設定
        TorihikisakiListView view = new TorihikisakiListView(condition);

        // 検索条件コピー
        BeanUtils.copyProperties(view, form);

        // 出力先判断
        if (form.get("outPut").equals("gamen")) {
            // 画面出力
            if (rsList.size() == 0) {
                context.setError("WARN.M.REVIEW.0014");
            } else {
                List<TorihikisakiListDetailView> detailList =
                        new ArrayList<TorihikisakiListDetailView>();
                for (int i = 0; i < rsList.size(); i++) {
                    TorihikisakiListDetailView detailView = view.new TorihikisakiListDetailView();
                    detailView.setTorihikisakiCd1(rsList.get(i).getFudousanCd());
                    detailView.setTorihikisakiCd2(rsList.get(i).getTorihikisakiCd());
                    detailView.setFudousanName(rsList.get(i).getFudousanName());
                    detailView.setTorihikisakiName(rsList.get(i).getTorihikisakiName());
                    detailView.setPrefName(rsList.get(i).getTPrefName());
                    detailView.setAddress1(rsList.get(i).getTAddress1());
                    detailView.setAddress2(rsList.get(i).getTAddress2());
                    detailView.setTorihikisakiSeq(rsList.get(i).getTorihikisakiSeq());
                    detailList.add(detailView);
                }
                view.setDetailList(detailList);
            }
            context.setForward("success", view);
        } else {
            // CSV出力
            if (rsList.size() == 0) {
                context.setError("WARN.M.DEMAND.0017");
                context.setForward("success", view);
            } else {

                // Csvデータ取得
                List<String[]> csvList = this.makeCsvList(rsList);

                // csv出力に必要な情報をstatusBeanに設定
                CsvStatusBean csvStatusBean = new CsvStatusBean();
                csvStatusBean.setFileName(this.getCsvFileName());
                csvStatusBean.setResponse(context.getResponse());

                // ダウンロード処理
                CsvExportUtil.export(csvStatusBean, csvList);

                context.setForward(null);
            }
        }

        return;
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.DEMAND);
    }

    /**
     * CSVフォマットに変換
     * @param 検索結果
     * @return CSVデータ
     */
    private List<String[]> makeCsvList(List<TorihikisakiListOutServiceBean> rsList) {
        List<String[]> csvList = new ArrayList<String[]>();
        TorihikisakiListOutServiceBean tmp;

        // Header設定
        csvList.add(SystemProperties.getProperty("TorihikisakiList.Header").split(","));

        // CSVフォマットの変換
        for (int i = 0; i < rsList.size(); i++) {
            tmp = rsList.get(i);
            csvList.add(new String[] {
                    tmp.getFudousanCd() + "-" + tmp.getTorihikisakiCd(),
                    tmp.getFudousanName(),
                    tmp.getFZipcd(),
                    tmp.getFPrefName(),
                    tmp.getFAddress1(),
                    tmp.getFAddress2(),
                    tmp.getFTel(),
                    tmp.getFFax(),
                    tmp.getFTantou(),
                    tmp.getTorihikisakiName(),
                    tmp.getTZipcd(),
                    tmp.getTPrefName(),
                    tmp.getTAddress1(),
                    tmp.getTAddress2(),
                    tmp.getTTel(),
                    tmp.getTFax(),
                    tmp.getTTantou(),
                    tmp.getShisyaCd(),
                    tmp.getShisyaName(),
                    tmp.getStartYear(),
                    tmp.getStartMonth(),
                    tmp.getBukkenCnt(),
                    tmp.getTokusenCnt() });
        }
        return csvList;
    }

    /**
     * CSVファイル名を取得
     * @param なし
     * @return CSVファイル名
     */
    private String getCsvFileName() {

        return SystemProperties.getProperty("TorihikisakiList.Filename")
                + DateUtil.getCurrentYear()
                + DateUtil.getCurrentMonth()
                + DateUtil.getCurrentDay()
                + ".csv";
    }
}
