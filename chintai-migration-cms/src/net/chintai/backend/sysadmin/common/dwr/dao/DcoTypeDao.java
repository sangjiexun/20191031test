/*
 * $Id: DcoTypeDao.java 4772 2014-01-09 07:50:59Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/11/08     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.common.dwr.dao;

import java.util.List;

import net.chintai.backend.sysadmin.common.dwr.domain.DcoType;


/**
 * 連携対象マスタを取得するDao
 * @author KAMEDA Takuma
 * @version $Revision: 4772 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface DcoTypeDao {
    /**
     * 連携対象マスタリストを取得
     * @param dcoTypes 連携対象番号
     * @return MST_DCO情報
     */
    public List<DcoType> selectDcoTypeList(String dcoTypes);

}
