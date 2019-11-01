/*
 * $Id: KeiyakuShopSearchAction.java 4301 2009-07-13 01:18:57Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/17  BGT)李昊燮     新規作成
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 */
package net.chintai.backend.sysadmin.shop_listing.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.ConstValues;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.session.SessionSearchKey;
import net.chintai.backend.sysadmin.common.util.CsvExportUtil;
import net.chintai.backend.sysadmin.common.util.CsvStatusBean;
import net.chintai.backend.sysadmin.shop_listing.action.view.KeiyakuShopSearchView;
import net.chintai.backend.sysadmin.shop_listing.action.view.KeiyakuShopSearchView.KeiyakuShopSearchDetailView;
import net.chintai.backend.sysadmin.shop_listing.service.KeiyakuShopSearchService;
import net.chintai.backend.sysadmin.shop_listing.service.bean.KeiyakuShopSearchInServiceBean;
import net.chintai.backend.sysadmin.shop_listing.service.bean.KeiyakuShopSearchOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 契約店舗検索アクション
 *
 * @author Lee Hosup
 * @version $Revision: 4301 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class KeiyakuShopSearchAction extends BaseActionSupport {

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#
     * doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        KeiyakuShopSearchInServiceBean inBean = new KeiyakuShopSearchInServiceBean();
        BeanUtils.copyProperties(inBean, form);

        // 検索ボタンで実行される場合セッションに検索条件を格納
        context.getSessionBean().getSearchConditionMap().put(SessionSearchKey.CONTRACT_SHOP_SEARCH,
                inBean);

        // Injection
        ApplicationContext ac = getWebApplicationContext();
        KeiyakuShopSearchService service =
                (KeiyakuShopSearchService) ac.getBean("keiyakuShopSearchService");

        // ページング状態を設定
        BasePagerCondition condition = new BasePagerCondition();
        if (form.get("output").equals(ConstValues.OUT_PUT_GAMEN)) {
            condition.setLimit((Integer) form.get("displayNum"));
            condition.setOffset((Integer) form.get("offSet"));
        }

        // 契約店舗検索を行う。
        List<KeiyakuShopSearchOutServiceBean> rsList = service.searchShopList(inBean, condition);

        // ViewHelper設定
        KeiyakuShopSearchView view = new KeiyakuShopSearchView(condition);
        List<KeiyakuShopSearchDetailView> returnList = new ArrayList<KeiyakuShopSearchDetailView>();

        if (rsList.size() > 0) {

            // 検索日時を取得
            Date nowDate = service.searchSysdate();
            view.setNowDate(nowDate);

            // 出力先判断
            if (form.get("output").equals(ConstValues.OUT_PUT_CSV)) {

                // Csvデータ取得
                List<String[]> csvList = this.makeCsvList(rsList);

                // csv出力に必要な情報をstatusBeanに設定
                CsvStatusBean csvStatusBean = new CsvStatusBean();
                csvStatusBean.setFileName(this.getCsvFileName(nowDate));
                csvStatusBean.setResponse(context.getResponse());

                // ダウンロード処理
                CsvExportUtil.export(csvStatusBean, csvList);

                context.setForward(null);

            } else {

                for (KeiyakuShopSearchOutServiceBean outBean : rsList) {
                    KeiyakuShopSearchDetailView detailView = view.new KeiyakuShopSearchDetailView();
                    BeanUtils.copyProperties(detailView, outBean);

                    returnList.add(detailView);
                }
            }
        } else {

            // 検索結果0件警告メッセージ
            if (form.get("output").equals("csv")) {
                context.setError("WARN.M.SHOP_LISTING.0004");
            } else {
                context.setError("WARN.M.SHOP_LISTING.0001");
            }

        }

        view.setShopList(returnList);

        // 検索条件をViewHelperにコピー
        BeanUtils.copyProperties(view, form);

        context.setForward("success", view);
    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java
     * .lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.SHOP_LISTING);
    }

    /**
     * CSV出力用データを生成します。
     *
     * @param rsList 契約店舗検索結果リスト。
     * @return CSV出力用データリスト。
     */
    private List<String[]> makeCsvList(List<KeiyakuShopSearchOutServiceBean> rsList) {
        List<String[]> csvList = new ArrayList<String[]>();
        KeiyakuShopSearchOutServiceBean tmp;

        // Header設定
        csvList.add(SystemProperties.getProperty("SHOP_LISTING_HEADER").split(","));

        // CSVフォマットの変換
        for (int i = 0; i < rsList.size(); i++) {
            tmp = rsList.get(i);
            if (ConstValues.KEIYAKU_CHINTAI.equals(tmp.getKeiyakuShubetsu())) {
                csvList.add(new String[] {
                        tmp.getShopCd(),
                        tmp.getCompany(),
                        tmp.getBumon(),
                        this.convertKeiyakuShubetsu(tmp.getKeiyakuShubetsu()),
                        this.convertDateValue(tmp.getKeiyakuStartYm()),
                        this.convertDateValue(tmp.getKeiyakuEndYm()),
                        this.convertDateValue(tmp.getCouponStartYm()),
                        this.convertDateValue(tmp.getCouponEndYm()),
                        this.convertDateValue(tmp.getCoupon1StartYmd(),
                                                new SimpleDateFormat("yyyy/MM/dd")),
                        this.convertDateValue(tmp.getCoupon1EndYmd(),
                                                new SimpleDateFormat("yyyy/MM/dd")),
                        this.convertDateValue(tmp.getCoupon2StartYmd(),
                                                new SimpleDateFormat("yyyy/MM/dd")),
                        this.convertDateValue(tmp.getCoupon2EndYmd(),
                                                new SimpleDateFormat("yyyy/MM/dd")),
                        this.convertDateValue(tmp.getCoupon3StartYmd(),
                                                new SimpleDateFormat("yyyy/MM/dd")),
                        this.convertDateValue(tmp.getCoupon3EndYmd(),
                                                new SimpleDateFormat("yyyy/MM/dd")),
                        this.convertDateValue(tmp.getLinkStartYm()),
                        this.convertDateValue(tmp.getLinkEndYm()) });
            } else {
                csvList.add(new String[] {
                        tmp.getShopCd(),
                        tmp.getCompany(),
                        tmp.getBumon(),
                        this.convertKeiyakuShubetsu(tmp.getKeiyakuShubetsu()),
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null });
            }
        }
        return csvList;
    }

    /**
     * 契約種別コードをプロパティ設定値に変換します。
     *
     * @param code 契約種別
     * @return 契約種別コード変換値
     */
    private String convertKeiyakuShubetsu(String code) {

        // 戻り値
        String returnValue = null;

        String[] names = SystemProperties.getProperties("KEIYAKU_SHUBETSU_NAME_FOR_CSV");
        String[] values = SystemProperties.getProperties("KEIYAKU_SHUBETSU_VALUE_FOR_CSV");

        for (int i = 0; i < values.length; i++) {
            if (StringUtils.isNotEmpty(values[i]) && values[i].equals(code)) {
                returnValue = names[i];
            }
        }

        return returnValue;
    }

    /**
     * 日付データを出力用文字列に変換します。
     *
     * @param date 日付データ。
     * @param sdf SimpleDateFormat。
     * @return 変換済の日付文字列。
     */
    private String convertDateValue(Date date, SimpleDateFormat sdf) {

        String returnValue = "";
        if (date != null) {
            returnValue = sdf.format(date);
        }

        return returnValue;
    }

    /**
     * 日付データを出力用文字列に変換します。
     *
     * @param date 日付データ。
     * @return 変換済の日付文字列。
     */
    private String convertDateValue(String date) {

        String returnValue = "";
        if (date != null) {
            returnValue = date.substring(0, 4) + '/' + date.substring(4);
        }

        return returnValue;
    }

    /**
     * CSVファイル名を生成します。
     *
     * @param nowDate 現在日付。
     * @return 生成されたCSVファイル名。
     */
    private String getCsvFileName(Date nowDate) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        String date = sdf.format(nowDate);

        StringBuffer sb = new StringBuffer();
        sb.append(SystemProperties.getProperty("SHOP_LISTING_FILENAME"));
        sb.append(date);
        sb.append(".csv");

        return sb.toString();
    }
}
