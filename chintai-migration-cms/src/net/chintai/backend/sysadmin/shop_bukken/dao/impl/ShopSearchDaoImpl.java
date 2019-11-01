/*
 * $Id: ShopSearchDaoImpl.java 3868 2008-03-12 09:16:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/04  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopSearchDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopSearchParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * ShopSearchDaoの実装クラス
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3868 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopSearchDaoImpl extends SqlMapClientDaoSupport implements ShopSearchDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ShopSearchDao#selectShopSearchByArea(net.chintai.backend.sysadmin.shop_bukken.dao.ShopSearchParamBean)
     */
    public List selectShopSearchByArea(ShopSearchParamBean paramBean, BasePagerCondition condition) {
        paramBean.setChintaiBukkenCountTableName(getChintaiBukkenCountTableName());
        paramBean.setAbleBukkenCountTableName(getAbleBukkenCountTableName());
        return getSqlMapClientTemplate().queryForList("shopBukken.selectShopSearchByArea", paramBean, condition.getOffset(), condition.getLimit());
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ShopSearchDao#selectShopSearchByAreaEnsen(net.chintai.backend.sysadmin.shop_bukken.dao.ShopSearchParamBean)
     */
    public List selectShopSearchByEnsen(ShopSearchParamBean paramBean, BasePagerCondition condition) {
        paramBean.setChintaiBukkenCountTableName(getChintaiBukkenCountTableName());
        paramBean.setAbleBukkenCountTableName(getAbleBukkenCountTableName());
        return getSqlMapClientTemplate().queryForList("shopBukken.selectShopSearchByEnsen", paramBean, condition.getOffset(), condition.getLimit());
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ShopSearchDao#selectShopSearchByShopInfo(net.chintai.backend.sysadmin.shop_bukken.dao.ShopSearchParamBean)
     */
    public List selectShopSearchByShopInfo(ShopSearchParamBean paramBean, BasePagerCondition condition) {
        paramBean.setChintaiBukkenCountTableName(getChintaiBukkenCountTableName());
        paramBean.setAbleBukkenCountTableName(getAbleBukkenCountTableName());
        return getSqlMapClientTemplate().queryForList("shopBukken.selectShopSearchByShopInfo", paramBean, condition.getOffset(), condition.getLimit());
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ShopSearchDao#selectShopSearchByShopInfoCount(net.chintai.backend.sysadmin.shop_bukken.dao.ShopSearchParamBean)
     */
    public int selectShopSearchByShopInfoCount(ShopSearchParamBean paramBean) {
        paramBean.setChintaiBukkenCountTableName(getChintaiBukkenCountTableName());
        paramBean.setAbleBukkenCountTableName(getAbleBukkenCountTableName());
        return (Integer) getSqlMapClientTemplate().queryForObject("shopBukken.selectShopSearchByShopInfoCount", paramBean);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ShopSearchDao#selectShopSearchByAreaCount(net.chintai.backend.sysadmin.shop_bukken.dao.ShopSearchParamBean)
     */
    public int selectShopSearchByAreaCount(ShopSearchParamBean paramBean) {
        paramBean.setChintaiBukkenCountTableName(getChintaiBukkenCountTableName());
        paramBean.setAbleBukkenCountTableName(getAbleBukkenCountTableName());
        return (Integer) getSqlMapClientTemplate().queryForObject("shopBukken.selectShopSearchByAreaCount", paramBean);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ShopSearchDao#selectShopSearchByEnsenCount(net.chintai.backend.sysadmin.shop_bukken.dao.ShopSearchParamBean)
     */
    public int selectShopSearchByEnsenCount(ShopSearchParamBean paramBean) {
        paramBean.setChintaiBukkenCountTableName(getChintaiBukkenCountTableName());
        paramBean.setAbleBukkenCountTableName(getAbleBukkenCountTableName());
        return (Integer) getSqlMapClientTemplate().queryForObject("shopBukken.selectShopSearchByEnsenCount", paramBean);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ShopSearchDao#selectShopSearchByAreaForCsv(net.chintai.backend.sysadmin.shop_bukken.dao.ShopSearchParamBean)
     */
    public List selectShopSearchByAreaForCsv(ShopSearchParamBean paramBean) {
        paramBean.setChintaiBukkenCountTableName(getChintaiBukkenCountTableName());
        paramBean.setAbleBukkenCountTableName(getAbleBukkenCountTableName());
        return getSqlMapClientTemplate().queryForList("shopBukken.selectShopSearchByArea", paramBean);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ShopSearchDao#selectShopSearchByEnsenForCsv(net.chintai.backend.sysadmin.shop_bukken.dao.ShopSearchParamBean)
     */
    public List selectShopSearchByEnsenForCsv(ShopSearchParamBean paramBean) {
        paramBean.setChintaiBukkenCountTableName(getChintaiBukkenCountTableName());
        paramBean.setAbleBukkenCountTableName(getAbleBukkenCountTableName());
        return getSqlMapClientTemplate().queryForList("shopBukken.selectShopSearchByEnsen", paramBean);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ShopSearchDao#selectShopSearchByShopInfoForCsv(net.chintai.backend.sysadmin.shop_bukken.dao.ShopSearchParamBean)
     */
    public List selectShopSearchByShopInfoForCsv(ShopSearchParamBean paramBean) {
        paramBean.setChintaiBukkenCountTableName(getChintaiBukkenCountTableName());
        paramBean.setAbleBukkenCountTableName(getAbleBukkenCountTableName());
        return getSqlMapClientTemplate().queryForList("shopBukken.selectShopSearchByShopInfo", paramBean);
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
}
