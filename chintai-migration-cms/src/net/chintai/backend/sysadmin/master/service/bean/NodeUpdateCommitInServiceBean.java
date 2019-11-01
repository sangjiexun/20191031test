package net.chintai.backend.sysadmin.master.service.bean;

import java.util.List;

/**
 * 統一駅登録更新情報Bean
 * 
 * @author JavaBeans Code Generator
 * @version $Revision: 4087 $ Copyright: (C) CHINTAI Corporation All Right
 *          Reserved.
 */
public class NodeUpdateCommitInServiceBean {

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