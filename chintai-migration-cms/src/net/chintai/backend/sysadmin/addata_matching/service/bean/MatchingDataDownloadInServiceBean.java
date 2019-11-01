/*
 * $Id: MatchingDataDownloadInServiceBean.java 4367 2009-09-01 05:37:54Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/08/27     BGT)石井       新規作成
 *
 */
package net.chintai.backend.sysadmin.addata_matching.service.bean;


/**
 * 照合結果ダウンロードInServiceBean
 * @author e-ishii
 * @version $Revision: 4367 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MatchingDataDownloadInServiceBean {

    /** 対象年月 */
    private String taisyoYm;

    /**
     * 対象年月を取得します。
     * @return 対象年月
     */
    public String getTaisyoYm() {
        return taisyoYm;
    }

    /**
     * 対象年月を設定します。
     * @param taisyoYm 対象年月
     */
    public void setTaisyoYm(String taisyoYm) {
        this.taisyoYm = taisyoYm;
    }
}
