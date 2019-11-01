/*
 * $Id: KeiyakuShopSearchService.java 4246 2009-03-23 09:00:00Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/19     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service;

import java.util.Date;
import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.shop_listing.service.bean.KeiyakuShopSearchInServiceBean;
import net.chintai.backend.sysadmin.shop_listing.service.bean.KeiyakuShopSearchOutServiceBean;

/**
 * 契約店舗検索サービス。
 *
 * @author Lee Hosup
 * @version $Revision: 4246 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface KeiyakuShopSearchService {

    /**
     * 契約店舗検索を行います。
     *
     * @param inBean 検索条件
     * @param condition ページング情報
     * @return 契約店舗検索結果
     */
    public List<KeiyakuShopSearchOutServiceBean> searchShopList(
            KeiyakuShopSearchInServiceBean inBean, BasePagerCondition condition);

    /**
     * 検索時点の日時を取得します。
     * @return DBのSYSDATE
     */
    public Date searchSysdate();
}
