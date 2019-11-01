/*
 * $Id: ShopBasicInfoUpdateConfirmServiceImpl.java 4295 2009-07-07 12:59:59Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopBasicInfoUpdateConfirmDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopBasicInfoUpdateConfirmParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.EnsenInfo;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopBasicInfoUpdateConfirmService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopBasicInfoUpdateConfirmInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopBasicInfoUpdateConfirmOutServiceBean;


/**
 * ShopBasicInfoUpdateConfirmServiceの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4295 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopBasicInfoUpdateConfirmServiceImpl implements ShopBasicInfoUpdateConfirmService {

    /** 店舗基本情報更新確認DAO */
    private ShopBasicInfoUpdateConfirmDao shopBasicInfoUpdateConfirmDao;

    /**
     * 店舗基本情報更新確認DAOを設定します。
     * @param shopBasicInfoUpdateConfirmDao 店舗基本情報更新確認DAO
     */
    public void setShopBasicInfoUpdateConfirmDao(ShopBasicInfoUpdateConfirmDao shopBasicInfoUpdateConfirmDao) {
        this.shopBasicInfoUpdateConfirmDao = shopBasicInfoUpdateConfirmDao;
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.ShopBasicInfoUpdateConfirmService#
     * getEnsenInfo(net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopBasicInfoUpdateConfirmInServiceBean)
     */
    public ShopBasicInfoUpdateConfirmOutServiceBean getEnsenInfo(
            ShopBasicInfoUpdateConfirmInServiceBean inBean) {

        // パラメータ設定
        ShopBasicInfoUpdateConfirmParamBean paramBean = new ShopBasicInfoUpdateConfirmParamBean();
        BeanUtilsWrapper.copyProperties(paramBean, inBean);

        EnsenInfo domain = shopBasicInfoUpdateConfirmDao.searchEnsenInfo(paramBean);

        ShopBasicInfoUpdateConfirmOutServiceBean outBean = new ShopBasicInfoUpdateConfirmOutServiceBean();
        BeanUtilsWrapper.copyProperties(outBean, domain);

        return outBean;
    }

}
