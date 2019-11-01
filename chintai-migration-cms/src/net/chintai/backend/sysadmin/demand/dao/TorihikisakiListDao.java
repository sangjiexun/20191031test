/*
 * $Id: TorihikisakiListDao.java 3671 2007-12-20 02:09:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/20  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.demand.domain.TorihikisakiListDomain;

/**
 * 取引先一覧CSV出力用データ取得DAO
 *
 * @author lee-hosup
 * @version $Revision: 3671 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface TorihikisakiListDao {

    /**
     * 総件数を取得します
     * @param paramBean 検索パラメータ
     * @return 総件数
     */
    public int selectTotalCount(TorihikisakiListParamBean paramBean);

    /**
     * 取引先一覧を検索(画面用)
     * @param paramBean 検索パラメータ
     * @return 取引先一覧情報
     */
    public List<TorihikisakiListDomain> getTorihikisakiList(TorihikisakiListParamBean paramBean);

    /**
     * 取引先一覧を検索(CSV用)
     * @param paramBean 検索パラメータ
     * @return 取引先一覧情報
     */
    public List<TorihikisakiListDomain> getTorihikisakiList(TorihikisakiListParamBean paramBean,
            BasePagerCondition condition);

}
