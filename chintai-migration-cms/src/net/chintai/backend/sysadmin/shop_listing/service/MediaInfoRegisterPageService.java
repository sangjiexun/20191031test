/*
 * $Id: MediaInfoRegisterPageService.java 4257 2009-03-25 05:34:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/03     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service;

import java.util.List;

import net.chintai.backend.sysadmin.shop_listing.service.bean.MediaInfoRegisterPageOutServiceBean;
import net.chintai.backend.sysadmin.shop_listing.service.bean.OptionTagBean;

/**
 * 出稿情報登録画面表示サービス
 *
 * @author Lee Hosup
 * @version $Revision: 4257 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface MediaInfoRegisterPageService {

    /**
     * 出稿情報登録画面の初期表示に必要な情報を取得します。
     *
     * @param shopCd
     * @return
     */
    public MediaInfoRegisterPageOutServiceBean searchDefaultInfo(String shopCd);

    /**
     * 選択済出稿対象駅の初期値を生成します。
     *
     * @param selectEkiValue 選択された出稿対象駅コード。
     * @return 選択済出稿対象駅プルダウン生成用データ
     */
    public List<OptionTagBean> searchEkiOptions(String selectEkiValue);

    /**
     * 選択済出稿対象市区町村の初期値を生成します。
     *
     * @param selectEkiValue 選択された出稿対象市区町村コード。
     * @return 選択済出稿対象市区町村プルダウン生成用データ
     */
    public List<OptionTagBean> searchCityOptions(String selectEkiValue);
}
