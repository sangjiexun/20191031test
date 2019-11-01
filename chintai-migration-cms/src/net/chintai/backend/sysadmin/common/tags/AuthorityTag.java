/*
 * $Id: AuthorityTag.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/19  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.common.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import net.chintai.backend.sysadmin.common.service.CustomTagService;
import net.chintai.backend.sysadmin.common.tags.domain.AuthorityTagDomain;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 操作内容プルダウンを生成します。
 * 
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AuthorityTag extends TagSupport {

    private static final long serialVersionUID = 2862326234060851572L;

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
        List rsList = service.getAuthorityService();

        // JSPに書き出す内容作成
        AuthorityTagDomain domain;
        String authorityId;
        String authorityName;

        StringBuilder content = new StringBuilder();
        content.append("<select name=\"" + name + "\" ");

        // onChange入力処理
        if (onChange != null) {
            content.append("onchange=\"" + onChange + "\"");
        }
        content.append(">\r\n");

        content.append("<option label=\"\" value=\"\"></option>");

        if (StringUtils.isNotEmpty(fixValue) && fixValue.equals("00")) {
            content.append("\t<option label=\"共通\" value=\"00\" selected>共通</option>\r\n");
        } else {
            content.append("\t<option label=\"共通\" value=\"00\">共通</option>\r\n");
        }

        for (int i = 0; i < rsList.size(); i++) {
            domain = (AuthorityTagDomain) rsList.get(i);
            authorityId = String.valueOf(domain.getAuthorityId());
            authorityName = domain.getAuthorityName();

            if (StringUtils.isNotEmpty(fixValue) && fixValue.equals(authorityId)) {
                content.append("\t<option label=\"" + authorityName + "\"" + " value=\"" + authorityId + "\" selected>"
                        + authorityName + "</option>\r\n");
            } else {
                content.append("\t<option label=\"" + authorityName + "\"" + " value=\"" + authorityId + "\">"
                        + authorityName + "</option>\r\n");
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
