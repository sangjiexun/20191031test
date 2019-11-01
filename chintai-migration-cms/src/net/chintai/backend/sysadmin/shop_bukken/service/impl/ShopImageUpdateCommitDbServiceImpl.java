/*
 * $Id: ShopImageUpdateCommitDbServiceImpl.java 4311 2009-07-14 06:51:14Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/26  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopImageUpdateCommitDao;
import net.chintai.backend.sysadmin.shop_bukken.domain.ShopImageInfo;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopImageUpdateCommitDbService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopImageUpdateCommitDbInServiceBean;

import org.apache.commons.beanutils.BeanUtils;

/**
 * ShopImageUpdateCommitDbServiceの実装クラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 4311 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopImageUpdateCommitDbServiceImpl implements ShopImageUpdateCommitDbService {

    /** 店舗画像フラグDAO */
    private ShopImageUpdateCommitDao shopImageUpdateCommitDao = null;

    /**
     * shopImageUpdateCommitDaoを設定する
     * @param shopImageUpdateCommitDao
     */
    public void setShopImageUpdateCommitDao(ShopImageUpdateCommitDao shopImageUpdateCommitDao) {
        this.shopImageUpdateCommitDao = shopImageUpdateCommitDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.ShopImageUpdateCommitDbService#shopImageUpdateCommitDb(net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopImageUpdateCommitDbInServiceBean)
     */
    public void shopImageUpdateCommitDb(ShopImageUpdateCommitDbInServiceBean inServiceBean)
            throws Exception {

        // 更新する店舗画像フラグを取得。
        ShopImageInfo shopImageInfo = new ShopImageInfo();
        BeanUtils.copyProperties(shopImageInfo, inServiceBean);

        // 店舗画像のフラグ更新を実行。
        int affected = shopImageUpdateCommitDao.updateShopImageFlgUpdateCommit(shopImageInfo);

        if (affected == 0) {
            throw new ApplicationException("ERROR.M.SHOP_BUKKEN.0011");
        }
    }
}
