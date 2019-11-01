/*
 * $Id: AspAreaPrefInfoDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/11  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.dao.AspAreaPrefInfoDao;
import net.chintai.backend.sysadmin.shop_bukken.domain.AspAreaPrefInfo;
import net.chintai.backend.sysadmin.shop_bukken.domain.AspPrefInfo;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * AspAreaPrefInfoDaoの実装クラス
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspAreaPrefInfoDaoImpl extends SqlMapClientDaoSupport implements AspAreaPrefInfoDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.AspAreaPrefInfoDao#selectAspAreaPrefInfo()
     */
    @SuppressWarnings("unchecked")
    public List<AspAreaPrefInfo> selectAspAreaPrefInfo() {
        return getSqlMapClientTemplate().queryForList("shopBukken.selectAspAreaPrefInfo");
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.AspAreaPrefInfoDao#selectAspPrefInfo()
     */
    @SuppressWarnings("unchecked")
    public List<AspPrefInfo> selectAspPrefInfo() {
        return getSqlMapClientTemplate().queryForList("shopBukken.selectAspPrefInfo");
    }

}
