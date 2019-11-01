/*
 * $Id: SchoolMaintenanceInServiceBean.java 4464 2010-09-27 08:05:10Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/13  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.master.service.bean;

import java.util.List;


/**
 * 大学マスタメンテナンスinServiceBean
 * @author e-ishii
 * @version $Revision: 4464 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class SchoolMaintenanceInServiceBean {
    
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

}
