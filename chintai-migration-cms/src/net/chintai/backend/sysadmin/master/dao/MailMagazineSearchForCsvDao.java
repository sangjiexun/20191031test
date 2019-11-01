/*
 * $Id: MailMagazineSearchForCsvDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/20  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.master.dao;

import java.util.List;

/**
 * メールマガジン用メールアドレスを検索するDao.
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface MailMagazineSearchForCsvDao {

    /**
     * CSV ファイルのダウンロード用メールマガジン用メールアドレスを検索する.
     * @return 検索された結果リスト
     */
    public List selectMagazineMailForCsv();

}
