/*
 * $Id: RosenUpdateCommitService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/21  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.master.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.master.service.bean.RosenUpdateCommitInServiceBean;

/**
 * 沿線・駅の登録/変更/削除処理サービスクラス
 *
 * @author Kim-Dongjin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface RosenUpdateCommitService {

    /**
     * 沿線・駅の登録/変更/削除する
     *
     * @param inServiceBean CSV取得したデータ
     * @throws ApplicationException エラー
     */
    public void rosenUpdateCommit(RosenUpdateCommitInServiceBean inServiceBean) throws ApplicationException;

    public void crsPlusCacheClear() throws ApplicationException;

    public void crsPlusCacheClear(final String url) throws ApplicationException;
}