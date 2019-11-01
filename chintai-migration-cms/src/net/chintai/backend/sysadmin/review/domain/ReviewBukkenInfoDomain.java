/*
 * $Id: ReviewBukkenInfoDomain.java 3911 2008-05-27 07:09:06Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/15  BGT)李昊燮   新規作成
 * 2008/05/27  BGT)李昊燮   変数（連続掲載日数、Web審査掲載起算日）追加
 */
package net.chintai.backend.sysadmin.review.domain;

/**
 * 物件詳細情報を格納する。
 *
 * @author lee-hosup
 * @version $Revision: 3911 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenInfoDomain {

    /** 初期審査対象外フラグ */
    private String syokaiSkipFlg;

    /** 定期審査対象外フラグ */
    private String teikiSkipFlg;

    /** 自動削除フラグ */
    private String autoDelSkipflg;

    /** 物件対象外設定備考 */
    private String shinsaSkipBikou;

    /** CHINTAI.NET掲載状況 */
    private String bukkenStatusShinsa;

    /** CHINTAI.NET掲載状況備考 */
    private String shinsaBukkenStatusBikou;

    /** 警告コード */
    private String warningCd;

    /** 状態区分 */
    private String statusKbn;

    /** 処理区分 */
    private String syoriKbn;

    /** 警告日 */
    private String sendDt;

    /** 処理日 */
    private String syoriDt;

    /** 警告内容 */
    private String warningName;

    /** 空室になった日付 */
    private String vacantYmd;

    /** 新築フラグ */
    private String shinchikuFlg;

    /** 最終条件確認年月日 */
    private String lastConfirmYmd;

    /** 警告履歴備考 */
    private String bikou;

    /** Web審査警告履歴連番 */
    private String warningRirekiSeq;

    /** 初回審査自動削除予定日 */
    private String syokaiAutoDelDt;

    /** 定期審査自動削除予定日 */
    private String teikiAutoDelDt;

    /** Web審査掲載起算日 */
    private String shinsaStartDt;

    /** 連続掲載日数 */
    private String elapsedDays;

    /** 警告日 */
    private String warningDt;

    /**
     * 初期審査対象外フラグを取得します。
     * @return 初期審査対象外フラグ
     */
    public String getSyokaiSkipFlg() {
        return syokaiSkipFlg;
    }

    /**
     * 初期審査対象外フラグを設定します。
     * @param syokaiSkipFlg 初期審査対象外フラグ
     */
    public void setSyokaiSkipFlg(String syokaiSkipFlg) {
        this.syokaiSkipFlg = syokaiSkipFlg;
    }

    /**
     * 定期審査対象外フラグを取得します。
     * @return 定期審査対象外フラグ
     */
    public String getTeikiSkipFlg() {
        return teikiSkipFlg;
    }

    /**
     * 定期審査対象外フラグを設定します。
     * @param teikiSkipFlg 定期審査対象外フラグ
     */
    public void setTeikiSkipFlg(String teikiSkipFlg) {
        this.teikiSkipFlg = teikiSkipFlg;
    }

    /**
     * 自動削除フラグを取得します。
     * @return 自動削除フラグ
     */
    public String getAutoDelSkipflg() {
        return autoDelSkipflg;
    }

    /**
     * 自動削除フラグを設定します。
     * @param autoDelSkipflg 自動削除フラグ
     */
    public void setAutoDelSkipflg(String autoDelSkipflg) {
        this.autoDelSkipflg = autoDelSkipflg;
    }

    /**
     * 物件対象外設定備考を取得します。
     * @return 物件対象外設定備考
     */
    public String getShinsaSkipBikou() {
        return shinsaSkipBikou;
    }

    /**
     * 物件対象外設定備考を設定します。
     * @param shinsaSkipBikou 物件対象外設定備考
     */
    public void setShinsaSkipBikou(String shinsaSkipBikou) {
        this.shinsaSkipBikou = shinsaSkipBikou;
    }

    /**
     * CHINTAI.NET掲載状況を取得します。
     * @return CHINTAI.NET掲載状況
     */
    public String getBukkenStatusShinsa() {
        return bukkenStatusShinsa;
    }

    /**
     * CHINTAI.NET掲載状況を設定します。
     * @param bukkenStatusShinsa CHINTAI.NET掲載状況
     */
    public void setBukkenStatusShinsa(String bukkenStatusShinsa) {
        this.bukkenStatusShinsa = bukkenStatusShinsa;
    }

    /**
     * CHINTAI.NET掲載状況備考を取得します。
     * @return CHINTAI.NET掲載状況備考
     */
    public String getShinsaBukkenStatusBikou() {
        return shinsaBukkenStatusBikou;
    }

    /**
     * CHINTAI.NET掲載状況備考を設定します。
     * @param shinsaBukkenStatusBikou CHINTAI.NET掲載状況備考
     */
    public void setShinsaBukkenStatusBikou(String shinsaBukkenStatusBikou) {
        this.shinsaBukkenStatusBikou = shinsaBukkenStatusBikou;
    }

    /**
     * 警告コードを取得します。
     * @return 警告コード
     */
    public String getWarningCd() {
        return warningCd;
    }

    /**
     * 警告コードを設定します。
     * @param warningCd 警告コード
     */
    public void setWarningCd(String warningCd) {
        this.warningCd = warningCd;
    }

    /**
     * 状態区分を取得します。
     * @return 状態区分
     */
    public String getStatusKbn() {
        return statusKbn;
    }

    /**
     * 状態区分を設定します。
     * @param statusKbn 状態区分
     */
    public void setStatusKbn(String statusKbn) {
        this.statusKbn = statusKbn;
    }

    /**
     * 処理区分を取得します。
     * @return 処理区分
     */
    public String getSyoriKbn() {
        return syoriKbn;
    }

    /**
     * 処理区分を設定します。
     * @param syoriKbn 処理区分
     */
    public void setSyoriKbn(String syoriKbn) {
        this.syoriKbn = syoriKbn;
    }

    /**
     * 警告日を取得します。
     * @return 警告日
     */
    public String getSendDt() {
        return sendDt;
    }

    /**
     * 警告日を設定します。
     * @param sendDt 警告日
     */
    public void setSendDt(String sendDt) {
        this.sendDt = sendDt;
    }

    /**
     * 処理日を取得します。
     * @return 処理日
     */
    public String getSyoriDt() {
        return syoriDt;
    }

    /**
     * 処理日を設定します。
     * @param syoriDt 処理日
     */
    public void setSyoriDt(String syoriDt) {
        this.syoriDt = syoriDt;
    }

    /**
	 * @return warningDt
	 */
	public String getWarningDt() {
		return warningDt;
	}

	/**
	 * @param warningDt セットする warningDt
	 */
	public void setWarningDt(String warningDt) {
		this.warningDt = warningDt;
	}

	/**
     * 警告内容を取得します。
     * @return 警告内容
     */
    public String getWarningName() {
        return warningName;
    }

    /**
     * 警告内容を設定します。
     * @param warningName 警告内容
     */
    public void setWarningName(String warningName) {
        this.warningName = warningName;
    }

    /**
     * 空室になった日付を取得します。
     * @return 空室になった日付
     */
    public String getVacantYmd() {
        return vacantYmd;
    }

    /**
     * 空室になった日付を設定します。
     * @param vacantYmd 空室になった日付
     */
    public void setVacantYmd(String vacantYmd) {
        this.vacantYmd = vacantYmd;
    }

    /**
     * 新築フラグを取得します。
     * @return 新築フラグ
     */
    public String getShinchikuFlg() {
        return shinchikuFlg;
    }

    /**
     * 新築フラグを設定します。
     * @param shinchikuFlg 新築フラグ
     */
    public void setShinchikuFlg(String shinchikuFlg) {
        this.shinchikuFlg = shinchikuFlg;
    }

    /**
     * 最終条件確認年月日を取得します。
     * @return 最終条件確認年月日
     */
    public String getLastConfirmYmd() {
        return lastConfirmYmd;
    }

    /**
     * 最終条件確認年月日を設定します。
     * @param lastConfirmYmd 最終条件確認年月日
     */
    public void setLastConfirmYmd(String lastConfirmYmd) {
        this.lastConfirmYmd = lastConfirmYmd;
    }

    /**
     * 警告履歴備考を取得します。
     * @return 警告履歴備考
     */
    public String getBikou() {
        return bikou;
    }

    /**
     * 警告履歴備考を設定します。
     * @param bikou 警告履歴備考
     */
    public void setBikou(String bikou) {
        this.bikou = bikou;
    }

    /**
     * Web審査警告履歴連番を取得します。
     * @return Web審査警告履歴連番
     */
    public String getWarningRirekiSeq() {
        return warningRirekiSeq;
    }

    /**
     * Web審査警告履歴連番を設定します。
     * @param warningRirekiSeq Web審査警告履歴連番
     */
    public void setWarningRirekiSeq(String warningRirekiSeq) {
        this.warningRirekiSeq = warningRirekiSeq;
    }

    /**
     * 初回審査自動削除予定日を取得します。
     * @return 初回審査自動削除予定日
     */
    public String getSyokaiAutoDelDt() {
        return syokaiAutoDelDt;
    }

    /**
     * 初回審査自動削除予定日を設定します。
     * @param syokaiAutoDelDt 初回審査自動削除予定日
     */
    public void setSyokaiAutoDelDt(String syokaiAutoDelDt) {
        this.syokaiAutoDelDt = syokaiAutoDelDt;
    }

    /**
     * 定期審査自動削除予定日を取得します。
     * @return 定期審査自動削除予定日
     */
    public String getTeikiAutoDelDt() {
        return teikiAutoDelDt;
    }

    /**
     * 定期審査自動削除予定日を設定します。
     * @param teikiAutoDelDt 定期審査自動削除予定日
     */
    public void setTeikiAutoDelDt(String teikiAutoDelDt) {
        this.teikiAutoDelDt = teikiAutoDelDt;
    }

    /**
     * 連続掲載日数を取得します。
     * @return elapsedDays
     */
    public String getElapsedDays() {
        return elapsedDays;
    }

    /**
     * 連続掲載日数を設定します。
     * @param elapsedDays 設定する elapsedDays
     */
    public void setElapsedDays(String elapsedDays) {
        this.elapsedDays = elapsedDays;
    }

    /**
     * Web審査掲載起算日を取得します。
     * @return shinsaStartDt
     */
    public String getShinsaStartDt() {
        return shinsaStartDt;
    }

    /**
     * Web審査掲載起算日を設定します。
     * @param shinsaStartDt 設定する shinsaStartDt
     */
    public void setShinsaStartDt(String shinsaStartDt) {
        this.shinsaStartDt = shinsaStartDt;
    }

}
