/*
 * $Id: ShopRegistrationStatusUpdatePageServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/09  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import java.lang.reflect.InvocationTargetException;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopRegistrationStautsUpdatePageDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopRegistrationStautsUpdatePageParamBean;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopRegistrationStatusUpdatePageService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopRegistrationStautsUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopRegistrationStautsUpdatePageOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;


/**
 * ShopRegistrationStatusUpdatePageServiceの実装クラス
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopRegistrationStatusUpdatePageServiceImpl implements
        ShopRegistrationStatusUpdatePageService {

    /** 登録状況更新データの照会するDAO */
    private ShopRegistrationStautsUpdatePageDao shopRegistrationStautsUpdatePageDao = null;

    /**
     * shopRegistrationStautsUpdatePageDaoを設定する
     * @param shopRegistrationStautsUpdatePageDao
     */
    public void setShopRegistrationStautsUpdatePageDao(ShopRegistrationStautsUpdatePageDao shopRegistrationStautsUpdatePageDao) {
        this.shopRegistrationStautsUpdatePageDao = shopRegistrationStautsUpdatePageDao;
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.ShopRegistrationStatusUpdatePageService#shopSearchByShopCd(net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopRegistrationStautsUpdatePageInServiceBean)
     */
    public ShopRegistrationStautsUpdatePageOutServiceBean shopRegistrationStautsSearchByShopCd(
            ShopRegistrationStautsUpdatePageInServiceBean inServiceBean)
            throws ApplicationException {
        
        // 検索条件データを取得
        ShopRegistrationStautsUpdatePageParamBean paramBean = new ShopRegistrationStautsUpdatePageParamBean();
        try{
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        
        // 登録状況更新データを照会
        Object rsShopRegistrationStaut = shopRegistrationStautsUpdatePageDao.selectShopRegistrationStauts(paramBean);

        ShopRegistrationStautsUpdatePageOutServiceBean shopRegistrationStautOutServiceBean = new ShopRegistrationStautsUpdatePageOutServiceBean();
            try{
                BeanUtils.copyProperties(shopRegistrationStautOutServiceBean, rsShopRegistrationStaut);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        
        return shopRegistrationStautOutServiceBean;
        
    }

}
