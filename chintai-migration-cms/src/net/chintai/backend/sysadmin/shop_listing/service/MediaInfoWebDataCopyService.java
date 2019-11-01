/*
 * $Id: MediaInfoWebDataCopyService.java 4259 2009-03-25 06:22:41Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/18     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service;

import net.chintai.backend.sysadmin.shop_listing.service.bean.MediaInfoWebDataCopyServiceOutBean;

/**
 * 現在WEB掲載データコピーサービス。
 *
 * @author Lee Hosup
 * @version $Revision: 4259 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface MediaInfoWebDataCopyService {

    /**
     * 現在Web掲載中の出稿情報を取得します。
     *
     * @param shopCd 店舗コード。
     * @return Web掲載中の出稿情報。
     */
    MediaInfoWebDataCopyServiceOutBean searchWebMediaInfo(String shopCd);

}
