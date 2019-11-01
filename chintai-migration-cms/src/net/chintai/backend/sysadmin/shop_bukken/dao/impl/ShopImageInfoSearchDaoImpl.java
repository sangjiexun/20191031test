/*
 * $Id: ShopImageInfoSearchDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/23  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import net.chintai.backend.sysadmin.shop_bukken.dao.ShopImageInfoSearchDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopImageInfoSearchParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * ShopImageInfoSearchDaoの実装クラス
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopImageInfoSearchDaoImpl extends SqlMapClientDaoSupport implements
        ShopImageInfoSearchDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ShopImageInfoSearchDao#selectShopImageInfoSearchByShopCd(net.chintai.backend.sysadmin.shop_bukken.dao.ShopImageInfoSearchParamBean)
     */
    public Object selectShopImageInfoSearchByShopCd(ShopImageInfoSearchParamBean paramBean) {
        return getSqlMapClientTemplate().queryForObject("shopBukken.selectShopImageInfoByShopCd",
                paramBean);
    }

}
