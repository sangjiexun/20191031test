/*
 * $Id: TorihikisakiWakuInfoDeleteConfirmService.java 3673 2007-12-20 02:25:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/10  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service;

import java.util.List;

import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuInfoDeleteConfirmInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuInfoDeleteConfirmOutServiceBean;

/**
 * 削除する取引先物件枠情報を取得
 *
 * @author lee-hosup
 * @version $Revision: 3673 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface TorihikisakiWakuInfoDeleteConfirmService {

    /**
     * 削除する取引先物件枠情報を取得
     * @param inBean 検索パラメータ（取引先シーケンス番号、適用月）
     * @return 取引先物件枠情報
     */
    public List<TorihikisakiWakuInfoDeleteConfirmOutServiceBean>  getTorihikisakiWakuInfoForDelete(
            TorihikisakiWakuInfoDeleteConfirmInServiceBean inBean);
}
