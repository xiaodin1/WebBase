package com.fibbery.framework.tag;

import com.fibbery.framework.utils.StringUtils;
import org.apache.log4j.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * 自定义标签的基类,方便统一管理
 * Created by Administrator on 2016/7/8.
 */
public abstract class BaseTag extends TagSupport {

    private static final Logger logger = Logger.getLogger(BaseTag.class);

    private String category;
    private String name;

    public String getCategory() {
        return category;
    }

    public void setCategory(String type) {
        this.category = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*一些通用处理,描绘好头部*/
    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.write("<"+getCategory());
            if(!StringUtils.isEmpty(getId())) {
                out.write(" id='" + getId() + "'");
            }
            if(!StringUtils.isEmpty(getName())) {
                out.write(" name='" + getName() + "'");
            }

            //绘制其他的一些些自带属性
            writeProperties();

            out.write(">");
        } catch (IOException e) {
            logger.error("io error");
            e.printStackTrace();
        }
        return Tag.EVAL_BODY_INCLUDE;
    }

    public abstract void writeProperties();

    @Override
    public int doEndTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.write("</"+getCategory()+">");
        } catch (IOException e) {
            logger.error("io error");
            e.printStackTrace();
        }
       return Tag.EVAL_PAGE;
    }

    @Override
    public int doAfterBody() throws JspException {
        return super.doAfterBody();
    }
}
