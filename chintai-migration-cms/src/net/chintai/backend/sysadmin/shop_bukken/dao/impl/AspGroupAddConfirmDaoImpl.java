/*
 * $Id: AspGroupAddConfirmDaoImpl.java 3769 2008-01-21 10:41:43Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/23  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.dao.AspGroupAddConfirmDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.AspGroupSearchParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.AspGroupInfo;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * AspGroupAddConfirmDaoの実装クラス
 * 
 * @author Yang-EunMi
 * @version $Revision: 3769 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspGroupAddConfirmDaoImpl extends SqlMapClientDaoSupport implements
        AspGroupAddConfirmDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.AspGroupAddConfirmDao#selectGroupShopSearch(java.lang.String)
     */
    @SuppressWarnings("unchecked")
    public List<AspGroupInfo> selectGroupShopSearch(AspGroupSearchParamBean paramBean) {
        paramBean.setChintaiBukkenCountTableName(getChintaiBukkenCountTableName());
        return getSqlMapClientTemplate().queryForList("shopBukken.selectAddAspGroup", paramBean);
    }
    
    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.AspGroupAddConfirmDao#selectGroupShopCount(java.lang.String)
     */
    public int selectGroupShopCount(AspGroupSearchParamBean paramBean) {
        return (Integer)getSqlMapClientTemplate().queryForObject("shopBukken.selectGroupShopCount", paramBean);
    }
    

    /**
     * 現在有効なCHINTAI有効物件数カウント元テーブルを取得します。<br>
     * 有効テーブルの判定はPL/SQLプロシージャが行います。
     * @return "CT_BUKKEN" or "CT_BUKKEN_2"
     */
    private String getChintaiBukkenCountTableName() {
        return (String) getSqlMapClientTemplate().queryForObject("shopBukken.chintaiBukkenCountTable");
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.AspGroupAddConfirmDao#selectAspShopSeq(java.lang.String)
     */
    public Long selectAspShopSeq(String shopCd) {
        return (Long) getSqlMapClientTemplate().queryForObject("shopBukken.aspShopSeq",shopCd);
    }



}
