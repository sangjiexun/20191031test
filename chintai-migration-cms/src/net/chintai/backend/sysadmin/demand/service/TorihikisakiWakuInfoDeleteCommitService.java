/*
 * $Id: TorihikisakiWakuInfoDeleteCommitService.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/10  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuInfoDeleteCommitInServiceBean;

/**
 * 取引先物件枠設定情報を削除処理
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface TorihikisakiWakuInfoDeleteCommitService {

    /**
     * 物件枠設定情報を削除します。
     * @param inBean 削除処理パラメータ（取引先シーケンス番号、適用月、最終更新日時）
     * @throws ApplicationException
     */
    public void deleteWakuInfo(TorihikisakiWakuInfoDeleteCommitInServiceBean inBean)
            throws ApplicationException;

}
