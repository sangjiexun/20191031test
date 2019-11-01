/*
 * $Id: EnsenEkiDomain.java 4027 2008-10-30 06:25:26Z m-ono $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/11/17   BGT)沈鍾沿    新規作成
 * 2007/01/09   BGT)児島      削除区分の名称変更
 */
package net.chintai.backend.sysadmin.master.domain;

/**
 * 沿線・駅を保持するDomain。
 *
 * @author Sim-JongYeon
 * @version $Revision: 4027 $ Copyright: (C) CHINTAI Corporation All Right
 *          Reserved.
 */
public class EnsenEkiDomain {

    /** 沿線コード */
    private String ensenCd;

    /** 沿線名称 */
    private String ensenName;

    /** 沿線タイプ */
    private String ensenType;

    /** エリアコード */
    private String areaCd;

    /** 沿線ソードキー */
    private String ensenSortKey;

    /** 沿線配布停止区分 */
    private String ensenUseStopFlg;

    /** 駅コード */
    private String ekiCd;

    /** 駅名称 */
    private String ekiName;

    /** 駅ソードキー */
    private String ekiSortKey;

    /** 駅停車種類フラグ */
    private String stopFlg;

    /** 駅配布停止区分 */
    private String ekiUseStopFlg;

    /** 沿線名称かな */
    private String ensenKana;

    /** 鉄道会社番号 */
    private String railwaycoNo;

    /** 沿線シーケンス（Webソートキー） */
    private String ensenSeq;

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

    /** 沿線略称 */
    private String ensennameShort;

    /** 沿線略称かな */
    private String ensenkanaShort;

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
     * 沿線名称を取得します。
     * @return 沿線名称
     */
    public String getEnsenName() {
        return ensenName;
    }

    /**
     * 沿線名称を設定します。
     * @param ensenName 沿線名称
     */
    public void setEnsenName(String ensenName) {
        this.ensenName = ensenName;
    }

    /**
     * 沿線タイプを取得します。
     * @return 沿線タイプ
     */
    public String getEnsenType() {
        return ensenType;
    }

    /**
     * 沿線タイプを設定します。
     * @param ensenType 沿線タイプ
     */
    public void setEnsenType(String ensenType) {
        this.ensenType = ensenType;
    }

    /**
     * エリアコードを取得します。
     * @return エリアコード
     */
    public String getAreaCd() {
        return areaCd;
    }

    /**
     * エリアコードを設定します。
     * @param areaCd エリアコード
     */
    public void setAreaCd(String areaCd) {
        this.areaCd = areaCd;
    }

    /**
     * 沿線ソードキーを取得します。
     * @return 沿線ソードキー
     */
    public String getEnsenSortKey() {
        return ensenSortKey;
    }

    /**
     * 沿線ソードキーを設定します。
     * @param ensenSortKey 沿線ソードキー
     */
    public void setEnsenSortKey(String ensenSortKey) {
        this.ensenSortKey = ensenSortKey;
    }

    /**
     * 沿線配布停止区分を取得します。
     * @return 沿線配布停止区分
     */
    public String getEnsenUseStopFlg() {
        return ensenUseStopFlg;
    }

    /**
     * 沿線配布停止区分を設定します。
     * @param ensenUseStopFlg 沿線配布停止区分
     */
    public void setEnsenUseStopFlg(String ensenUseStopFlg) {
        this.ensenUseStopFlg = ensenUseStopFlg;
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
     * 駅ソードキーを取得します。
     * @return 駅ソードキー
     */
    public String getEkiSortKey() {
        return ekiSortKey;
    }

    /**
     * 駅ソードキーを設定します。
     * @param ekiSortKey 駅ソードキー
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
     * 沿線名称かなを取得します。
     * @return 沿線名称かな
     */
    public String getEnsenKana() {
        return ensenKana;
    }

    /**
     * 沿線名称かなを設定します。
     * @param ensenKana 沿線名称かな
     */
    public void setEnsenKana(String ensenKana) {
        this.ensenKana = ensenKana;
    }

    /**
     * 鉄道会社番号を取得します。
     * @return 鉄道会社番号
     */
    public String getRailwaycoNo() {
        return railwaycoNo;
    }

    /**
     * 鉄道会社番号を設定します。
     * @param railwaycoNo 鉄道会社番号
     */
    public void setRailwaycoNo(String railwaycoNo) {
        this.railwaycoNo = railwaycoNo;
    }

    /**
     * 沿線シーケンス（Webソートキー）を取得します。
     * @return 沿線シーケンス（Webソートキー）
     */
    public String getEnsenSeq() {
        return ensenSeq;
    }

    /**
     * 沿線シーケンス（Webソートキー）を設定します。
     * @param ensenSeq 沿線シーケンス（Webソートキー）
     */
    public void setEnsenSeq(String ensenSeq) {
        this.ensenSeq = ensenSeq;
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

	public String getEnsennameShort() {
		return ensennameShort;
	}

	public void setEnsennameShort(String ensennameShort) {
		this.ensennameShort = ensennameShort;
	}

	public String getEnsenkanaShort() {
		return ensenkanaShort;
	}

	public void setEnsenkanaShort(String ensenkanaShort) {
		this.ensenkanaShort = ensenkanaShort;
	}

}
