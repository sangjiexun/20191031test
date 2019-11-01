/*
 * $Id: AblOutSettingDao.java 4714 2013-11-05 07:39:12Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/11     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.dao;

import java.util.List;

import net.chintai.backend.sysadmin.dataoutput.domain.AblOutSettingDomain;


/**
 * エイブル担当店/取扱店出力情報取得Dao
 * @author KAMEDA Takuma
 * @version $Revision: 4714 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AblOutSettingDao {

    /**
     * エイブル担当店/取扱店出力情報を取得
     * @return　取得結果リスト
     */
    public List<AblOutSettingDomain> getAblOutSettingInfo();

}
