/*
 * $Id: PrefClientUpdateCommitService.java 4749 2013-11-05 09:10:32Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/23     BGT)亀田       E-0070 建物名表示に関する改修
 *
 */
package net.chintai.backend.sysadmin.dataoutput.service;

import net.chintai.backend.sysadmin.dataoutput.service.bean.PrefClientSettingInServiceBean;


/**
 * 都道府県別データ元出力設定の更新Service
 *
 * @author e-ishii
 * @version $Revision: 4749 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface PrefClientUpdateCommitService {

    /**
     * 都道府県別データ元出力設定情報を更新します。
     * @param commitList
     * @param formBean 2013/10/24 追加
     */
    public void prefClientUpdateCommit(PrefClientSettingInServiceBean inServiceBean);

}
