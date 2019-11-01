/*
 * $Id: KeiyakuShopInfoService.java 4315 2009-07-14 11:21:14Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/23  BGT)李昊燮     新規作成
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 */
package net.chintai.backend.sysadmin.shop_listing.service;

import java.util.List;

import net.chintai.backend.sysadmin.shop_listing.service.bean.KeiyakuShopInfoOutServiceBean;
import net.chintai.backend.sysadmin.shop_listing.service.bean.MediaInfoForShopInfo;

/**
 * 契約店舗詳細取得サービス。
 *
 * @author Lee Hosup
 * @version $Revision: 4315 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface KeiyakuShopInfoService {

    /**
     * 契約店舗詳細を取得します。
     *
     * @param shopCd 店舗コード。
     * @return 基本契約情報リスト。
     */
    public List<KeiyakuShopInfoOutServiceBean> searchShopInfo(String shopCd);

    /**
     * 出稿情報を取得します。
     *
     * @param shopCd 店舗コード。
     * @return 出稿情報。
     */
    public MediaInfoForShopInfo searchShopMediaInfo(String shopCd);

}
