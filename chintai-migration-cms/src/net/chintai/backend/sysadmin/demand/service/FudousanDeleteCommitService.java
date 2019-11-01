/*
 * $Id: FudousanDeleteCommitService.java 3671 2007-12-20 02:09:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/12/05     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanDeleteCommitInServiceBean;

/**
 * 不動産会社削除サービスクラス
 *
 * @author TAKAHASHI Yuki
 * @version $Revision: 3671 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface FudousanDeleteCommitService {

    /**
     * 不動産会社削除
     * @param inServiceBean 削除処理パラメータ
     * @throws ApplicationException
     */
    public void fudousanDeleteCommit(FudousanDeleteCommitInServiceBean inServiceBean)
            throws ApplicationException;

}
