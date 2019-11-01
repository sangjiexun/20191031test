/*
 * $Id: TorihikisakiInfoForBindView.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/27  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.common.ViewHelper;

/**
 * 取引先検索(店舗コード紐付用)
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiInfoForBindView implements ViewHelper {

    /** 不動産会社名称 */
    private String fudousanName;

    /** 取引先名称 */
    private String torihikisakiName;

    /** 不動産会社コード */
    private String fudousanCd;

    /** 取引先コード */
    private String torihikisakiCd;

    /** 取引先コード */
    private String torihikisakiSeq;

    /** 郵便番号 */
    private String zipCd;

    /** 都道府県名 */
    private String prefName;

    /** 住所１ */
    private String address1;

    /** 住所２ */
    private String address2;

    /** 電話番号 */
    private String tel;

    /** ファックス番号 */
    private String fax;

    /** 担当者名 */
    private String tantou;

    /** 取引担当支社名 */
    private String shisya;

    /** 登録日 */
    private String insDt;

    /** 更新日 */
    private String updDt;

    /** 物件枠情報リスト */
    private List<TorihikisakiInfoForBindDetailView> wakuInfoList;

    // 物件枠情報格納用InnerClass
    public class TorihikisakiInfoForBindDetailView {

        /** 適用月 */
        private String startYm;

        /** 物件枠 */
        private String bukkenCnt;

        /** 物件リスティング */
        private String tokusenCnt;

        /** 最終更新日 */
        private String updDt;

        /** 適用月フラグ */
        private String appliedFlg;

        /**
         * 適用月を取得します。
         * @return 適用月
         */
        public String getStartYm() {
            return startYm;
        }

        /**
         * 適用月を設定します。
         * @param startYm 適用月
         */
        public void setStartYm(String startYm) {
            this.startYm = startYm;
        }

        /**
         * 物件枠を取得します。
         * @return 物件枠
         */
        public String getBukkenCnt() {
            return bukkenCnt;
        }

        /**
         * 物件枠を設定します。
         * @param bukkenCnt 物件枠
         */
        public void setBukkenCnt(String bukkenCnt) {
            this.bukkenCnt = bukkenCnt;
        }

        /**
         * 物件リスティングを取得します。
         * @return 物件リスティング
         */
        public String getTokusenCnt() {
            return tokusenCnt;
        }

        /**
         * 物件リスティングを設定します。
         * @param tokusenCnt 物件リスティング
         */
        public void setTokusenCnt(String tokusenCnt) {
            this.tokusenCnt = tokusenCnt;
        }

        /**
         * 最終更新日を取得します。
         * @return 最終更新日
         */
        public String getUpdDt() {
            return updDt;
        }

        /**
         * 最終更新日を設定します。
         * @param updDt 最終更新日
         */
        public void setUpdDt(String updDt) {
            this.updDt = updDt;
        }

        /**
         * 適用月フラグを取得します。
         * @return 適用月フラグ
         */
        public String getAppliedFlg() {
            return appliedFlg;
        }

        /**
         * 適用月フラグを設定します。
         * @param appliedFlg 適用月フラグ
         */
        public void setAppliedFlg(String appliedFlg) {
            this.appliedFlg = appliedFlg;
        }
    }

    /**
     * 不動産会社名称を取得します。
     * @return 不動産会社名称
     */
    public String getFudousanName() {
        return fudousanName;
    }

    /**
     * 不動産会社名称を設定します。
     * @param fudousanName 不動産会社名称
     */
    public void setFudousanName(String fudousanName) {
        this.fudousanName = fudousanName;
    }

    /**
     * 取引先名称を取得します。
     * @return 取引先名称
     */
    public String getTorihikisakiName() {
        return torihikisakiName;
    }

    /**
     * 取引先名称を設定します。
     * @param torihikisakiName 取引先名称
     */
    public void setTorihikisakiName(String torihikisakiName) {
        this.torihikisakiName = torihikisakiName;
    }

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
     * 取引先コードを取得します。
     * @return 取引先コード
     */
    public String getTorihikisakiSeq() {
        return torihikisakiSeq;
    }

    /**
     * 取引先コードを設定します。
     * @param torihikisakiSeq 取引先コード
     */
    public void setTorihikisakiSeq(String torihikisakiSeq) {
        this.torihikisakiSeq = torihikisakiSeq;
    }

    /**
     * 郵便番号を取得します。
     * @return 郵便番号
     */
    public String getZipCd() {
        return zipCd;
    }

    /**
     * 郵便番号を設定します。
     * @param zipCd 郵便番号
     */
    public void setZipCd(String zipCd) {
        this.zipCd = zipCd;
    }

    /**
     * 都道府県名を取得します。
     * @return 都道府県名
     */
    public String getPrefName() {
        return prefName;
    }

    /**
     * 都道府県名を設定します。
     * @param prefName 都道府県名
     */
    public void setPrefName(String prefName) {
        this.prefName = prefName;
    }

    /**
     * 住所１を取得します。
     * @return 住所１
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * 住所１を設定します。
     * @param address1 住所１
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * 住所２を取得します。
     * @return 住所２
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * 住所２を設定します。
     * @param address2 住所２
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * 電話番号を取得します。
     * @return 電話番号
     */
    public String getTel() {
        return tel;
    }

    /**
     * 電話番号を設定します。
     * @param tel 電話番号
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * ファックス番号を取得します。
     * @return ファックス番号
     */
    public String getFax() {
        return fax;
    }

    /**
     * ファックス番号を設定します。
     * @param fax ファックス番号
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * 担当者名を取得します。
     * @return 担当者名
     */
    public String getTantou() {
        return tantou;
    }

    /**
     * 担当者名を設定します。
     * @param tantou 担当者名
     */
    public void setTantou(String tantou) {
        this.tantou = tantou;
    }

    /**
     * 取引担当支社名を取得します。
     * @return 取引担当支社名
     */
    public String getShisya() {
        return shisya;
    }

    /**
     * 取引担当支社名を設定します。
     * @param shisya 取引担当支社名
     */
    public void setShisya(String shisya) {
        this.shisya = shisya;
    }

    /**
     * 登録日を取得します。
     * @return 登録日
     */
    public String getInsDt() {
        return insDt;
    }

    /**
     * 登録日を設定します。
     * @param insDt 登録日
     */
    public void setInsDt(String insDt) {
        this.insDt = insDt;
    }

    /**
     * 更新日を取得します。
     * @return 更新日
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 更新日を設定します。
     * @param updDt 更新日
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
     * 物件枠情報リストを取得します。
     * @return 物件枠情報リスト
     */
    public List<TorihikisakiInfoForBindDetailView> getWakuInfoList() {
        return wakuInfoList;
    }

    /**
     * 物件枠情報リストを設定します。
     * @param wakuInfoList 物件枠情報リスト
     */
    public void setWakuInfoList(List<TorihikisakiInfoForBindDetailView> wakuInfoList) {
        this.wakuInfoList = wakuInfoList;
    }

}