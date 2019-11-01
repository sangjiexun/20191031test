/*
 * $Id: KeiyakuRegisterCompleteService.java 4246 2009-03-23 09:00:00Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/24     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service;

import net.chintai.backend.sysadmin.shop_listing.service.bean.KeiyakuRegisterCompleteInServiceBean;

/**
 * 契約情報を登録します。
 *
 * @author Lee Hosup
 * @version $Revision: 4246 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface KeiyakuRegisterCompleteService {

    /**
     * 契約情報を登録します。
     * @param inBean
     * @return
     */
    public String registerKiyakuInfo(KeiyakuRegisterCompleteInServiceBean inBean);

}
