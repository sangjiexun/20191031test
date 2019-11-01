package net.chintai.backend.sysadmin.master.dao;

import java.sql.Timestamp;


/**
 * 大学マスタアップロードBean
 * @author e-ishii
 * @version $Revision: 4471 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class SchoolMaintenanceParamBean {

    /** 大学ID */
    private String schoolId;

    /** 大学名 */
    private String schoolName;

    /** 登録・更新者ID */
    private String operUserId;

    /** 登録・更新PG名 */
    private String pgName;
    
    /** 登録日 */
    private Timestamp insDt;
    
    /** 更新日 */
    private Timestamp updDt;

    /**
     * 大学IDを取得します。
     * @return 大学ID
     */
    public String getSchoolId() {
        return schoolId;
    }

    /**
     * 大学IDを設定します。
     * @param schoolId 大学ID
     */
    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    /**
     * 大学名を取得します。
     * @return 大学名
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * 大学名を設定します。
     * @param schoolName 大学名
     */
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

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
     * 登録日を取得します。
     * @return 登録日
     */
    public Timestamp getInsDt() {
        return insDt;
    }

    /**
     * 登録日を設定します。
     * @param insDt 登録日
     */
    public void setInsDt(Timestamp insDt) {
        this.insDt = insDt;
    }

    /**
     * 更新日を取得します。
     * @return 更新日
     */
    public Timestamp getUpdDt() {
        return updDt;
    }

    /**
     * 更新日を設定します。
     * @param updDt 更新日
     */
    public void setUpdDt(Timestamp updDt) {
        this.updDt = updDt;
    }

}
