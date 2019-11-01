/*
 * $Id: SystemException.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者     内容
 * ---------------------------------------------------------
 * 2007/06/15  BGT)児島   新規作成
 * 2007/08/13  BGT)児島   コメント修正
 */
package net.chintai.backend.sysadmin.common.exception;

import net.chintai.backend.sysadmin.common.properties.CodeProperties;

/**
 * アプリケーション共通のシステム例外。<br>
 * 予測不可能な事態などで、アプリケーション処理の継続が<br>
 * 不可能な場合に、この例外がスローされます。<br>
 * 通常は、SystemException を実装者がスローすることはありません。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class SystemException extends RuntimeException {

    private static final long serialVersionUID = -7688850996496272053L;

    /**
     * エラーID。<br>
     * ログ記録のために使用されます。
     */
    private String errorId = null;

    /**
     * エラーメッセージのプレースホルダー。<br>
     * エラーメッセージ中のプレースホルダーをこれらの値で置換します。
     */
    private String[] placeHolders = null;

    /**
     * エラーIDおよびエラーメッセージのプレースホルダーを指定して、<br>
     * 新しい SystemException を構築します。
     * @param errorId エラーID
     * @param placeHolders エラーメッセージのプレースホルダー部分(可変長引数)
     */
    public SystemException(String errorId, String... placeHolders) {
        super(errorId);

        String[] copy = new String[placeHolders.length];
        for (int i = 0; i < placeHolders.length; i++) {
            copy[i] = placeHolders[i];
        }
        this.errorId = errorId;
        this.placeHolders = copy;
    }

    /**
     * エラーID、原因、エラーメッセージのプレースホルダーを指定して、<br>
     * 新しい SystemException を構築します。
     * @param errorId エラーID
     * @param cause 原因
     * @param placeHolders エラーメッセージのプレースホルダー部分(可変長引数)
     */
    public SystemException(String errorId, Throwable cause,
            String... placeHolders) {
        super(errorId, cause);

        String[] copy = new String[placeHolders.length];
        for (int i = 0; i < placeHolders.length; i++) {
            copy[i] = placeHolders[i];
        }
        this.errorId = errorId;
        this.placeHolders = copy;
    }

    /**
     * エラーIDを取得します。
     * @return エラーID
     */
    public String getErrorId() {
        return this.errorId;
    }

    /**
     * エラーメッセージIDを取得します。
     * @return メッセージID
     */
    public String getMessageId() {
        return toMessageId(errorId);
    }

    /**
     * エラーメッセージを取得します。
     * @return エラーメッセージ
     */
    public String[] getPlaceHolders() {
        String[] copy = new String[placeHolders.length];
        for (int i = 0; i < placeHolders.length; i++) {
            copy[i] = placeHolders[i];
        }
        return copy;
    }

    /**
     * エラーIDからメッセージIDを引き当てる内部メソッドです。
     * @param errorId エラーID
     * @return エラーメッセージID
     */
    private String toMessageId(String errorId) {
        return CodeProperties.getProperty(errorId);
    }
}
