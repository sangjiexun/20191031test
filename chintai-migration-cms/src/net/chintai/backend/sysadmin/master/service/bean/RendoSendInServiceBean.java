package net.chintai.backend.sysadmin.master.service.bean;

public class RendoSendInServiceBean {
    /** 連動元コード */
    private String rendoCd;
    
    /** 契約管理コード */
    private String keiyakuCd;
    
    /** 契約管理オプションコード */
    private String keiyakuSubCd;
    
    /** 契約番号 */
    private String rendoSendNo;
    
    /** 出稿許可開始日 */
    private String permitStartDt;
    
    /** 出稿許可終了日 */
    private String permitEndDt;
    
    /** ユーザ名 */
    private String userId;
    
    /** プログラム名 */
    private String pgName;
    
    /** 備考 */
    private String note;
    
    /** 処理区分 */
    private String procKbn;

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
     * 出稿許可開始日を取得します。
     * @return 出稿許可開始日
     */
    public String getPermitStartDt() {
        return permitStartDt;
    }
    
    /**
     * 出稿許可開始日を設定します。
     * @param permitStartDt 出稿許可開始日
     */
    public void setPermitStartDt(String permitStartDt) {
        this.permitStartDt = permitStartDt;
    }
    
    /**
     * 出稿許可終了日を取得します。
     * @return 出稿許可終了日
     */
    public String getPermitEndDt() {
        return permitEndDt;
    }
    
    /**
     * 出稿許可終了日を設定します。
     * @param permitEndDt 出稿許可終了日
     */
    public void setPermitEndDt(String permitEndDt) {
        this.permitEndDt = permitEndDt;
    }
    
    /**
     * ユーザ名を取得します。
     * @return ユーザ名
     */
    public String getUserId() {
        return userId;
    }
    
    /**
     * ユーザ名を設定します。
     * @param userId ユーザ名
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    /**
     * プログラム名を取得します。
     * @return プログラム名
     */
    public String getPgName() {
        return pgName;
    }
    
    /**
     * プログラム名を設定します。
     * @param pgName プログラム名
     */
    public void setPgName(String pgName) {
        this.pgName = pgName;
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
    
    /**
     * 処理区分を取得します。
     * @return 処理区分
     */
    public String getProcKbn() {
    	return procKbn;
    }
    
    /**
     * 処理区分を設定します。
     * @param procKbn 処理区分
     */
    public void setProcKbn(String procKbn) {
    	this.procKbn = procKbn;
    }
}
