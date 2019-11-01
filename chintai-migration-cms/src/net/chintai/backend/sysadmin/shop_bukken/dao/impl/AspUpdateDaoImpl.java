/*
 * $Id: AspUpdateDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/16  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.dao.AspShopInfoParamBean;
import net.chintai.backend.sysadmin.shop_bukken.dao.AspUpdateDao;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * AspUpdateDaoの実装クラス。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspUpdateDaoImpl extends SqlMapClientDaoSupport implements AspUpdateDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.AspUpdateDao#selectAspRegisteredInfo(net.chintai.backend.sysadmin.shop_bukken.dao.AspUpdateParamBean)
     */
    public Object selectAspRegisteredInfo(AspShopInfoParamBean paramBean) {
        return getSqlMapClientTemplate().queryForObject("shopBukken.selectAspRegisteredInfo",
                paramBean);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.AspUpdateDao#selectAspAreaRegisteredInfo(net.chintai.backend.sysadmin.shop_bukken.dao.AspUpdateParamBean)
     */
    public List selectAspAreaRegisteredInfo(AspShopInfoParamBean paramBean) {
        return getSqlMapClientTemplate().queryForList("shopBukken.selectAspAreaRegisteredInfo",
                paramBean);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.AspUpdateDao#selectAspShopInfo(net.chintai.backend.sysadmin.shop_bukken.dao.AspUpdateParamBean)
     */
    public Object selectAspShopInfo(AspShopInfoParamBean paramBean) {
        return getSqlMapClientTemplate().queryForObject("shopBukken.selectAspShopInfo", paramBean);
    }

}
