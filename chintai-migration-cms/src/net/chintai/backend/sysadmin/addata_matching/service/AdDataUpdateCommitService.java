/*
 * $Id: AdDataUpdateCommitService.java 4367 2009-09-01 05:37:54Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/08/24     BGT)石井       新規作成
 *
 */
package net.chintai.backend.sysadmin.addata_matching.service;

import net.chintai.backend.sysadmin.addata_matching.service.bean.AdDataUpdateInServiceBean;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;


/**
 * ADデータDB登録処理クラス
 * @author e-ishii
 * @version $Revision: 4367 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AdDataUpdateCommitService {

    /**
     * ADデータをDB登録する
     * @param inServiceBean CSV取得したデータ
     * @throws ApplicationException エラー
     */
    public void adDataUpdateCommit(AdDataUpdateInServiceBean inServiceBean)
                                                                    throws ApplicationException;
}
