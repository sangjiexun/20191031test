/*
 * $Id: RosenEkiSearchForCsvDao.java 3707 2007-12-26 05:42:05Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/17  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.master.dao;

import java.util.List;

import com.ibatis.sqlmap.client.event.RowHandler;

/**
 * 沿線・駅を取得するDao
 *
 * @author Sim-JongYeon
 * @version $Revision: 3707 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface RosenEkiSearchForCsvDao {

    /**
     * 沿線・駅データをCSV出力する
     * @param handler 沿線・駅データのRowHandler
     */
    public void selectEnsenEkiToCsv(RowHandler handler);

    /**
     * 件数取得
     * @return
     */
    public List selectEnsenEkiToCsv();
}
