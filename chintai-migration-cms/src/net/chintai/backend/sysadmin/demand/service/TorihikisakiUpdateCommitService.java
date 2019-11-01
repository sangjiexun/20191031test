/*
 * $Id: TorihikisakiUpdateCommitService.java 3671 2007-12-20 02:09:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/06  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiUpdateCommitInServiceBean;

/**
 * 取引先情報更新
 *
 * @author lee-hosup
 * @version $Revision: 3671 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface TorihikisakiUpdateCommitService {

    /**
     * 取引先情報を更新します。
     * @param inBean 更新パラメータ
     * @return 更新した取引先番号
     * @throws ApplicationException
     */
    public String updateTorihikisakiInfo(TorihikisakiUpdateCommitInServiceBean inBean)
            throws ApplicationException;
}
