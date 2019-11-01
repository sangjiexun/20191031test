/*
 * $Id: ExitStatus.java,v 1.1 2007/10/11 04:06:42 t-kojima Exp $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/10/11   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.logging;

/**
 * プログラム終了コードを定義する Enum です。
 * 
 * @author KOJIMA Takanori
 */
public enum SessionStatus {

    /** 列挙型定義 */
    SUCCESS("0"), FAILURE("1");

    /** 終了コード */
    private final String sessionStatus;

    /**
     * コンストラクター
     * @param sessionStatus
     */
    private SessionStatus(String sessionStatus) {
        this.sessionStatus = sessionStatus;
    }
    
    /**
     * 列挙型定数値の文字列表現を返します。
     */
    public String toString() {
        return sessionStatus;
    }
}
