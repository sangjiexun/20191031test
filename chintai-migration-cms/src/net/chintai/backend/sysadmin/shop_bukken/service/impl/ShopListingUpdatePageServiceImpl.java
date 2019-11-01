package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.lang.reflect.InvocationTargetException;

import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingUpdatePageDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingUpdatePageParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.ShopListingDetailDomain;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopListingUpdagePageService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingUpdatePageOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;

/**
 * ShopListingUpdagePageServiceの実装クラス。
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingUpdatePageServiceImpl implements
        ShopListingUpdagePageService {

    /** 店舗リスティング設定情報取得DAO */
    ShopListingUpdatePageDao shopListingUpdatePageDao;

    /**
     * 店舗リスティング設定情報取得DAOを設定します。
     * @param shopListingUpdatePageDao 店舗リスティング設定情報取得DAO
     */
    public void setShopListingUpdatePageDao(
            ShopListingUpdatePageDao shopListingUpdatePageDao) {
        this.shopListingUpdatePageDao = shopListingUpdatePageDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.ShopListingUpdagePageService#getShopListing(net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopListingUpdatePageInServiceBean)
     */
    public ShopListingUpdatePageOutServiceBean getShopListing(
            ShopListingUpdatePageInServiceBean inBean) {

        ShopListingUpdatePageParamBean paramBean =
                new ShopListingUpdatePageParamBean();

        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        ShopListingDetailDomain domain =
                shopListingUpdatePageDao.getShopListing(paramBean);

        // 店舗情報が取得できない場合
        if (domain == null) {
            throw new RuntimeException();
        }

        ShopListingUpdatePageOutServiceBean outBean =
                new ShopListingUpdatePageOutServiceBean();

        try {
            BeanUtils.copyProperties(outBean, domain);

            outBean.setKeiyakuStartYear(domain.getKeiyakuStartDt().substring(0,4));
            outBean.setKeiyakuStartMonth(domain.getKeiyakuStartDt().substring(4,6));
            outBean.setKeiyakuStartDay(domain.getKeiyakuStartDt().substring(6,8));
            outBean.setKeiyakuStartHour(domain.getKeiyakuStartDt().substring(8,10));
            outBean.setKeiyakuStartMinute(domain.getKeiyakuStartDt().substring(10,12));
            outBean.setKeiyakuStartSecond(domain.getKeiyakuStartDt().substring(12,14));

            if (!"99999999999999".equals(domain.getKeiyakuEndDt()) && !SystemProperties.getProperty("LAST_DT").equals(domain.getKeiyakuEndDt())) {
                outBean.setKeiyakuEndYear(domain.getKeiyakuEndDt().substring(0,4));
                outBean.setKeiyakuEndMonth(domain.getKeiyakuEndDt().substring(4,6));
                outBean.setKeiyakuEndDay(domain.getKeiyakuEndDt().substring(6,8));
                outBean.setKeiyakuEndHour(domain.getKeiyakuEndDt().substring(8,10));
                outBean.setKeiyakuEndMinute(domain.getKeiyakuEndDt().substring(10,12));
                outBean.setKeiyakuEndSecond(domain.getKeiyakuEndDt().substring(12,14));
            }

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        return outBean;
    }
}
