/*
 * $Id: ShopRegistrationStatusUpdateCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/10  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import net.chintai.backend.sysadmin.shop_bukken.dao.ShopRegistrationStatusUpdateCommitDao;
import net.chintai.backend.sysadmin.shop_bukken.domain.ShopRegistrationStauts;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * ShopRegistrationStatusUpdateCommitDaoの実装クラス。
 * 
 * @author Sim-JongYeon
 * @author yang-eunmi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopRegistrationStatusUpdateCommitDaoImpl extends SqlMapClientDaoSupport implements
        ShopRegistrationStatusUpdateCommitDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ShopRegistrationStatusUpdateCommitDao#updateShopRegistrationStatus(net.chintai.backend.sysadmin.shop_bukken.domain.ShopRegistrationStauts)
     */
    public int updateShopRegistrationStatus(ShopRegistrationStauts shopRegistrationStautsBean) {
        return getSqlMapClientTemplate().update("shopBukken.updateShopRegistrationStatus",
                shopRegistrationStautsBean);
    }
    
    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ShopRegistrationStatusUpdateCommitDao#updateShopBindInfo(net.chintai.backend.sysadmin.shop_bukken.domain.ShopRegistrationStauts)
     */
    public int updateShopBindInfo(ShopRegistrationStauts paramBean) {
        return getSqlMapClientTemplate().update("shopBukken.updateShopBindInfo", paramBean);
    }
    
    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ShopRegistrationStatusUpdateCommitDao#updateShopBindInfo2(net.chintai.backend.sysadmin.shop_bukken.domain.ShopRegistrationStauts)
     */
    public int updateShopBindInfo2(ShopRegistrationStauts paramBean) {
        return getSqlMapClientTemplate().update("shopBukken.updateShopBindInfo2", paramBean);
    }

}
