/*
 * $Id: SelectBoxTag.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/22  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.common.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import org.apache.commons.lang.StringUtils;


/**
 * プルダウンを生成します。<br>
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class SelectBoxTag extends TagSupport {

    private static final long serialVersionUID = -3088624323603296361L;


    /** ドロップダウンリストの名前 */
    private String name;

    /**
     * 必須フラグ。<br>
     * この値が設定されと、空白選択不可になります。
     */
    private String required;

    /**
     * プルダウンの画面表示項目値リスト。<br>
     */
    private List<String[]> valuesList;

    /**
     * デフォルト値。<br>
     * この値が設定されていない場合は、システムのデフォルト値が適用されます。
     */
    private String fixValue;


    /**
     * ドロップダウンリストを作成します。
     * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
     */
    public int doStartTag() throws JspException {

        // タグの中身を作成
        StringBuilder content = new StringBuilder();

        content.append("\r\n\t<select name=\"" + name + "\">\r\n");
        if(StringUtils.isEmpty(required) || !(required.equals("true"))){
            content.append("\t\t<option value=\"\" ></option>\r\n");
        }

        for (int i = 0; i < valuesList.size(); i++) {
            content.append("\t\t<option value=\"");
            content.append(valuesList.get(i)[0]);
            if (valuesList.get(i)[0].equals(fixValue)) {
                content.append("\" selected=\"selected\">");
            } else {
                content.append( "\">");
            }
            content.append(valuesList.get(i)[1]);
            content.append("</option>\r\n");
        }

        content.append("\t</select>");
        // jsp への書き出し
        try {
            pageContext.getOut().print(content.toString());
            return SKIP_BODY;
        } catch (IOException e) {
            throw new JspException(e);
        }
    }

    /**
    * ドロップダウンリストの名前を設定します。
    * @param name ドロップダウンリストの名前
    */
    public void setName(String name) {
        this.name = name;
    }

    /**
    * 必須フラグ。<br>を設定します。
    * @param required 必須フラグ。<br>
    */
    public void setRequired(String required) {
        this.required = required;
    }

    /**
    * プルダウンの画面表示項目値リスト。<br>を設定します。
    * @param valuesList プルダウンの画面表示項目値リスト。<br>
    */
    public void setValuesList(List<String[]> valuesList) {
        this.valuesList = valuesList;
    }

    /**
    * デフォルト値。<br>を設定します。
    * @param fixValue デフォルト値。<br>
    */
    public void setFixValue(String fixValue) {
        this.fixValue = fixValue;
    }


}
