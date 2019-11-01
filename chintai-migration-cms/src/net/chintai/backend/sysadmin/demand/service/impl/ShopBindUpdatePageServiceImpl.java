/*
 * $Id: ShopBindUpdatePageServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/13  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.demand.dao.ShopBindUpdatePageDao;
import net.chintai.backend.sysadmin.demand.dao.ShopBindUpdatePageParamBean;
import net.chintai.backend.sysadmin.demand.domain.ShopBindUpdateDomain;
import net.chintai.backend.sysadmin.demand.service.ShopBindUpdatePageService;
import net.chintai.backend.sysadmin.demand.service.bean.ShopBindUpdatePageOutServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.ShopBindUpdatePageInServiceBean;


/**
 * ShopBindUpdatePageServiceの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopBindUpdatePageServiceImpl implements ShopBindUpdatePageService {

    /** 店舗情報詳細取得DAO */
    private ShopBindUpdatePageDao shopBindUpdatePageDao;

    /**
     * 店舗情報詳細取得DAOを設定します。
     * @param shopBindUpdatePageDao 店舗情報詳細取得DAO
     */
    public void setShopBindUpdatePageDao(ShopBindUpdatePageDao shopBindUpdatePageDao) {
        this.shopBindUpdatePageDao = shopBindUpdatePageDao;
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.service.ShopBindUpdatePageService#getShopInfoDetail(net.chintai.backend.sysadmin.demand.service.bean.ShopBindUpdatePageInServiceBean)
     */
    public ShopBindUpdatePageOutServiceBean getShopInfoDetail(ShopBindUpdatePageInServiceBean inBean) {

        // 検索条件設定
        ShopBindUpdatePageParamBean paramBean = new ShopBindUpdatePageParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // 検索開始
        ShopBindUpdateDomain domain = shopBindUpdatePageDao.getShopInfoDetail(paramBean);

        // 戻り値設定
        ShopBindUpdatePageOutServiceBean outBean = new ShopBindUpdatePageOutServiceBean();
        try {
            BeanUtils.copyProperties(outBean, domain);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        return outBean;
    }
}
