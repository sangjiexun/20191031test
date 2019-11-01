/*
 * $Id: TorihikisakiDeleteCommitService.java 3682 2007-12-20 06:35:55Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/07  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiDeleteCommitInServiceBean;

/**
 * 取引先削除サービス
 *
 * @author lee-hosup
 * @version $Revision: 3682 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface TorihikisakiDeleteCommitService {

    /**
     * 取引先削除処理を行います。
     * @param inBean 削除処理パラメータ（シーケンス番号、最終更新日時）
     * @throws ApplicationException
     */
    public void deleteTorihikisaki(TorihikisakiDeleteCommitInServiceBean inBean)
            throws ApplicationException;
}
