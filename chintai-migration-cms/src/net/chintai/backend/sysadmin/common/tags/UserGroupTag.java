/*
 * $Id: UserGroupTag.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/09/20  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.common.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import net.chintai.backend.sysadmin.common.service.CustomTagService;
import net.chintai.backend.sysadmin.common.tags.domain.UserGroupDomain;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * グループのドロップダウンリストを生成するカスタムタグ。
 * 
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserGroupTag extends TagSupport {

    /** serialVersionUID */
    private static final long serialVersionUID = -4183203622656857078L;

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
        List rsList = service.userGroupListService();

        // JSPに書き出す内容作成
        UserGroupDomain domain;
        String id;
        String grpName;

        StringBuilder content = new StringBuilder();
        content.append("<select name=\"" + name + "\">\r\n");

        for (int i = 0; i < rsList.size(); i++) {
            domain = (UserGroupDomain) rsList.get(i);
            id = String.valueOf(domain.getId());
            grpName = domain.getName();

            if (StringUtils.isNotEmpty(fixValue) && fixValue.equals(id)) {
                content.append("\t<option label=\"" + grpName + "\"" + "value=\"" + id
                        + "\" selected >" + grpName + "</option>\r\n");
            } else {
                content.append("\t<option label=\"" + grpName + "\"" + "value=\"" + id + "\">"
                        + grpName + "</option>\r\n");
            }
        }
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
     * 基本設定値を設定します。
     * @param fixValue
     */
    public void setFixValue(String fixValue) {
        this.fixValue = fixValue;
    }
}
