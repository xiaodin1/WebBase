package com.fibbery.framework.controller;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * 请求结果封装类
 * Created by jiangnenghua on 2016/8/16.
 */

@JsonIgnoreProperties(value={"errorStack"})
public class ResultInfo implements Serializable{

    private static final long serialVersionUID = 1L;

    private int code;

    private Object result;

    private String errorStack;

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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
