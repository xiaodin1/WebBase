package com.fibbery.framework.vo.enums;

/**
 * 后台资源管理类型  1.菜单  2.按钮
 * Created by jiangnenghua on 16/7/30.
 */
public enum ResourceTypeEnum {
    MENU(1,"菜单"), BUTTON(2,"按钮");

    private int code;
    private String name;

    private ResourceTypeEnum(int code, String name) {
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
