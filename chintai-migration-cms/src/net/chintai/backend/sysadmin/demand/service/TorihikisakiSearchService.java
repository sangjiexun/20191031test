/*
 * $Id: TorihikisakiSearchService.java 3671 2007-12-20 02:09:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/15  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiSearchInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiSearchOutServiceBean;


/**
 * 取引先検索サービス<br>
 * @author lee-hosup
 * @version $Revision: 3671 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface TorihikisakiSearchService {

    /**
     * 取引先を検索
     * @param inBean 検索パラメータ
     * @return 検索結果
     */
    public List<TorihikisakiSearchOutServiceBean> getTorihikisakiList(
            TorihikisakiSearchInServiceBean inBean, BasePagerCondition condition);
}
