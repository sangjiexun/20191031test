/*
 * $Id: TorihikisakiSearchForBindDao.java 3671 2007-12-20 02:09:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/20  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.demand.domain.TorihikisakiSearchForBindDomain;

/**
 * 取引先検索(店舗コード紐付用)
 *
 * @author lee-hosup
 * @version $Revision: 3671 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface TorihikisakiSearchForBindDao {

    /**
     * 総件数を取得します
     * @param paramBean 検索パラメータ
     * @return 総件数
     */
    public int selectTotalCount(TorihikisakiSearchForBindParamBean paramBean);

    /**
     * 取引先を検索
     * @param paramBean 検索パラメータ
     * @param condition ページング情報
     * @return 検索結果
     */
    public List<TorihikisakiSearchForBindDomain> getTorihikisaki(TorihikisakiSearchForBindParamBean paramBean,
                                                    BasePagerCondition condition);

}