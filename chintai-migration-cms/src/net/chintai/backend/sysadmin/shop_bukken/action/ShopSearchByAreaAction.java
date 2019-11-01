/*
 * $Id: ShopSearchByAreaAction.java 3838 2008-02-27 04:16:18Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/19  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.action;

import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.BaseActionSupport;
import net.chintai.backend.sysadmin.common.BusinessContext;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.AuthService;
import net.chintai.backend.sysadmin.common.session.SessionSearchKey;
import net.chintai.backend.sysadmin.common.util.CsvException;
import net.chintai.backend.sysadmin.common.util.CsvExportUtil;
import net.chintai.backend.sysadmin.common.util.CsvStatusBean;
import net.chintai.backend.sysadmin.shop_bukken.action.view.ShopSearchView;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopListCsvService;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopSearchByAreaForCsvService;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopSearchByAreaService;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopSearchByEnsenForCsvService;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopSearchByEnsenService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopSearchInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopSearchOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 地域・沿線から検索のアクション
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3838 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopSearchByAreaAction extends BaseActionSupport {

    /** 地域から検索 */
    private static final String SHOP_SEARCH_BY_AREA = "1";

    /** 沿線から検索 */
    private static final String SHOP_SEARCH_BY_ENSEN = "2";

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#doExecute(net.chintai.backend.sysadmin.common.BusinessContext)
     */
    @Override
    protected void doExecute(BusinessContext context) throws Exception {

        // 画面データの取得
        DynaValidatorForm form = (DynaValidatorForm) context.getForm();
        ShopSearchInServiceBean inServiceBean = new ShopSearchInServiceBean();
        BeanUtils.copyProperties(inServiceBean, form);

        // Sessionに検索条件InServiceBeanをセットする
        context.getSessionBean().getSearchConditionMap().put(SessionSearchKey.SHOP_BUKKEN_SEARCH_BY_AREA, inServiceBean);

        // ページング状態を設定
        BasePagerCondition condition = new BasePagerCondition();
        condition.setLimit(Integer.parseInt(((String) form.get("displayNum"))));
        condition.setOffset(((Integer) form.get("offSet")).intValue());

        // 検索タイプを取得
        String kbnAreaRosen = inServiceBean.getKbnAreaRosen();

        ShopSearchView view = new ShopSearchView(condition);

        // 検索処理実行(CSV/Viewで分岐)
        if (form.getString("outputMode").equals("csv")) {
            List<ShopSearchOutServiceBean> rsShopList = searchForCsv(inServiceBean, kbnAreaRosen);

            // CSV 出力
            if (rsShopList != null && rsShopList.size() > 0) {
                exportCsv(context, rsShopList);

                context.setForward(null);
                return;
            }
            context.setError("WARN.M.SHOP_BUKKEN.0073");

        } else {
            // グループ一覧のviewHelper設定
            List<ShopSearchView.ShopSearchDetailView> shopSearchList = new ArrayList<ShopSearchView.ShopSearchDetailView>();

            List<ShopSearchOutServiceBean> rsShopList = searchForView(inServiceBean, condition, kbnAreaRosen);

            if (rsShopList != null && rsShopList.size() > 0) {
                for (int i = 0; i < rsShopList.size(); i++) {
                    ShopSearchOutServiceBean shop = (ShopSearchOutServiceBean) rsShopList.get(i);

                    ShopSearchView.ShopSearchDetailView shopDetail = view.new ShopSearchDetailView();
                    BeanUtils.copyProperties(shopDetail, shop);

                    shopSearchList.add(shopDetail);
                }
                view.setShopSearchList(shopSearchList);

            } else {
                context.setError("WARN.M.SHOP_BUKKEN.0044");
            }
        }
        // 一覧以外の情報をコピー
        BeanUtils.copyProperties(view, inServiceBean);
        context.setForward("success", view);
    }

    /**
     * CSV出力を実行します。
     * @param context ビジネスコンテキスト
     * @param rsShopList 店舗検索結果リスト
     * @throws CsvException CSV出力中に例外が発生した場合スローされます。
     */
    private void exportCsv(BusinessContext context, List<ShopSearchOutServiceBean> rsShopList) throws CsvException {
        // csvデータ取得
        List<String[]> csvList = this.makeCsvList(rsShopList);

        // csv出力に必要な情報をstatusBeanに設定
        CsvStatusBean csvStatusBean = new CsvStatusBean();
        csvStatusBean.setFileName(this.getCsvFileName());
        csvStatusBean.setResponse(context.getResponse());

        // ダウンロード処理
        CsvExportUtil.export(csvStatusBean, csvList);
    }

    /**
     * 検索を実行します。
     * @param inServiceBean 検索パラメータ
     * @param condition 検索パラメータ(表示件数など)
     * @param kbnAreaRosen 地域/沿線
     * @return 検索結果リスト
     */
    private List<ShopSearchOutServiceBean> searchForView(ShopSearchInServiceBean inServiceBean, BasePagerCondition condition, String kbnAreaRosen) {
        ApplicationContext ac = getWebApplicationContext();
        List<ShopSearchOutServiceBean> rsShopList = null;

        // 地域から検索
        if (SHOP_SEARCH_BY_AREA.equals(kbnAreaRosen)) {
            ShopSearchByAreaService shopSearchService = (ShopSearchByAreaService) ac.getBean("shopSearchByAreaService");
            rsShopList = shopSearchService.shopSearchByArea(inServiceBean, condition);
        // 沿線から検索
        } else if (SHOP_SEARCH_BY_ENSEN.equals(kbnAreaRosen)) {
            ShopSearchByEnsenService shopSearchService = (ShopSearchByEnsenService) ac.getBean("shopSearchByEnsenService");
            rsShopList = shopSearchService.shopSearchByEnsen(inServiceBean, condition);
        }
        return rsShopList;
    }

    /**
     * CSV用の検索を実行します。
     * @param inServiceBean 検索パラメータ
     * @param kbnAreaRosen 地域/沿線
     * @return 検索結果リスト
     */
    private List<ShopSearchOutServiceBean> searchForCsv(ShopSearchInServiceBean inServiceBean, String kbnAreaRosen) {
        ApplicationContext ac = getWebApplicationContext();
        List<ShopSearchOutServiceBean> rsShopList = null;

        // 地域から検索
        if (SHOP_SEARCH_BY_AREA.equals(kbnAreaRosen)) {
            ShopSearchByAreaForCsvService shopSearchByAreaForCsvService = (ShopSearchByAreaForCsvService) ac.getBean("shopSearchByAreaForCsvService");
            rsShopList = shopSearchByAreaForCsvService.shopSearchByAreaForCsv(inServiceBean);
        // 沿線から検索
        } else if (SHOP_SEARCH_BY_ENSEN.equals(kbnAreaRosen)) {
            ShopSearchByEnsenForCsvService shopSearchByEnsenForCsvService = (ShopSearchByEnsenForCsvService) ac.getBean("shopSearchByEnsenForCsvService");
            rsShopList = shopSearchByEnsenForCsvService.shopSearchByEnsenForCsv(inServiceBean);
        }
        return rsShopList;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.BaseActionSupport#isAuthorized(java.lang.String)
     */
    @Override
    protected boolean isAuthorized(String userId) {
        ApplicationContext ac = getWebApplicationContext();
        AuthService auth = (AuthService) ac.getBean("authService");
        return auth.authenticate(userId, AuthorityId.SHOP_BUKKEN);
    }

    /**
     * CSVファイル名を取得
     * @param 開始日、終了日
     * @return CSVファイル名
     */
    private String getCsvFileName() {
        return SystemProperties.getProperty("ShopSearch.Filename") + ".csv";
    }

    /**
     * 店舗リストをCSVフォーマットに変換します。
     * @param 検索結果
     * @return CSVデータ
     */
    private List<String[]> makeCsvList(List<ShopSearchOutServiceBean> rsShopList) {
        ShopListCsvService service = (ShopListCsvService) getWebApplicationContext().getBean("shopListCsvService");
        return service.createShopListCsv(rsShopList);
    }

}
