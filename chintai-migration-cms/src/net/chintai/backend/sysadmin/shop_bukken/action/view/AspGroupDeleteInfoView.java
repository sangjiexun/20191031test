/*
 * $Id: AspGroupDeleteInfoView.java 3853 2008-03-10 05:43:48Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/25  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.common.ViewHelper;

/**
 * 不動産ASPグループから外すViewHelper
 * @author Yang-EunMi
 * @version $Revision: 3853 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspGroupDeleteInfoView implements ViewHelper {

    /** グループから外す店舗リスト */
    private List<AspGroupDeleteInfoDetailView> deleteGroupList;


    /** 店舗管理テーブル更新日時 */
    private String shopKanriUpdDt;

    /**新日時を返します。
     * @return  店舗管理テーブル更新日時
     */
    public String getShopKanriUpdDt() {
        return shopKanriUpdDt;
    }

    /**
     *  店舗管理テーブル更新日時を設定します。
     * @param shopKanriUpdDt   店舗管理テーブル更新日時
     */
    public void setShopKanriUpdDt(String shopKanriUpdDt) {
        this.shopKanriUpdDt = shopKanriUpdDt;
    }

    /**
     * グループから外す店舗リストを設定します。
     * @return deleteGroupList
     */
    public List<AspGroupDeleteInfoDetailView> getDeleteGroupList() {
        return deleteGroupList;
    }

    /**
     * グループから外す店舗リストを取得します。
     * @param deleteGroupList
     */
    public void setDeleteGroupList(List<AspGroupDeleteInfoDetailView> deleteGroupList) {
        this.deleteGroupList = deleteGroupList;
    }

    public class AspGroupDeleteInfoDetailView {

        /** 店舗コード */
        private String shopCd;

        /** グループ店舗コード */
        private String groupshopCd;

        /** 会社名 */
        private String company;

        /** 事務所名 */
        private String bumon;

        /** 状態 */
        private String shopStatus;

        /** ASP */
        private String aspFlg;

        /** ユーザ最終更新日付 */
        private String updDt;

        /** グループ削除フラグ */
        private String delFlg;

        /** 不動産ＡＳＰ連番 add kashiyama */
        private Long aspShopSeq;

        /** 店舗管理テーブル更新日時 */
        private String shopKanriUpdDt;

        /**
         * グループ削除フラグを設定します。
         * @return delFlg グループ削除フラグ
         */
        public String getDelFlg() {
            return delFlg;
        }

        /**
         * グループ削除フラグを取得します。
         * @param delFlg グループ削除フラグ
         */
        public void setDelFlg(String delFlg) {
            this.delFlg = delFlg;
        }

        /**
         * グループ店舗コードを設定します。
         * @return groupshopCd グループ店舗コード
         */
        public String getGroupshopCd() {
            return groupshopCd;
        }

        /**
         * グループ店舗コードを取得します。
         * @param groupshopCd グループ店舗コード
         */
        public void setGroupshopCd(String groupshopCd) {
            this.groupshopCd = groupshopCd;
        }

        /**
         * ASPを取得します。
         * @return aspFlg ASP
         */
        public String getAspFlg() {
            return aspFlg;
        }

        /**
         * ASPを設定します。
         * @param aspFlg ASP
         */
        public void setAspFlg(String aspFlg) {
            this.aspFlg = aspFlg;
        }

        /**
         * 事務所名を取得します。
         * @return bumon 事務所名
         */
        public String getBumon() {
            return bumon;
        }

        /**
         * 事務所名を設定します。
         * @param bumon 事務所名
         */
        public void setBumon(String bumon) {
            this.bumon = bumon;
        }

        /**
         * 会社名を取得します。
         * @return company 会社名
         */
        public String getCompany() {
            return company;
        }

        /**
         * 会社名を設定します。
         * @param company 会社名
         */
        public void setCompany(String company) {
            this.company = company;
        }

        /**
         * 店舗コードを取得します。
         * @return shopCd
         */
        public String getShopCd() {
            return shopCd;
        }

        /**
         * 店舗コードを設定します。
         * @param shopCd
         */
        public void setShopCd(String shopCd) {
            this.shopCd = shopCd;
        }

        /**
         * 状態を取得します。
         * @return shopStatus 状態
         */
        public String getShopStatus() {
            return shopStatus;
        }

        /**
         * 状態を設定します。
         * @param shopStatus 状態
         */
        public void setShopStatus(String shopStatus) {
            this.shopStatus = shopStatus;
        }

        /**
         * ユーザ最終更新日付を取得します。
         * @return updDt ユーザ最終更新日付
         */
        public String getUpdDt() {
            return updDt;
        }

        /**
         * ユーザ最終更新日付を設定します。
         * @param updDt ユーザ最終更新日付
         */
        public void setUpdDt(String updDt) {
            this.updDt = updDt;
        }

        /**
         * 不動産ＡＳＰ連番を取得します。
         *
         * @return 不動産ＡＳＰ連番
         */
        public Long getAspShopSeq() {
            return aspShopSeq;
        }

        /**
         * 不動産ＡＳＰ連番を設定します。
         *
         * @param aspShopSeq
         *            不動産ＡＳＰ連番
         */
        public void setAspShopSeq(Long aspShopSeq) {
            this.aspShopSeq = aspShopSeq;
        }

        /**
         *  店舗管理テーブル更新日時を返します。
         * @return  店舗管理テーブル更新日時
         */
        public String getShopKanriUpdDt() {
            return shopKanriUpdDt;
        }

        /**
         *  店舗管理テーブル更新日時を設定します。
         * @param shopKanriUpdDt   店舗管理テーブル更新日時
         */
        public void setShopKanriUpdDt(String shopKanriUpdDt) {
            this.shopKanriUpdDt = shopKanriUpdDt;
        }

    }

}
