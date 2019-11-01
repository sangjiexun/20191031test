/*
 * $Id: ShopImageUpdateCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/26  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import net.chintai.backend.sysadmin.shop_bukken.dao.ShopImageUpdateCommitDao;
import net.chintai.backend.sysadmin.shop_bukken.domain.ShopImageInfo;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * ShopImageUpdateCommitDaoの実装クラス
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopImageUpdateCommitDaoImpl extends SqlMapClientDaoSupport implements
        ShopImageUpdateCommitDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ShopImageUpdateCommitDao#selectShopDetailInfoSearchByShopCd(net.chintai.backend.sysadmin.shop_bukken.dao.ShopImageUpdateCommitParamBean)
     */
    public int updateShopImageFlgUpdateCommit(ShopImageInfo shopImageInfo) {
        return getSqlMapClientTemplate().update("shopBukken.updateShopImageFlgUpdateCommit",
                shopImageInfo);
    }

}
