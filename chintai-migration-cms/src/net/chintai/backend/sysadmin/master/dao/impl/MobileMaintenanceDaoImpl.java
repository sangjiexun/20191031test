/*
 * $Id: MobileMaintenanceDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/13  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.master.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.master.dao.MobileMaintenanceDao;
import net.chintai.backend.sysadmin.master.dao.MobileMaintenanceParamBean;
import net.chintai.backend.sysadmin.master.domain.MobileMaintenanceListInfo;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * MobileMaintenanceDaoの実装クラス
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MobileMaintenanceDaoImpl extends SqlMapClientDaoSupport implements
        MobileMaintenanceDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.dao.MobileMaintenanceDao#selectMobileMaintenanceCsvForDownload()
     */
    @SuppressWarnings("unchecked")
    public List<MobileMaintenanceListInfo> selectMobileMaintenanceCsvForDownload() {
        return getSqlMapClientTemplate().queryForList("master.selectMobileCSVDownload");
    }

    
    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.dao.MobileMaintenanceDao#insertMobileMaintenanceCsvForUpload(net.chintai.backend.sysadmin.master.dao.MobileMaintenanceParamBean)
     */
    public void insertMobileMaintenanceCsvForUpload(MobileMaintenanceParamBean param) {
        getSqlMapClientTemplate().insert("master.insertMobileCSVUpload", param);
    }


    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.dao.MobileMaintenanceDao#deleteAllMobileLists()
     */
    public void deleteAllMobileLists() {
        getSqlMapClientTemplate().delete("master.deleteAllMobileLists");
    }

    
    
}
