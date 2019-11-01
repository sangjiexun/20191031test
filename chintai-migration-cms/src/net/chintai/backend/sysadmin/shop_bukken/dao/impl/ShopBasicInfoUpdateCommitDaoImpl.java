/*
 * $Id: ShopBasicInfoUpdateCommitDaoImpl.java 4295 2009-07-07 12:59:59Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import net.chintai.backend.sysadmin.shop_bukken.dao.ShopBasicInfoUpdateCommitDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopBasicInfoUpdateCommitParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * {@link ShopBasicInfoUpdateCommitDao}の実装クラス
 *
 * @author Lee Hosup
 * @version $Revision: 4295 $ Copyright:
 * (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopBasicInfoUpdateCommitDaoImpl extends SqlMapClientDaoSupport implements
        ShopBasicInfoUpdateCommitDao {

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ShopBasicInfoUpdateCommitDao#
     * updateShopBasicInfo(net.chintai.backend.sysadmin.shop_bukken.dao.ShopBasicInfoUpdateCommitParamBean)
     */
    public void updateShopBasicInfo(ShopBasicInfoUpdateCommitParamBean paramBean) {
        getSqlMapClientTemplate().update("shopBukken.shopBasicInfoUpdate",paramBean , 1);
    }

}
