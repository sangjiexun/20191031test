/*
 * $Id: TetudoGaishaSearchAction.java 4076 2008-11-19 09:33:13Z m-ono $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2008/10/08  BGT)長谷川正一 新規作成
 *
 */
package net.chintai.backend.sysadmin.master.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.session.SessionSearchKey;
import net.chintai.backend.sysadmin.common.util.CsvException;
import net.chintai.backend.sysadmin.common.util.CsvExportUtil;
import net.chintai.backend.sysadmin.common.util.CsvStatusBean;
import net.chintai.backend.sysadmin.master.action.view.TetudoGaishaSearchView;
import net.chintai.backend.sysadmin.master.service.TetudoGaishaListCsvService;
import net.chintai.backend.sysadmin.master.service.TetudoGaishaSearchForCsvService;
import net.chintai.backend.sysadmin.master.service.TetudoGaishaSearchService;
import net.chintai.backend.sysadmin.master.service.bean.TetudoGaishaInSearchrviceBean;
import net.chintai.backend.sysadmin.master.service.bean.TetudoGaishaOutSearchServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 鉄道会社検索アクション
 * 
 * @author S.HASEGAWA
 * @version $Revision: 4076 $ Copyright: (C) CHINTAI Corporation All Right
 *          Reserved.
 */
public class TetudoGaishaSearchAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();

        // 鉄道会社検索条件Bean
        TetudoGaishaInSearchrviceBean inServiceBean = new TetudoGaishaInSearchrviceBean();

        // 鉄道会社検索条件Beanに画面.検索条件を設定
        BeanUtils.copyProperties(inServiceBean, form);
        // セッションに検索条件を設定
        context.getSessionBean().getSearchConditionMap().put(SessionSearchKey.TETUDO_GAISHA_SEARCH, inServiceBean);

        // ページングデータを設定
        BasePagerCondition condition = new BasePagerCondition();
        condition.setLimit(Integer.valueOf((String) form.get("displayNum")));
        condition.setOffset(((Integer) form.get("offSet")).intValue());

        // 鉄道会社検索結果Bean
        TetudoGaishaSearchView view = new TetudoGaishaSearchView(condition);

        // 出力形式がCSVの場合
        if (form.getString("outputMode").equals("csv")) {
            // 鉄道会社リストを取得する
            List<TetudoGaishaOutSearchServiceBean> tetudoGaishaList = searchForCsv(inServiceBean);

            // 取得結果が0件だった場合
            if (tetudoGaishaList.isEmpty()) {
                context.setError("WARN.M.MASTER.0040");
                // 取得結果が1件以上だった場合
            } else {
                // CSV出力を行う
                exportCsv(context, tetudoGaishaList);

                context.setForward(null);
                return;

            }
            // 出力形式が画面の場合
        } else {
            // 鉄道会社情報照会サービスを取得する
            ApplicationContext ac = getWebApplicationContext();
            TetudoGaishaSearchService tetudoGaishaSearchService =
                    (TetudoGaishaSearchService) ac.getBean("tetudoGaishaSearchService");

            // viewにセットする鉄道会社リスト
            List<TetudoGaishaSearchView.TetudoGaishaSearchDetailView> tetudoGaishaList =
                    new ArrayList<TetudoGaishaSearchView.TetudoGaishaSearchDetailView>();

            // 検索結果の鉄道会社リスト
            List<TetudoGaishaOutSearchServiceBean> rsTetudoGaishaList = null;
            // 鉄道会社リストを取得する
            rsTetudoGaishaList = tetudoGaishaSearchService.tetudoGaishaSearch(inServiceBean, condition);
            // 取得結果が0件だった場合、エラー
            if (rsTetudoGaishaList.isEmpty()) {
                context.setError("WARN.M.MASTER.0041");
            }
            // tetudoGaishaListに取得した鉄道会社情報をセットする
            for (int i = 0; i < rsTetudoGaishaList.size(); i++) {
                TetudoGaishaOutSearchServiceBean serviceBean =
                        (TetudoGaishaOutSearchServiceBean) rsTetudoGaishaList.get(i);

                TetudoGaishaSearchView.TetudoGaishaSearchDetailView detailView =
                        view.new TetudoGaishaSearchDetailView();
                BeanUtils.copyProperties(detailView, serviceBean);

                tetudoGaishaList.add(detailView);
            }
            // viewに検索結果をセット
            view.setTetudoGaishaSearchList(tetudoGaishaList);

        }
        // 検索条件をviewにセット
        BeanUtils.copyProperties(view, inServiceBean);
        context.setForward("success", view);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        // マスタ参照権限の有無をチェック
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.MASTER);
    }

    /**
     * 画面の検索条件に合致する鉄道会社を全件取得するメソッド
     * @param inServiceBean 画面の検索条件
     * @return 鉄道会社リスト
     * @throws Exception プロパティコピーに失敗した場合
     */
    private List<TetudoGaishaOutSearchServiceBean> searchForCsv(TetudoGaishaInSearchrviceBean inServiceBean)
            throws Exception {
        // 鉄道会社を格納するリスト
        List<TetudoGaishaOutSearchServiceBean> tetudoGaishaList = null;
        // CSV用鉄道会社取得サービスの宣言
        ApplicationContext ac = getWebApplicationContext();
        TetudoGaishaSearchForCsvService tetudoGaishaSearchForCsvService =
                (TetudoGaishaSearchForCsvService) ac.getBean("tetudoGaishaSearchForCsvService");
        // 鉄道会社リストを取得
        tetudoGaishaList = tetudoGaishaSearchForCsvService.tetudoGaishaSearchForCsv(inServiceBean);
        return tetudoGaishaList;
    }

    /**
     * 鉄道会社リストをCSV形式に変換し、CSV出力を行うメソッド
     * @param context コンテキスト
     * @param rsTetudoGaishaList 鉄道会社リスト
     * @throws CsvException CSV出力に失敗した場合
     */
    private void exportCsv(BusinessContext context, List<TetudoGaishaOutSearchServiceBean> rsTetudoGaishaList)
            throws ApplicationException {

        // 鉄道会社リストをCSV形式に変換
        List<String[]> csvList = this.makeCsvList(rsTetudoGaishaList);
        // csv出力に必要な情報をstatusBeanに設定
        CsvStatusBean csvStatusBean = new CsvStatusBean();
        // CSVファイル名を設定
        csvStatusBean.setFileName(this.getCsvFileName());
        // HTTPレスポンスオブジェクトを設定
        csvStatusBean.setResponse(context.getResponse());

        try {
            // CSVファイルのダウンロード処理
            CsvExportUtil.export(csvStatusBean, csvList);

            // CSV出力に失敗した場合、エラー
        } catch (CsvException e) {
            throw new ApplicationException("ERROR.M.MASTER.0017", e);
        }
    }

    private List<String[]> makeCsvList(List<TetudoGaishaOutSearchServiceBean> tetudoGaishaList) {
        TetudoGaishaListCsvService service =
                (TetudoGaishaListCsvService) getWebApplicationContext().getBean("tetudoGaishaListCsvService");
        return service.createTetudoGaishaListCsv(tetudoGaishaList);
    }

    /**
     * 鉄道会社CSVファイル名を取得するメソッド
     * @return CSVファイル名
     */
    private String getCsvFileName() {
        // 鉄道会社CSVファイル名を取得
        return SystemProperties.getProperty("TetudoGaishaSearch.Filename") + ".csv";
    }

}
