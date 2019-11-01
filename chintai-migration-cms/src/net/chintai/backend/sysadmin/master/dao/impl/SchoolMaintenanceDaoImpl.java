package net.chintai.backend.sysadmin.master.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.master.dao.SchoolMaintenanceDao;
import net.chintai.backend.sysadmin.master.dao.SchoolMaintenanceParamBean;


/**
 * SchoolMaintenanceDaoの実装クラス
 * @author e-ishii
 * @version $Revision: 4464 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class SchoolMaintenanceDaoImpl extends SqlMapClientDaoSupport implements SchoolMaintenanceDao {

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.dao.SchoolMaintenanceDao#deleteAllSchoolLists()
     */
    public void deleteAllSchoolLists() {
        getSqlMapClientTemplate().delete("master.deleteAllSchoolLists");
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.dao.SchoolMaintenanceDao#insertSchoolMaintenanceCsvForUpload(net.chintai.backend.sysadmin.master.dao.SchoolMaintenanceParamBean)
     */
    public void insertSchoolMaintenanceCsvForUpload(SchoolMaintenanceParamBean param) {
        getSqlMapClientTemplate().insert("master.insertSchoolCSVUpload", param);

    }

}
