/*
 * $Id: ContractAmountMaintenanceUploadInServiceBean.java 4665 2013-10-09 08:43:44Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 *
 */
package net.chintai.backend.sysadmin.demand.service.bean;

import java.util.List;


/**
 * 物件枠数・物件リスティング枠数のCSVアップロード用InServiceBean
 * @author 
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountMaintenanceUploadInServiceBean {

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
