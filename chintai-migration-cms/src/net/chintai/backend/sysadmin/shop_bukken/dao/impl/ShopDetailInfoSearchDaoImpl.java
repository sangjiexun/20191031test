/*
 * $Id: ShopDetailInfoSearchDaoImpl.java 3765 2008-01-21 09:04:43Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/09  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.dao.ShopDetailInfoSearchDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopDetailInfoSearchParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.ShopDetailInfo;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopDownloadInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopDownloadOutServiceBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * ShopDetailInfoDaoの実装クラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3765 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopDetailInfoSearchDaoImpl extends SqlMapClientDaoSupport implements ShopDetailInfoSearchDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ShopDetailInfoSearchDao#selectShopDetailInfoSearchByShopCd(net.chintai.backend.sysadmin.shop_bukken.dao.ShopDetailInfoSearchParamBean)
     */
    public ShopDetailInfo selectShopDetailInfoSearchByShopCd(ShopDetailInfoSearchParamBean paramBean) {
        paramBean.setChintaiBukkenCountTableName(getChintaiBukkenCountTableName());
        paramBean.setAbleBukkenCountTableName(getAbleBukkenCountTableName());
        return (ShopDetailInfo) getSqlMapClientTemplate().queryForObject("shopBukken.selectShopDetailInfo", paramBean);
    }

    /**
     * 現在有効なCHINTAI有効物件数カウント元テーブルを取得します。<br>
     * 有効テーブルの判定はPL/SQLプロシージャが行います。
     * @return "CT_BUKKEN" or "CT_BUKKEN_2"
     */
    private String getChintaiBukkenCountTableName() {
        return (String) getSqlMapClientTemplate().queryForObject("shopBukken.chintaiBukkenCountTable");
    }

    /**
     * 現在有効なエイブル有効物件数カウント元テーブルを取得します。
     * 有効テーブルの判定はPL/SQLプロシージャが行います。
     * @return "ABL_BUKKEN" or "ABL_BUKKEN_2"
     */
    private String getAbleBukkenCountTableName() {
        return (String) getSqlMapClientTemplate().queryForObject("shopBukken.ableBukkenCountTable");
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ShopDetailInfoSearchDao#selectShopForDownload()
     */
    public List<ShopDownloadOutServiceBean> selectShopForDownload(ShopDownloadInServiceBean bean) {
        return getSqlMapClientTemplate().queryForList("shopBukken.selectShopForDownload", bean);
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ShopDetailInfoSearchDao#selectShopReserveForDownload(net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopDownloadInServiceBean)
     */
    public List<ShopDownloadOutServiceBean> selectShopReserveForDownload(ShopDownloadInServiceBean bean) {
        return getSqlMapClientTemplate().queryForList("shopBukken.selectShopReserveForDownload", bean);
    }
}
