/*
 * $Id: TorihikisakiWakuInfoUpdateCommitService.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/10  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuInfoUpdateCommitInServiceBean;

/**
 * 取引先物件枠設定情報更新
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface TorihikisakiWakuInfoUpdateCommitService {

    /**
     * 取引先物件枠設定情報を更新します。
     * @param inBean 更新パラメータ
     * @throws ApplicationException
     */
    public void updateTorihikisakiWakuInfo(TorihikisakiWakuInfoUpdateCommitInServiceBean inBean)
            throws ApplicationException;
}
