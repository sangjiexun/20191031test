/*
 * $Id: ShikutyosonClientSettingCommitDaoImpl.java 4800 2014-01-10 05:02:50Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2014/01/06     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.dao.impl;

import java.sql.SQLException;
import java.util.List;

import net.chintai.backend.sysadmin.dataoutput.dao.ShikutyosonClientSettingCommitDao;
import net.chintai.backend.sysadmin.dataoutput.dao.ShikutyosonClientSettingCommitParamBean;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapExecutor;


/**
 * ShikutyosonClientSettingCommitDao実装クラス
 * @author KAMEDA Takuma
 * @version $Revision: 4800 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShikutyosonClientSettingCommitDaoImpl extends SqlMapClientDaoSupport implements ShikutyosonClientSettingCommitDao {

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.dao.ShikutyosonClientSettingCommitDao#deleteShikutyosonSkipConfig(net.chintai.backend.sysadmin.dataoutput.dao.ShikutyosonClientSettingCommitParamBean)
     */
    public void deleteShikutyosonSkipConfig(ShikutyosonClientSettingCommitParamBean paramBean) {
        getSqlMapClientTemplate().delete("dataoutput.deleteCitySkipConfig", paramBean);
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.dao.ShikutyosonClientSettingCommitDao#insertShikutyosonSkipConfig(java.util.List)
     */
    public void insertShikutyosonSkipConfig(final List<ShikutyosonClientSettingCommitParamBean> commitList) {
        getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
            public Integer doInSqlMapClient(SqlMapExecutor excutor) throws SQLException {
                excutor.startBatch();

                for (ShikutyosonClientSettingCommitParamBean shikutyosonClientSettingCommitParamBean : commitList) {
                    excutor.insert("dataoutput.insertCitySkipConfig", shikutyosonClientSettingCommitParamBean);
                }
                int rowsaffected = excutor.executeBatch();
                return new Integer(rowsaffected);
            }
        });
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.dao.ShikutyosonClientSettingCommitDao#deletePrefSkipConfig(net.chintai.backend.sysadmin.dataoutput.dao.ShikutyosonClientSettingCommitParamBean)
     */
    public void deletePrefSkipConfig(ShikutyosonClientSettingCommitParamBean paramBean) {
        getSqlMapClientTemplate().delete("dataoutput.deletePrefSkipConfigCity", paramBean);
    }

}
