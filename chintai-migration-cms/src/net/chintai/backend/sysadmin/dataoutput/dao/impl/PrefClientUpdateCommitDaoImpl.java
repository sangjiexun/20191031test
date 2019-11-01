/*
 * $Id: PrefClientUpdateCommitDaoImpl.java 4747 2013-11-05 09:02:41Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/23     BGT)亀田       E-0070 建物名表示に関する改修
 *
 */
package net.chintai.backend.sysadmin.dataoutput.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapExecutor;

import net.chintai.backend.sysadmin.dataoutput.dao.PrefClientSettingParamBean;
import net.chintai.backend.sysadmin.dataoutput.dao.PrefClientUpdateCommitDao;
import net.chintai.backend.sysadmin.dataoutput.dao.PrefClientUpdateParamBean;


/**
 * PrefClientUpdateCommitDaoの実装クラス
 *
 * @author e-ishii
 * @version $Revision: 4747 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class PrefClientUpdateCommitDaoImpl extends SqlMapClientDaoSupport  implements PrefClientUpdateCommitDao {

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.dao.PrefClientUpdateCommitDao
     * #deletePrefSkipConfig(net.chintai.backend.sysadmin.dataoutput.dao.PrefClientSettingParamBean)
     */
    public void deletePrefSkipConfig(PrefClientSettingParamBean dcoTypeParamBean) {
        getSqlMapClientTemplate().delete("dataoutput.deletePrefSkipConfig", dcoTypeParamBean);

    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.dao.PrefClientUpdateCommitDao#insertPrefSkipConfig(java.util.List)
     */
    public void insertPrefSkipConfig(final List<PrefClientUpdateParamBean> commitList) {

        getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
            public Integer doInSqlMapClient(SqlMapExecutor excutor) throws SQLException {
                excutor.startBatch();

                for (PrefClientUpdateParamBean prefClientUpdateParamBean : commitList) {
                    excutor.insert("dataoutput.insertPrefSkipConfig", prefClientUpdateParamBean);
                }
                int rowsaffected = excutor.executeBatch();
                return new Integer(rowsaffected);
            }
        });

    }

}
