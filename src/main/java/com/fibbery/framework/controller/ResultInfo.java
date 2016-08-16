package com.fibbery.framework.controller;

import com.fibbery.framework.vo.enums.ResultCodeEnum;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * 请求结果封装类
 * Created by jiangnenghua on 2016/8/16.
 */

@JsonIgnoreProperties(value={"errorStack"})
public class ResultInfo implements Serializable{

    private static final long serialVersionUID = 1L;

    private ResultCodeEnum code;

    private Object result;

    private String errorStack;

    public ResultCodeEnum getCode() {
        return code;
    }

    public void setCode(ResultCodeEnum code) {
        this.code = code;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getErrorStack() {
        return errorStack;
    }

    public void setErrorStack(String errorStack) {
        this.errorStack = errorStack;
    }
}
