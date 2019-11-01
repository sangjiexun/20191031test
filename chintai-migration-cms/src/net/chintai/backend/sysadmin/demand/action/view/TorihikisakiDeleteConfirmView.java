/*
 * $Id: TorihikisakiDeleteConfirmView.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/07  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.common.ViewHelper;

/**
 * 取引先削除
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiDeleteConfirmView implements ViewHelper {

    /** 取引先削除確認リスト */
    private List delelteConfrimList;

    /** 削除する取引先シーケンスリスト */
    private String[] delFlgList;

    public class TorihikisakiDeleteConfirmDetailView {

        /** 不動産会社コード */
        private String fudousanCd;

        /** 取引先コード */
        private String torihikisakiCd;

        /** 不動産会社名 */
        private String fudousanName;

        /** 取引先名 */
        private String torihikisakiName;

        /** 地域名 */
        private String prefName;

        /** 住所１ */
        private String address1;

        /** 住所２ */
        private String address2;

        /** 紐付済み店舗コード */
        private String shopCd;

        /** 取引先テーブルシーケンス */
        private String torihikisakiSeq;

        /** 取引先テーブル最終更新日時 */
        private String updDt;

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
         * 地域名を取得します。
         * @return 地域名
         */
        public String getPrefName() {
            return prefName;
        }

        /**
         * 地域名を設定します。
         * @param prefName 地域名
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
         * 紐付済み店舗コードを取得します。
         * @return 紐付済み店舗コード
         */
        public String getShopCd() {
            return shopCd;
        }

        /**
         * 紐付済み店舗コードを設定します。
         * @param shopCd 紐付済み店舗コード
         */
        public void setShopCd(String shopCd) {
            this.shopCd = shopCd;
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
         * 取引先テーブル最終更新日時を取得します。
         * @return 取引先テーブル最終更新日時
         */
        public String getUpdDt() {
            return updDt;
        }

        /**
         * 取引先テーブル最終更新日時を設定します。
         * @param updDt 取引先テーブル最終更新日時
         */
        public void setUpdDt(String updDt) {
            this.updDt = updDt;
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
    }

    /**
     * 取引先削除確認リストを取得します。
     * @return 取引先削除確認リスト
     */
    public List getDelelteConfrimList() {
        return delelteConfrimList;
    }

    /**
     * 取引先削除確認リストを設定します。
     * @param delelteConfrimList 取引先削除確認リスト
     */
    public void setDelelteConfrimList(List delelteConfrimList) {
        this.delelteConfrimList = delelteConfrimList;
    }

    /**
     * 削除する取引先シーケンスリストを取得します。
     * @return 削除する取引先シーケンスリスト
     */
    public String[] getDelFlgList() {
        return delFlgList;
    }

    /**
     * 削除する取引先シーケンスリストを設定します。
     * @param delFlgList 削除する取引先シーケンスリスト
     */
    public void setDelFlgList(String[] delFlgList) {
        this.delFlgList = delFlgList;
    }

}
