/*
 * $Id: ShopInfoServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/16  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import net.chintai.backend.sysadmin.shop_bukken.dao.AspShopInfoDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.AspShopInfoParamBean;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopInfoService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspShopInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspShopInfoOutServiceBean;
import net.chintai.batch.common.util.CryptUtils;

import org.apache.commons.beanutils.BeanUtils;

/**
 * ShopInfoServiceの実装クラス
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopInfoServiceImpl implements ShopInfoService {

    /** 不動産ASPの店舗情報DAO */
    private AspShopInfoDao aspShopInfoDao = null;

    /**
     * 不動産ASPの店舗情報DAOを設定する
     * @param aspShopInfoDao
     */
    public void setAspShopInfoDao(AspShopInfoDao aspShopInfoDao) {
        this.aspShopInfoDao = aspShopInfoDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.ShopInfoService#aspShopInfoSearchByShopCd(net.chintai.backend.sysadmin.shop_bukken.service.bean.AspShopInfoInService)
     */
    public AspShopInfoOutServiceBean aspShopInfoSearchByShopCd(AspShopInfoInServiceBean inServiceBean)
            throws Exception {

        // 店舗コードをParamBeanに設定
        AspShopInfoParamBean paramBean = new AspShopInfoParamBean();
        BeanUtils.copyProperties(paramBean, inServiceBean);

        // 不動産ASPの店舗情報を取得
        Object rsAspShopInfo = aspShopInfoDao.selectAspShopInfo(paramBean);

        // 取得した店舗情報をOutServiceBeanに設定
        AspShopInfoOutServiceBean outServiceBean = new AspShopInfoOutServiceBean();
        BeanUtils.copyProperties(outServiceBean, rsAspShopInfo);

        outServiceBean.setPassword(CryptUtils.decypt(outServiceBean.getPassword()));


        return outServiceBean;
    }

}
