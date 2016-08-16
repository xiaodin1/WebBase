package com.fibbery.framework.vo.enums;

/**
 * 返回请求结构类型的code
 * Created by jiangnenghua on 2016/8/16.
 */
public enum ResultCodeEnum {
    SUCCESS(0, "请求正常,结果返回正常"), FAIL(1, "请求正常,预料的业务异常"), ERROR(-1, "系统异常,联系管理员解决");

    private String message;
    private int code;

    private ResultCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}