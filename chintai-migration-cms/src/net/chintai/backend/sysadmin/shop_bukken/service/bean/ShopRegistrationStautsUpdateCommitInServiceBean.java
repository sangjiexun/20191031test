/*
 * $Id: ShopRegistrationStautsUpdateCommitInServiceBean.java 4241 2009-03-23 02:37:03Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/10  BGT)沈鍾沿     新規作成
 * 2009/03/23  BGT)李昊燮     「地図上の店舗アイコン表示状態」コメント処理
 */
package net.chintai.backend.sysadmin.shop_bukken.service.bean;

/**
 * 登録状況更新完了用InServiceBean
 *
 * @author Sim-JongYeon
 * @author yang-eunmi
 * @version $Revision: 4241 $ Copyright: (C) CHINTAI Corporation All Right
 *          Reserved.
 */
public class ShopRegistrationStautsUpdateCommitInServiceBean {

    /** 店舗コード */
    private String shopCd;

    /** 取引先コード */
    private String torihikisakiCd;

    /** 取引先名 */
    private String torihikisakiName;

    /** 取引先テーブルシーケンス */
    private String torihikisakiSeq;

    /** 承認状態 */
    private String certifyFlg;

    /** システム利用状態 */
    private String shopStatus;

    /** CHINTAI掲載フラグ */
    private String ctFlg;

    /** エイブル掲載フラグ */
    private String ablFlg;

    /** 店舗サイト権限 */
    private String shopSiteRole;

    /** 最終更新日付 */
    private String updDt;

    /** 最終更新者ID */
    private String operId;

    /** 最終更新プログラムID */
    private String updPg;

    /** 不動産会社コード */
    private String fudousanCd;

    /** 不動産会社名 */
    private String fudousanName;

    /** 備考 */
    private String adminNote;

    /** 店舗名かな */
    private String bumonKana;

    //** 地図上の店舗アイコン表示状態 */
    //private String shopIconDelFlg;
    // 2009/03/23 李昊燮 「地図上の店舗アイコン表示状態」削除

    /**
     * 不動産会社コードを取得します。
     * @return 不動産会社コード
     */
    public String getFudousanCd() {
        return fudousanCd;
    }

    /**
     * 不動産会社コードを設定します。
     * @param fudousanCd 不動産会社コード
     */
    public void setFudousanCd(String fudousanCd) {
        this.fudousanCd = fudousanCd;
    }

    /**
     * 不動産会社名を取得します。
     * @return 不動産会社名
     */
    public String getFudousanName() {
        return fudousanName;
    }

    /**
     * 不動産会社名を設定します。
     * @param fudousanName 不動産会社名
     */
    public void setFudousanName(String fudousanName) {
        this.fudousanName = fudousanName;
    }

    /**
     * 取引先テーブルシーケンスを取得します。
     * @return 取引先テーブルシーケンス
     */
    public String getTorihikisakiSeq() {
        return torihikisakiSeq;
    }

    /**
     * 取引先テーブルシーケンスを設定します。
     * @param torihikisakiSeq 取引先テーブルシーケンス
     */
    public void setTorihikisakiSeq(String torihikisakiSeq) {
        this.torihikisakiSeq = torihikisakiSeq;
    }

    /**
     * 最終更新プログラムIDを取得します。
     * @return 最終更新プログラムID
     */
    public String getUpdPg() {
        return updPg;
    }

    /**
     * 最終更新プログラムIDを設定します。
     * @param updPg 最終更新プログラムID
     */
    public void setUpdPg(String updPg) {
        this.updPg = updPg;
    }

    /**
     * 最終更新者IDを取得します。
     * @return 最終更新者ID
     */
    public String getOperId() {
        return operId;
    }

    /**
     * 最終更新者IDを設定します。
     * @param operId 最終更新者ID
     */
    public void setOperId(String operId) {
        this.operId = operId;
    }

    /**
     * 最終更新日付を取得します。
     * @return 最終更新日付
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 最終更新日付を設定します。
     * @param updDt 最終更新日付
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
     * エイブル掲載フラグを取得します。
     * @return エイブル掲載フラグ
     */
    public String getAblFlg() {
        return ablFlg;
    }

