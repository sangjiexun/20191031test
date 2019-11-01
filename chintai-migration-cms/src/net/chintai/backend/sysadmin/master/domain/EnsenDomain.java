/*
 * $Id: EnsenDomain.java 4027 2008-10-30 06:25:26Z m-ono $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/12/26   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.master.domain;

/**
 * 沿線データを表すDomain。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 4027 $ Copyright: (C) CHINTAI Corporation All Right
 *          Reserved.
 */
public class EnsenDomain {

    /** 沿線コード */
    private String ensenCd;

    /** 沿線名称 */
    private String ensenName;

    /** 沿線タイプ */
    private String ensenType;

    /** エリアコード */
    private String areaCd;

    /** 沿線ソートキー */
    private String ensenSortKey;

    /** 沿線配布停止区分 */
    private String ensenUseStopFlg;

    /** 沿線名称かな */
    private String ensenKana;

    /** 鉄道会社番号 */
    private String railwaycoNo;

    /** 沿線シーケンス（Webソートキー） */
    private String ensenSeq;

    /** 沿線略称 */
    private String ensennameShort;

    /** 沿線略称かな */
    private String ensenkanaShort;

    /** 更新ユーザID */
    private String operUserId;

    /** 更新プログラム名 */
    private String pgName;

    /** 処理対象行番号(エラーメッセージ用) */
    private String lineNumber;

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
     * 沿線ソートキーを取得します。
     * @return 沿線ソートキー
     */
    public String getEnsenSortKey() {
        return ensenSortKey;
    }

    /**
     * 沿線ソートキーを設定します。
     * @param ensenSortKey 沿線ソートキー
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
