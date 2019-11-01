package net.chintai.backend.sysadmin.master.dao;

public class RendoSendParamBean {
    /** 許可管理番号 */
    private String rendoSendNo;

    /** 連動元コード */
    private String rendoCd;

    /** 契約管理コード */
    private String keiyakuCd;

    /** 契約管理オプションコード */
    private String keiyakuSubCd;

    /** 出稿許可開始日時 */
    private String permitStartDt;

    /** 出稿許可終了日時 */
    private String permitEndDt;

    /** 備考 */
    private String note;

    /** 削除区分 */
    private String delKbn;

    /** レコード作成日時 */
    private String insDt;

    /** レコード作成プログラムＩＤ */
    private String insPg;

    /** レコード作成者 */
    private String insId;

    /** レコード更新日時 */
    private String updDt;

    /** レコード更新プログラムＩＤ */
    private String updPg;

    /** レコード更新者 */
    private String updId;

    /**
     * 契約管理番号を取得します。
     * @return 契約管理番号
     */
    public String getRendoSendNo() {
        return rendoSendNo;
    }

    /**
     * 契約管理番号を設定します。
     * @param rendoSendNo 契約管理番号
     */
    public void setRendoSendNo(String rendoSendNo) {
        this.rendoSendNo = rendoSendNo;
    }

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
     * 許可管理コードを取得します。
     * @return 契約管理コード
     */
    public String getKeiyakuCd() {
        return keiyakuCd;
    }

    /**
     * 許可管理コードを設定します。
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
        return permitEndDt;
    }

    /**
     * 出稿許可終了日時を設定します。
     * @param permitEndDt 出稿許可終了日時
     */
    public void setPermitEndDt(String permitEndDt) {
        this.permitEndDt = permitEndDt;
    }

    /**
     * 契約備考を取得します。
     * @return 契約備考
     */
    public String getNote() {
        return note;
    }

    /**
     * 契約備考を設定します。
     * @param note 契約備考
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * 削除区分を取得します。
     * @return 削除区分
     */
    public String getDelKbn() {
        return delKbn;
    }

    /**
     * 削除区分を設定します。
     * @param delKbn 削除区分
     */
    public void setDelKbn(String delKbn) {
        this.delKbn = delKbn;
    }

    /**
     * レコード作成日時を取得します。
     * @return レコード作成日時
     */
    public String getInsDt() {
        return insDt;
    }

    /**
     * レコード作成日時を設定します。
     * @param insDt レコード作成日時
     */
    public void setInsDt(String insDt) {
        this.insDt = insDt;
    }

    /**
     * レコード作成プログラムＩＤを取得します。
     * @return レコード作成プログラムＩＤ
     */
    public String getInsPg() {
        return insPg;
    }

    /**
     * レコード作成プログラムＩＤを設定します。
     * @param insPg レコード作成プログラムＩＤ
     */
    public void setInsPg(String insPg) {
        this.insPg = insPg;
    }

    /**
     * レコード作成者を取得します。
     * @return レコード作成者
     */
    public String getInsId() {
        return insId;
    }

    /**
     * レコード作成者を設定します。
     * @param insId レコード作成者
     */
    public void setInsId(String insId) {
        this.insId = insId;
    }

    /**
     * レコード更新日時を取得します。
     * @return レコード更新日時
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * レコード更新日時を設定します。
     * @param updDt レコード更新日時
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
     * レコード更新プログラムＩＤを取得します。
     * @return レコード更新プログラムＩＤ
     */
    public String getUpdPg() {
        return updPg;
    }

    /**
     * レコード更新プログラムＩＤを設定します。
     * @param updPg レコード更新プログラムＩＤ
     */
    public void setUpdPg(String updPg) {
        this.updPg = updPg;
    }

    /**
     * レコード更新者を取得します。
     * @return レコード更新者
     */
    public String getUpdId() {
        return updId;
    }

    /**
     * レコード更新者を設定します。
     * @param updId レコード更新者
     */
    public void setUpdId(String updId) {
        this.updId = updId;
    }
}