    /**
     * エイブル掲載フラグを設定します。
     * @param ablFlg エイブル掲載フラグ
     */
    public void setAblFlg(String ablFlg) {
        this.ablFlg = ablFlg;
    }

    /**
     * 承認状態を取得します。
     * @return 承認状態
     */
    public String getCertifyFlg() {
        return certifyFlg;
    }

    /**
     * 承認状態を設定します。
     * @param certifyFlg 承認状態
     */
    public void setCertifyFlg(String certifyFlg) {
        this.certifyFlg = certifyFlg;
    }

    /**
     * CHINTAI掲載フラグを取得します。
     * @return CHINTAI掲載フラグ
     */
    public String getCtFlg() {
        return ctFlg;
    }

    /**
     * CHINTAI掲載フラグを設定します。
     * @param ctFlg CHINTAI掲載フラグ
     */
    public void setCtFlg(String ctFlg) {
        this.ctFlg = ctFlg;
    }

    /**
     * 店舗コードを取得します。
     * @return 店舗コード
     */
    public String getShopCd() {
        return shopCd;
    }

    /**
     * 店舗コードを設定します。
     * @param shopCd 店舗コード
     */
    public void setShopCd(String shopCd) {
        this.shopCd = shopCd;
    }

    /**
     * 店舗サイト権限を取得します。
     * @return 店舗サイト権限
     */
    public String getShopSiteRole() {
        return shopSiteRole;
    }

    /**
     * 店舗サイト権限を設定します。
     * @param shopSiteRole 店舗サイト権限
     */
    public void setShopSiteRole(String shopSiteRole) {
        this.shopSiteRole = shopSiteRole;
    }

    /**
     * システム利用状態を取得します。
     * @return システム利用状態
     */
    public String getShopStatus() {
        return shopStatus;
    }

    /**
     * システム利用状態を設定します。
     * @param shopStatus システム利用状態
     */
    public void setShopStatus(String shopStatus) {
        this.shopStatus = shopStatus;
    }

    /**
     * 取引先コードを取得します。
     * @return 取引先コード
     */
    public String getTorihikisakiCd() {
        return torihikisakiCd;
    }

    /**
     * 取引先コードを設定します。
     * @param torihikisakiCd 取引先コード
     */
    public void setTorihikisakiCd(String torihikisakiCd) {
        this.torihikisakiCd = torihikisakiCd;
    }

    /**
     * 取引先名を取得します。
     * @return 取引先名
     */
    public String getTorihikisakiName() {
        return torihikisakiName;
    }

    /**
     * 取引先名を設定します。
     * @param torihikisakiName 取引先名
     */
    public void setTorihikisakiName(String torihikisakiName) {
        this.torihikisakiName = torihikisakiName;
    }

    /**
     * 備考を取得します。
     * @return 備考
     */
    public String getAdminNote() {
        return adminNote;
    }

    /**
     * 備考を設定します。
     * @param adminNote 備考
     */
    public void setAdminNote(String adminNote) {
        this.adminNote = adminNote;
    }

    /**
     * 店舗名かなを取得します。
     * @return 店舗名かな
     */
    public String getBumonKana() {
        return bumonKana;
    }

    /**
     * 店舗名かなを設定します。
     * @param bumonKana 店舗名かな
     */
    public void setBumonKana(String bumonKana) {
        this.bumonKana = bumonKana;
    }

    /**
     * 地図上の店舗アイコン表示状態を取得します。
     * @return 地図上の店舗アイコン表示状態
     */
    //public String getShopIconDelFlg() {
    //    return shopIconDelFlg;
    //}

    /**
     * 地図上の店舗アイコン表示状態を設定します。
     * @param shopIconDelFlg 地図上の店舗アイコン表示状態
     */
    //public void setShopIconDelFlg(String shopIconDelFlg) {
    //    this.shopIconDelFlg = shopIconDelFlg;
    //}
}
