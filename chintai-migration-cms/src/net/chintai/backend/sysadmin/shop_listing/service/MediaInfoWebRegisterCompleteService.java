/*
 * $Id: MediaInfoWebRegisterCompleteService.java 4259 2009-03-25 06:22:41Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/15     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service;

import net.chintai.backend.sysadmin.shop_listing.service.bean.MediaInfoWebRegisterCompleteInServiceBean;

/**
 * 出稿情報(仮保存)本番反映完了サービス。
 *
 * @author Lee Hosup
 * @version $Revision: 4259 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface MediaInfoWebRegisterCompleteService {

    /**
     * 仮保存中の出稿情報を本番に反映します。
     *
     * @param inBean 更新内容。
     */
    void updateWebMediaInfo(MediaInfoWebRegisterCompleteInServiceBean inBean);

}
