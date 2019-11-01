/*
 * $Id: ShopRegistrationStatusUpdateCommitDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/10  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao;

import net.chintai.backend.sysadmin.shop_bukken.domain.ShopRegistrationStauts;

/**
 * 登録状況更新完了Dao。
 * 
 * @author Sim-JongYeon
 * @author yang-eunmi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopRegistrationStatusUpdateCommitDao {

    /**
     * 店舗紐付先情報を更新します。
     * @param paramBean 更新データ
     * @return 更新件数
     */
    public int updateShopBindInfo(ShopRegistrationStauts paramBean);

    /**
     * 元の紐付先情報を初期化します。
     * @param paramBean 更新データ
     * @return 更新件数
     */
    public int updateShopBindInfo2(ShopRegistrationStauts paramBean);

    /**
     * 登録状況更新します。
     * @param shopRegistrationStautsBean 変更された登録状況
     * @return 更新件数
     */
    public int updateShopRegistrationStatus(ShopRegistrationStauts shopRegistrationStautsBean);

}
