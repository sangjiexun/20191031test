/*
 * $Id: RosenEkiSearchForDistributeCsvDao.java 3714 2007-12-26 06:23:19Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/12/26   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.master.dao;

import java.util.List;

import com.ibatis.sqlmap.client.event.RowHandler;

/**
 * 配布用のCSVデータを取得するDAO。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 3714 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface RosenEkiSearchForDistributeCsvDao {

    /**
     * 沿線データをCSV出力します。
     * @param handler RowHandler
     */
    public void selectEnsenToCsv(RowHandler handler);

    /**
     *
     * 駅データをCSV出力します。
     * @param handler RowHandler
     */
    public void selectEkiToCsv(RowHandler handler);

    /**
     * 件数取得
     * @return
     */
    public List selectEnsenToCsv();

    /**
     * 件数取得
     * @return
     */
    public List selectEkiToCsv();
}
