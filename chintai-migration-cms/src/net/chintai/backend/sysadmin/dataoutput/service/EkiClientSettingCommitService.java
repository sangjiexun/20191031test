/*
 * $Id: EkiClientSettingCommitService.java 4800 2014-01-10 05:02:50Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/12/20     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.service;

import net.chintai.backend.sysadmin.dataoutput.service.bean.EkiClientSettingCommitInServiceBean;


/**
 * 他社データ連携駅除外設定更新用Service
 * @author KAMEDA Takuma
 * @version $Revision: 4800 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface EkiClientSettingCommitService {

    /**
     * 他社データ連携駅除外設定を更新する
     * @param inServiceBean 入力情報
     */
    public void ekiClientSettingCommit(EkiClientSettingCommitInServiceBean inServiceBean);
}
