package com.fibbery.framework.tag.div;

import com.fibbery.framework.tag.BaseTag;
import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2016/7/8.
 */
public class InputTag extends BaseTag {
    private static final Logger logger = Logger.getLogger(PageTag.class);


    private static final String CATEGORY_STRING = "div";

    @Override
    public String getCategory() {
        return CATEGORY_STRING;
    }

    @Override
    public void writeProperties() {

    }
}
