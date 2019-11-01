/*
 * $Id: OperationLoggingService.java,v 1.1 2007/10/10 01:18:03 t-kojima Exp $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/10/10   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.logging.service;

import net.chintai.backend.sysadmin.logging.SessionStatus;

/**
 * 操作ログ記録を行うServiceです。<br>
 * このパッケージは広告チームと共有するため、独立したモジュールとして管理します。
 *
 * @author KOJIMA Takanori
 */
public interface OperationLoggingService {

    /**
     * 操作ログを記録します。処理した件数を int として戻します。
     * @param bean 記録する内容
     * @return 処理した件数 (通常は、成功 = 1, 失敗 = 0 を返す)
     */
    public int write(OperationLoggingServiceBean bean);

    /**
     * 操作ログを記録します。処理した件数を int として戻します。
     * @param operationId 操作内容ID
     * @param operUserId 操作者のユーザID
     * @param sessionStatus 操作の成否 (成功 = 0, 失敗 = 1)
     * @param target 処理対象(変更対象レコードのIDなどを記録)
     * @return 処理した件数 (通常は、成功 = 1, 失敗 = 0 を返す)
     */
    public int write(String operationId, String operUserId, SessionStatus sessionStatus, String target, String pgName);
}
