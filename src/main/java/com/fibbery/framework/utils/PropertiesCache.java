package com.fibbery.framework.utils;

import com.google.common.collect.Multimap;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 缓存了classpath下面不同模块的xml
 * Created by jiangnenghua on 2016/8/18.
 */
public class PropertiesCache {

    private static final Logger logger = LoggerFactory.getLogger(PropertiesCache.class);

    private static PropertiesCache cache;

    private static final String PATH = "config.xml";

    private static HashMap<String,HashMap<String,String>> content = new HashMap<String,HashMap<String,String>>();

    //该文件最后修改时间
    private static long lastModifyTime;

    //读取配置文件的间隔时间
    private static int interval = 5;



    private PropertiesCache(){
        Timer time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                parseXML();
            }
        },0 , 5*60*1000);
    }

    //获取xml里面的值
    private void parseXML() {
        URL url = Thread.currentThread().getContextClassLoader().getResource(PATH);
        File file = null;
        try {
            file = new File(url.toURI().getPath());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        if(file == null || !file.exists()) return;

        //解析对应的值
    }

    public static PropertiesCache getInstance(){
        if(cache == null) cache = new PropertiesCache();
        return cache;
    }
}
