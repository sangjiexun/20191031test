/*
 * $Id: ShopSearchDao.java 3762 2008-01-21 06:58:31Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/04  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;

/**
 * 店舗検索するDao
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3762 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopSearchDao {

    /**
     * 店舗情報から検索の結果件数
     * @param paramBean paramBean 検索条件
     * @return 店舗検索結果件数
     */
    public int selectShopSearchByShopInfoCount(ShopSearchParamBean paramBean);

    /**
     * 店舗情報から検索
     * @param paramBean 検索条件
     * @return 店舗検索結果リスト
     */
    public List selectShopSearchByShopInfo(ShopSearchParamBean paramBean, BasePagerCondition condition);

    /**
     * 店舗情報から検索(CSV用)
     * @param paramBean 検索条件
     * @return 店舗検索結果リスト(CSV用)
     */
    public List selectShopSearchByShopInfoForCsv(ShopSearchParamBean paramBean);

    /**
     * 店舗情報から検索の結果件数
     * @param paramBean 検索条件
     * @return 店舗検索結果件数
     */
    public int selectShopSearchByAreaCount(ShopSearchParamBean paramBean);

    /**
     * 地域から検索
     * @param paramBean 検索条件
     * @return 店舗検索結果リスト
     */
    public List selectShopSearchByArea(ShopSearchParamBean paramBean, BasePagerCondition condition);

    /**
     * 地域から検索(CSV用)
     * @param paramBean 検索条件
     * @return 店舗検索結果リスト(CSV用)
     */
    public List selectShopSearchByAreaForCsv(ShopSearchParamBean paramBean);

    /**
     * 店舗情報から検索の結果件数
     * @param paramBean 検索条件
     * @return 店舗検索結果件数
     */
    public int selectShopSearchByEnsenCount(ShopSearchParamBean paramBean);

    /**
     * 沿線から検索
     * @param paramBean 検索条件
     * @return 店舗検索結果リスト
     */
    public List selectShopSearchByEnsen(ShopSearchParamBean paramBean, BasePagerCondition condition);

    /**
     * 沿線から検索(CSV用)
     * @param paramBean 検索条件
     * @return 店舗検索結果リスト(CSV用)
     */
    public List selectShopSearchByEnsenForCsv(ShopSearchParamBean paramBean);

}
