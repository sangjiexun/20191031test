/*
 * $Id: EkiDomain.java 4027 2008-10-30 06:25:26Z m-ono $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/12/26   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.master.domain;

/**
 * 駅データを表すDomain。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 4027 $ Copyright: (C) CHINTAI Corporation All Right
 *          Reserved.
 */
public class EkiDomain {

    /** 沿線コード */
    private String ensenCd;

    /** 駅コード */
    private String ekiCd;

    /**
     * 沿線駅コード。<br>
     * 沿線コードを駅コードをハイフンでつなげたもの。
     */
    private String ensenEkiCd;

    /** 駅名称 */
    private String ekiName;

    /** 駅ソートキー */
    private String ekiSortKey;

    /** 駅停車種類フラグ */
    private String stopFlg;

    /** 駅配布停止区分 */
    private String ekiUseStopFlg;

    /** 統一駅番号 */
    private String ekiNo;

    /** 始発駅フラグ */
    private String startekiFlg;

    /** 駅シーケンス（Webソートキー） */
    private String ekiSeq;

    /** 更新ユーザID */
    private String operUserId;

    /** 更新プログラム名 */
    private String pgName;

    /**
     * 沿線コードを取得します。
     * @return 沿線コード
     */
    public String getEnsenCd() {
        return ensenCd;
    }

    /**
     * 沿線コードを設定します。
     * @param ensenCd 沿線コード
     */
    public void setEnsenCd(String ensenCd) {
        this.ensenCd = ensenCd;
    }

    /**
     * 駅コードを取得します。
     * @return 駅コード
     */
    public String getEkiCd() {
        return ekiCd;
    }

    /**
     * 駅コードを設定します。
     * @param ekiCd 駅コード
     */
    public void setEkiCd(String ekiCd) {
        this.ekiCd = ekiCd;
    }

    /**
     * 沿線駅コードを取得します。
     * @return 沿線駅コード
     */
    public String getEnsenEkiCd() {
        return ensenEkiCd;
    }

    /**
     * 沿線駅コードを設定します。
     * @param ensenEkiCd 沿線駅コード
     */
    public void setEnsenEkiCd(String ensenEkiCd) {
        this.ensenEkiCd = ensenEkiCd;
    }

    /**
     * 駅名称を取得します。
     * @return 駅名称
     */
    public String getEkiName() {
        return ekiName;
    }

    /**
     * 駅名称を設定します。
     * @param ekiName 駅名称
     */
    public void setEkiName(String ekiName) {
        this.ekiName = ekiName;
    }

    /**
     * 駅ソートキーを取得します。
     * @return 駅ソートキー
     */
    public String getEkiSortKey() {
        return ekiSortKey;
    }

    /**
     * 駅ソートキーを設定します。
     * @param ekiSortKey 駅ソートキー
     */
    public void setEkiSortKey(String ekiSortKey) {
        this.ekiSortKey = ekiSortKey;
    }

    /**
     * 駅停車種類フラグを取得します。
     * @return 駅停車種類フラグ
     */
    public String getStopFlg() {
        return stopFlg;
    }

    /**
     * 駅停車種類フラグを設定します。
     * @param stopFlg 駅停車種類フラグ
     */
    public void setStopFlg(String stopFlg) {
        this.stopFlg = stopFlg;
    }

    /**
     * 駅配布停止区分を取得します。
     * @return 駅配布停止区分
     */
    public String getEkiUseStopFlg() {
        return ekiUseStopFlg;
    }

    /**
     * 駅配布停止区分を設定します。
     * @param ekiUseStopFlg 駅配布停止区分
     */
    public void setEkiUseStopFlg(String ekiUseStopFlg) {
        this.ekiUseStopFlg = ekiUseStopFlg;
    }

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
     * 始発駅フラグを取得します。
     * @return 始発駅フラグ
     */
    public String getStartekiFlg() {
        return startekiFlg;
    }

    /**
     * 始発駅フラグを設定します。
     * @param startekiFlg 始発駅フラグ
     */
    public void setStartekiFlg(String startekiFlg) {
        this.startekiFlg = startekiFlg;
    }

    /**
     * 駅シーケンス（Webソートキー）を取得します。
     * @return 駅シーケンス（Webソートキー）
     */
    public String getEkiSeq() {
        return ekiSeq;
    }

    /**
     * 駅シーケンス（Webソートキー）を設定します。
     * @param ekiseq 駅シーケンス（Webソートキー）
     */
    public void setEkiSeq(String ekiSeq) {
        this.ekiSeq = ekiSeq;
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

}
