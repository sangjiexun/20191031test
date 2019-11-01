/*
 * $Id: TorihikisakiWakuInfoUpdagePageService.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/09  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service;

import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuInfoUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuInfoUpdatePageOutServiceBean;


/**
 * 取引先物件枠設定情報照会
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface TorihikisakiWakuInfoUpdagePageService {

    /**
     * 物件枠情報を取得します。
     * @param inBean 検索パラメータ（取引先シーケンス番号、適用月）
     * @return 物件枠情報
     */
    public TorihikisakiWakuInfoUpdatePageOutServiceBean getTorihikisakiWakuInfo(
            TorihikisakiWakuInfoUpdatePageInServiceBean inBean);
}
