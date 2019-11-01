/*
 * $Id: ShopRegistrationStautsUpdatePageDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/09  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao;

/**
 * 登録状況更新画面用のDao
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopRegistrationStautsUpdatePageDao {

    /**
     * 登録状況更新画面用のデータを取得する。
     * 
     * @param paramBean 店舗コード
     * @return 登録状況更新画面用のデータ
     */
    public Object selectShopRegistrationStauts(ShopRegistrationStautsUpdatePageParamBean paramBean);

}
