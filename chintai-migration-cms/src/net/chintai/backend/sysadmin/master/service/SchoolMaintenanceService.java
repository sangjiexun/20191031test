/*
 * $Id: SchoolMaintenanceService.java 4464 2010-09-27 08:05:10Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/13  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.master.service;


import net.chintai.backend.sysadmin.common.exception.ApplicationException;

import net.chintai.backend.sysadmin.master.service.bean.SchoolMaintenanceInServiceBean;


/**
 * 大学マスタメンテナンスService
 * @author e-ishii
 * @version $Revision: 4464 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface SchoolMaintenanceService {

    /**
     * 大学マスタメンテナンス (CSV ファイルのアップロード用)
     * @throws ApplicationException
     *
     */
    public void schoolCsvUpload(SchoolMaintenanceInServiceBean inSerivceBean) throws ApplicationException;

}
