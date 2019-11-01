/*
 * $Id: ProfilePasswordChangeCommitService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/04  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.profile.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.profile.service.bean.ProfilePasswordChangeCommitInServiceBean;

/**
 * プロフィールパスワード変更完了サービスクラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ProfilePasswordChangeCommitService {

    /**
     * プロフィールパスワード変更完了
     * @param inServiceBean 更新データ
     * @throws ApplicationException
     */
    public void profilePasswordChangeCommit
        (ProfilePasswordChangeCommitInServiceBean inServiceBean)
            throws ApplicationException;
}