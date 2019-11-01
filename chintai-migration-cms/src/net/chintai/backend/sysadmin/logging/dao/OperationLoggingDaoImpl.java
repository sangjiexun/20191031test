/*
 * $Id: OperationLoggingDaoImpl.java,v 1.1 2007/10/10 01:18:00 t-kojima Exp $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/10/10   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.logging.dao;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * OperationLoggingDao の実装クラス。<br>
 * このパッケージは広告チームと共有するため、独立したモジュールとして管理します。
 * 
 * @author KOJIMA Takanori
 */
public class OperationLoggingDaoImpl extends SqlMapClientDaoSupport implements OperationLoggingDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.logging.OperationLoggingDao#insert(net.chintai.backend.sysadmin.logging.OperationLoggingParamBean)
     */
    public int insert(OperationLoggingParamBean param) {
        return (Integer) getSqlMapClientTemplate().insert("logging.insertOperationLog", param);
    }
}
