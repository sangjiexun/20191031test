/*
 * $Id: QaCategoryTag.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/02  BGT)劉俊秀   Q&Aカテゴリタグ新規
 *
 */
package net.chintai.backend.sysadmin.common.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import net.chintai.backend.sysadmin.common.properties.SystemProperties;
import net.chintai.backend.sysadmin.common.service.CustomTagService;
import net.chintai.backend.sysadmin.common.tags.domain.MngMstQaCategoryDomain;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Q&Aカテゴリのプルダウンを生成します。
 *
 * @author yoo-junsu
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class QaCategoryTag extends TagSupport {

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
                WebApplicationContextUtils.getRequiredWebApplicationContext(pageContext
                        .getServletContext());

        // DB検索
        CustomTagService service = (CustomTagService) ac.getBean("customTagService");
        List rsList = service.getMngMstQaCategoryService();

        // JSPに書き出す内容作成
        MngMstQaCategoryDomain domain;
        String categoryId;
        String categoryName;

        StringBuilder content = new StringBuilder();
        content.append("<select name=\"" + name + "\" ");

        // onChange入力処理
        if (onChange != null) {
            content.append("onchange=\"" + onChange + "\"");
        }
        content.append(">\r\n");

        content.append("<option label=\"\" value=\"\"></option>");

        for (int i = 0; i < rsList.size(); i++) {
            domain = (MngMstQaCategoryDomain) rsList.get(i);
            domain = qaCategoryConvert(domain);
            categoryId = String.valueOf(domain.getCategoryId());
            categoryName = domain.getCategoryName();

            if (StringUtils.isNotEmpty(fixValue) && fixValue.equals(categoryId)) {
                content.append("\t<option label=\"" + categoryName + "\"" + "value=\""
                        + categoryId + "\" selected >" + categoryName + "</option>\r\n");
            } else {
                content.append("\t<option label=\"" + categoryName + "\"" + "value=\""
                        + categoryId + "\">" + categoryName + "</option>\r\n");
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

    /**
	 * Q&Aカテゴリコード変換処理を行なう
	 * @param code Q&Aカテゴリコード
	 * @return Q&Aカテゴリコード変換値
	 */
	private MngMstQaCategoryDomain qaCategoryConvert(MngMstQaCategoryDomain domain) {
		String result = "";
		String[] names = SystemProperties.getProperty("CATEGORY01_NAME").split(",");
		String[] values = SystemProperties.getProperty("CATEGORY01_VALUE").split(",");
		int idx = 0;
		for (String value : values) {
			if (domain.getCategoryId1().equals(value)) {
				result = names[idx]+"-"+domain.getCategoryName();
				domain.setCategoryName(result);
                break;
			}
			idx++;
		}
		return domain;
	}
}
