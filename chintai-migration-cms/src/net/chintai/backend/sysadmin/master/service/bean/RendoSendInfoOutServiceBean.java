package net.chintai.backend.sysadmin.master.service.bean;


public class RendoSendInfoOutServiceBean {
    /** 契約番号 */
    private String rendoSendNo;

    /** 出稿許可開始日時 */
    private String permitStartDt;

    /** 出稿許可終了日時 */
    private String permitEndDt;

    /** 備考 */
    private String note;

    /** 更新日時 */
    private String updDt;

    /**
     * 契約番号を返します。
     * @return rendoSendNo
     */
    public String getRendoSendNo() {
        return rendoSendNo;
    }

    /**
     * 契約番号を設定します。
     * @param rendoSendNo  契約番号
     */
    public void setRendoSendNo(String rendoSendNo) {
        this.rendoSendNo = rendoSendNo;
    }

    /**
     * 出稿許可開始日時を返します。
     * @return 出稿許可開始日時
     */
    public String getPermitStartDt() {
        return permitStartDt;
    }

    /**
     * 出稿許可開始日時を設定します。
     * @param permitStartDt  出稿許可開始日時
     */
    public void setPermitStartDt(String permitStartDt) {
        this.permitStartDt = permitStartDt;
    }

    /**
     * 出稿許可終了日時を返します。
     * @return 出稿許可終了日時
     */
    public String getPermitEndDt() {
        return permitEndDt;
    }

    /**
     * 出稿許可終了日時を設定します。
     * @param permitEndDt  permitEndDt
     */
    public void setPermitEndDt(String permitEndDt) {
        this.permitEndDt = permitEndDt;
    }

    /**
     * 備考を返します。
     * @return 備考
     */
    public String getNote() {
        return note;
    }

    /**
     * 備考を設定します。
     * @param note  備考
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * 最終更新日を取得します。
     * @return 最終更新日
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 最終更新日を設定します。
     * @param updDt 最終更新日
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

}
