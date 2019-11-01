/*
 * $Id: ShopImageDeleteCommitDao.java 4314 2009-07-14 10:37:17Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/26  BGT)沈鍾沿     新規作成
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 */
package net.chintai.backend.sysadmin.shop_bukken.dao;

/**
 * 削除処理実行時に、店舗画像フラグを更新するDAO。
 *
 * @author Sim-JongYeon
 * @version $Revision: 4314 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopImageDeleteCommitDao {

    /**
     * 店舗画像の論理削除処理を行う。
     *
     * @param shopImageInfo
     * @return なし
     * @since 2009/06
     */
    public void updateShopImageFlgDeleteCommit(ShopImageDeleteCommitParamBean paramBean);

}
