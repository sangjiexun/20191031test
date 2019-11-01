/*
 * $Id: ShopRegistrationStautsUpdatePageDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/09  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.shop_bukken.dao.ShopRegistrationStautsUpdatePageDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopRegistrationStautsUpdatePageParamBean;


/**
 * ShopRegistrationStautsUpdatePageDaoの実装クラス
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopRegistrationStautsUpdatePageDaoImpl extends SqlMapClientDaoSupport implements
        ShopRegistrationStautsUpdatePageDao {

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ShopRegistrationStautsUpdatePageDao#selectShopRegistrationStauts(net.chintai.backend.sysadmin.shop_bukken.dao.ShopRegistrationStautsUpdatePageParamBean)
     */
    public Object selectShopRegistrationStauts(ShopRegistrationStautsUpdatePageParamBean paramBean) {
        return getSqlMapClientTemplate().queryForObject("shopBukken.selectShopRegistrationStatusUpdatePage", paramBean);
    }

}
