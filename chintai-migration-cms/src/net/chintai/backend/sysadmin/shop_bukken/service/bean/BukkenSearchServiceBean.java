/*
 * BukkenSearchServiceBean.java
 * ---------------------------------------------------------
 * 更新日      更新者     内容
 * ---------------------------------------------------------
 * 2007/07/19  BGT)児島   新規作成
 * 
 */
package net.chintai.backend.sysadmin.shop_bukken.service.bean;

/**
 * 物件検索サービスBean
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class BukkenSearchServiceBean {

    /** 店舗コード */
    private String shopCode;

    /** 物件コード */
    private String bukkenCode;

    /** 部屋連番 */
    private String roomNum;

    /** 問い合せ番号 */
    private String inquiryCd;

    /**
     * 店舗コードを取得します。
     * @return 店舗コード
     */
    public String getShopCode() {
        return shopCode;
    }

    /**
     * 店舗コードを設定します。
     * @param shopCode 店舗コード
     */
    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    /**
     * 物件コードを取得します。
     * @return 物件コード
     */
    public String getBukkenCode() {
        return bukkenCode;
    }

    /**
     * 物件コードを設定します。
     * @param bukkenCode 物件コード
     */
    public void setBukkenCode(String bukkenCode) {
        this.bukkenCode = bukkenCode;
    }

    /**
     * 部屋連番を取得します。
     * @return 部屋連番
     */
    public String getRoomNum() {
        return roomNum;
    }

    /**
     * 部屋連番を設定します。
     * @param roomNum 部屋連番
     */
    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    /**
     * 問い合せ番号を取得します。
     * @return 問い合せ番号
     */
    public String getInquiryCd() {
        return inquiryCd;
    }

    /**
     * 問い合せ番号を設定します。
     * @param inquiryCd 問い合せ番号
     */
    public void setInquiryCd(String inquiryCd) {
        this.inquiryCd = inquiryCd;
    }
}
