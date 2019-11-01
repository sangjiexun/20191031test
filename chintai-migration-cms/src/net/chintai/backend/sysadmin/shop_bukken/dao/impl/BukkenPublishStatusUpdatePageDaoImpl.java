/*
 * $Id: BukkenPublishStatusUpdatePageDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/02  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.shop_bukken.dao.BukkenPublishStatusUpdatePageDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.BukkenPublishStatusUpdatePageParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.Bukken;

/**
 * BukkenPublishStatusUpdatePageDaoインターフェースの実装クラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class BukkenPublishStatusUpdatePageDaoImpl
    extends SqlMapClientDaoSupport implements BukkenPublishStatusUpdatePageDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.BukkenPublishStatusUpdatePageDao#bukkenPublishStatusUpdatePage(net.chintai.backend.sysadmin.shop_bukken.dao.BukkenPublishStatusUpdatePageParamBean)
     */
    public Bukken bukkenPublishStatusUpdatePage(BukkenPublishStatusUpdatePageParamBean paramBean) {
        //return (Bukken) getSqlMapClientTemplate().queryForObject("shopBukken.bukkenPublishStatusUpdateInfo", paramBean);

    	//SQLは物件詳細と共通にする
    	return (Bukken) getSqlMapClientTemplate().queryForObject("shopBukken.bukkenInfo", paramBean);
    }
}