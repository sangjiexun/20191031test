/*
 * $Id: TodofukenTag.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/09/11  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.common.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import net.chintai.backend.sysadmin.common.service.CustomTagService;
import net.chintai.backend.sysadmin.common.tags.domain.TodofukenDomain;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 都道府県プルダウン生成用クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TodofukenTag extends TagSupport {

    private static final long serialVersionUID = -2601315774539325210L;

    /** ドロップダウンリストの名前 */
    private String name;

    /**
     * 基本設定値。この値が設定されていないときは、デフォルト値が使用されます。<br>
     * 半角数字で設定します。
     */
    private String fixValue;

    /** onChange */
    private String onChange;

    /**
     * ドロップダウンリストを作成します。
     * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
     */
    public int doStartTag() throws JspException {

        // Get ApplicationContext
        ApplicationContext ac =
                WebApplicationContextUtils.getRequiredWebApplicationContext(pageContext.getServletContext());

        // DB検索
        CustomTagService service = (CustomTagService) ac.getBean("customTagService");
        List rsList = service.todofukenListService();

        // JSPに書き出す内容作成
        TodofukenDomain domain = (TodofukenDomain) rsList.get(0);
        String tmpAreaName = domain.getAreaName();
        String areaName = domain.getAreaName();
        String prefCd = domain.getPrefCd();
        String prefName = domain.getPrefName();

        StringBuilder content = new StringBuilder();
        content.append("<select name=\"" + name + "\" ");

        // onChange入力処理
        if (onChange != null) {
            content.append("onchange=\"" + onChange + "\"");
        }
        content.append(">\r\n");
        content.append("\t<option value=\"\"></option>\r\n");
        content.append("<optgroup label=\"" + areaName + "\">\r\n");
        content.append("\t<option label=\"" + prefName + "\"" + "value=\"" + prefCd + "\"");
        if (StringUtils.isNotEmpty(fixValue) && fixValue.equals(prefCd)) {
            content.append(" selected");
        }
        content.append(">" + prefName + "</option>\r\n");

        for (int i = 1; i < rsList.size(); i++) {
            domain = (TodofukenDomain) rsList.get(i);
            areaName = domain.getAreaName();
            prefCd = domain.getPrefCd();
            prefName = domain.getPrefName();

            // 新しいエリアが始まる時グループタグ追加
            if (!areaName.equals(tmpAreaName)) {
                content.append("</optgroup>\r\n");
                content.append("<optgroup label=\"" + areaName + "\">\r\n");

                tmpAreaName = areaName;
            }

            content.append("\t<option label=\"" + prefName + "\"" + "value=\"" + prefCd + "\"");

            // 基本設定値の処理
            if (StringUtils.isNotEmpty(fixValue) && fixValue.equals(prefCd)) {
                content.append(" selected");
            }
            content.append(">" + prefName + "</option>\r\n");
        }
        content.append("</optgroup>\r\n");
        content.append("</select>\r\n");

        // jspへの書き出し
        try {
            pageContext.getOut().print(content.toString());
            return SKIP_BODY;
        } catch (IOException e) {
            throw new JspException(e);
        }
    }

    /**
     * ドロップダウンリストの名前を設定します。
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * onChangeを設定する
     * @param onChange
     */
    public void setOnChange(String onChange) {
        this.onChange = onChange;
    }

    /**
     * 基本設定値を設定します。
     * @param fixValue
     */
    public void setFixValue(String fixValue) {
        this.fixValue = fixValue;
    }
}
