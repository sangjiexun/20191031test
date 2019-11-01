/*
 * $Id: BukkenInfoDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/01  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.shop_bukken.dao.BukkenInfoDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.BukkenInfoParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.Bukken;
import net.chintai.backend.sysadmin.shop_bukken.domain.TantouShop;

/**
 * BukkenInfoDaoインターフェースの実装クラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class BukkenInfoDaoImpl extends SqlMapClientDaoSupport implements BukkenInfoDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.BukkenInfoDao#bukkenInfo(net.chintai.backend.sysadmin.shop_bukken.dao.BukkenInfoParamBean)
     */
    public Bukken bukkenInfo(BukkenInfoParamBean paramBean) {
        return (Bukken) getSqlMapClientTemplate().queryForObject("shopBukken.bukkenInfo", paramBean);
    }

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.shop_bukken.dao.BukkenInfoDao#bukkenInfoTantouShop(net.chintai.backend.sysadmin.shop_bukken.dao.BukkenInfoParamBean)
	 */
	public List bukkenInfoTantouShop(BukkenInfoParamBean paramBean) {
		return getSqlMapClientTemplate().queryForList("shopBukken.tantouShopList", paramBean);
	}
}