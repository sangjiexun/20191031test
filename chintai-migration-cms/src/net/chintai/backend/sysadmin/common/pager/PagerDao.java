/*
 * $Id: PagerDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者     内容
 * ---------------------------------------------------------
 * 2007/07/18  BGT)児島   新規作成
 * 
 */
package net.chintai.backend.sysadmin.common.pager;

/**
 * ページャ DAO のインターフェース。<br>
 * ページング処理を考慮する DAO は、このインターフェースを実装します。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface PagerDao {

    /**
     * 総件数を取得します。
     * @param condition 呼び出そうとするDAOに対応するPagerのコンテキスト
     * @return レコード総件数
     */
    public int getRecordCount(PagerCondition condition);

}
