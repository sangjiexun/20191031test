/*
 * $Id: ShopBasicInfoUpdateConfirmDaoImpl.java 4295 2009-07-07 12:59:59Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.shop_bukken.dao.ShopBasicInfoUpdateConfirmDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopBasicInfoUpdateConfirmParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.EnsenInfo;

/**
 * ShopBasicInfoUpdateConfirmDaoの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4295 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopBasicInfoUpdateConfirmDaoImpl extends SqlMapClientDaoSupport implements
        ShopBasicInfoUpdateConfirmDao {

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_bukken.dao.ShopBasicInfoUpdateConfirmDao
     * #searchEnsenInfo(net.chintai.backend.sysadmin.shop_bukken.dao.
     * ShopBasicInfoUpdateConfirmParamBean)
     */
    public EnsenInfo searchEnsenInfo(ShopBasicInfoUpdateConfirmParamBean paramBean) {
        return (EnsenInfo) getSqlMapClientTemplate().queryForObject("shopBukken.selectEnsenInfo",
                paramBean);
    }

}
