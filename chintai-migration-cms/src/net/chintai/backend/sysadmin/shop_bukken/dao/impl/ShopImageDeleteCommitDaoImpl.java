/*
 * $Id: ShopImageDeleteCommitDaoImpl.java 4314 2009-07-14 10:37:17Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/26  BGT)沈鍾沿     新規作成
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 */
package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import net.chintai.backend.sysadmin.shop_bukken.dao.ShopImageDeleteCommitDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopImageDeleteCommitParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * ShopImageDeleteCommitDaoの実装クラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 4314 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopImageDeleteCommitDaoImpl extends SqlMapClientDaoSupport implements
        ShopImageDeleteCommitDao {

    /** 更新目標件数 */  //2009/06 李昊燮追加
    private final int REQUIRED_ROWS_AFFECTED = 1;

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ShopImageDeleteCommitDao#
     * updateShopImageFlgDeleteCommit(net.chintai.backend.sysadmin.shop_bukken.dao.ShopImageDeleteCommitParamBean)
     */
    //2009/06 李昊燮追加
    public void updateShopImageFlgDeleteCommit(ShopImageDeleteCommitParamBean paramBean) {
        getSqlMapClientTemplate().update  ("shopBukken.updateShopImageFlg", paramBean, REQUIRED_ROWS_AFFECTED);
    }

}
