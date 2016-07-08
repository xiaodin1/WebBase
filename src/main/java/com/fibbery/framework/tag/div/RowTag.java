package com.fibbery.framework.tag.div;

import com.fibbery.framework.tag.BaseTag;
import org.apache.log4j.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;

/**
 * Created by Administrator on 2016/7/8.
 */
public class RowTag extends BaseTag {

    private static final Logger logger = Logger.getLogger(RowTag.class);


    private static final String CATEGORY_STRING = "div";

    @Override
    public int doStartTag() throws JspException {
        return super.doStartTag();
    }

    @Override
    public void writeProperties() {
        JspWriter out = pageContext.getOut();
        try {
            out.write(" class='row'");
        } catch (IOException e) {
            logger.error("io error");
            e.printStackTrace();
        }
    }

    @Override
    public int doEndTag() throws JspException {
        return super.doEndTag();
    }
}
