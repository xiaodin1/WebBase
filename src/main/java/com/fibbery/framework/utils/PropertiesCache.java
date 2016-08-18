package com.fibbery.framework.utils;

/**
 * 缓存了classpath下面不同模块的xml
 * Created by jiangnenghua on 2016/8/18.
 */
public class PropertiesCache {

    private static PropertiesCache cache;

    private static final String PATH = "config.xml";


    private PropertiesCache(){

    }

    public static PropertiesCache getInstance(){
        if(cache == null) cache = new PropertiesCache();
        return cache;
    }
}
