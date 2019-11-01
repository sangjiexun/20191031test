/*
 * $Id: TorihikisakiWakuInfoAddCommitService.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/09  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuInfoAddCommitInServiceBean;


/**
 * 取引先物件枠設定情報登録
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface TorihikisakiWakuInfoAddCommitService {

    /**
     * 物件枠設定情報を登録します。
     * @param inBean 登録パラメータ
     * @throws ApplicationException
     */
    public void insertTorihikisakiWakuInfo(TorihikisakiWakuInfoAddCommitInServiceBean inBean) throws ApplicationException;
}
