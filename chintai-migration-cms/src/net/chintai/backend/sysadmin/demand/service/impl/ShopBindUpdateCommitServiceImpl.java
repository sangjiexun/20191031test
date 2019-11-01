/*
 * $Id: ShopBindUpdateCommitServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/16  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.demand.dao.ShopBindUpdateCommitDao;
import net.chintai.backend.sysadmin.demand.dao.ShopBindUpdateCommitParamBean;
import net.chintai.backend.sysadmin.demand.service.ShopBindUpdateCommitService;
import net.chintai.backend.sysadmin.demand.service.bean.ShopBindUpdateCommitInServiceBean;


/**
 * ShopBindUpdateCommitServiceの実装クラス
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopBindUpdateCommitServiceImpl implements ShopBindUpdateCommitService {

    /** 店舗紐付先更新DAO */

    ShopBindUpdateCommitDao shopBindUpdateCommitDao;

    /**
     * 店舗紐付先更新DAOを設定します。
     * @param shopBindUpdateCommitDao 店舗紐付先更新DAO
     */
    public void setShopBindUpdateCommitDao(ShopBindUpdateCommitDao shopBindUpdateCommitDao) {
        this.shopBindUpdateCommitDao = shopBindUpdateCommitDao;
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.service.ShopBindUpdateCommitService#updateShopBindInfo(net.chintai.backend.sysadmin.demand.service.bean.ShopBindUpdateCommitInServiceBean)
     */
    public void updateShopBindInfo(ShopBindUpdateCommitInServiceBean inBean) throws ApplicationException {

        // 更新データ設定
        ShopBindUpdateCommitParamBean paramBean = new ShopBindUpdateCommitParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        try {
            /* 以下は、同一トランザクションである
             * updateShopBindInfo2(元紐付テータ初期化)の更新処理は
             * 0件、1件(元々紐付されてなかった取引先0件、されていたのは1件)以外エラーを投げる
             * 紐付設定処理、店舗管理最終更新日付更新の場合更新結果が1件以外は
             * エラーを投げるし、Rollbakcされます。
             */

            // 紐付設定処理
            shopBindUpdateCommitDao.updateShopBindInfo(paramBean);

            // 元紐付情報がある場合、初期化
            int updateCnt = shopBindUpdateCommitDao.updateShopBindInfo2(paramBean);

            if(!(updateCnt == 0 || updateCnt == 1)){
                throw new RuntimeException();
            }

            // 店舗管理テーブルの最終更新日付を更新
            shopBindUpdateCommitDao.updateLastUpdateTime(paramBean);

        } catch (Exception e) {
            throw new ApplicationException("ERROR.M.REVIEW.0012");
        }
    }
}
