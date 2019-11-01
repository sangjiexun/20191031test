/*
 * $Id: ShopImageDeleteCommitDbServiceImpl.java 4295 2009-07-07 12:59:59Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/26  BGT)沈鍾沿     新規作成
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 */
package net.chintai.backend.sysadmin.shop_bukken.service.impl;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopImageDeleteCommitDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopImageDeleteCommitParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.ShopImageInfo;
import net.chintai.backend.sysadmin.shop_bukken.service.ShopImageDeleteCommitDbService;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopImageDeleteCommitDbInServiceBean;

/**
 * ShopImageDeleteCommitDbServiceの実装クラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 4295 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopImageDeleteCommitDbServiceImpl implements ShopImageDeleteCommitDbService {

    /** 店舗画像フラグDAO */
    private ShopImageDeleteCommitDao shopImageDeleteCommitDao = null;

    /**
     * shopImageDeleteCommitDaoを設定する
     * @param shopImageDeleteCommitDao
     */
    public void setShopImageDeleteCommitDao(ShopImageDeleteCommitDao shopImageDeleteCommitDao) {
        this.shopImageDeleteCommitDao = shopImageDeleteCommitDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.service.ShopImageDeleteCommitDbService#shopImageUpdateCommitDb(net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopImageDeleteCommitDbInServiceBean)
     */
    public void shopImageUpdateCommitDb(ShopImageDeleteCommitDbInServiceBean inServiceBean)
            throws Exception {

        /* 2009/06 李昊燮 コメント処理
        // 更新する店舗画像フラグを取得。
        ShopImageInfo shopImageInfo = new ShopImageInfo();
        BeanUtils.copyProperties(shopImageInfo, inServiceBean);

        // 店舗画像のフラグ更新を実行。
        int affected = shopImageDeleteCommitDao.updateShopImageFlgDeleteCommit(shopImageInfo);

        if (affected == 0) {
            throw new ApplicationException("ERROR.M.SHOP_BUKKEN.0005"); // 別のエラーメッセージが必要
        }
        */

        // paramBean設定
        ShopImageDeleteCommitParamBean paramBean = new ShopImageDeleteCommitParamBean();
        BeanUtilsWrapper.copyProperties(paramBean, inServiceBean);

        // 削除処理(フラグ更新)を行う
        shopImageDeleteCommitDao.updateShopImageFlgDeleteCommit(paramBean);

    }

}
