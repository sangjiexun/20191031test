/*
 * $Id: SystemControlDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/11/13   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.common.dao;

/**
 * MST_SYSTEM_CONTROL テーブルの操作を行うDAO。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface SystemControlDao {

    /**
     * MST_SYSTEM_CONTROLテーブルからシステムプロパティ値を取得します。
     * @param property プロパティ名
     * @return プロパティ名に対応する値
     */
    public String selectSystemControlValue(String property);
}
