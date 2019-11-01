/*
 * $Id: SchoolMaintenanceDao.java 4464 2010-09-27 08:05:10Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/13  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.master.dao;



/**
 * 大学マスタメンテナンスDAO
 * @author e-ishii
 * @version $Revision: 4464 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface SchoolMaintenanceDao {

    /**
     * 大学マスタメンテナンス (CSV ファイルのアップロード用)
     * @param param
     */
    public void insertSchoolMaintenanceCsvForUpload(SchoolMaintenanceParamBean param);

    /**
     * 大学マスタテーブルのデータを全削除します。
     */
    public void deleteAllSchoolLists();

}
