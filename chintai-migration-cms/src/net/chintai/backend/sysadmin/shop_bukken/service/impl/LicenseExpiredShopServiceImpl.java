/*
 * $Id: LicenseExpiredShopServiceImpl.java 3861 2008-03-10 06:27:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/06     BGT)劉俊秀       新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.shop_bukken.dao.LicenseExpiredShopDao;
import net.chintai.backend.sysadmin.shop_bukken.service.LicenseExpiredShopService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.LicenseExpiredShopOutServiceBean;

/**
 * 免許期限有効期限切れ店舗一覧取得
 * @author yoo-junsu
 * @version $Revision: 3861 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class LicenseExpiredShopServiceImpl implements LicenseExpiredShopService {

    private LicenseExpiredShopDao licenseExpiredShopDao;

    /**
     * @param licenseExpiredShopDao 設定する licenseExpiredShopDao
     */
    public void setLicenseExpiredShopDao(LicenseExpiredShopDao licenseExpiredShopDao) {
        this.licenseExpiredShopDao = licenseExpiredShopDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.LicenseExpiredShopService#selectLicenseExpiredShop()
     */
    public List<LicenseExpiredShopOutServiceBean> selectLicenseExpiredShop() throws Exception {

        List rList = licenseExpiredShopDao.selectLicenseExpireShop();
        List<LicenseExpiredShopOutServiceBean> outbeanList = new ArrayList<LicenseExpiredShopOutServiceBean>();
        for (int i = 0; i < rList.size(); i++) {
            LicenseExpiredShopOutServiceBean outbean = new LicenseExpiredShopOutServiceBean();
            BeanUtils.copyProperties(outbean, rList.get(i));
            outbeanList.add(outbean);
        }

        return outbeanList;
    }
}
