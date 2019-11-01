/*
 * $Id: ShisyaTag.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/14  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.common.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import net.chintai.backend.sysadmin.common.service.CustomTagService;
import net.chintai.backend.sysadmin.common.tags.domain.ShisyaDomain;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


/**
 * 取引先メンテナンスの担当支社プルダウン作成
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShisyaTag extends TagSupport {

    private static final long serialVersionUID = -4035771519970925974L;

    /** ドロップダウンリストの名前 */
    private String name;

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

        // Get ApplicationContext
        ApplicationContext ac =
                WebApplicationContextUtils.getRequiredWebApplicationContext(pageContext.getServletContext());

        // DB検索
        CustomTagService service = (CustomTagService) ac.getBean("customTagService");
        List rsList = service.getShisyaInfo();

        // JSPに書き出す内容作成
        ShisyaDomain domain;
        String optionValue;
        String optionName;

        StringBuilder content = new StringBuilder();
        content.append("<select name=\"" + name + "\" ");

        // onChange及びstyleなどのオプションを付けるときここにappend

        content.append(">\r\n");

        content.append("<option label=\"\" value=\"\"></option>");
        for (int i = 0; i < rsList.size(); i++) {
            domain = (ShisyaDomain) rsList.get(i);
            optionValue = String.valueOf(domain.getOptionValue());
            optionName = domain.getOptionName();

            if (StringUtils.isNotEmpty(fixValue) && fixValue.equals(optionValue)) {
                content.append("\t<option label=\"" + optionName + "\"" + "value=\"" + optionValue + "\" selected >"
                        + optionName + "</option>\r\n");
            } else {
                content.append("\t<option label=\"" + optionName + "\"" + "value=\"" + optionValue + "\">" + optionName
                        + "</option>\r\n");
            }
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
     * ドロップダウンリストの名前を設定します。
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 基本設定値を設定します。
     * @param fixValue
     */
    public void setFixValue(String fixValue) {
        this.fixValue = fixValue;
    }
}