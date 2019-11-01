package net.chintai.backend.sysadmin.review.domain;

public class ReviewBukkenWebStatusDomain {


    private String changeSourceKbn;

    private String ctStopDt;

    /**
     * changeSourceKbnを返します。
     * @return changeSourceKbn
     */
    public String getChangeSourceKbn() {
        return changeSourceKbn;
    }

    /**
     * を設定します。
     * @param changeSourceKbn  changeSourceKbn
     */
    public void setChangeSourceKbn(String changeSourceKbn) {
        this.changeSourceKbn = changeSourceKbn;
    }

    /**
     * ctStopDtを返します。
     * @return ctStopDt
     */
    public String getCtStopDt() {
        return ctStopDt;
    }

    /**
     * を設定します。
     * @param ctStopDt  ctStopDt
     */
    public void setCtStopDt(String ctStopDt) {
        this.ctStopDt = ctStopDt;
    }



}
