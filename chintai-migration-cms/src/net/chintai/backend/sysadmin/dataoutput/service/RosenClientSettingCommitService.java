/*
 * $Id: RosenClientSettingCommitService.java 4803 2014-01-10 05:38:20Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/11/07     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.service;

import net.chintai.backend.sysadmin.dataoutput.service.bean.RosenClientSettingCommitInServiceBean;


/**
 * 沿線別データ元除外設定更新用サービスクラス
 * @author KAMEDA Takuma
 * @version $Revision: 4803 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface RosenClientSettingCommitService {

    /**
     * 沿線別データ元除外設定を更新する
     * @param inServiceBean 入力情報
     */
    public void rosenClientSettingCommit(RosenClientSettingCommitInServiceBean inServiceBean);
}
