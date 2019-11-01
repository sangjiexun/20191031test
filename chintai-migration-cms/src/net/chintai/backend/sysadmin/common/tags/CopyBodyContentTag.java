package net.chintai.backend.sysadmin.common.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;


/**
 * CopyBodyContentTag<br />
 * Body  をコピーします
 */
public class CopyBodyContentTag extends BodyTagSupport {
    /** serialVersionUID */
    private static final long serialVersionUID = 1711266755609022437L;
    private String name;
    private boolean outputThis = true;

    /* (非 Javadoc)
    * @see javax.servlet.jsp.tagext.BodyTagSupport#doAfterBody()
    */
    @Override
    public int doAfterBody() throws JspException {
        final BodyContent body = getBodyContent();

        pageContext.getRequest().setAttribute(name, body.getString());

        if (outputThis) {
            final JspWriter out = body.getEnclosingWriter();

            try {
                out.print(body.getString());
            } catch (final IOException e) {
                throw new JspException(e);
            }
        }

        return SKIP_BODY;
    }

    /* (non-Javadoc)
     * @see javax.servlet.jsp.tagext.BodyTagSupport#release()
     */
    @Override
    public void release() {
        outputThis = true;
        name = null;
        super.release();
    }

    /**
     * outputThis を戻します。
     * @return boolean outputThis
     */
    public boolean isOutputThis() {
        return outputThis;
    }

    /**
     * outputThis を設定。
     * @param boolean outputThis
     */
    public void setOutputThis(boolean outputThis) {
        this.outputThis = outputThis;
    }

    /**
    * name を戻します。
    * @return String name
    */
    public String getName() {
        return name;
    }

    /**
     * name を設定。
     * @param String name
     */
    public void setName(String name) {
        this.name = name;
    }
}
