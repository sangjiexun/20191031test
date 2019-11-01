/*
 * $Id: OperationLoggingServiceImpl.java,v 1.1 2007/10/10 01:18:03 t-kojima Exp $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/10/10   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.logging.service;

import net.chintai.backend.sysadmin.logging.SessionStatus;
import net.chintai.backend.sysadmin.logging.dao.OperationLoggingDao;
import net.chintai.backend.sysadmin.logging.dao.OperationLoggingParamBean;

/**
 * OperationLoggingService の実装クラス。<br>
 * このパッケージは広告チームと共有するため、独立したモジュールとして管理します。
 *
 * @author KOJIMA Takanori
 */
public class OperationLoggingServiceImpl implements OperationLoggingService {

    /** 操作ログ記録DAO */
    private OperationLoggingDao loggingDao;

    /**
     * 操作ログ記録DAOを設定します。
     * @param dao 操作ログ記録DAO
     */
    public void setOperationLoggingDao(OperationLoggingDao dao) {
        loggingDao = dao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.logging.OperationLoggingService#write(net.chintai.backend.sysadmin.logging.OperationLoggingServiceBean)
     */
    public int write(OperationLoggingServiceBean bean) {
        return write(bean.getOperationId(), bean.getOperUserId(), bean.getSessionStatus(), bean.getTarget(), bean.getPgName());
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.logging.service.OperationLoggingService#write(java.lang.String,
     *      java.lang.String, java.lang.String, java.lang.String)
     */
    public int write(String operationId, String operUserId, SessionStatus sessionStatus, String target, String pgName) {
        OperationLoggingParamBean param = new OperationLoggingParamBean();

        param.setOperationId(operationId);
        param.setSessionStatus(sessionStatus.toString());
        param.setTarget(target);
        param.setOperUserId(operUserId);
        param.setPgName(pgName);

        return loggingDao.insert(param);
    }

}
