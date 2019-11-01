/*
 * $Id: ShopSearchByShopInfoAction.java 3830 2008-02-27 04:06:42Z t-kojima $
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
import net.chintai.backend.sysadmin.common.util.CsvExportUtil;
import net.chintai.backend.sysadmin.common.util.CsvStatusBean;
import net.chintai.backend.sysadmin.shop_bukken.action.view.ShopSearchView;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopListCsvService;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopSearchByShopInfoForCsvService;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopSearchByShopInfoService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopSearchInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopSearchOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.context.ApplicationContext;

/**
 * 店舗情報から検索のアクション
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3830 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopSearchByShopInfoAction extends BaseActionSupport {

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

        // Sessionに検索条件InServiceBeanをセットする。
        context.getSessionBean().getSearchConditionMap().put(SessionSearchKey.SHOP_BUKKEN_SEARCH_BY_SHOPINFO, inServiceBean);

        // ページング状態を設定
        BasePagerCondition condition = new BasePagerCondition();
        condition.setLimit(Integer.parseInt(((String) form.get("displayNum"))));
        condition.setOffset(((Integer) form.get("offSet")).intValue());

        ApplicationContext ac = getWebApplicationContext();

        ShopSearchView view = new ShopSearchView(condition);

        // 店舗情報から検索
        if (form.get("outputMode").equals("csv")) {
            ShopSearchByShopInfoForCsvService shopSearchByShopInfoForCsvService = (ShopSearchByShopInfoForCsvService) ac.getBean("shopSearchByShopInfoForCsvService");
            List<ShopSearchOutServiceBean> rsShopList = shopSearchByShopInfoForCsvService.shopSearchByShopInfoForCsv(inServiceBean);

            if (rsShopList != null && rsShopList.size() > 0) {
                // csvデータ取得
                List<String[]> csvList = this.makeCsvList(rsShopList);

                // csv出力に必要な情報をstatusBeanに設定
                CsvStatusBean csvStatusBean = new CsvStatusBean();
                csvStatusBean.setFileName(this.getCsvFileName());
                csvStatusBean.setResponse(context.getResponse());

                // ダウンロード処理
                CsvExportUtil.export(csvStatusBean, csvList);

                context.setForward(null);
                return;
            }
            context.setError("WARN.M.SHOP_BUKKEN.0073");

        } else {
            ShopSearchByShopInfoService shopSearchService = (ShopSearchByShopInfoService) ac.getBean("shopSearchByShopInfoService");
            List<ShopSearchOutServiceBean> rsShopList = shopSearchService.shopSearchByShopInfo(inServiceBean, condition);

            if (rsShopList != null && rsShopList.size() > 0) {
                List<ShopSearchView.ShopSearchDetailView> shopSearchList = new ArrayList<ShopSearchView.ShopSearchDetailView>();

                for (int i = 0; i < rsShopList.size(); i++) {
                    ShopSearchOutServiceBean shop = (ShopSearchOutServiceBean) rsShopList.get(i);

                    // リスト項目はinnerClassで処理
                    ShopSearchView.ShopSearchDetailView shopDetail = view.new ShopSearchDetailView();
                    BeanUtils.copyProperties(shopDetail, shop);

                    shopSearchList.add(shopDetail);
                }
                // 検索結果をViewに設定
                view.setShopSearchList(shopSearchList);

            } else {
                context.setError("WARN.M.SHOP_BUKKEN.0044");
            }
        }

        // 検索条件をViewに設定
        BeanUtils.copyProperties(view, inServiceBean);
        context.setForward("success", view);
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
        String fileName = SystemProperties.getProperty("ShopSearch.Filename") + ".csv";
        return fileName;
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
