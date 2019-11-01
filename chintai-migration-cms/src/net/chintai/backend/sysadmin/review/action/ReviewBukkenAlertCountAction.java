/*
 * $Id: ReviewBukkenAlertCountAction.java 4461 2010-07-05 06:58:27Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/12  BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.review.action;

import java.util.List;
import java.util.ArrayList;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
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
import net.chintai.backend.sysadmin.review.action.view.ReviewBukkenAlertCountView;
import net.chintai.backend.sysadmin.review.action.view.ReviewBukkenAlertCountView.ReviewBukkenAlertCountDetailView;
import net.chintai.backend.sysadmin.review.service.ReviewBukkenAlertCountService;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenAlertCountInServiceBean;
import net.chintai.backend.sysadmin.review.service.bean.ReviewBukkenAlertCountOutServiceBean;

/**
 * 警告対象物件集計アクション
 * @author Lee Hosup
 * @version $Revision: 4461 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenAlertCountAction extends BaseActionSupport {

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
        ReviewBukkenAlertCountInServiceBean inBean = new ReviewBukkenAlertCountInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // 検索ボタンで実行される場合セッションに検索条件を格納
        context.getSessionBean().getSearchConditionMap()
                .put(SessionSearchKey.REVIEW_BUKKEN_ALERT_COUNT, inBean);

        // ページング状態を設定
        BasePagerCondition condition = new BasePagerCondition();
        condition.setLimit(Integer.valueOf(
                SystemProperties.getProperty("C_SHINSA_BUKKEN_ALERT_COUNT_DISPLAY_LIMIT")));
        condition.setOffset(inBean.getOffSet());

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        ReviewBukkenAlertCountService service =
                (ReviewBukkenAlertCountService) ac.getBean("reviewBukkenAlertCountService");

        List<ReviewBukkenAlertCountOutServiceBean> rsList =
                service.getBukkenAlertCount(inBean, condition);

        // ViewHelper設定
        ReviewBukkenAlertCountView view = new ReviewBukkenAlertCountView(condition);
        BeanUtils.copyProperties(view, form);

        if (rsList.size() != 0) {
            // Csv出力処理
            if (form.get("outPut").equals("csv")) {

                // Csvデータ取得
                List<String[]> csvList = this.makeCsvList(rsList);

                // csv出力に必要な情報をstatusBeanに設定
                CsvStatusBean csvStatusBean = new CsvStatusBean();
                csvStatusBean.setFileName(this.getCsvFileName(inBean.getSendDtFrom(),
                                                              inBean.getSendDtTo()));
                csvStatusBean.setResponse(context.getResponse());

                // ダウンロード処理
                CsvExportUtil.export(csvStatusBean, csvList) ;

                context.setForward(null);
                return;
            } else {
                // 画面出力処理
                List<ReviewBukkenAlertCountDetailView> detailList =
                        new ArrayList<ReviewBukkenAlertCountDetailView>();
                for (int i = 0; i < rsList.size(); i++) {
                    ReviewBukkenAlertCountDetailView detailView =
                            view.new ReviewBukkenAlertCountDetailView();
                    BeanUtils.copyProperties(detailView, rsList.get(i));

                    String warningDt = rsList.get(i).getWarningDt().substring(0, 10).replaceAll("-", "/");
                    detailView.setWarningDt(warningDt);

                    detailList.add(detailView);
                }
                view.setBukkenAlertList(detailList);
            }

        } else {

            if (form.get("outPut").equals("csv")) {
                context.setError("WARN.M.REVIEW.0100");
            } else {
                context.setError("WARN.M.REVIEW.0055");
            }
        }

        context.setForward("success", view);
    }

    /**
     * CSVフォマットに変換
     * @param 検索結果
     * @return CSVデータ
     */
    private List<String[]> makeCsvList(List<ReviewBukkenAlertCountOutServiceBean> rsList) {
        List<String[]> csvList = new ArrayList<String[]>();
        ReviewBukkenAlertCountOutServiceBean tmp;

        // Header設定
        csvList.add(SystemProperties.getProperty("BukkenAlert.Header").split(","));

        // CSVフォマットの変換
        for (int i = 0; i < rsList.size(); i++) {
            tmp = rsList.get(i);
            csvList.add(new String[] { tmp.getWarningDt(), tmp.getShopCd(), tmp.getShopStatus(),
                    tmp.getCompany(), tmp.getBumon(), tmp.getCtStatus(),tmp.getAblStatus(),
                    tmp.getRendoCd(),
                    tmp.getShopCd() + "-" + tmp.getBkCd() + "-" + tmp.getRoomCd(),
                    tmp.getStatusKbn(), tmp.getWarningName() });
        }
        return csvList;
    }

    /**
     * CSVファイル名を取得
     * @param 開始日、終了日
     * @return CSVファイル名
     */
    private String getCsvFileName(String fromDate, String toDate) {
        StringBuffer sb = new StringBuffer();
        sb.append(SystemProperties.getProperty("BukkenAlert.Filename"));
        if (StringUtils.isNotEmpty(fromDate)) {
            sb.append("_f" + fromDate);
        }
        if (StringUtils.isNotEmpty(toDate)) {
            sb.append("_t" + toDate);
        }
        sb.append(".csv");

        return sb.toString();
    }
}
