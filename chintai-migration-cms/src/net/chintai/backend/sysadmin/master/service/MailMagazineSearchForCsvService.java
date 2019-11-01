/*
 * $Id: MailMagazineSearchForCsvService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/20  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.master.service;

import java.util.List;

import net.chintai.backend.sysadmin.master.service.bean.MailMagazineSearchForCsvOutServiceBean;

/**
 * CSV ファイルのダウンロード用メールマガジン用メールアドレスを検索するService。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface MailMagazineSearchForCsvService {

    /**
     * CSV ファイルのダウンロード用メールマガジン用メールアドレスを検索する。
     * @return 検索されたメールマガジン用メールアドレス。
     * @throws Exception
     */
    public List<MailMagazineSearchForCsvOutServiceBean> mailMagazineSearchForCsv() throws Exception;
}
