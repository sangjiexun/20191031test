/*
 * $Id: KeiyakuRegisterPageServiceImpl.java 4281 2009-07-06 12:10:17Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/07/06  BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service.impl;

import net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuRegisterPageDao;
import net.chintai.backend.sysadmin.shop_listing.service.KeiyakuRegisterPageService;

/**
 * KeiyakuRegisterPageServiceの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4281 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class KeiyakuRegisterPageServiceImpl implements KeiyakuRegisterPageService {

    /** 契約登録ページ表示DAO */
    KeiyakuRegisterPageDao keiyakuRegisterPageDao;

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.service.KeiyakuRegisterPageService
     * #searchUpdDt(java.lang.String)
     */
    public String searchUpdDt(String shopCd) {

        return keiyakuRegisterPageDao.searchUpdDt(shopCd);
    }

    /**
     * 契約登録ページ表示DAOを設定します。
     * @param keiyakuRegisterPageDao 契約登録ページ表示DAO
     */
    public void setKeiyakuRegisterPageDao(KeiyakuRegisterPageDao keiyakuRegisterPageDao) {
        this.keiyakuRegisterPageDao = keiyakuRegisterPageDao;
    }

}
