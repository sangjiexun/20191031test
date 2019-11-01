/*
 * $Id: KeiyakuRegisterCompleteDaoImpl.java 4282 2009-07-06 12:17:41Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/24  BGT)李昊燮     新規作成
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 */
package net.chintai.backend.sysadmin.shop_listing.dao.impl;

import net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuRegisterCompleteDao;
import net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuRegisterCompleteParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * KeiyakuRegisterCompleteDaoの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4282 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class KeiyakuRegisterCompleteDaoImpl extends SqlMapClientDaoSupport implements
        KeiyakuRegisterCompleteDao {

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuRegisterCompleteDao#
     * registerKeiyakuInfo(net.chintai.backend.sysadmin.shop_listing.dao.
     * KeiyakuRegisterCompleteParamBean)
     */
    public String registerKeiyakuInfo(KeiyakuRegisterCompleteParamBean paramBean) {
        return (String) getSqlMapClientTemplate()
                .insert("shopListing.insertKeiyakuInfo", paramBean);
    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuRegisterCompleteDao#
     * registerKeiyakuHistoryInfo(
     * net.chintai.backend.sysadmin.shop_listing.dao.
     * KeiyakuRegisterCompleteParamBean)
     */
    public String registerKeiyakuHistoryInfo(KeiyakuRegisterCompleteParamBean paramBean) {
        return (String) getSqlMapClientTemplate().insert("shopListing.insertKeiyakuRireki",
                paramBean);
    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuRegisterCompleteDao#
     * countTotalCnt(net.chintai.backend.sysadmin.shop_listing.dao.
     * KeiyakuRegisterCompleteParamBean)
     */
    public int countTotalCnt(KeiyakuRegisterCompleteParamBean paramBean) {
        return (Integer) getSqlMapClientTemplate().queryForObject(
                "shopListing.countKeiyakuCntByShopCd", paramBean);
    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuRegisterCompleteDao
     * #updateKeiyakuInfo(net.chintai.backend.sysadmin.shop_listing.dao.
     * KeiyakuRegisterCompleteParamBean)
     */
    public void updateKeiyakuInfo(KeiyakuRegisterCompleteParamBean paramBean) {
        getSqlMapClientTemplate().update("shopListing.updateKeiyakuInfo", paramBean, 1);
    }

}
