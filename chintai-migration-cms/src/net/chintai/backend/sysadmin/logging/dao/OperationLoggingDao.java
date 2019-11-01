/*
 * $Id: OperationLoggingDao.java,v 1.1 2007/10/10 01:18:00 t-kojima Exp $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/10/10   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.logging.dao;

/**
 * 操作ログ記録を行うDAOです。<br>
 * このパッケージは広告チームと共有するため、独立したモジュールとして管理します。
 * 
 * @author KOJIMA Takanori
 */
public interface OperationLoggingDao {

    /**
     * 操作ログをDBに書き込みます。処理した件数を int として戻します。
     * @param param 記録する内容
     * @return 処理した件数 (基本的に成功 = 1, 失敗 = 0)
     */
    public int insert(OperationLoggingParamBean param);
}
