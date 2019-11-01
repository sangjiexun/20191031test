/*
 * $Id: KeiyakuShopSearchDao.java 4246 2009-03-23 09:00:00Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/19     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.dao;

import java.util.Date;
import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.shop_listing.domain.KeiyakuShopSearchDomain;

/**
 * 契約店舗検索DAO
 *
 * @author Lee Hosup
 * @version $Revision: 4246 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface KeiyakuShopSearchDao {

    /**
     * 総件数を取得。
     *
     * @param paramBean 検索パラメータ
     * @return 総件数
     */
    public int searchTotalCnt(KeiyakuShopSearchParamBean paramBean);

    /**
     * 契約店舗検索を行う。
     * @param paramBean 検索パラメータ
     * @return 検索結果リスト
     */
    public List<KeiyakuShopSearchDomain> searchShopList(KeiyakuShopSearchParamBean paramBean,
            BasePagerCondition condition);

    /**
     * DBの現在時刻を取得します。
     *
     * @return DBのSYSDATE
     */
    public Date searchSysdate();

}
