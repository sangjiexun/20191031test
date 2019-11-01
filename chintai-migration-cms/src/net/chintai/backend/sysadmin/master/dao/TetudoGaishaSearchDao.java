/*
 * $Id: TetudoGaishaSearchDao.java 4076 2008-11-19 09:33:13Z m-ono $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2008/10/08  BGT)長谷川正一 新規作成
 *
 */
package net.chintai.backend.sysadmin.master.dao;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;

/**
 * 鉄道会社検索DAO
 * 
 * @author S.HASEGAWA
 * @version $Revision: 4076 $ Copyright: (C) CHINTAI Corporation All Right
 *          Reserved.
 */
public interface TetudoGaishaSearchDao {

    /**
     * 検索条件に合致する鉄道会社数を取得する。
     * @param paramBean 鉄道会社検索ParamBean
     * @return 鉄道会社数
     */
    public int selectTetudoGaishaCount(TetudoGaishaSearchParamBean paramBean);

    /**
     * 検索条件とに合致する鉄道会社情報をページングデータで指定されただけ取得する。
     * @param paramBean 鉄道会社検索ParamBean
     * @param condition ページングデータ
     * @return 鉄道会社情報一覧
     */
    public List selectTetudoGaishaList(TetudoGaishaSearchParamBean paramBean, BasePagerCondition condition);

    /**
     * 検索条件に合致する鉄道会社情報を全件取得する。
     * @param paramBean 鉄道会社検索ParamBean
     * @return 鉄道会社情報一覧
     */
    public List selectTetudoGaishaForCsv(TetudoGaishaSearchParamBean paramBean);
}
