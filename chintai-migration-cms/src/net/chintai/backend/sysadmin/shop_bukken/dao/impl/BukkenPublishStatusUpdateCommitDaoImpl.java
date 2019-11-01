/*
 * $Id: BukkenPublishStatusUpdateCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/03  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import java.util.HashMap;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.shop_bukken.dao.BukkenPublishStatusRirekiAddCommitParamBean;
import net.chintai.backend.sysadmin.shop_bukken.dao.BukkenPublishStatusUpdateCommitDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.BukkenPublishStatusUpdateCommitParamBean;

/**
 * BukkenPublishStatusUpdateCommitDaoインターフェースの実装クラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class BukkenPublishStatusUpdateCommitDaoImpl
    extends SqlMapClientDaoSupport
    implements BukkenPublishStatusUpdateCommitDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.BukkenPublishStatusUpdateCommitDao#bukkenPublishStatusUpdateCommit(net.chintai.backend.sysadmin.shop_bukken.dao.BukkenPublishStatusUpdateCommitParamBean)
     */
    public int bukkenPublishStatusUpdateCommit(
            BukkenPublishStatusUpdateCommitParamBean paramBean) {

        return getSqlMapClientTemplate().update
            ("shopBukken.bukkenPublishStatusUpdateCommit", paramBean);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.selectBukkenPublishStatusUpdateCheck#bukkenPublishStatusUpdateCommit(net.chintai.backend.sysadmin.shop_bukken.dao.BukkenPublishStatusUpdateCommitParamBean)
     */
    public HashMap<String,Object> selectBukkenPublishStatusUpdateCheck(
            BukkenPublishStatusUpdateCommitParamBean paramBean) {

        return (HashMap<String,Object>)getSqlMapClientTemplate().queryForObject
                ("shopBukken.selectPublishStatusUpdateCheck", paramBean);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.bukkenPublishStatuRirekiAddCommit#bukkenPublishStatusUpdateCommit(net.chintai.backend.sysadmin.shop_bukken.dao.BukkenPublishStatusUpdateCommitParamBean)
     */
    public int bukkenPublishStatuRirekiAddCommit(
            BukkenPublishStatusRirekiAddCommitParamBean paramBean) {
        return getSqlMapClientTemplate().update
                ("shopBukken.bukkenPublishStatuRirekiAddCommit", paramBean);

    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.bukkenPublishStatuRirekiAddCommit#selectSeqBUkkenRireki()
     */
   public Long selectSeqBUkkenRireki() {
        return (Long)getSqlMapClientTemplate().queryForObject
                ("shopBukken.selectPkBukkenRireki");

    }

   /*
    * (非 Javadoc)
    * @see net.chintai.backend.sysadmin.shop_bukken.dao.bukkenPublishStatuRirekiAddCommit#BukkenPublishStatusRirekiAddCommitParamBean(net.chintai.backend.sysadmin.shop_bukken.dao.BukkenPublishStatusUpdateCommitParamBean)
    */
    public void bukkenStatuKanriAddCommit(
            BukkenPublishStatusUpdateCommitParamBean paramBean) {
        // TODO 自動生成されたメソッド・スタブ
        getSqlMapClientTemplate().update
                ("shopBukken.bukkenStatuKanriAddCommit", paramBean);
    }

}