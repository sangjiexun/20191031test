/*
 * $Id: EkiClientSettingCommitDaoImpl.java 4796 2014-01-10 04:15:22Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/12/20     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.dao.impl;

import java.sql.SQLException;
import java.util.List;

import net.chintai.backend.sysadmin.dataoutput.dao.EkiClientSettingCommitDao;
import net.chintai.backend.sysadmin.dataoutput.dao.EkiClientSettingCommitParamBean;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapExecutor;


/**
 * EkiClientSettingCommitDao実装クラス
 * @author KAMEDA Takuma
 * @version $Revision: 4796 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class EkiClientSettingCommitDaoImpl extends SqlMapClientDaoSupport implements EkiClientSettingCommitDao{

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.dao.EkiClientSettingCommitDao#deleteEkiSkipConfig(net.chintai.backend.sysadmin.dataoutput.dao.EkiClientSettingCommitParamBean)
     */
    public void deleteEkiSkipConfig(EkiClientSettingCommitParamBean paramBean) {
        getSqlMapClientTemplate().delete("dataoutput.deleteEkiSkipConfig", paramBean);

    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.dao.EkiClientSettingCommitDao#insertEkiSkipConfig(java.util.List)
     */
    public void insertEkiSkipConfig(final List<EkiClientSettingCommitParamBean> commitList) {
        getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
            public Integer doInSqlMapClient(SqlMapExecutor excutor) throws SQLException {
                excutor.startBatch();

                for (EkiClientSettingCommitParamBean ekiClientSettingCommitParamBean : commitList) {
                    excutor.insert("dataoutput.insertEkiSkipConfig", ekiClientSettingCommitParamBean);
                }
                int rowsaffected = excutor.executeBatch();
                return new Integer(rowsaffected);
            }
        });
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.dao.EkiClientSettingCommitDao#deleteEnsenSkipConfig(net.chintai.backend.sysadmin.dataoutput.dao.EkiClientSettingCommitParamBean)
     */
    public void deleteEnsenSkipConfig(EkiClientSettingCommitParamBean paramBean) {
        getSqlMapClientTemplate().delete("dataoutput.deleteEnsenSkipConfigEki", paramBean);
    }

}
