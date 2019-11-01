/*
 * $Id: ShikutyosonClientSettingCommitService.java 4803 2014-01-10 05:38:20Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2014/01/06     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.service;

import net.chintai.backend.sysadmin.dataoutput.service.bean.ShikutyosonClientSettingCommitInServiceBean;


/**
 * 市区町村別データ元出力設定登録用サービスクラス
 * @author KAMEDA Takuma
 * @version $Revision: 4803 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShikutyosonClientSettingCommitService {

    /**
     * 市区町村別データ元出力設定を登録する
     * @param inServiceBean 入力情報
     */
    public void cityClientSettingCommit(ShikutyosonClientSettingCommitInServiceBean inServiceBean);
}
