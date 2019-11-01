/*
 * $Id: ShopImageUpdateConfirmView.java 4295 2009-07-07 12:59:59Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/24  BGT)沈鍾沿     新規作成
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 */
package net.chintai.backend.sysadmin.shop_bukken.action.view;

import net.chintai.backend.sysadmin.common.ViewHelper;

/**
 * 店舗画像更新確認ViewHelper
 *
 * @author Sim-JongYeon
 * @version $Revision: 4295 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopImageUpdateConfirmView implements ViewHelper {

    /** 店舗名(会社名) */
    private String company;

    /** 店舗名(事務所名) */
    private String bumon;

    /** 店舗コード */
    private String shopCd;

    /** お客様設定パスワード */
    private String password;

    /** 店舗地図表示フラグ */
    private String shopMapPctFlgOrg;

    /** 店舗画像(左側)表示フラグ */
    private String shopPhoto1FlgOrg;

    /** 店舗画像(右側)表示フラグ */
    private String shopPhoto2FlgOrg;

    /** 店舗画像(店内写真)表示フラグ */
    private String shopPhoto3FlgOrg;

    /** 店舗画像(スタッフ接客写真) */
    private String shopPhoto4FlgOrg;

    /** 店舗地図の現在更新状態フラグ (1:更新中, 0:更新中以外) */
    private String shopMapPctFlgUpdateFlg;

    /** 店舗画像(左側)の現在更新状態フラグ (1:更新中, 0:更新中以外) */
    private String shopPhoto1FlgUpdateFlg;

    /** 店舗画像(右側)の現在更新状態フラグ (1:更新中, 0:更新中以外) */
    private String shopPhoto2FlgUpdateFlg;

    /** 店舗画像(店内写真)の現在更新状態フラグ (1:更新中, 0:更新中以外) */
    private String shopPhoto3FlgUpdateFlg;

    /** 店舗画像(スタッフ接客写真)の現在更新状態フラグ (1:更新中, 0:更新中以外) */
    private String shopPhoto4FlgUpdateFlg;

    /** 店舗地図パス(Url表示パズ) */
    private String shopMapPctFileUrlPath;

    /** 店舗画像(左側)パス(Url表示パズ) */
    private String shopPhoto1FileUrlPath;

    /** 店舗画像(右側)パス(Url表示パズ) */
    private String shopPhoto2FileUrlPath;

    /** 店舗画像(店内写真)パス(Url表示パズ) */
    private String shopPhoto3FileUrlPath;

    /** 店舗画像(スタッフ接客写真)パス(Url表示パズ) */
    private String shopPhoto4FileUrlPath;

    /** 店舗地図パス(物理パズ) */
    private String shopMapPctFileLogicalPath;

    /** 店舗画像(左側)パス(物理パズ) */
    private String shopPhoto1FileLogicalPath;

    /** 店舗画像(右側)パス(物理パズ) */
    private String shopPhoto2FileLogicalPath;

    /** 店舗画像(店内写真)パス(物理パズ) */
    private String shopPhoto3FileLogicalPath;

    /** 店舗画像(スタッフ接客写真)パス(物理パズ) */
    private String shopPhoto4FileLogicalPath;

    /** 店舗地図コメント */
    private String shopMapPctComment;

    /** 店舗画像１(店内写真)コメント */
    private String shopPhoto1Comment;

    /** 店舗画像２(スタッフ写真)コメント */
    private String shopPhoto2Comment;

    /** 店舗画像３(店内写真)コメント */
    private String shopPhoto3Comment;

    /** 店舗画像４(スタッフ接客写真)コメント */
    private String shopPhoto4Comment;

    /** 店舗地図コメント変更値 */
    private String editedMapPctComment;

    /** 店舗画像１(店内写真)コメント変更値 */
    private String editedPhoto1Comment;

    /** 店舗画像２(スタッフ写真)コメント変更値 */
    private String editedPhoto2Comment;

    /** 店舗画像３(店内写真)コメント変更値 */
    private String editedPhoto3Comment;

    /** 店舗画像４(スタッフ接客写真)コメント変更値 */
    private String editedPhoto4Comment;

    /** 最終更新日付 */
    private String updDt;

    /** 最終更新プログラム */
    private String updPg;

    /**
     * 店舗名(会社名)を取得します。
     * @return 店舗名(会社名)
     */
    public String getCompany() {
        return company;
    }

    /**
     * 店舗名(会社名)を設定します。
     * @param company 店舗名(会社名)
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 店舗名(事務所名)を取得します。
     * @return 店舗名(事務所名)
     */
    public String getBumon() {
        return bumon;
    }

    /**
     * 店舗名(事務所名)を設定します。
     * @param bumon 店舗名(事務所名)
     */
    public void setBumon(String bumon) {
        this.bumon = bumon;
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
     * お客様設定パスワードを取得します。
     * @return お客様設定パスワード
     */
    public String getPassword() {
        return password;
    }

    /**
     * お客様設定パスワードを設定します。
     * @param password お客様設定パスワード
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 店舗地図表示フラグを取得します。
     * @return 店舗地図表示フラグ
     */
    public String getShopMapPctFlgOrg() {
        return shopMapPctFlgOrg;
    }

    /**
     * 店舗地図表示フラグを設定します。
     * @param shopMapPctFlgOrg 店舗地図表示フラグ
     */
    public void setShopMapPctFlgOrg(String shopMapPctFlgOrg) {
        this.shopMapPctFlgOrg = shopMapPctFlgOrg;
    }

    /**
     * 店舗画像(左側)表示フラグを取得します。
     * @return 店舗画像(左側)表示フラグ
     */
    public String getShopPhoto1FlgOrg() {
        return shopPhoto1FlgOrg;
    }

    /**
     * 店舗画像(左側)表示フラグを設定します。
     * @param shopPhoto1FlgOrg 店舗画像(左側)表示フラグ
     */
    public void setShopPhoto1FlgOrg(String shopPhoto1FlgOrg) {
        this.shopPhoto1FlgOrg = shopPhoto1FlgOrg;
    }

    /**
     * 店舗画像(右側)表示フラグを取得します。
     * @return 店舗画像(右側)表示フラグ
     */
    public String getShopPhoto2FlgOrg() {
        return shopPhoto2FlgOrg;
    }

    /**
     * 店舗地図の現在更新状態フラグ (1:更新中, 0:更新中以外)を取得します。
     * @return 店舗地図の現在更新状態フラグ (1:更新中, 0:更新中以外)
     */
    public String getShopMapPctFlgUpdateFlg() {
        return shopMapPctFlgUpdateFlg;
    }

    /**
     * 店舗地図の現在更新状態フラグ (1:更新中, 0:更新中以外)を設定します。
     * @param shopMapPctFlgUpdateFlg 店舗地図の現在更新状態フラグ (1:更新中, 0:更新中以外)
     */
    public void setShopMapPctFlgUpdateFlg(String shopMapPctFlgUpdateFlg) {
        this.shopMapPctFlgUpdateFlg = shopMapPctFlgUpdateFlg;
    }

    /**
     * 店舗画像(左側)の現在更新状態フラグ (1:更新中, 0:更新中以外)を取得します。
     * @return 店舗画像(左側)の現在更新状態フラグ (1:更新中, 0:更新中以外)
     */
    public String getShopPhoto1FlgUpdateFlg() {
        return shopPhoto1FlgUpdateFlg;
    }

    /**
     * 店舗画像(左側)の現在更新状態フラグ (1:更新中, 0:更新中以外)を設定します。
     * @param shopPhoto1FlgUpdateFlg 店舗画像(左側)の現在更新状態フラグ (1:更新中, 0:更新中以外)
     */
    public void setShopPhoto1FlgUpdateFlg(String shopPhoto1FlgUpdateFlg) {
        this.shopPhoto1FlgUpdateFlg = shopPhoto1FlgUpdateFlg;
    }

    /**
     * 店舗画像(右側)の現在更新状態フラグ (1:更新中, 0:更新中以外)を取得します。
     * @return 店舗画像(右側)の現在更新状態フラグ (1:更新中, 0:更新中以外)
     */
    public String getShopPhoto2FlgUpdateFlg() {
        return shopPhoto2FlgUpdateFlg;
    }

    /**
     * 店舗画像(右側)の現在更新状態フラグ (1:更新中, 0:更新中以外)を設定します。
     * @param shopPhoto2FlgUpdateFlg 店舗画像(右側)の現在更新状態フラグ (1:更新中, 0:更新中以外)
     */
    public void setShopPhoto2FlgUpdateFlg(String shopPhoto2FlgUpdateFlg) {
        this.shopPhoto2FlgUpdateFlg = shopPhoto2FlgUpdateFlg;
    }

    /**
     * 店舗画像(右側)表示フラグを設定します。
     * @param shopPhoto2FlgOrg 店舗画像(右側)表示フラグ
     */
    public void setShopPhoto2FlgOrg(String shopPhoto2FlgOrg) {
        this.shopPhoto2FlgOrg = shopPhoto2FlgOrg;
    }

    /**
     * 店舗地図パス(Url表示パズ)を取得します。
     * @return 店舗地図パス(Url表示パズ)
     */
    public String getShopMapPctFileUrlPath() {
        return shopMapPctFileUrlPath;
    }

    /**
     * 店舗地図パス(Url表示パズ)を設定します。
     * @param shopMapPctFileUrlPath 店舗地図パス(Url表示パズ)
     */
    public void setShopMapPctFileUrlPath(String shopMapPctFileUrlPath) {
        this.shopMapPctFileUrlPath = shopMapPctFileUrlPath;
    }

    /**
     * 店舗画像(左側)パス(Url表示パズ)を取得します。
     * @return 店舗画像(左側)パス(Url表示パズ)
     */
    public String getShopPhoto1FileUrlPath() {
        return shopPhoto1FileUrlPath;
    }

    /**
     * 店舗画像(左側)パス(Url表示パズ)を設定します。
     * @param shopPhoto1FileUrlPath 店舗画像(左側)パス(Url表示パズ)
     */
    public void setShopPhoto1FileUrlPath(String shopPhoto1FileUrlPath) {
        this.shopPhoto1FileUrlPath = shopPhoto1FileUrlPath;
    }

    /**
     * 店舗画像(右側)パス(Url表示パズ)を取得します。
     * @return 店舗画像(右側)パス(Url表示パズ)
     */
    public String getShopPhoto2FileUrlPath() {
        return shopPhoto2FileUrlPath;
    }

    /**
     * 店舗画像(右側)パス(Url表示パズ)を設定します。
     * @param shopPhoto2FileUrlPath 店舗画像(右側)パス(Url表示パズ)
     */
    public void setShopPhoto2FileUrlPath(String shopPhoto2FileUrlPath) {
        this.shopPhoto2FileUrlPath = shopPhoto2FileUrlPath;
    }

    /**
     * 店舗地図パス(物理パズ)を取得します。
     * @return 店舗地図パス(物理パズ)
     */
    public String getShopMapPctFileLogicalPath() {
        return shopMapPctFileLogicalPath;
    }

    /**
     * 店舗地図パス(物理パズ)を設定します。
     * @param shopMapPctFileLogicalPath 店舗地図パス(物理パズ)
     */
    public void setShopMapPctFileLogicalPath(String shopMapPctFileLogicalPath) {
        this.shopMapPctFileLogicalPath = shopMapPctFileLogicalPath;
    }

    /**
     * 店舗画像(左側)パス(物理パズ)を取得します。
     * @return 店舗画像(左側)パス(物理パズ)
     */
    public String getShopPhoto1FileLogicalPath() {
        return shopPhoto1FileLogicalPath;
    }

    /**
     * 店舗画像(左側)パス(物理パズ)を設定します。
     * @param shopPhoto1FileLogicalPath 店舗画像(左側)パス(物理パズ)
     */
    public void setShopPhoto1FileLogicalPath(String shopPhoto1FileLogicalPath) {
        this.shopPhoto1FileLogicalPath = shopPhoto1FileLogicalPath;
    }

    /**
     * 店舗画像(右側)パス(物理パズ)を取得します。
     * @return 店舗画像(右側)パス(物理パズ)
     */
    public String getShopPhoto2FileLogicalPath() {
        return shopPhoto2FileLogicalPath;
    }

    /**
     * 店舗画像(右側)パス(物理パズ)を設定します。
     * @param shopPhoto2FileLogicalPath 店舗画像(右側)パス(物理パズ)
     */
    public void setShopPhoto2FileLogicalPath(String shopPhoto2FileLogicalPath) {
        this.shopPhoto2FileLogicalPath = shopPhoto2FileLogicalPath;
    }

    /**
     * 店舗画像(店内写真)パス(Url表示パズ)を取得します。
     * @return 店舗画像(店内写真)パス(Url表示パズ)
     */
    public String getShopPhoto3FileUrlPath() {
        return shopPhoto3FileUrlPath;
    }

    /**
     * 店舗画像(店内写真)パス(Url表示パズ)を設定します。
     * @param shopPhoto3FileUrlPath 店舗画像(店内写真)パス(Url表示パズ)
     */
    public void setShopPhoto3FileUrlPath(String shopPhoto3FileUrlPath) {
        this.shopPhoto3FileUrlPath = shopPhoto3FileUrlPath;
    }

    /**
     * 店舗画像(スタッフ接客写真)パス(Url表示パズ)を取得します。
     * @return 店舗画像(スタッフ接客写真)パス(Url表示パズ)
     */
    public String getShopPhoto4FileUrlPath() {
        return shopPhoto4FileUrlPath;
    }

    /**
     * 店舗画像(スタッフ接客写真)パス(Url表示パズ)を設定します。
     * @param shopPhoto4FileUrlPath 店舗画像(スタッフ接客写真)パス(Url表示パズ)
     */
    public void setShopPhoto4FileUrlPath(String shopPhoto4FileUrlPath) {
        this.shopPhoto4FileUrlPath = shopPhoto4FileUrlPath;
    }

    /**
     * 店舗画像(店内写真)パス(物理パズ)を取得します。
     * @return 店舗画像(店内写真)パス(物理パズ)
     */
    public String getShopPhoto3FileLogicalPath() {
        return shopPhoto3FileLogicalPath;
    }

    /**
     * 店舗画像(店内写真)パス(物理パズ)を設定します。
     * @param shopPhoto3FileLogicalPath 店舗画像(店内写真)パス(物理パズ)
     */
    public void setShopPhoto3FileLogicalPath(String shopPhoto3FileLogicalPath) {
        this.shopPhoto3FileLogicalPath = shopPhoto3FileLogicalPath;
    }

    /**
     * 店舗画像(スタッフ接客写真)パス(物理パズ)を取得します。
     * @return 店舗画像(スタッフ接客写真)パス(物理パズ)
     */
    public String getShopPhoto4FileLogicalPath() {
        return shopPhoto4FileLogicalPath;
    }

    /**
     * 店舗画像(スタッフ接客写真)パス(物理パズ)を設定します。
     * @param shopPhoto4FileLogicalPath 店舗画像(スタッフ接客写真)パス(物理パズ)
     */
    public void setShopPhoto4FileLogicalPath(String shopPhoto4FileLogicalPath) {
        this.shopPhoto4FileLogicalPath = shopPhoto4FileLogicalPath;
    }

    /**
     * 店舗画像(店内写真)の現在更新状態フラグ (1:更新中, 0:更新中以外)を取得します。
     * @return 店舗画像(店内写真)の現在更新状態フラグ (1:更新中, 0:更新中以外)
     */
    public String getShopPhoto3FlgUpdateFlg() {
        return shopPhoto3FlgUpdateFlg;
    }

    /**
     * 店舗画像(店内写真)の現在更新状態フラグ (1:更新中, 0:更新中以外)を設定します。
     * @param shopPhoto3FlgUpdateFlg 店舗画像(店内写真)の現在更新状態フラグ (1:更新中, 0:更新中以外)
     */
    public void setShopPhoto3FlgUpdateFlg(String shopPhoto3FlgUpdateFlg) {
        this.shopPhoto3FlgUpdateFlg = shopPhoto3FlgUpdateFlg;
    }

    /**
     * 店舗画像(スタッフ接客写真)の現在更新状態フラグ (1:更新中, 0:更新中以外)を取得します。
     * @return 店舗画像(スタッフ接客写真)の現在更新状態フラグ (1:更新中, 0:更新中以外)
     */
    public String getShopPhoto4FlgUpdateFlg() {
        return shopPhoto4FlgUpdateFlg;
    }

    /**
     * 店舗画像(スタッフ接客写真)の現在更新状態フラグ (1:更新中, 0:更新中以外)を設定します。
     * @param shopPhoto4FlgUpdateFlg 店舗画像(スタッフ接客写真)の現在更新状態フラグ (1:更新中, 0:更新中以外)
     */
    public void setShopPhoto4FlgUpdateFlg(String shopPhoto4FlgUpdateFlg) {
        this.shopPhoto4FlgUpdateFlg = shopPhoto4FlgUpdateFlg;
    }

    /**
     * 店舗画像(店内写真)表示フラグを取得します。
     * @return 店舗画像(店内写真)表示フラグ
     */
    public String getShopPhoto3FlgOrg() {
        return shopPhoto3FlgOrg;
    }

    /**
     * 店舗画像(店内写真)表示フラグを設定します。
     * @param shopPhoto3FlgOrg 店舗画像(店内写真)表示フラグ
     */
    public void setShopPhoto3FlgOrg(String shopPhoto3FlgOrg) {
        this.shopPhoto3FlgOrg = shopPhoto3FlgOrg;
    }

    /**
     * 店舗画像(スタッフ接客写真)を取得します。
     * @return 店舗画像(スタッフ接客写真)
     */
    public String getShopPhoto4FlgOrg() {
        return shopPhoto4FlgOrg;
    }

    /**
     * 店舗画像(スタッフ接客写真)を設定します。
     * @param shopPhoto4FlgOrg 店舗画像(スタッフ接客写真)
     */
    public void setShopPhoto4FlgOrg(String shopPhoto4FlgOrg) {
        this.shopPhoto4FlgOrg = shopPhoto4FlgOrg;
    }

    /**
     * 店舗地図コメントを取得します。
     * @return 店舗地図コメント
     */
    public String getShopMapPctComment() {
        return shopMapPctComment;
    }

    /**
     * 店舗地図コメントを設定します。
     * @param shopMapPctComment 店舗地図コメント
     */
    public void setShopMapPctComment(String shopMapPctComment) {
        this.shopMapPctComment = shopMapPctComment;
    }

    /**
     * 店舗画像１(店内写真)コメントを取得します。
     * @return 店舗画像１(店内写真)コメント
     */
    public String getShopPhoto1Comment() {
        return shopPhoto1Comment;
    }

    /**
     * 店舗画像１(店内写真)コメントを設定します。
     * @param shopPhoto1Comment 店舗画像１(店内写真)コメント
     */
    public void setShopPhoto1Comment(String shopPhoto1Comment) {
        this.shopPhoto1Comment = shopPhoto1Comment;
    }

    /**
     * 店舗画像２(スタッフ写真)コメントを取得します。
     * @return 店舗画像２(スタッフ写真)コメント
     */
    public String getShopPhoto2Comment() {
        return shopPhoto2Comment;
    }

    /**
     * 店舗画像２(スタッフ写真)コメントを設定します。
     * @param shopPhoto2Comment 店舗画像２(スタッフ写真)コメント
     */
    public void setShopPhoto2Comment(String shopPhoto2Comment) {
        this.shopPhoto2Comment = shopPhoto2Comment;
    }

    /**
     * 店舗画像３(店内写真)コメントを取得します。
     * @return 店舗画像３(店内写真)コメント
     */
    public String getShopPhoto3Comment() {
        return shopPhoto3Comment;
    }

    /**
     * 店舗画像３(店内写真)コメントを設定します。
     * @param shopPhoto3Comment 店舗画像３(店内写真)コメント
     */
    public void setShopPhoto3Comment(String shopPhoto3Comment) {
        this.shopPhoto3Comment = shopPhoto3Comment;
    }

    /**
     * 店舗画像４(スタッフ接客写真)コメントを取得します。
     * @return 店舗画像４(スタッフ接客写真)コメント
     */
    public String getShopPhoto4Comment() {
        return shopPhoto4Comment;
    }

    /**
     * 店舗画像４(スタッフ接客写真)コメントを設定します。
     * @param shopPhoto4Comment 店舗画像４(スタッフ接客写真)コメント
     */
    public void setShopPhoto4Comment(String shopPhoto4Comment) {
        this.shopPhoto4Comment = shopPhoto4Comment;
    }

    /**
     * 店舗地図コメント変更値を取得します。
     * @return 店舗地図コメント変更値
     */
    public String getEditedMapPctComment() {
        return editedMapPctComment;
    }

    /**
     * 店舗地図コメント変更値を設定します。
     * @param editedMapPctComment 店舗地図コメント変更値
     */
    public void setEditedMapPctComment(String editedMapPctComment) {
        this.editedMapPctComment = editedMapPctComment;
    }

    /**
     * 店舗画像１(店内写真)コメント変更値を取得します。
     * @return 店舗画像１(店内写真)コメント変更値
     */
    public String getEditedPhoto1Comment() {
        return editedPhoto1Comment;
    }

    /**
     * 店舗画像１(店内写真)コメント変更値を設定します。
     * @param editedPhoto1Comment 店舗画像１(店内写真)コメント変更値
     */
    public void setEditedPhoto1Comment(String editedPhoto1Comment) {
        this.editedPhoto1Comment = editedPhoto1Comment;
    }

    /**
     * 店舗画像２(スタッフ写真)コメント変更値を取得します。
     * @return 店舗画像２(スタッフ写真)コメント変更値
     */
    public String getEditedPhoto2Comment() {
        return editedPhoto2Comment;
    }

    /**
     * 店舗画像２(スタッフ写真)コメント変更値を設定します。
     * @param editedPhoto2Comment 店舗画像２(スタッフ写真)コメント変更値
     */
    public void setEditedPhoto2Comment(String editedPhoto2Comment) {
        this.editedPhoto2Comment = editedPhoto2Comment;
    }

    /**
     * 店舗画像３(店内写真)コメント変更値を取得します。
     * @return 店舗画像３(店内写真)コメント変更値
     */
    public String getEditedPhoto3Comment() {
        return editedPhoto3Comment;
    }

    /**
     * 店舗画像３(店内写真)コメント変更値を設定します。
     * @param editedPhoto3Comment 店舗画像３(店内写真)コメント変更値
     */
    public void setEditedPhoto3Comment(String editedPhoto3Comment) {
        this.editedPhoto3Comment = editedPhoto3Comment;
    }

    /**
     * 店舗画像４(スタッフ接客写真)コメント変更値を取得します。
     * @return 店舗画像４(スタッフ接客写真)コメント変更値
     */
    public String getEditedPhoto4Comment() {
        return editedPhoto4Comment;
    }

    /**
     * 店舗画像４(スタッフ接客写真)コメント変更値を設定します。
     * @param editedPhoto4Comment 店舗画像４(スタッフ接客写真)コメント変更値
     */
    public void setEditedPhoto4Comment(String editedPhoto4Comment) {
        this.editedPhoto4Comment = editedPhoto4Comment;
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
     * 最終更新プログラムを取得します。
     * @return 最終更新プログラム
     */
    public String getUpdPg() {
        return updPg;
    }

    /**
     * 最終更新プログラムを設定します。
     * @param updPg 最終更新プログラム
     */
    public void setUpdPg(String updPg) {
        this.updPg = updPg;
    }

}
