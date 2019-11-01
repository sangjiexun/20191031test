/*
 * $Id: KeiyakuUpdatePageService.java 4246 2009-03-23 09:00:00Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/25     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service;

import net.chintai.backend.sysadmin.shop_listing.service.bean.KeiyakuUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.shop_listing.service.bean.KeiyakuUpdatePageOutServiceBean;

/**
 * 契約情報更新画面表示サービス。
 *
 * @author Lee Hosup
 * @version $Revision: 4246 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface KeiyakuUpdatePageService {

    /**
     * 契約情報更新画面に表示する項目情報を取得します。
     *
     * @param inBean
     * @return
     */
    public KeiyakuUpdatePageOutServiceBean searchKeiyakuInfo(KeiyakuUpdatePageInServiceBean inBean);

}
