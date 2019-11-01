/*
 * $Id: AdDataUpdateCommitDaoImpl.java 4367 2009-09-01 05:37:54Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/08/24     BGT)石井       新規作成
 *
 */
package net.chintai.backend.sysadmin.addata_matching.dao.impl;

import java.sql.SQLException;
import java.util.List;

import net.chintai.backend.sysadmin.addata_matching.dao.AdDataAddParamBean;
import net.chintai.backend.sysadmin.addata_matching.dao.AdDataUpdateCommitDao;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapExecutor;

/**
 * AdDataUpdateCommitDaoインターフェースの実装クラス
 * @author e-ishii
 * @version $Revision: 4367 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AdDataUpdateCommitDaoImpl extends SqlMapClientDaoSupport implements
        AdDataUpdateCommitDao {

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.addata_matching.dao.AdDataUpdateCommitDao
     * #adDatainsert(java.util.List)
     */
    public void adDatainsert(List<AdDataAddParamBean> paramList) {
        for (int i = 0; i < paramList.size(); i++) {
            getSqlMapClientTemplate().insert("adDataMatching.adDataInsert", paramList.get(i));
        }
    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.addata_matching.dao.AdDataUpdateCommitDao
     * #AdDatainsert(java.util.List)
     */
    public int adDatainsertByBatch(final List<AdDataAddParamBean> paramList) {
        Integer rsCnt = (Integer)getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
            public Integer doInSqlMapClient(SqlMapExecutor excutor) throws SQLException {
                excutor.startBatch();

                for (AdDataAddParamBean adDataAddParamBean : paramList) {
                    excutor.insert("adDataMatching.adDataInsert", adDataAddParamBean);
                }
                int rowsaffected = excutor.executeBatch();
                return new Integer(rowsaffected);
            }
        });
        return rsCnt.intValue();
    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.addata_matching.dao.AdDataUpdateCommitDao
     * #deleteAdData
     * (net.chintai.backend.sysadmin.addata_matching.dao.AdDataAddParamBean)
     */
    public void deleteAdData(AdDataAddParamBean paramBean) {

        getSqlMapClientTemplate().update("adDataMatching.deleteAdData", paramBean);
    }
}
