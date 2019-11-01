/*
 * $Id: ApplicationException.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者     内容
 * ---------------------------------------------------------
 * 2007/07/10  BGT)児島   新規作成
 * 2007/08/13  BGT)児島   コメント修正
 */
package net.chintai.backend.sysadmin.common.exception;

import net.chintai.backend.sysadmin.common.properties.CodeProperties;

/**
 * アプリケーション共通のアプリケーション例外。<br>
 * アプリケーションの処理において事前に予想され得る異常系の<br>
 * 処理については、アプリケーション例外として取り扱います。<br>
 * 実装者は、必要ならば例外をハンドリングします。<br>
 * ハンドリングしない場合、最終的に ApplicationExceptionHandler が<br>
 * 例外を捕捉し、アプリケーションエラー画面に遷移します。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ApplicationException extends Exception {

    private static final long serialVersionUID = 2361584855971054302L;

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
     * 新しい ApplicationException を構築します。
     * @param errorId エラーID
     * @param placeHolders エラーメッセージのプレースホルダー部分(可変長引数)
     */
    public ApplicationException(String errorId, String... placeHolders) {
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
     * 新しい ApplicationException を構築します。
     * @param errorId エラーID
     * @param cause 原因
     * @param placeHolders エラーメッセージのプレースホルダー部分(可変長引数)
     */
    public ApplicationException(String errorId, Throwable cause,
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
        return errorId;
    }

    /**
     * エラーメッセージIDを取得します。
     * @return メッセージID
     */
    public String getMessageId() {
        return toMessageId(errorId);
    }

    /**
     * メッセージのプレースホルダーを取得します。
     * @return プレースホルダーの配列
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
