/*
 * $Id: CodePrintTag.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/02  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.common.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import net.chintai.backend.sysadmin.common.properties.SystemProperties;

import org.apache.commons.lang.StringUtils;

/**
 * コード値を文字列に変換して出力するタグ。
 * 
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CodePrintTag extends TagSupport {

    private static final long serialVersionUID = -7500865376933848850L;

    /** コード値 */
    private String code;

    /** 設定ファイルのNameKey */
    private String nameKey;

    /** 設定ファイルのValueKey */
    private String valueKey;

    /**
     * 入力されたコード値に基づいて設定ファイルの該当文字列を出力します。
     * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
     */
    public int doStartTag() throws JspException {

        // コード値がヌルの場合処理しない
        if (StringUtils.isEmpty(code)) {
            return SKIP_BODY;
        }

        // SystemPropertiesファイルの値を読み込む
        String[] outNames = (SystemProperties.getProperty(nameKey)).split(",");
        String[] outValues = (SystemProperties.getProperty(valueKey)).split(",");

        String outValue = "";

        for (int i = 0; (i < outValues.length) && outValue.length() == 0; i++) {
            if (code.equals(outValues[i])) {
                outValue = outNames[i];
            }
        }

        // jspへの書き出し
        try {
            pageContext.getOut().print(outValue);
            return SKIP_BODY;
        } catch (IOException e) {
            throw new JspException(e);
        }
    }

    /**
     * nameKeyを設定する
     * @param nameKey
     */
    public void setNameKey(String nameKey) {
        this.nameKey = nameKey;
    }

    /**
     * codeを設定する
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * valueKeyを設定する
     * @param valueKey
     */
    public void setValueKey(String valueKey) {
        this.valueKey = valueKey;
    }
}
