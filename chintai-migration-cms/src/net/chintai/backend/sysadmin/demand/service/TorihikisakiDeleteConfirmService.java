/*
 * $Id: TorihikisakiDeleteConfirmService.java 3671 2007-12-20 02:09:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/06  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service;

import java.util.List;

import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiDeleteConfirmInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiDeleteConfirmOutServiceBean;

/**
 * 取引先削除確認
 *
 * @author lee-hosup
 * @version $Revision: 3671 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface TorihikisakiDeleteConfirmService {

    /**
     * 削除チェックされた取引先の詳細情報を取得
     * @param inBean 検索パラメータ（取引先シーケンス番号リスト）
     * @return 取引先詳細情報
     */
    public List<TorihikisakiDeleteConfirmOutServiceBean> getTorihikisakiInfoForDel(
            TorihikisakiDeleteConfirmInServiceBean inBean);

}
