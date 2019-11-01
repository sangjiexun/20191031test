/*
 * $Id: ShopDetailInfoSearchDao.java 3765 2008-01-21 09:04:43Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/09  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao;

import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.domain.ShopDetailInfo;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopDownloadInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopDownloadOutServiceBean;


/**
 * 店舗詳細を照会する。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3765 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopDetailInfoSearchDao {

    /**
     * 店舗コードから店舗詳細を照会する。
     * @param paramBean 店舗コード
     * @return 店舗詳細
     */
    public ShopDetailInfo selectShopDetailInfoSearchByShopCd(ShopDetailInfoSearchParamBean paramBean);

    /**
     * 店舗ダウンロード
     * @return
     */
    public List<ShopDownloadOutServiceBean> selectShopForDownload(ShopDownloadInServiceBean bean);

    /**
     * 店舗ダウンロード
     * @return
     */
    public List<ShopDownloadOutServiceBean> selectShopReserveForDownload(ShopDownloadInServiceBean bean);

}
