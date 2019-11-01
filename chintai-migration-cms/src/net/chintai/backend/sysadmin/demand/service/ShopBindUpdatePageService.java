/*
 * $Id: ShopBindUpdatePageService.java 3671 2007-12-20 02:09:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/13  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service;

import net.chintai.backend.sysadmin.demand.service.bean.ShopBindUpdatePageOutServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.ShopBindUpdatePageInServiceBean;


/**
 * 店舗情報詳細画面
 *
 * @author lee-hosup
 * @version $Revision: 3671 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopBindUpdatePageService {

    /**
     * 店舗情報詳細画面に表示する情報を取得
     * @param inBean 検索パラメータ
     * @return 店舗情報詳細
     */
    public ShopBindUpdatePageOutServiceBean getShopInfoDetail(
            ShopBindUpdatePageInServiceBean inBean);
}
