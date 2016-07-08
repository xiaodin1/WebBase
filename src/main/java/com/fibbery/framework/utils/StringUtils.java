package com.fibbery.framework.utils;

/**
 * 通用字符处理
 * Created by Administrator on 2016/7/8.
 */
public class StringUtils{

    public static final String STRING_EMPTY = "";

    public static boolean isEmpty(Object obj){
        return cnull(obj).equals(STRING_EMPTY);
    }

    public static String cnull(Object obj){
        return obj == null ? STRING_EMPTY : obj.toString().trim();
    }
}
