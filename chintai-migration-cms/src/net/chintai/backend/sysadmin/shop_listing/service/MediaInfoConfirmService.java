/*
 * $Id: MediaInfoConfirmService.java 4257 2009-03-25 05:34:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/12     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service;

import net.chintai.backend.sysadmin.shop_listing.service.bean.MediaInfoConfirmInServiceBean;
import net.chintai.backend.sysadmin.shop_listing.service.bean.MediaInfoConfirmOutServiceBean;

/**
 * 出稿情報確認サービス。
 *
 * @author Lee Hosup
 * @version $Revision: 4257 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface MediaInfoConfirmService {

    /**
     * 確認画面表示用データを取得します。
     *
     * @param inBean 検索条件
     * @return 確認画面表示用データ
     */
    public MediaInfoConfirmOutServiceBean searchConfirmInfo(MediaInfoConfirmInServiceBean inBean);

}
