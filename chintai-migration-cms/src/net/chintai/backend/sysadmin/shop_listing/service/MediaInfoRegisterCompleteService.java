/*
 * $Id: MediaInfoRegisterCompleteService.java 4252 2009-03-24 08:11:47Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/12     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.shop_listing.service.bean.MediaInfoRegisterCompleteInServiceBean;

/**
 * 出稿情報登録完了サービス。
 *
 * @author Lee Hosup
 * @version $Revision: 4252 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface MediaInfoRegisterCompleteService {

    /**
     * @param inBean
     * @return
     * @throws ApplicationException
     */
    void registerMediaInfo(MediaInfoRegisterCompleteInServiceBean inBean)
            throws ApplicationException;

}
