/*
 * $Id: ShopBindSearchService.java 3671 2007-12-20 02:09:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/09  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.demand.service.bean.ShopBindSearchInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.ShopBindSearchOutServiceBean;


/**
 * 店舗コード紐付検索サービス
 *
 * @author lee-hosup
 * @version $Revision: 3671 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopBindSearchService {

    /**
     * 入力された検索条件に基づいて店舗検索を行う
     * @param inBean 検索パラメータ（店舗コード、不動産会社名、店舗名）
     * @param condition ページング情報
     * @return 店舗検索結果リスト
     */
    public List<ShopBindSearchOutServiceBean> getShopInfo(ShopBindSearchInServiceBean inBean,
                                                          BasePagerCondition condition);
}
