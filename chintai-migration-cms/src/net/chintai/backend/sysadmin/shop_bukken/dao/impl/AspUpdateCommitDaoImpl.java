/*
 * $Id: AspUpdateCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/17  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.dao.AspGroupAddCommitParamBean;
import net.chintai.backend.sysadmin.shop_bukken.dao.AspPrefDeleteCommitParamBean;
import net.chintai.backend.sysadmin.shop_bukken.dao.AspShopInfoParamBean;
import net.chintai.backend.sysadmin.shop_bukken.dao.AspUpdateCommitDao;
import net.chintai.backend.sysadmin.shop_bukken.domain.AspContractInfo;
import net.chintai.backend.sysadmin.shop_bukken.domain.AspInfo;
import net.chintai.backend.sysadmin.shop_bukken.domain.AspPrefInfo;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * AspUpdateCommitDaoの実装クラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspUpdateCommitDaoImpl extends SqlMapClientDaoSupport implements AspUpdateCommitDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.AspUpdateCommitDao#insertAspPref(net.chintai.backend.sysadmin.shop_bukken.domain.AspPrefInfo)
     */
    public void insertAspPref(AspPrefInfo aspPrefInfo) {
        getSqlMapClientTemplate().insert("shopBukken.insertAspPref", aspPrefInfo);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.AspUpdateCommitDao#selectAspPrefCountByShopCdPrefCd(net.chintai.backend.sysadmin.shop_bukken.domain.AspPrefInfo)
     */
    public int selectAspPrefCountByShopCdPrefCd(AspPrefInfo aspPrefInfo) {
        return ((Integer) getSqlMapClientTemplate().queryForObject(
                "shopBukken.selectAspPrefCountByShopCdPrefCd", aspPrefInfo)).intValue();
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.AspUpdateCommitDao#updateAspByShopCd(net.chintai.backend.sysadmin.shop_bukken.domain.AspInfo)
     */
    public int updateAspByShopCd(AspInfo aspInfo) {
        return getSqlMapClientTemplate().update("shopBukken.updateAspByShopCd", aspInfo);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.AspUpdateCommitDao#updateAspPrefByShopCd(net.chintai.backend.sysadmin.shop_bukken.domain.AspPrefInfo)
     */
    public void updateAspPrefByShopCd(AspPrefInfo aspPrefInfo) {
        getSqlMapClientTemplate().update("shopBukken.updateAspPrefByShopCd", aspPrefInfo);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.AspUpdateCommitDao#selectAspPrefUpdDtByShopCd(net.chintai.backend.sysadmin.shop_bukken.domain.AspPrefInfo)
     */
    public String selectAspPrefUpdDtByShopCd(AspPrefInfo aspPrefInfo) {
        return (String) getSqlMapClientTemplate().queryForObject(
                "shopBukken.selectAspPrefUpdDtByShopCd", aspPrefInfo);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.AspUpdateCommitDao#deleteAspPrefByShopCdAndPrefCd(net.chintai.backend.sysadmin.shop_bukken.dao.AspPrefDeleteCommitParamBean)
     */
    public void deleteAspPrefByShopCdAndPrefCd(AspPrefDeleteCommitParamBean paramBean) {
        getSqlMapClientTemplate().delete("shopBukken.deleteAspPrefByShopCdAndPrefCd", paramBean);
    }

    @Override
    public int updateAspShopContracLogicalDeleteByKeiyakuNo(
            AspContractInfo paramBean) {
        return getSqlMapClientTemplate().update("shopBukken.updateAspContractCommit", paramBean);
    }

    @Override
    public void insertAspShopContract(AspContractInfo paramBean) {
        getSqlMapClientTemplate().insert("shopBukken.insertAspContractCommit", paramBean);
   }

    @Override
    public Long insertAsp(AspInfo paramBean) {
        return (Long)getSqlMapClientTemplate().insert("shopBukken.insertAspAddCommit", paramBean);
    }

    @Override
    public List<AspGroupAddCommitParamBean> selectAspGroupByShopCd(
            String shopCd) {
        return getSqlMapClientTemplate().queryForList("shopBukken.aspGroupInsertCopypList", shopCd);
    }

    @Override
    public void insertAspGroup(AspGroupAddCommitParamBean paramBean) {
        getSqlMapClientTemplate().insert("shopBukken.aspGroupAddCommit", paramBean);
    }

    @Override
    public void insertAspContractAddCommit(AspContractInfo aspContractInfo) {
        getSqlMapClientTemplate().insert("shopBukken.insertAspContractCommit", aspContractInfo);
    }

    @Override
    public Object selectAspRegisteredInfo(AspShopInfoParamBean aspShopInfoParamBean) {
        return getSqlMapClientTemplate().queryForObject("shopBukken.selectAspRegisteredInfo", aspShopInfoParamBean);
    }
}
