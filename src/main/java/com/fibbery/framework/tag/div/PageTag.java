package com.fibbery.framework.tag.div;

import com.fibbery.framework.tag.BaseTag;
import org.apache.log4j.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;

/**
 * Created by Administrator on 2016/7/8.
 */
public class PageTag extends BaseTag {

    private static final Logger logger = Logger.getLogger(PageTag.class);


    private static final String CATEGORY_STRING = "div";

    @Override
    public String getCategory() {
        return CATEGORY_STRING;
    }
    @Override
    public void writeProperties() {
        JspWriter out = pageContext.getOut();
        try {
            out.write(" class='wrapper wrapper-content animated fadeinright'");
        } catch (IOException e) {
            logger.error("io error");
            e.printStackTrace();
        }
    }

    @Override
    public int doEndTag() throws JspException {
        return super.doEndTag();
    }

    @Override
    public int doAfterBody() throws JspException {
        return super.doAfterBody();
    }
}
