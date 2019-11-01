package net.chintai.backend.sysadmin.common.tags;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.util.ResponseUtils;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;


/**
 * FilterTag<br />
 * Body に org.apache.struts.util.ResponseUtils#filter を適用します
 * @author hasegawa
 * @lastModified $Date: 2007/10/04 14:37:32 $ by $Author: hasegawa $
 * @version $Revision: 1.5 $
 * Copyright(C）CHINTAI Corporation Rights Reserved.
 */
public class FilterTag extends BodyTagSupport {
    /** serialVersionUID */
    private static final long serialVersionUID = -608568060840795583L;
    private boolean changeNL2BR = false;
    //private boolean filter = true;
    //<c:out>でサニタイズするのでここではやらない
    private boolean filter = false;

	/* (非 Javadoc)
    * @see javax.servlet.jsp.tagext.BodyTagSupport#doAfterBody()
    */
    @Override
    public int doAfterBody() throws JspException {
        final BodyContent body = getBodyContent();
        String string = body.getString();
        if (filter) {
        	string = ResponseUtils.filter(string);
        }

		if ("null".equals(string)) {
			string = "";
		}

        final JspWriter out = body.getEnclosingWriter();

        try {
            out.print(StringUtils.trimToEmpty((!changeNL2BR) ? string : string.replaceAll("\r\n|\n|\r", "<br />")));
        } catch (final IOException e) {
            throw new JspException(e);
        }

        return SKIP_BODY;
    }

    /* (non-Javadoc)
     * @see javax.servlet.jsp.tagext.BodyTagSupport#release()
     */
    @Override
    public void release() {
        super.release();
        changeNL2BR = false;
    }

    /**
     * changeNL2BR を戻します。
     * @return boolean changeNL2BR
     */
    public boolean isChangeNL2BR() {
        return changeNL2BR;
    }

    /**
     * changeNL2BR を設定。
     * @param boolean changeNL2BR
     */
    public void setChangeNL2BR(boolean changeNL2BR) {
        this.changeNL2BR = changeNL2BR;
    }

    /**
	 * @return filter を戻します。
	 */
	public boolean isFilter() {
		return filter;
	}

	/**
	 * @param filter 設定する filter。
	 */
	public void setFilter(boolean filter) {
		this.filter = filter;
	}

}
