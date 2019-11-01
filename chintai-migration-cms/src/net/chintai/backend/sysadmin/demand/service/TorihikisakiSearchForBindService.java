/*
 * $Id: TorihikisakiSearchForBindService.java 3671 2007-12-20 02:09:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/20  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiSearchForBindInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiSearchForBindOutServiceBean;

/**
 * 取引先検索（店舗コード紐付用）
 *
 * @author lee-hosup
 * @version $Revision: 3671 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface TorihikisakiSearchForBindService {

    /**
     * 取引先を検索
     * @param inBean 検索パラメータ
     * @return 検索結果
     */
    public List<TorihikisakiSearchForBindOutServiceBean> getTorihikisakiList(
            TorihikisakiSearchForBindInServiceBean inBean, BasePagerCondition condition);
}
