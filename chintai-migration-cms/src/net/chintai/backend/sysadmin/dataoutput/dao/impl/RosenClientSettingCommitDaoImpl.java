/*
 * $Id: RosenClientSettingCommitDaoImpl.java 4800 2014-01-10 05:02:50Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/11/07     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.dao.impl;

import java.sql.SQLException;
import java.util.List;

import net.chintai.backend.sysadmin.dataoutput.dao.RosenClientSettingCommitDao;
import net.chintai.backend.sysadmin.dataoutput.dao.RosenClientSettingCommitParamBean;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapExecutor;


/**
 * RosenClientSettingCommitDao実装クラス
 * @author KAMEDA Takuma
 * @version $Revision: 4800 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RosenClientSettingCommitDaoImpl extends SqlMapClientDaoSupport implements RosenClientSettingCommitDao {

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.dao.RosenClientSettingCommitDao#deleteEnsenSkipConfig(net.chintai.backend.sysadmin.dataoutput.dao.RosenClientSettingCommitParamBean)
     */
    public void deleteEnsenSkipConfig(RosenClientSettingCommitParamBean paramBean) {
        getSqlMapClientTemplate().delete("dataoutput.deleteEnsenSkipConfig", paramBean);

    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.dao.RosenClientSettingCommitDao#insertEnsenSkipConfig(java.util.List)
     */
    public void insertEnsenSkipConfig(final List<RosenClientSettingCommitParamBean> commitList) {
        getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
            public Integer doInSqlMapClient(SqlMapExecutor excutor) throws SQLException {
                excutor.startBatch();

                for (RosenClientSettingCommitParamBean rosenClientSettingCommitParamBean : commitList) {
                    excutor.insert("dataoutput.insertEnsenSkipConfig", rosenClientSettingCommitParamBean);
                }
                int rowsaffected = excutor.executeBatch();
                return new Integer(rowsaffected);
            }
        });

    }

}
