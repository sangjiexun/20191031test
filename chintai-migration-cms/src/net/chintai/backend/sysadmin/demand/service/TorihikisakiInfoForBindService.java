/*
 * $Id: TorihikisakiInfoForBindService.java 3671 2007-12-20 02:09:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/27  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiInfoForBindInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiInfoForBindOutServiceBean;


/**
 * 取引先検索(店舗コード紐付用)
 *
 * @author lee-hosup
 * @version $Revision: 3671 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface TorihikisakiInfoForBindService {

    /**
     * 取引先詳細情報を検索
     * @param inBean 検索パラメータ（不動産会社コード、取引先コード）
     * @return 取引先詳細情報
     * @throws ApplicationException
     */
    public TorihikisakiInfoForBindOutServiceBean getTorihikisakiDetailInfo(
            TorihikisakiInfoForBindInServiceBean inBean) throws ApplicationException;
}