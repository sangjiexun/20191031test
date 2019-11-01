/*
 * $Id: TorihikisakiWakuInfoAddConfirmService.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/13  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuInfoAddConfirmInServiceBean;

/**
 * 物件枠新規登録確認
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface TorihikisakiWakuInfoAddConfirmService {

    /**
     * 登録する物件枠情報と同じ適用月のデータがあるかを確認
     * @param inBean 登録パラメータ（取引先シーケンス、適用月）
     * @throws ApplicationException
     */
    public void checkAppliyYm(TorihikisakiWakuInfoAddConfirmInServiceBean inBean)
            throws ApplicationException;
}
