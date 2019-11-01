/*
 * $Id: PropertyOptions.java 4308 2009-07-14 06:46:43Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/13  BGT)李昊燮     新規作成
 * 2009/03/04  BGT)李昊燮     引数追加(delimiter)
 */
package net.chintai.backend.sysadmin.common.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import net.chintai.backend.sysadmin.common.properties.SystemProperties;

/**
 * 設定ファイルの定義値でプルダウンを作るクラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4308 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class PropertyOptions extends TagSupport {

    private static final long serialVersionUID = 6725569128668035721L;

    /** ドロップダウンリストの名前 */
    private String name;

    /** Option Name */
    private String nameKey;

    /** Option Value */
    private String valueKey;

    /** Style */
    private String style;

    /** onChange */
    private String onChange;

    /** 区切り文字列 */
    private String delimiter; // 2009/03/04 Lee Hosup追加

    /** id */
    private String id; // 2009/03/04 Lee Hosup追加

    /**
     * 基本設定値。この値が設定されていないときは、デフォルト値が使用されます。<br>
     * 半角数字で設定します。
     */
    private String fixValue;

    /**
     * ドロップダウンリストを作成します。
     * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
     */
    public int doStartTag() throws JspException {

        // JSPに書き出す内容を格納
        StringBuilder content = new StringBuilder();

        // ##### 2009/03/04 Lee Hosup修正前 開始
        // SystemPropertiesファイルから<option>に付ける名前と値を取得
        // String[] oNames = (SystemProperties.getProperty(nameKey)).split(",");
        // String[] oValues = (SystemProperties.getProperty(valueKey)).split(",");
        // ##### 2009/03/04 Lee Hosup修正前 終了

        // ##### 2009/03/04 Lee Hosup修正後 開始
        if (delimiter == null || delimiter == "")
            delimiter = ",";
        String[] oNames = (SystemProperties.getProperty(nameKey)).split("[" + delimiter + "]");
        String[] oValues = (SystemProperties.getProperty(valueKey)).split("[" + delimiter + "]");
        // ##### 2009/03/04 Lee Hosup修正後 終了

        content.append("<select name=\"" + name + "\" ");

        // ##### 2009/03/04 Lee Hosup修正後 開始
        if (id != null) {
            content.append("id=\"" + id + "\"");
        }
        // ##### 2009/03/04 Lee Hosup修正後 終了

        // style入力処理
        if (style != null) {
            content.append("style=\"" + style + "\"");
        }

        // onChange入力処理
        if (onChange != null) {
            content.append("onchange=\"" + onChange + "\"");
        }
        content.append(">\r\n");

        for (int i = 0; i < oNames.length; i++) {
            if (oValues[i].equals(fixValue)) {
                content.append("\t<option value=\"" + oValues[i] + "\" selected>");
            } else {
                content.append("\t<option value=\"" + oValues[i] + "\">");
            }
            content.append(oNames[i] + "</option>\r\n");
        }

        content.append("</select>\r");

        // jspへの書き出し
        try {
            pageContext.getOut().print(content.toString());
            return SKIP_BODY;
        } catch (IOException e) {
            throw new JspException(e);
        }
    }

    /**
     * 基本設定値の名前を設定します。
     * @param fixValue
     */
    public void setFixValue(String fixValue) {
        this.fixValue = fixValue;
    }

    /**
     * ドロップダウンリストの名前を設定します。
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * nameKey を設定します。
     * @param nameKey
     */
    public void setNameKey(String nameKey) {
        this.nameKey = nameKey;
    }

    /**
     * valueKey を設定します。
     * @param valueKey
     */
    public void setValueKey(String valueKey) {
        this.valueKey = valueKey;
    }

    /**
     * Style を設定します。
     * @param style 設定する style
     */
    public void setStyle(String style) {
        this.style = style;
    }

    /**
     * onChangeを設定する
     * @param onChange
     */
    public void setOnChange(String onChange) {
        this.onChange = onChange;
    }

    /**
     * 区切り文字列を設定します。
     * @param delimiter 区切り文字列
     */
    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    /**
     * idを設定します。
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }
}
