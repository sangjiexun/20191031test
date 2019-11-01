/*
 * $Id: LicenseExpiredShopDaoImpl.java 3861 2008-03-10 06:27:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/06     BGT)劉俊秀       新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.dao.LicenseExpiredShopDao;
import net.chintai.backend.sysadmin.shop_bukken.domain.ShopSearchInfo;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * 免許有効期限切れ店舗一覧を取得
 * @author yoo-junsu
 * @version $Revision: 3861 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class LicenseExpiredShopDaoImpl extends SqlMapClientDaoSupport implements LicenseExpiredShopDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.LicenseExpiredShopDao#selectLicenseExpireShop()
     */
    @SuppressWarnings("unchecked")
    public List<ShopSearchInfo> selectLicenseExpireShop() {
        return getSqlMapClientTemplate().queryForList("shopBukken.licenseExpireShopList");
    }
}
