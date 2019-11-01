/*
 * $Id: MediaInfoWebRegisterConfirmService.java 4259 2009-03-25 06:22:41Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/15     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service;

import net.chintai.backend.sysadmin.shop_listing.service.bean.MediaInfoWebRegisterConfirmOutServiceBean;

/**
 * 出稿情報(仮保存)本番反映確認サービス。
 *
 * @author Lee Hosup
 * @version $Revision: 4259 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface MediaInfoWebRegisterConfirmService {

    /**
     * 現在本番反映中の出稿情報を取得します。
     *
     * @param shopCd 店舗コード
     * @return 現在Web掲載中の出稿情報。
     */
    MediaInfoWebRegisterConfirmOutServiceBean searchMediaInfo(String shopCd);

}
