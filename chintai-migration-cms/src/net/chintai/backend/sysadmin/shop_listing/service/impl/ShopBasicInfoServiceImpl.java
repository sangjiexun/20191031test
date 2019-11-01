/*
 * $Id: ShopBasicInfoServiceImpl.java 4247 2009-03-23 09:15:01Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/24     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service.impl;

import java.lang.reflect.InvocationTargetException;

import net.chintai.backend.sysadmin.shop_listing.dao.ShopBasicInfoDao;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopBasicInfoDomain;
import net.chintai.backend.sysadmin.shop_listing.service.ShopBasicInfoService;
import net.chintai.backend.sysadmin.shop_listing.service.bean.ShopBasicInfoOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;

/**
 * KeiyakuRegisterPageServiceの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4247 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopBasicInfoServiceImpl implements ShopBasicInfoService {

    /** 店舗情報取得DAO */
    private ShopBasicInfoDao shopBasicInfoDao;

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.service.KeiyakuRegisterPageService
     * # searchShopBasicInfo(java.lang.String)
     */
    public ShopBasicInfoOutServiceBean searchShopBasicInfo(String shopCd) {

        // 契約店舗基本情報を取得
        ShopBasicInfoDomain domain = shopBasicInfoDao.searchShopBasicInfo(shopCd);

        // domain -> outBean 詰め替え：店舗基本情報
        ShopBasicInfoOutServiceBean outBean = new ShopBasicInfoOutServiceBean();
        try {
            BeanUtils.copyProperties(outBean, domain);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        return outBean;
    }

    /**
     * 店舗情報取得DAOを設定します。
     * @param shopBasicInfoDao 店舗情報取得DAO
     */
    public void setShopBasicInfoDao(ShopBasicInfoDao shopBasicInfoDao) {
        this.shopBasicInfoDao = shopBasicInfoDao;
    }
}
