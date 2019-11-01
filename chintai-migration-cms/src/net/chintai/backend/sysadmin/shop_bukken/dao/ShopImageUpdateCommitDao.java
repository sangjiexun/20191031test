/*
 * $Id: ShopImageUpdateCommitDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/26  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao;

import net.chintai.backend.sysadmin.shop_bukken.domain.ShopImageInfo;

/**
 * 更新処理実行時に、店舗画像フラグを更新するDAO。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopImageUpdateCommitDao {

    /**
     * 更新される店舗画像に対して、SHOP_KANRI の画像フラグを更新します。
     * @param shopImageInfo 店舗コード、店舗画像フラグ等の更新情報
     * @return 更新結果行数
     */
    public int updateShopImageFlgUpdateCommit(ShopImageInfo shopImageInfo);

}
