/*
 * $Id: AblOutUpdateCommitService.java 4722 2013-11-05 07:54:43Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/18     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.dataoutput.service.bean.AblOutUpdateCommitInServiceBean;


/**
 * エイブル担当店/取扱店出力情報設定Service
 * @author KAMEDA Takuma
 * @version $Revision: 4722 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AblOutUpdateCommitService {

    /**
     * エイブル担当店/取扱店出力情報を設定する
     * @param inServiceBean　入力内容
     * @throws ApplicationException　楽観ロックエラー
     */
    public void ablOutUpdateCommit(AblOutUpdateCommitInServiceBean inServiceBean) throws ApplicationException;

}
