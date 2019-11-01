/*
 * $Id: KeiyakuRegisterPageService.java 4281 2009-07-06 12:10:17Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/07/06  BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service;


/**
 * 契約情報登録ページサービス。
 *
 * @author Lee Hosup
 * @version $Revision: 4281 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface KeiyakuRegisterPageService {

    /**
     * 店舗リスティング契約情報テーブルで該当店舗の最終更新日を取得します。
     *
     * @param shopCd
     * @return 該当店舗のレコードが存在する場合：最終更新日
     *         該当店舗のレコードが存在しない場合：ヌルー
     */
    public String searchUpdDt(String shopCd);

}
