/*
 * $Id: AdDataUpdateInServiceBean.java 4367 2009-09-01 05:37:54Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/08/24     BGT)石井       新規作成
 *
 */
package net.chintai.backend.sysadmin.addata_matching.service.bean;

import java.util.List;


/**
 * ADデータアップロードServiceBean
 * @author e-ishii
 * @version $Revision: 4367 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AdDataUpdateInServiceBean {

    /** 年 */
    private String uploadYear;

    /** 月 */
    private String uploadMonth;

    /** 登録・更新者ID */
    private String operUserId;

    /** 登録・更新PG名 */
    private String pgName;

    /** アップロードリスト */
    private List<String[]> uploadList;

    /**
     * 登録・更新者IDを取得します。
     * @return 登録・更新者ID
     */
    public String getOperUserId() {
        return operUserId;
    }

    /**
     * 登録・更新者IDを設定します。
     * @param operUserId 登録・更新者ID
     */
    public void setOperUserId(String operUserId) {
        this.operUserId = operUserId;
    }

    /**
     * 登録・更新PG名を取得します。
     * @return 登録・更新PG名
     */
    public String getPgName() {
        return pgName;
    }

    /**
     * 登録・更新PG名を設定します。
     * @param pgName 登録・更新PG名
     */
    public void setPgName(String pgName) {
        this.pgName = pgName;
    }

    /**
     * アップロードリストを取得します。
     * @return アップロードリスト
     */
    public List<String[]> getUploadList() {
        return uploadList;
    }

    /**
     * アップロードリストを設定します。
     * @param uploadList アップロードリスト
     */
    public void setUploadList(List<String[]> uploadList) {
        this.uploadList = uploadList;
    }

    /**
     * 年を取得します。
     * @return 年
     */
    public String getUploadYear() {
        return uploadYear;
    }

    /**
     * 年を設定します。
     * @param uloadYear 年
     */
    public void setUploadYear(String uploadYear) {
        this.uploadYear = uploadYear;
    }

    /**
     * 月を取得します。
     * @return 月
     */
    public String getUploadMonth() {
        return uploadMonth;
    }

    /**
     * 月を設定します。
     * @param uploadMonth 月
     */
    public void setUploadMonth(String uploadMonth) {
        this.uploadMonth = uploadMonth;
    }

}
