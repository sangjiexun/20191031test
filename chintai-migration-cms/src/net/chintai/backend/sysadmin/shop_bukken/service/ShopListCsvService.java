/*
 * $Id: ShopListCsvService.java 3839 2008-02-27 04:17:31Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2008/02/27   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service;

import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopSearchOutServiceBean;

/**
 * Bean List を CSV出力用 List に変換するサービス。
 * 店舗検索用。
 * 
 * @author KOJIMA Takanori
 */
public interface ShopListCsvService {

    /**
     * Bean List を CSV出力用 List に変換します。
     * @param rsShopList {@link List} - {@link ShopSearchOutServiceBean} のリスト
     * @return {@link List} - String[] のリスト
     */
    public List<String[]> createShopListCsv(List<ShopSearchOutServiceBean> rsShopList);
}
