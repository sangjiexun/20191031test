/*
 * $Id: AspShopInfoDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/10  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.dao.AspShopInfoDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.AspShopInfoParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.AspGroupInfo;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * AspShopInfoDaoの実装クラス。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspShopInfoDaoImpl extends SqlMapClientDaoSupport implements AspShopInfoDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.AspShopInfoDao#selectAspShopInfo(net.chintai.backend.sysadmin.shop_bukken.dao.AspShopInfoParamBean)
     */
    public Object selectAspShopInfo(AspShopInfoParamBean paramBean) {
        return getSqlMapClientTemplate().queryForObject("shopBukken.selectAspShopInfo", paramBean);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.AspShopInfoDao#selectAspAreaRegisteredInfo(net.chintai.backend.sysadmin.shop_bukken.dao.AspShopInfoParamBean)
     */
    public List selectAspAreaRegisteredInfo(AspShopInfoParamBean paramBean) {
        return getSqlMapClientTemplate().queryForList("shopBukken.selectAspAreaRegisteredInfo",
                paramBean);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.AspShopInfoDao#selectAspRegisteredInfo(net.chintai.backend.sysadmin.shop_bukken.dao.AspShopInfoParamBean)
     */
    public Object selectAspRegisteredInfo(AspShopInfoParamBean paramBean) {
        return getSqlMapClientTemplate().queryForObject("shopBukken.selectAspRegisteredInfo",
                paramBean);
    }
    
    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.AspShopInfoDao#selectAspGroupList(java.lang.String)
     */
    @SuppressWarnings("unchecked")
    public List<AspGroupInfo> selectAspGroupList(String shopCd) {
        return getSqlMapClientTemplate().queryForList("shopBukken.aspGroupShopList", shopCd);
    }

}
