package net.chintai.backend.sysadmin.master.domain;

public class RendoSendInfoDomain {
    /** 連動元コード */
    private String rendoCd;
    
    /** 連動会社名 */
    private String rendoCompany;
    
    /** 契約管理コード */
    private String keiyakuCd;
    
    /** 契約管理オプションコード */
    private String keiyakuSubCd;
    
    /** 契約名称 */
    private String keiyakuName;
    
    /** 出稿許可開始日時 */
    private String permitStartDt;
    
    /** 出稿許可終了日時 */
    private String PermitEndDt;
    
    /** 契約番号 */
    private String rendoSendNo;
    
    /** 更新日時 */
    private String updDt;
    
    /** 備考 */
    private String note;    
    
    /**
     * 連動元コードを取得します。
     * @return 連動元コード
     */
    public String getRendoCd() {
        return rendoCd;
    }
    
    /**
     * 連動元コードを設定します。
     * @param rendoCd 連動元コード
     */
    public void setRendoCd(String rendoCd) {
        this.rendoCd = rendoCd;
    }
    
    /**
     * 連動会社名を取得します。
     * @return 連動会社名
     */
    public String getRendoCompany() {
        return rendoCompany;
    }
    
    /**
     * 連動会社名を設定します。
     * @param rendoCompany 連動会社名
     */
    public void setRendoCompany(String rendoCompany) {
        this.rendoCompany = rendoCompany;
    }
    
    /**
     * 契約管理コードを取得します。
     * @return 契約管理コード
     */
    public String getKeiyakuCd() {
        return keiyakuCd;
    }
    
    /**
     * 契約管理コードを設定します。
     * @param keiyakuCd 契約管理コード
     */
    public void setKeiyakuCd(String keiyakuCd) {
        this.keiyakuCd = keiyakuCd;
    }
    
    /**
     * 契約管理オプションコードを取得します。
     * @return 契約管理オプションコード
     */
    public String getKeiyakuSubCd() {
        return keiyakuSubCd;
    }
    
    /**
     * 契約管理オプションコードを設定します。
     * @param keiyakuSubCd 契約管理オプションコード
     */
    public void setKeiyakuSubCd(String keiyakuSubCd) {
        this.keiyakuSubCd = keiyakuSubCd;
    }
    
    /**
     * 契約名称を取得します。
     * @return 契約名称
     */
    public String getKeiyakuName() {
        return keiyakuName;
    }
    
    /**
     * 契約名称を設定します。
     * @param keiyakuName 契約名称
     */
    public void setKeiyakuName(String keiyakuName) {
        this.keiyakuName = keiyakuName;
    }
    
    /**
     * 出稿許可開始日時を取得します。
     * @return 出稿許可開始日時
     */
    public String getPermitStartDt() {
        return permitStartDt;
    }
    
    /**
     * 出稿許可開始日時を設定します。
     * @param permitStartDt 出稿許可開始日時
     */
    public void setPermitStartDt(String permitStartDt) {
        this.permitStartDt = permitStartDt;
    }
    
    /**
     * 出稿許可終了日時を取得します。
     * @return 出稿許可終了日時
     */
    public String getPermitEndDt() {
        return PermitEndDt;
    }
    
    /**
     * 出稿許可終了日時を設定します。
     * @param PermitEndDt 出稿許可終了日時
     */
    public void setPermitEndDt(String PermitEndDt) {
        this.PermitEndDt = PermitEndDt;
    }
    
    /**
     * 契約番号を取得します。
     * @return 契約番号
     */
    public String getRendoSendNo() {
        return rendoSendNo;
    }
    
    /**
     * 契約番号を設定します。
     * @param rendoSendNo 契約番号
     */
    public void setRendoSendNo(String rendoSendNo) {
        this.rendoSendNo = rendoSendNo;
    }
    
    /**
     * 更新日時を取得します。
     * @return 更新日時
     */
    public String getUpdDt() {
        return updDt;
    }
    
    /**
     * 更新日時を設定します。
     * @param updDt 更新日時
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }
    
    /**
     * 備考を取得します。
     * @return 備考
     */
    public String getNote() {
        return note;
    }
    
    /**
     * 備考を設定します。
     * @param note 備考
     */
    public void setNote(String note) {
        this.note = note;
    }
}
