/*
 * $Id: ReviewTodofukenMediaCountAction.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/12  BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.review.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.util.CsvStatusBean;
import net.chintai.backend.sysadmin.common.util.CsvExportUtil;
import net.chintai.backend.sysadmin.review.action.view.ReviewTodofukenMediaCountView;
import net.chintai.backend.sysadmin.review.action.view.ReviewTodofukenMediaCountView.ReviewTodofukenMediaCountDetailView;
import net.chintai.backend.sysadmin.review.service.ReviewTodofukenMediaCountService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewTodofukenMediaCountInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewTodofukenMediaCountOutServiceBean;

/**
 * 都道府県別出稿状況集計アクション
 * 
 * @author Lee Hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewTodofukenMediaCountAction extends BaseActionSupport {

    /** 種別コード(初回審査対象) */
    public final String SYOKAI_SHINSA_CD = "1";

    /** 種別コード(初回審査対象外) */
    public final String SYOKAI_SHINSA_SKIP_CD = "2";

    /** 種別コード(初回停止) */
    public final String SYOKAI_AUTODEL_CD = "3";

    /** 種別コード(定期審査対象) */
    public final String TEIKI_SHINSA_CD = "4";

    /** 種別コード(定期停止) */
    public final String TEIKI_AUTODEL_CD = "5";

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.REVIEW);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データ取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        ReviewTodofukenMediaCountInServiceBean inBean = new ReviewTodofukenMediaCountInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        ReviewTodofukenMediaCountService service =
                (ReviewTodofukenMediaCountService) ac.getBean("reviewTodofukenMediaCountService");

        // 検索開始
        List<ReviewTodofukenMediaCountOutServiceBean> rsList = service.getMediaCountInfo(inBean);

        ReviewTodofukenMediaCountView view = new ReviewTodofukenMediaCountView();

        // 検索結果0件時のメッセージ
        if (rsList.size() == 0) {

            if (form.get("outPut").equals("csv")) {
                context.setError("WARN.M.REVIEW.0101");
            } else {
                context.setError("WARN.M.REVIEW.0051");
            }

        } else {
            if (form.get("outPut").equals("csv")) {

                // csvデータ取得
                List<String[]> csvList = this.makeCsvList(rsList);

                // csv出力に必要な情報をstatusBeanに設定
                CsvStatusBean csvStatusBean = new CsvStatusBean();
                csvStatusBean.setFileName(this.getCsvFileName(inBean.getSumYmdFromYear(), inBean.getSumYmdFromMonth()));
                csvStatusBean.setResponse(context.getResponse());

                // ダウンロード処理
                CsvExportUtil.export(csvStatusBean, csvList);

                context.setForward(null);
                return;
            } else {
                // 画面出力
                List<ReviewTodofukenMediaCountDetailView> detailList =
                        new ArrayList<ReviewTodofukenMediaCountDetailView>();

                for (int i = 0; i < rsList.size(); i++) {
                    ReviewTodofukenMediaCountDetailView detailView = view.new ReviewTodofukenMediaCountDetailView();
                    detailView.setPrefName(rsList.get(i).getPrefName());
                    detailView.setSyokaiShinsaCntList(getShinsaList(rsList.get(i), SYOKAI_SHINSA_CD));
                    i++;
                    detailView.setSyokaiShinsaSkipList(getShinsaList(rsList.get(i), SYOKAI_SHINSA_SKIP_CD));
                    i++;
                    detailView.setSyokaiAutoDelList(getShinsaList(rsList.get(i), SYOKAI_AUTODEL_CD));
                    i++;
                    detailView.setTeikiShinsaList(getShinsaList(rsList.get(i), TEIKI_SHINSA_CD));
                    i++;
                    detailView.setTeikiAutoDelList(getShinsaList(rsList.get(i), TEIKI_AUTODEL_CD));

                    detailList.add(detailView);
                }

                view.setTodofukenMediaCntList(detailList);
                view.setDateList(getCntDate(inBean.getSumYmdFromYear(), inBean.getSumYmdFromMonth()));
            }
        }

        // 集計時間を取得
        view.setCntTime(service.getCntTime().getCntTime());
        context.setForward("success", view);
    }

    /**
     * CSVファイル名を取得
     * @param 開始日、終了日
     * @return CSVファイル名
     */
    private String getCsvFileName(String year, String month) {
        String fileName =
                SystemProperties.getProperty("TodofukenMediaCnt.Filename") + "_" + year + "_" + month + ".csv";
        return fileName;
    }

    /**
     * CSVフォマットに変換
     * @param 検索結果
     * @return CSVデータ
     */
    private List<String[]> makeCsvList(List<ReviewTodofukenMediaCountOutServiceBean> rsList) {
        List<String[]> csvList = new ArrayList<String[]>();
        ReviewTodofukenMediaCountOutServiceBean tmp;

        // Header設定
        csvList.add(SystemProperties.getProperty("TodofukenMediaCnt.Header").split(","));

        // CSVフォマットの変換
        for (int i = 0; i < rsList.size(); i++) {
            tmp = rsList.get(i);
            csvList
                    .add(new String[] { tmp.getPrefName(), tmp.getSyokaiShinsaCnt(), tmp.getSyokaiShinsaSkipCnt(),
                            tmp.getSyokaiShinsaDelCnt(), tmp.getTeikiShinsaCnt(), tmp.getTeikiShinsaDelCnt(),
                            tmp.getSendDt() });
        }
        return csvList;
    }

    /**
     * 画面表示形式に合わせて DetailView に格納するリストを作る
     * @param bean 月別件数
     * @param shinsaCd DBから検索した審査種別
     * @return DetailView格納用リスト
     */
    private static List getShinsaList(ReviewTodofukenMediaCountOutServiceBean bean, String shinsaCd) {
        if (bean.getShinsaCd().equals(shinsaCd)) {
            List<String> returnList = new ArrayList<String>();
            returnList.add(bean.getCnt1());
            returnList.add(bean.getCnt2());
            returnList.add(bean.getCnt3());
            returnList.add(bean.getCnt4());
            returnList.add(bean.getCnt5());
            returnList.add(bean.getCnt6());
            returnList.add(bean.getCnt7());
            returnList.add(bean.getCnt8());
            returnList.add(bean.getCnt9());
            returnList.add(bean.getCnt10());
            returnList.add(bean.getCnt11());
            returnList.add(bean.getCnt12());
            return returnList;
        }
        return null;
    }

    /**
     * 日付を画面表示形式に変換
     * @param sYear DBから取得した年
     * @param sMonth DBから取得した月
     * @return 画面表示形式に変換した日付
     */
    private static List<String> getCntDate(String sYear, String sMonth) {

        List<String> dateArray = new ArrayList<String>();

        int year = Integer.parseInt(sYear);
        int month = Integer.parseInt(sMonth);
        String date = "";
        for (int i = 0; i < 12; i++) {
            date = String.valueOf(year) + "年<BR>";
            date = date + String.valueOf(month) + "月";
            dateArray.add(date);
            month++;
            if (month > 12) {
                month = 1;
                year++;
            }
        }
        return dateArray;
    }
}
