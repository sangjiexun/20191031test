/*
 * $Id: KeiyakuShopInfoView.java 4406 2009-10-14 01:56:40Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/20  BGT)李昊燮     新規作成
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 */
package net.chintai.backend.sysadmin.shop_listing.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.common.ViewHelper;
import net.chintai.backend.sysadmin.shop_listing.service.bean.MediaInfoForShopInfo;

/**
 * 契約店舗詳細ViewHelper
 *
 * @author Lee Hosup
 * @version $Revision: 4406 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class KeiyakuShopInfoView extends ShopBasicInfoView {

    /** クーポン情報Seq */
    private String[] couponSeqs;

    /** 開始年配列 */
    private String[] startYears;

    /** 開始月配列 */
    private String[] startMonths;

    /** 開始日配列 */
    private String[] startDays;

    /** 終了年配列 */
    private String[] endYears;

    /** 終了月配列 */
    private String[] endMonths;

    /** 終了日配列 */
    private String[] endDays;

    /** 利用対象：プルダウン選択値 */
    private String[] riyouTaisyo;

    /** 利用対象：手入力値 */
    private String[] riyouTaisyoCustom;

    /** 利用対象：タイプ */
    private String[] riyouTaisyoType;

    /** 特典：プルダウン選択値 */
    private String[] tokuten;

    /** 特典：手入力値 */
    private String[] tokutenCustom;

    /** 特典：タイプ */
    private String[] tokutenType;

    /** 提示条件：プルダウン選択値 */
    private String[] jouken;

    /** 提示条件：手入力値 */
    private String[] joukenCustom;

    /** 提示条件：タイプ */
    private String[] joukenType;

    /** 表示順配列 */
    private String[] sortKeys;

    /** 非表示配列 */
    private String[] delFlgs;

    /** 更新日配列 */
    private String[] updDt;

    /** 出稿情報 */
    private MediaInfoForShopInfo mediaInfo;

    /** 基本契約情報リスト */
    List<KeiyakuShopInfoDetailView> kihonKeiyakuInfoList;

    /** 有効基本契約フラグ */
    private String yukouKihonKeiyakuFlg;

    /**
     * クーポン情報Seqを取得します。
     * @return クーポン情報Seq
     */
    public String[] getCouponSeqs() {
        return couponSeqs;
    }

    /**
     * クーポン情報Seqを設定します。
     * @param couponSeqs クーポン情報Seq
     */
    public void setCouponSeqs(String[] couponSeqs) {
        this.couponSeqs = couponSeqs;
    }

    /**
     * 開始年配列を取得します。
     * @return 開始年配列
     */
    public String[] getStartYears() {
        return startYears;
    }

    /**
     * 開始年配列を設定します。
     * @param startYears 開始年配列
     */
    public void setStartYears(String[] startYears) {
        this.startYears = startYears;
    }

    /**
     * 開始月配列を取得します。
     * @return 開始月配列
     */
    public String[] getStartMonths() {
        return startMonths;
    }

    /**
     * 開始月配列を設定します。
     * @param startMonths 開始月配列
     */
    public void setStartMonths(String[] startMonths) {
        this.startMonths = startMonths;
    }

    /**
     * 開始日配列を取得します。
     * @return 開始日配列
     */
    public String[] getStartDays() {
        return startDays;
    }

    /**
     * 開始日配列を設定します。
     * @param startDays 開始日配列
     */
    public void setStartDays(String[] startDays) {
        this.startDays = startDays;
    }

    /**
     * 終了年配列を取得します。
     * @return 終了年配列
     */
    public String[] getEndYears() {
        return endYears;
    }

    /**
     * 終了年配列を設定します。
     * @param endYears 終了年配列
     */
    public void setEndYears(String[] endYears) {
        this.endYears = endYears;
    }

    /**
     * 終了月配列を取得します。
     * @return 終了月配列
     */
    public String[] getEndMonths() {
        return endMonths;
    }

    /**
     * 終了月配列を設定します。
     * @param endMonths 終了月配列
     */
    public void setEndMonths(String[] endMonths) {
        this.endMonths = endMonths;
    }

    /**
     * 終了日配列を取得します。
     * @return 終了日配列
     */
    public String[] getEndDays() {
        return endDays;
    }

    /**
     * 終了日配列を設定します。
     * @param endDays 終了日配列
     */
    public void setEndDays(String[] endDays) {
        this.endDays = endDays;
    }

    /**
     * 利用対象：プルダウン選択値を取得します。
     * @return 利用対象：プルダウン選択値
     */
    public String[] getRiyouTaisyo() {
        return riyouTaisyo;
    }

    /**
     * 利用対象：プルダウン選択値を設定します。
     * @param riyouTaisyo 利用対象：プルダウン選択値
     */
    public void setRiyouTaisyo(String[] riyouTaisyo) {
        this.riyouTaisyo = riyouTaisyo;
    }

    /**
     * 利用対象：手入力値を取得します。
     * @return 利用対象：手入力値
     */
    public String[] getRiyouTaisyoCustom() {
        return riyouTaisyoCustom;
    }

    /**
     * 利用対象：手入力値を設定します。
     * @param riyouTaisyoCustom 利用対象：手入力値
     */
    public void setRiyouTaisyoCustom(String[] riyouTaisyoCustom) {
        this.riyouTaisyoCustom = riyouTaisyoCustom;
    }

    /**
     * 利用対象：タイプを取得します。
     * @return 利用対象：タイプ
     */
    public String[] getRiyouTaisyoType() {
        return riyouTaisyoType;
    }

    /**
     * 利用対象：タイプを設定します。
     * @param riyouTaisyoType 利用対象：タイプ
     */
    public void setRiyouTaisyoType(String[] riyouTaisyoType) {
        this.riyouTaisyoType = riyouTaisyoType;
    }

    /**
     * 特典：プルダウン選択値を取得します。
     * @return 特典：プルダウン選択値
     */
    public String[] getTokuten() {
        return tokuten;
    }

    /**
     * 特典：プルダウン選択値を設定します。
     * @param tokuten 特典：プルダウン選択値
     */
    public void setTokuten(String[] tokuten) {
        this.tokuten = tokuten;
    }

    /**
     * 特典：手入力値を取得します。
     * @return 特典：手入力値
     */
    public String[] getTokutenCustom() {
        return tokutenCustom;
    }

    /**
     * 特典：手入力値を設定します。
     * @param tokutenCustom 特典：手入力値
     */
    public void setTokutenCustom(String[] tokutenCustom) {
        this.tokutenCustom = tokutenCustom;
    }

    /**
     * 特典：タイプを取得します。
     * @return 特典：タイプ
     */
    public String[] getTokutenType() {
        return tokutenType;
    }

    /**
     * 特典：タイプを設定します。
     * @param tokutenType 特典：タイプ
     */
    public void setTokutenType(String[] tokutenType) {
        this.tokutenType = tokutenType;
    }

    /**
     * 提示条件：プルダウン選択値を取得します。
     * @return 提示条件：プルダウン選択値
     */
    public String[] getJouken() {
        return jouken;
    }

    /**
     * 提示条件：プルダウン選択値を設定します。
     * @param jouken 提示条件：プルダウン選択値
     */
    public void setJouken(String[] jouken) {
        this.jouken = jouken;
    }

    /**
     * 提示条件：手入力値を取得します。
     * @return 提示条件：手入力値
     */
    public String[] getJoukenCustom() {
        return joukenCustom;
    }

    /**
     * 提示条件：手入力値を設定します。
     * @param joukenCustom 提示条件：手入力値
     */
    public void setJoukenCustom(String[] joukenCustom) {
        this.joukenCustom = joukenCustom;
    }

    /**
     * 提示条件：タイプを取得します。
     * @return 提示条件：タイプ
     */
    public String[] getJoukenType() {
        return joukenType;
    }

    /**
     * 提示条件：タイプを設定します。
     * @param joukenType 提示条件：タイプ
     */
    public void setJoukenType(String[] joukenType) {
        this.joukenType = joukenType;
    }

    /**
     * 表示順配列を取得します。
     * @return 表示順配列
     */
    public String[] getSortKeys() {
        return sortKeys;
    }

    /**
     * 表示順配列を設定します。
     * @param sortKeys 表示順配列
     */
    public void setSortKeys(String[] sortKeys) {
        this.sortKeys = sortKeys;
    }

    /**
     * 非表示配列を取得します。
     * @return 非表示配列
     */
    public String[] getDelFlgs() {
        return delFlgs;
    }

    /**
     * 非表示配列を設定します。
     * @param delFlgs 非表示配列
     */
    public void setDelFlgs(String[] delFlgs) {
        this.delFlgs = delFlgs;
    }

    /**
     * 更新日配列を取得します。
     * @return 更新日配列
     */
    public String[] getUpdDt() {
        return updDt;
    }

    /**
     * 更新日配列を設定します。
     * @param updDt 更新日配列
     */
    public void setUpdDt(String[] updDt) {
        this.updDt = updDt;
    }

    /**
     * 出稿情報を取得します。
     * @return 出稿情報
     */
    public MediaInfoForShopInfo getMediaInfo() {
        return mediaInfo;
    }

    /**
     * 出稿情報を設定します。
     * @param mediaInfo 出稿情報
     */
    public void setMediaInfo(MediaInfoForShopInfo mediaInfo) {
        this.mediaInfo = mediaInfo;
    }

    /**
     * 基本契約情報リストを取得します。
     * @return 基本契約情報リスト
     */
    public List<KeiyakuShopInfoDetailView> getKihonKeiyakuInfoList() {
        return kihonKeiyakuInfoList;
    }

    /**
     * 基本契約情報リストを設定します。
     * @param kihonKeiyakuInfoList 基本契約情報リスト
     */
    public void setKihonKeiyakuInfoList(List<KeiyakuShopInfoDetailView> kihonKeiyakuInfoList) {
        this.kihonKeiyakuInfoList = kihonKeiyakuInfoList;
    }

    /**
     * 基本契約情報格納用InnerClass
     *
     * @author Lee Hosup
     */
    public class KeiyakuShopInfoDetailView implements ViewHelper {

        /** 店舗リスティングSEQ */
        private String pkShopListingSeq;

        /** 契約種別 */
        private String keiyakuShubetsu;

        /** 基本契約フラグ */
        private String kihonKeiyakuFlg;

        /** 基本契約開始日 */
        private String keiyakuStartYm;

        /** 基本契約終了日 */
        private String keiyakuEndYm;

        /** クーポン契約フラグ */
        private String couponKeiyakuFlg;

        /** クーポン契約開始日 */
        private String couponStartYm;

        /** クーポン契約終了日 */
        private String couponEndYm;

        /** リンク契約フラグ */
        private String linkKeiyakuFlg;

        /** 外部リンク契約開始日 */
        private String linkStartYm;

        /** 外部リンク契約開始日 */
        private String linkEndYm;

        /** 備考 */
        private String note;

        /** 最終更新日 */
        private String updDt;

        /** リンク表示フラグ */
        private String linkFlg;

        /** 契約中フラグ */
        private String keiyakuChuuFlg;

        /**
         * 店舗リスティングSEQを取得します。
         * @return 店舗リスティングSEQ
         */
        public String getPkShopListingSeq() {
            return pkShopListingSeq;
        }

        /**
         * 店舗リスティングSEQを設定します。
         * @param pkShopListingSeq 店舗リスティングSEQ
         */
        public void setPkShopListingSeq(String pkShopListingSeq) {
            this.pkShopListingSeq = pkShopListingSeq;
        }

        /**
         * 契約種別を取得します。
         * @return 契約種別
         */
        public String getKeiyakuShubetsu() {
            return keiyakuShubetsu;
        }

        /**
         * 契約種別を設定します。
         * @param keiyakuShubetsu 契約種別
         */
        public void setKeiyakuShubetsu(String keiyakuShubetsu) {
            this.keiyakuShubetsu = keiyakuShubetsu;
        }

        /**
         * 基本契約フラグを取得します。
         * @return 基本契約フラグ
         */
        public String getKihonKeiyakuFlg() {
            return kihonKeiyakuFlg;
        }

        /**
         * 基本契約フラグを設定します。
         * @param kihonKeiyakuFlg 基本契約フラグ
         */
        public void setKihonKeiyakuFlg(String kihonKeiyakuFlg) {
            this.kihonKeiyakuFlg = kihonKeiyakuFlg;
        }

        /**
         * 基本契約開始日を取得します。
         * @return 基本契約開始日
         */
        public String getKeiyakuStartYm() {
            return keiyakuStartYm;
        }

        /**
         * 基本契約開始日を設定します。
         * @param keiyakuStartYm 基本契約開始日
         */
        public void setKeiyakuStartYm(String keiyakuStartYm) {
            this.keiyakuStartYm = keiyakuStartYm;
        }

        /**
         * 基本契約終了日を取得します。
         * @return 基本契約終了日
         */
        public String getKeiyakuEndYm() {
            return keiyakuEndYm;
        }

        /**
         * 基本契約終了日を設定します。
         * @param keiyakuEndYm 基本契約終了日
         */
        public void setKeiyakuEndYm(String keiyakuEndYm) {
            this.keiyakuEndYm = keiyakuEndYm;
        }

        /**
         * クーポン契約フラグを取得します。
         * @return クーポン契約フラグ
         */
        public String getCouponKeiyakuFlg() {
            return couponKeiyakuFlg;
        }

        /**
         * クーポン契約フラグを設定します。
         * @param couponKeiyakuFlg クーポン契約フラグ
         */
        public void setCouponKeiyakuFlg(String couponKeiyakuFlg) {
            this.couponKeiyakuFlg = couponKeiyakuFlg;
        }

        /**
         * クーポン契約開始日を取得します。
         * @return クーポン契約開始日
         */
        public String getCouponStartYm() {
            return couponStartYm;
        }

        /**
         * クーポン契約開始日を設定します。
         * @param couponStartYm クーポン契約開始日
         */
        public void setCouponStartYm(String couponStartYm) {
            this.couponStartYm = couponStartYm;
        }

        /**
         * クーポン契約終了日を取得します。
         * @return クーポン契約終了日
         */
        public String getCouponEndYm() {
            return couponEndYm;
        }

        /**
         * クーポン契約終了日を設定します。
         * @param couponEndYm クーポン契約終了日
         */
        public void setCouponEndYm(String couponEndYm) {
            this.couponEndYm = couponEndYm;
        }

        /**
         * リンク契約フラグを取得します。
         * @return リンク契約フラグ
         */
        public String getLinkKeiyakuFlg() {
            return linkKeiyakuFlg;
        }

        /**
         * リンク契約フラグを設定します。
         * @param linkKeiyakuFlg リンク契約フラグ
         */
        public void setLinkKeiyakuFlg(String linkKeiyakuFlg) {
            this.linkKeiyakuFlg = linkKeiyakuFlg;
        }

        /**
         * 外部リンク契約開始日を取得します。
         * @return 外部リンク契約開始日
         */
        public String getLinkStartYm() {
            return linkStartYm;
        }

        /**
         * 外部リンク契約開始日を設定します。
         * @param linkStartYm 外部リンク契約開始日
         */
        public void setLinkStartYm(String linkStartYm) {
            this.linkStartYm = linkStartYm;
        }

        /**
         * 外部リンク契約開始日を取得します。
         * @return 外部リンク契約開始日
         */
        public String getLinkEndYm() {
            return linkEndYm;
        }

        /**
         * 外部リンク契約開始日を設定します。
         * @param linkEndYm 外部リンク契約開始日
         */
        public void setLinkEndYm(String linkEndYm) {
            this.linkEndYm = linkEndYm;
        }

        /**
         * 備考を取得します。
         * @return 備考
         */
        public String getNote() {
            return note;
        }

        /**
         * 備考を設定します。
         * @param note 備考
         */
        public void setNote(String note) {
            this.note = note;
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
         * 契約中フラグを取得します。
         * @return 契約中フラグ
         */
        public String getKeiyakuChuuFlg() {
            return keiyakuChuuFlg;
        }

        /**
         * 契約中フラグを設定します。
         * @param keiyakuChuuFlg 契約中フラグ
         */
        public void setKeiyakuChuuFlg(String keiyakuChuuFlg) {
            this.keiyakuChuuFlg = keiyakuChuuFlg;
        }

        /**
         * リンク表示フラグを取得します。
         * @return リンク表示フラグ
         */
        public String getLinkFlg() {
            return linkFlg;
        }

        /**
         * リンク表示フラグを設定します。
         * @param linkFlg リンク表示フラグ
         */
        public void setLinkFlg(String linkFlg) {
            this.linkFlg = linkFlg;
        }
    }

    /**
     * 有効基本契約フラグを取得します。
     * @return 有効基本契約フラグ
     */
    public String getYukouKihonKeiyakuFlg() {
        return yukouKihonKeiyakuFlg;
    }

    /**
     * 有効基本契約フラグを設定します。
     * @param yukouKihonKeiyakuFlg 有効基本契約フラグ
     */
    public void setYukouKihonKeiyakuFlg(String yukouKihonKeiyakuFlg) {
        this.yukouKihonKeiyakuFlg = yukouKihonKeiyakuFlg;
    }

}
