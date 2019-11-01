/*
 * $Id: TorihikisakiUpdatePageService.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/05  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiUpdatePageOutServiceBean;

/**
 * 取引先情報更新のため既存データを検索
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface TorihikisakiUpdatePageService {

    /**
     * 取引先情報を取得します。
     * @param inBean 検索パラメータ（不動産会社コード、取引先コード）
     * @return 取引先情報
     * @throws ApplicationException
     */
    public TorihikisakiUpdatePageOutServiceBean getTorihikisaki(
            TorihikisakiUpdatePageInServiceBean inBean) throws ApplicationException;
}
