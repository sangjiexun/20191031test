/*
 * $Id: TorihikisakiWakuInfoService.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/08  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service;

import java.util.List;

import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuInfoInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuInfoOutServiceBean;

/**
 * 物件枠情報を取得
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface TorihikisakiWakuInfoService {

    /**
     * 物件枠情報を取得します。
     * @param inBean 検索パラメータ（取引先シーケンス番号）
     * @return 物件枠情報
     */
    public List<TorihikisakiWakuInfoOutServiceBean> getTorihikisakiWakuInfo(
            TorihikisakiWakuInfoInServiceBean inBean);

}
