/*
 * $Id: PrefClientUpdateCommitDao.java 4744 2013-11-05 08:56:01Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/23     BGT)亀田       E-0070 建物名表示に関する改修
 *
 */
package net.chintai.backend.sysadmin.dataoutput.dao;

import java.util.List;



/**
 * 都道府県別データ元出力設定の更新処理Dao
 *
 * @author e-ishii
 * @version $Revision: 4744 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface PrefClientUpdateCommitDao {

    /**
     * DCO_PREF_SKIP_CONFIGテーブル全件削除処理
     * 他社データ連携種類を削除条件に追加したため、引数を追加 2013/10/24
     * @param dcoTypeParamBean
     */
    public void deletePrefSkipConfig(PrefClientSettingParamBean dcoTypeParamBean);

    /**
     * DCO_PREF_SKIP_CONFIGテーブルに、出力対象外データをinsertする処理
     * @param commitList
     */
    public void insertPrefSkipConfig(List<PrefClientUpdateParamBean> commitList);

}
