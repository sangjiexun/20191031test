/*
 * $Id: LicenseExpiredShopService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/06     BGT)劉俊秀       新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service;

import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.service.bean.LicenseExpiredShopOutServiceBean;

/**
 * 免許期限有効期限切れ店舗一覧取得
 * @author yoo-junsu
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface LicenseExpiredShopService {

    /**
     * 免許期限有効期限切れ店舗一覧取得
     * @return 免許期限有効期限切れ店舗一覧
     * @throws Exception
     */
    public List<LicenseExpiredShopOutServiceBean> selectLicenseExpiredShop() throws Exception;
}
