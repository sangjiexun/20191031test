/*
 * $Id: MediaInfoUpdateCompleteService.java 4257 2009-03-25 05:34:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/03     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.shop_listing.service.bean.MediaInfoUpdateCompleteInServiceBean;

/**
 * 出稿情報を登録完了サービス。
 *
 * @author Lee Hosup
 * @version $Revision: 4257 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface MediaInfoUpdateCompleteService {

    /**
     * 出稿情報(仮保存)を更新します。
     *
     * @param inBean 更新内容。
     * @throws ApplicationException
     */
    void updateMediaInfo(MediaInfoUpdateCompleteInServiceBean inBean) throws ApplicationException;

}
