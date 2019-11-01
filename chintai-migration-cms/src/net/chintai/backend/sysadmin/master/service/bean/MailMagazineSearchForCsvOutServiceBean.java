/*
 * $Id: MailMagazineSearchForCsvOutServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/20  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.master.service.bean;

/**
 * CSV ファイルのダウンロード用メールマガジン用メールアドレスOutServiceBean
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MailMagazineSearchForCsvOutServiceBean {

    /** メールマガジン用メールアドレス */
    private String magazineMailAddress;

    /**
     * メールマガジン用メールアドレスを取得します。
     * @return magazineMailAddress メールマガジン用メールアドレス
     */
    public String getMagazineMailAddress() {
        return magazineMailAddress;
    }

    /**
     * メールマガジン用メールアドレスを設定します。
     * @param magazineMailAddress メールマガジン用メールアドレス
     */
    public void setMagazineMailAddress(String magazineMailAddress) {
        this.magazineMailAddress = magazineMailAddress;
    }

}
