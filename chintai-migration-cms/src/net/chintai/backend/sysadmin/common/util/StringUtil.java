/*
 * $Id: StringUtil.java 4384 2009-09-08 02:59:32Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/08/26     BGT)石井       新規作成
 *
 */
package net.chintai.backend.sysadmin.common.util;


/**
 * 文字列操作を扱うクラス
 * @author e-ishii
 * @version $Revision: 4384 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public final class StringUtil {

    /**
     * 0埋めを行う
     * @param text もとのテキスト
     * @param i トータルで何桁の文字列にするかの数値
     * @return 0埋めした文字列、nullの場合は長さ0の文字列
     */
    public static String leftZeroPadding(String text, int i) {
        if (text == null)
            text = "";

        StringBuffer stringbuffer;
        for (stringbuffer = new StringBuffer(text); stringbuffer.length() < i; stringbuffer.insert(
                0,
                '0'))
            ;
        return stringbuffer.toString();
    }

}
