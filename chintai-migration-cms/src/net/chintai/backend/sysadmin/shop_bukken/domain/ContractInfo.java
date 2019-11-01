package net.chintai.backend.sysadmin.shop_bukken.domain;


/**
 * 契約登録完了で使用するDomain
 *
 * @author m-kashiyama
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractInfo {

    /**契約管理番号*/
    private Long keiyakuNo;

    /**店舗コード*/
    private String shopCd;

    /**契約管理コード*/
    private String keiyakuCd;

    /**契約管理オプションコード*/
    private String keiyakuSubCd;

    /**契約開始日時*/
    private String keiyakuStartDt;

    /**契約終了日時*/
    private String keiyakuEndDt;

    /**契約備考*/
    private String keiyakuNote;

    /**レコード作成プログラムＩＤ*/
    private String insPg;

    /**レコード作成者*/
    private String insId;

    /**
     * 契約管理番号を返します。
     * @return 契約管理番号
     */
    public Long getKeiyakuNo() {
        return keiyakuNo;
    }

    /**
     * 契約管理番号を設定します。
     * @param keiyakuNo  契約管理番号
     */
    public void setKeiyakuNo(Long keiyakuNo) {
        this.keiyakuNo = keiyakuNo;
    }

    /**
     * 店舗コードを返します。
     * @return 店舗コード
     */
    public String getShopCd() {
        return shopCd;
    }

    /**
     * 店舗コードを設定します。
     * @param shopCd  店舗コード
     */
    public void setShopCd(String shopCd) {
        this.shopCd = shopCd;
    }

    /**
     * 契約管理コードを返します。
     * @return 契約管理コード
     */
    public String getKeiyakuCd() {
        return keiyakuCd;
    }

    /**
     * 契約管理コードを設定します。
     * @param keiyakuCd  契約管理コード
     */
    public void setKeiyakuCd(String keiyakuCd) {
        this.keiyakuCd = keiyakuCd;
    }

    /**
     * 契約管理オプションコードを返します。
     * @return 契約管理オプションコード
     */
    public String getKeiyakuSubCd() {
        return keiyakuSubCd;
    }

    /**
     * 契約管理オプションコードを設定します。
     * @param keiyakuSubCd  契約管理オプションコード
     */
    public void setKeiyakuSubCd(String keiyakuSubCd) {
        this.keiyakuSubCd = keiyakuSubCd;
    }

    /**
     * 契約開始日時を返します。
     * @return 契約開始日時
     */
    public String getKeiyakuStartDt() {
        return keiyakuStartDt;
    }

    /**
     * 契約開始日時を設定します。
     * @param keiyakuStartDt  契約開始日時
     */
    public void setKeiyakuStartDt(String keiyakuStartDt) {
        this.keiyakuStartDt = keiyakuStartDt;
    }

    /**
     * 契約終了日時を返します。
     * @return 契約終了日時
     */
    public String getKeiyakuEndDt() {
        return keiyakuEndDt;
    }

    /**
     * 契約終了日時を設定します。
     * @param keiyakuEndDt  契約終了日時
     */
    public void setKeiyakuEndDt(String keiyakuEndDt) {
        this.keiyakuEndDt = keiyakuEndDt;
    }

    /**
     * 契約備考を返します。
     * @return 契約備考
     */
    public String getKeiyakuNote() {
        return keiyakuNote;
    }

    /**
     * 契約備考を設定します。
     * @param keiyakuNote  契約備考
     */
    public void setKeiyakuNote(String keiyakuNote) {
        this.keiyakuNote = keiyakuNote;
    }

    /**
     * レコード作成プログラムＩＤを返します。
     * @return レコード作成プログラムＩＤ
     */
    public String getInsPg() {
        return insPg;
    }

    /**
     * レコード作成プログラムＩＤを設定します。
     * @param insPg  レコード作成プログラムＩＤ
     */
    public void setInsPg(String insPg) {
        this.insPg = insPg;
    }

    /**
     * レコード作成者を返します。
     * @return レコード作成者
     */
    public String getInsId() {
        return insId;
    }

    /**
     * レコード作成者を設定します。
     * @param insId  レコード作成者
     */
    public void setInsId(String insId) {
        this.insId = insId;
    }


}
