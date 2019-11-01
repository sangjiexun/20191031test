package net.chintai.backend.sysadmin.addata_matching.service.bean;


/**
 * 照合結果一覧OutServiceBean
 * @author e-ishii
 * @version $Revision: 4367 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MatchingDataListOutServiceBean {

    /** 対象年月 */
    private String taisyoYm;

    /** 処理日 */
    private String insDt;

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

    /**
     * 処理日を取得します。
     * @return 処理日
     */
    public String getInsDt() {
        return insDt;
    }

    /**
     * 処理日を設定します。
     * @param insDt 処理日
     */
    public void setInsDt(String insDt) {
        this.insDt = insDt;
    }

}
