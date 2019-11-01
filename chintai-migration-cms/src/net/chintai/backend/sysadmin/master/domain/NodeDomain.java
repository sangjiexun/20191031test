package net.chintai.backend.sysadmin.master.domain;

/**
 * 統一駅データを表すDomain。
 * 
 * @author M.Ono
 * @version $Revision: 4087 $ Copyright: (C) CHINTAI Corporation All Right
 *          Reserved.
 */
public class NodeDomain {

    /** 統一駅番号 */
    private String ekiNo;

    /** 統一駅名称 */
    private String ekiName;

    /** 統一駅名称かな */
    private String ekiKana;

    /** 都道府県コード */
    private String prefCd;

    /** 市区町村コード（JIS） */
    private String cityCd;

    /** 駅住所（都道府県名＋市区町村名） */
    private String ekiAddress;

    /** 経度 */
    private String locationX;

    /** 緯度 */
    private String locationY;

    /** 削除区分 */
    private String delKbn;

    /** 更新ユーザID */
    private String operUserId;

    /** 更新プログラム名 */
    private String pgName;

    /** 処理対象行番号(エラーメッセージ用) */
    private String lineNumber;

    /**
     * 統一駅番号を取得します。
     * @return 統一駅番号
     */
    public String getEkiNo() {
        return ekiNo;
    }

    /**
     * 統一駅番号を設定します。
     * @param ekiNo 統一駅番号
     */
    public void setEkiNo(String ekiNo) {
        this.ekiNo = ekiNo;
    }

    /**
     * 統一駅名称を取得します。
     * @return 統一駅名称
     */
    public String getEkiName() {
        return ekiName;
    }

    /**
     * 統一駅名称を設定します。
     * @param ekiName 統一駅名称
     */
    public void setEkiName(String ekiName) {
        this.ekiName = ekiName;
    }

    /**
     * 統一駅名称かなを取得します。
     * @return 統一駅名称かな
     */
    public String getEkiKana() {
        return ekiKana;
    }

    /**
     * 統一駅名称かなを設定します。
     * @param ekiKana 統一駅名称かな
     */
    public void setEkiKana(String ekiKana) {
        this.ekiKana = ekiKana;
    }

    /**
     * 都道府県コードを取得します。
     * @return 都道府県コード
     */
    public String getPrefCd() {
        return prefCd;
    }

    /**
     * 都道府県コードを設定します。
     * @param prefCd 都道府県コード
     */
    public void setPrefCd(String prefCd) {
        this.prefCd = prefCd;
    }

    /**
     * 市区町村コード（JIS）を取得します。
     * @return 市区町村コード（JIS）
     */
    public String getCityCd() {
        return cityCd;
    }

    /**
     * 市区町村コード（JIS）を設定します。
     * @param cityCd 市区町村コード（JIS）
     */
    public void setCityCd(String cityCd) {
        this.cityCd = cityCd;
    }

    /**
     * 駅住所（都道府県名＋市区町村名）を取得します。
     * @return 駅住所（都道府県名＋市区町村名）
     */
    public String getEkiAddress() {
        return ekiAddress;
    }

    /**
     * 駅住所（都道府県名＋市区町村名）を設定します。
     * @param ekiAddress 駅住所（都道府県名＋市区町村名）
     */
    public void setEkiAddress(String ekiAddress) {
        this.ekiAddress = ekiAddress;
    }

    /**
     * 経度を取得します。
     * @return 経度
     */
    public String getLocationX() {
        return locationX;
    }

    /**
     * 経度を設定します。
     * @param locationX 経度
     */
    public void setLocationX(String locationX) {
        this.locationX = locationX;
    }

    /**
     * 緯度を取得します。
     * @return 緯度
     */
    public String getLocationY() {
        return locationY;
    }

    /**
     * 緯度を設定します。
     * @param locationY 緯度
     */
    public void setLocationY(String locationY) {
        this.locationY = locationY;
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
     * 更新ユーザIDを取得します。
     * @return 更新ユーザID
     */
    public String getOperUserId() {
        return operUserId;
    }

    /**
     * 更新ユーザIDを設定します。
     * @param operUserId 更新ユーザID
     */
    public void setOperUserId(String operUserId) {
        this.operUserId = operUserId;
    }

    /**
     * 更新プログラム名を取得します。
     * @return 更新プログラム名
     */
    public String getPgName() {
        return pgName;
    }

    /**
     * 更新プログラム名を設定します。
     * @param pgName 更新プログラム名
     */
    public void setPgName(String pgName) {
        this.pgName = pgName;
    }

    /**
     * 処理対象行番号(エラーメッセージ用)を取得します。
     * @return 処理対象行番号(エラーメッセージ用)
     */
    public String getLineNumber() {
        return lineNumber;
    }

    /**
     * 処理対象行番号(エラーメッセージ用)を設定します。
     * @param lineNumber 処理対象行番号(エラーメッセージ用)
     */
    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

}
