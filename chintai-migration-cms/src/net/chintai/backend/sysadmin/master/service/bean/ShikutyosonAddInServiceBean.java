/*
 * $Id: ShikutyosonAddInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 * 
 */
package net.chintai.backend.sysadmin.master.service.bean;

import java.util.List;

/**
 * 市区町村メンテナンス登録情報
 * 
 * @author JavaBeans Code Generator
 * @author yang-eunmi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShikutyosonAddInServiceBean {

    /** 更新者ID */
    private String operUserId;

    /** 更新プログラムID */
    private String className;

    /** アップロードリスト */
    private List<String[]> uploadList;

    /**
     * 更新者IDを取得します。
     * @return 更新者ID
     */
    public String getOperUserId() {
        return operUserId;
    }

    /**
     * 更新者IDを設定します。
     * @param operUserId 更新者ID
     */
    public void setOperUserId(String operUserId) {
        this.operUserId = operUserId;
    }

    /**
     * 更新プログラムIDを取得します。
     * @return 更新プログラムID
     */
    public String getClassName() {
        return className;
    }

    /**
     * 更新プログラムIDを設定します。
     * @param className 更新プログラムID
     */
    public void setClassName(String className) {
        this.className = className;
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
