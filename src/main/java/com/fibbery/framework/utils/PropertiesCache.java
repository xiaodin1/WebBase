package com.fibbery.framework.utils;

import com.fibbery.framework.constant.ConfigNode;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;

/**
 * 缓存了classpath下面不同模块的xml
 * Created by jiangnenghua on 2016/8/18.
 */
public class PropertiesCache {

    static class ElementFilter implements Predicate<Element> {

        private String attrName;

        private String attrValue;

        public ElementFilter(String attrName, String attrValue) {
            this.attrName = attrName;
            this.attrValue = attrValue;
        }

        @Override
        public boolean test(Element element) {
            if (element == null || element.attribute(attrName) == null) return true;
            return !StringUtils.cnull(element.attribute(attrName).getValue()).equals(attrValue);
        }
    }

    private static final Logger logger = LoggerFactory.getLogger(PropertiesCache.class);

    private static PropertiesCache cache;

    private static final String PATH = "config.xml";

    private static final String SEPERATOR = "@";

    private ConcurrentHashMap<String, String> propertiesCache;

    //该文件最后修改时间
    private static long lastModifyTime;

    //读取配置文件的间隔时间
    private static int interval = 5;


    private PropertiesCache() {
        this.propertiesCache = new ConcurrentHashMap<String, String>();
        Timer time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                parseXML();
            }
        }, 1 * 60 * 1000, 5 * 60 * 1000);
    }

    /**
     * 获取所有的值
     */
    private void parseXML() {
        parseXML(StringUtils.STRING_EMPTY);
    }

    /**
     * 梳理某个module的值
     *
     * @param moduleValue
     */
    private void parseXML(String moduleValue) {
        URL url = Thread.currentThread().getContextClassLoader().getResource(PATH);
        File file = null;
        try {
            file = new File(url.toURI().getPath());
        } catch (URISyntaxException e) {
            logger.error(e.getMessage());
            throw new RuntimeException();
        }

        if (file == null || !file.exists()) return;
        long modifyTime = file.lastModified();
        if (modifyTime == lastModifyTime) {
            logger.info("config file is not modify, so don`t need reload");
            return;
        } else {
            logger.info("config file is modify,reload!");
        }
        SAXReader reader = new SAXReader();
        Document doc = null;
        try {
            doc = reader.read(file);
            Element root = doc.getRootElement();
            List<Element> modules = root.elements(ConfigNode.MODULE);
            modules.removeIf(new ElementFilter(ConfigNode.ATTR_NAME, moduleValue));
            for (Element module : modules) {
                List<Element> properties = module.elements(ConfigNode.PROPERTY);
                for (Element property : properties) {
                    String key = SEPERATOR.join(module.attributeValue(ConfigNode.ATTR_NAME), property.attributeValue(ConfigNode.ATTR_NAME));
                    propertiesCache.put( key, property.getStringValue());
                }
            }

        } catch (DocumentException e) {
            logger.error(e.getMessage());
            throw new RuntimeException();
        }

        lastModifyTime = modifyTime;
    }

    public static PropertiesCache getInstance() {
        if (cache == null) cache = new PropertiesCache();
        return cache;
    }

    public String getProperty(String module, String property) {
        String key = SEPERATOR.join(module, property);
        if (!propertiesCache.contains(key)) {
            parseXML(module);
        }
        return StringUtils.cnull(propertiesCache.get(key));
    }


    public static void main(String[] args) {
        System.out.println(PropertiesCache.getInstance().getProperty("tiket", "tiketQueryUrl"));
    }
}
