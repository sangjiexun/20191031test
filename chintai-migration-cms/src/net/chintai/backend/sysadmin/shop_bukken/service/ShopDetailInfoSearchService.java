/*
 * $Id: ShopDetailInfoSearchService.java 3762 2008-01-21 06:58:31Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/09  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service;

import java.util.List;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopDetailInfoSearchInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopDetailInfoSearchOutServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopDownloadInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopDownloadOutServiceBean;

/**
 * 店舗詳細照会を提供するサービスクラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3762 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopDetailInfoSearchService {

    /**
     * 店舗コードから店舗詳細を照会する。
     *
     * @param inServiceBean 店舗コード
     * @return 店舗詳細
     * @throws ApplicationException
     */
    public ShopDetailInfoSearchOutServiceBean shopSearchByShopCd(ShopDetailInfoSearchInServiceBean inServiceBean)
            throws Exception;

    /**
     * 店舗のCSVダウンロード処理をする
     * @return CSVダウンロードリスト
     * @throws Exception
     */
    public List<ShopDownloadOutServiceBean> selectShopForDownload(ShopDownloadInServiceBean inServiceBean) throws ApplicationException;

    /**
     * 店舗予約のCSVダウンロード処理をする
     * @param inServiceBean
     * @return CSVダウンロードリスト
     * @throws ApplicationException
     */
    public List<ShopDownloadOutServiceBean> selectShopReserveForDownload(ShopDownloadInServiceBean inServiceBean) throws ApplicationException;
}
