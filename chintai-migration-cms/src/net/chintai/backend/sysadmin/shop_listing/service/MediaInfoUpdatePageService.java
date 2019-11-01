/*
 * $Id: MediaInfoUpdatePageService.java 4259 2009-03-25 06:22:41Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/12     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service;

import java.util.List;

import net.chintai.backend.sysadmin.shop_listing.service.bean.MediaInfoUpdatePageOutServiceBean;
import net.chintai.backend.sysadmin.shop_listing.service.bean.OptionTagBean;

/**
 * 出稿情報編集画面サービス。
 *
 * @author Lee Hosup
 * @version $Revision: 4259 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface MediaInfoUpdatePageService {

    /**
     * 出稿情報編集画面の初期表示用データを取得します。
     * @param shopCd
     * @return
     */
    public MediaInfoUpdatePageOutServiceBean searchMediaInfo(String shopCd);

    /**
     * 選択済の出稿対象駅プルダウン生成用データを取得します。
     *
     * @param selectEkiValue 選択済の出稿対象駅コード
     * @return プルダウン生成用データ
     */
    public List<OptionTagBean> searchEkiOptions(String selectEkiValue);

    /**
     * 選択済の出稿対象市区町村プルダウン生成用データを取得します。
     *
     * @param selectEkiValue 選択済の出稿対象市区町村コード
     * @return プルダウン生成用データ
     */
    public List<OptionTagBean> searchCityOptions(String selectEkiValue);
}
