/*
 * $Id: ReviewShopInfoOutServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/12  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service.bean;

/**
 * 店舗詳細情報
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewShopInfoOutServiceBean {

    /** 初回審査状況 */
    private String syokaiShinsa;

    /** 定期審査状況 */
    private String teikiShinsa;

    /** メール転送状況 */
    private String mailSend;

    /** 自動削除 */
    private String autoDelete;

    /** 備考 */
    private String bikou;

    /** Web審査有効物件数 */
    private String shinsaBukkenCnt;

    /** 返信待ち物件数(初回審査) */
    private String syokaiCnt;

    /** 返信待ち物件数(定期審査) */
    private String teikiCnt;

    /** 返信待ち率 */
    private String returnRate;

    /**
     * 初回審査状況を取得します。
     * @return 初回審査状況
     */
    public String getSyokaiShinsa() {
        return syokaiShinsa;
    }

    /**
     * 初回審査状況を設定します。
     * @param syokaiShinsa 初回審査状況
     */
    public void setSyokaiShinsa(String syokaiShinsa) {
        this.syokaiShinsa = syokaiShinsa;
    }

    /**
     * 定期審査状況を取得します。
     * @return 定期審査状況
     */
    public String getTeikiShinsa() {
        return teikiShinsa;
    }

    /**
     * 定期審査状況を設定します。
     * @param teikiShinsa 定期審査状況
     */
    public void setTeikiShinsa(String teikiShinsa) {
        this.teikiShinsa = teikiShinsa;
    }

    /**
     * メール転送状況を取得します。
     * @return メール転送状況
     */
    public String getMailSend() {
        return mailSend;
    }

    /**
     * メール転送状況を設定します。
     * @param mailSend メール転送状況
     */
    public void setMailSend(String mailSend) {
        this.mailSend = mailSend;
    }

    /**
     * 自動削除を取得します。
     * @return 自動削除
     */
    public String getAutoDelete() {
        return autoDelete;
    }

    /**
     * 自動削除を設定します。
     * @param autoDelete 自動削除
     */
    public void setAutoDelete(String autoDelete) {
        this.autoDelete = autoDelete;
    }

    /**
     * 備考を取得します。
     * @return 備考
     */
    public String getBikou() {
        return bikou;
    }

    /**
     * 備考を設定します。
     * @param bikou 備考
     */
    public void setBikou(String bikou) {
        this.bikou = bikou;
    }

    /**
     * Web審査有効物件数を取得します。
     * @return Web審査有効物件数
     */
    public String getShinsaBukkenCnt() {
        return shinsaBukkenCnt;
    }

    /**
     * Web審査有効物件数を設定します。
     * @param shinsaBukkenCnt Web審査有効物件数
     */
    public void setShinsaBukkenCnt(String shinsaBukkenCnt) {
        this.shinsaBukkenCnt = shinsaBukkenCnt;
    }

    /**
     * 返信待ち物件数(初回審査)を取得します。
     * @return 返信待ち物件数(初回審査)
     */
    public String getSyokaiCnt() {
        return syokaiCnt;
    }

    /**
     * 返信待ち物件数(初回審査)を設定します。
     * @param syokaiCnt 返信待ち物件数(初回審査)
     */
    public void setSyokaiCnt(String syokaiCnt) {
        this.syokaiCnt = syokaiCnt;
    }

    /**
     * 返信待ち物件数(定期審査)を取得します。
     * @return 返信待ち物件数(定期審査)
     */
    public String getTeikiCnt() {
        return teikiCnt;
    }

    /**
     * 返信待ち物件数(定期審査)を設定します。
     * @param teikiCnt 返信待ち物件数(定期審査)
     */
    public void setTeikiCnt(String teikiCnt) {
        this.teikiCnt = teikiCnt;
    }

    /**
     * 返信待ち率を取得します。
     * @return 返信待ち率
     */
    public String getReturnRate() {
        return returnRate;
    }

    /**
     * 返信待ち率を設定します。
     * @param returnRate 返信待ち率
     */
    public void setReturnRate(String returnRate) {
        this.returnRate = returnRate;
    }

}
