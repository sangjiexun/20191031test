/*
 * $Id: ReviewShopMediaCountAction.java 3673 2007-12-20 02:25:18Z lee-hosup $
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
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.session.SessionSearchKey;
import net.chintai.backend.sysadmin.common.util.CsvStatusBean;
import net.chintai.backend.sysadmin.common.util.CsvExportUtil;
import net.chintai.backend.sysadmin.review.ReviewUtils;
import net.chintai.backend.sysadmin.review.action.view.ReviewShopMediaCountView;
import net.chintai.backend.sysadmin.review.action.view.ReviewShopMediaCountView.ReviewShopMediaCountDetailView;
import net.chintai.backend.sysadmin.review.service.ReviewShopMediaCountService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewShopMediaCountInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewShopMediaCountOutServiceBean;

/**
 * 店舗別出稿状況集計アクション
 * @author Lee Hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewShopMediaCountAction extends BaseActionSupport {

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
        ReviewShopMediaCountInServiceBean inBean = new ReviewShopMediaCountInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // 検索ボタンで実行される場合セッションに検索条件を格納
        context.getSessionBean().getSearchConditionMap()
                .put(SessionSearchKey.REVIEW_SHOP_MEDIA_COUNT, inBean);

        // ページング状態を設定
        BasePagerCondition condition = new BasePagerCondition();
        condition.setLimit(Integer.valueOf
                (SystemProperties.getProperty("C_SHINSA_SHOP_MEDIA_COUNT_DISPLAY_LIMIT")));
        condition.setOffset(((Integer) form.get("offSet")).intValue());

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        ReviewShopMediaCountService service =
                (ReviewShopMediaCountService) ac.getBean("reviewShopMediaCountService");

        // 検索開始
        List<ReviewShopMediaCountOutServiceBean> rsList =
                service.getShopMediaCount(inBean, condition);

        // ViewHelper設定
        ReviewShopMediaCountView view = new ReviewShopMediaCountView(condition);

        // 検索条件コピー
        BeanUtils.copyProperties(view, form);

        if (rsList.size() == 0) {

            if (form.get("outPut").equals("csv")) {
                context.setError("WARN.M.REVIEW.0099");
            } else {
                context.setError("WARN.M.REVIEW.0046");
            }

        } else {
            if (form.get("outPut").equals("csv")) {

                // csvデータ取得
                List<String[]> csvList = this.makeCsvList(rsList);

                // csv出力に必要な情報をstatusBeanに設定
                CsvStatusBean csvStatusBean = new CsvStatusBean();
                csvStatusBean.setFileName(this.getCsvFileName(inBean.getSumYmdFromYear(),
                                                              inBean.getSumYmdFromMonth()));
                csvStatusBean.setResponse(context.getResponse());

                // ダウンロード処理
                CsvExportUtil.export(csvStatusBean, csvList) ;

                context.setForward(null);
                return;
            } else {
                // 画面出力形式にデータを編集
                List<ReviewShopMediaCountDetailView> shopMediaCntList =
                            ReviewShopMediaCountAction.convertData(rsList);

                view.setShopMediaCntList(shopMediaCntList);
                view.setDateList(ReviewUtils.getDateList(inBean.getSumYmdFromYear(), inBean
                        .getSumYmdFromMonth()));
            }
        }
        // 最終集計時間設定
        view.setCntTime(service.selectCntTime().getCntTime());
        context.setForward("success", view);
    }

    /**
     * DB検索結果を画面出力形式に変換します。
     * @param rsList DB検索結果
     * @return 画面出力形式のデータ
     */
    public static List<ReviewShopMediaCountDetailView> convertData(List<ReviewShopMediaCountOutServiceBean> rsList){

        // 種別コード(初回審査対象)
        final String SYOKAI_SHINSA_CD = "1";

        // 種別コード(初回審査対象外)
        final String SYOKAI_SHINSA_SKIP_CD = "2";

        // 種別コード(初回停止)
        final String SYOKAI_AUTODEL_CD = "3";

        // 種別コード(定期審査対象)
        final String TEIKI_SHINSA_CD = "4";

        // 種別コード(定期停止)
        final String TEIKI_AUTODEL_CD = "5";

        List<ReviewShopMediaCountDetailView> returnList = new ArrayList<ReviewShopMediaCountDetailView>();
        ReviewShopMediaCountOutServiceBean oBean;
        ReviewShopMediaCountView view = new ReviewShopMediaCountView(new BasePagerCondition());
        ReviewShopMediaCountDetailView dView = view.new ReviewShopMediaCountDetailView();

        String baseShopCd = "";

        for (int i = 0; i < rsList.size(); i++) {
            oBean = rsList.get(i);

            if (!(baseShopCd.equals(oBean.getShopCd()))) {
                baseShopCd = oBean.getShopCd();
                if (i != 0) {
                    returnList.add(dView);
                }
                dView = view.new ReviewShopMediaCountDetailView();
                dView.setShopCd(oBean.getShopCd());
                dView.setCompany(oBean.getCompany());
                dView.setBumon(oBean.getBumon());
            }

            List<String> shinsaList = ReviewShopMediaCountAction.getCList(oBean);
            if (oBean.getShinsaCd().equals(SYOKAI_SHINSA_CD)) {
                dView.setSyokaiCntList(shinsaList);
            } else if (oBean.getShinsaCd().equals(SYOKAI_SHINSA_SKIP_CD)) {
                dView.setSyokaiSkipList(shinsaList);
            } else if (oBean.getShinsaCd().equals(SYOKAI_AUTODEL_CD)) {
                dView.setSyokaiAutoDelList(shinsaList);
            } else if (oBean.getShinsaCd().equals(TEIKI_SHINSA_CD)) {
                dView.setTeikiCntList(shinsaList);
            } else if (oBean.getShinsaCd().equals(TEIKI_AUTODEL_CD)) {
                dView.setTeikiAutoDelList(shinsaList);
            }
            if (i + 1 == rsList.size()) {
                returnList.add(dView);
            }
        }
        return returnList;
    }


    /**
     * CSVファイル名を取得
     * @param 開始日、終了日
     * @return CSVファイル名
     */
    private String getCsvFileName(String year, String month){
        String fileName =
            SystemProperties.getProperty("ShopMediaCnt.Filename") + "_"
                    + year + "_" + month + ".csv";
        return fileName;
    }

    /**
     * CSVフォマットに変換
     * @param 検索結果
     * @return CSVデータ
     */
    private List<String[]> makeCsvList(List<ReviewShopMediaCountOutServiceBean> rsList) {
        List<String[]> csvList = new ArrayList<String[]>();
        ReviewShopMediaCountOutServiceBean tmp;

        // Header設定
        csvList.add(SystemProperties.getProperty("ShopMediaCnt.Header").split(","));

        // CSVフォマットの変換
        for (int i = 0; i < rsList.size(); i++) {
            tmp = rsList.get(i);
            csvList.add(new String[] { tmp.getShopCd(),
                                       tmp.getCompany(),
                                       tmp.getBumon(),
                                       tmp.getSyokaiShinsaCnt(),
                                       tmp.getSyokaiShinsaSkipCnt(),
                                       tmp.getSyokaiShinsaDelCnt(),
                                       tmp.getTeikiShinsaCnt(),
                                       tmp.getTeikiShinsaDelCnt(),
                                       tmp.getSendDt() });
        }
        return csvList;
    }

    /**
     * outBeanを画面出力用のリストに変換
     * @param 検索結果
     * @return 画面出力用リスト
     */
    private static List<String> getCList(ReviewShopMediaCountOutServiceBean bean) {
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
}
