/*
 * $Id: InquiryRecentSearchAction.java 4473 2010-10-14 02:20:33Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/05  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_inquiry.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.session.SessionSearchKey;
import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;
import net.chintai.backend.sysadmin.common.util.CsvStatusBean;
import net.chintai.backend.sysadmin.common.util.DateUtil;
import net.chintai.backend.sysadmin.shop_inquiry.action.view.InquiryRecentListView;
import net.chintai.backend.sysadmin.shop_inquiry.service.InquiryRecentListCsvService;
import net.chintai.backend.sysadmin.shop_inquiry.service.InquiryRecentSearchService;
import net.chintai.backend.sysadmin.shop_inquiry.service.bean.InquiryRecentSearchInServiceBean;

/**
 * 問い合せ情報検索アクション
 *
 * @author Kim Dong Jin
 * @version $Revision: 4473 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class InquiryRecentSearchAction extends BaseActionSupport {


    /** ログインスタンス */
    private static Log log = LogFactory.getLog(InquiryRecentSearchAction.class);


    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 問い合せ情報検索条件取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        InquiryRecentSearchInServiceBean inServiceBean = new InquiryRecentSearchInServiceBean();

        // 検索条件をServiceBeanに設定
        BeanUtilsWrapper.copyProperties(inServiceBean, form);


        // どの画面からアクションが行うか判断する
        String searchFlg = (String) form.get("searchFlg");

        if (searchFlg.equals("search")) {
            // 検索ボタンによる遷移の場合
            BeanUtils.copyProperties(inServiceBean, form);
            context.getSessionBean().getSearchConditionMap().put(SessionSearchKey.SHOP_INQUIRY_RECENT, inServiceBean);
        } else {
            // 問合せ詳細画面からパンくずで戻ってきたときは、セッションから検索条件を取得
            inServiceBean =
                    (InquiryRecentSearchInServiceBean) context.getSessionBean().getSearchConditionMap().get(
                            SessionSearchKey.SHOP_INQUIRY_RECENT);

            //問合せ検索画面でoutputMode「画面」の次に「CSV」で出力され、問合せ詳細画面に遷移してきて、
            //パンくずで、検索画面に戻ってきたときのための処理
            if(StringUtils.equals(inServiceBean.getOutputMode(), "csv")) {
                inServiceBean.setOutputMode("");
            }

            Object offSet = form.get("offSet");
            if (offSet == null) {
                inServiceBean.setOffSet(0);
            } else {
                inServiceBean.setOffSet((Integer) offSet);
            }
        }

        // ページング状態を設定
        BasePagerCondition condition = new BasePagerCondition();
        condition.setLimit(inServiceBean.getCnt());
        condition.setOffset(inServiceBean.getOffSet());

        // ViewHelperにセット
        InquiryRecentListView view = new InquiryRecentListView(condition);
        // 検索条件をViewHelperに設定

        BeanUtils.copyProperties(view, inServiceBean);

        //問合せ検索画面でoutputMode「画面」の次に「CSV」で出力され、問合せ詳細画面に遷移してきて、
        //パンくずで、検索画面に戻ってきたときのための処理
        if(StringUtils.equals(inServiceBean.getOutputMode(),"")) {
            view.setOutputMode("csv");
        }

        ApplicationContext ac = getWebApplicationContext();

        //csvファイル出力の場合
        if (StringUtils.equals(inServiceBean.getOutputMode(), "csv")) {

            InquiryRecentListCsvService service = (InquiryRecentListCsvService) getWebApplicationContext().getBean("inquiryRecentListCsvService");

            int count = service.selectCountInquiryRecentList(inServiceBean);

            if(count > 0) {

                // csv出力に必要な情報をstatusBeanに設定
                CsvStatusBean csvStatusBean = new CsvStatusBean();
                csvStatusBean.setFileName(this.getCsvFileName());
                csvStatusBean.setResponse(context.getResponse());

                // CSV出力処理
                try {
                    service.createInquiryRecentListCsv(inServiceBean, csvStatusBean);
                } catch (ApplicationException e) {
                    if (log.isErrorEnabled()) {
                        log.error(e.getErrorId(), e);
                    }
                }
                context.setForward(null);
                return;

            } else {
                context.setError("WARN.M.CJN_INQUIRY.0060");
            }


        } else {
         // Injection(問い合せ情報検索リスト)

            InquiryRecentSearchService inquiryRecentSearchService =
                    (InquiryRecentSearchService) ac.getBean("InquiryRecentSearchService");

            // 問い合せ情報検結果リストを取得
            List rsList = inquiryRecentSearchService.inquiryRecentSearch(inServiceBean, condition);

            List<InquiryRecentListView.InquiryRecentListDetailView> inquiryList =
                    new ArrayList<InquiryRecentListView.InquiryRecentListDetailView>();

            // 検索結果件数が0件の場合
            if (rsList.size() == 0) {

                // メッセージ設定
                context.setError("WARN.M.CJN_INQUIRY.0034");
            }

            // 検索結果をViewHelperに設定
            for (int i = 0; i < rsList.size(); i++) {
                InquiryRecentListView.InquiryRecentListDetailView inquiryDetail =
                    view.new InquiryRecentListDetailView();
                BeanUtils.copyProperties(inquiryDetail, rsList.get(i));
                inquiryList.add(inquiryDetail);
            }
            view.setInquiryList(inquiryList);
        }

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
        return auth.authenticate(userId, AuthorityId.SHOP_INQUIRY);
    }

    /**
     * CSVファイル名を取得
     * @param 開始日、終了日
     * @return CSVファイル名
     */
    private String getCsvFileName() {
        StringBuilder fileName = new StringBuilder();
        fileName.append(SystemProperties.getProperty("InquiryRecentSearch.Filename"));
        fileName.append(DateUtil.getToday());
        fileName.append(".csv");

        return fileName.toString();
    }
}