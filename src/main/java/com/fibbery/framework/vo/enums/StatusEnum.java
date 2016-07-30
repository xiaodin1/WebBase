package com.fibbery.framework.vo.enums;

/**
 * Created by jiangnenghua on 16/7/30.
 */
public enum StatusEnum {
    STATUS_NORMAL(1,"正常"),
    STATUS_DEL(0,"删除");

    private int code;
    private String name;

    private StatusEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
