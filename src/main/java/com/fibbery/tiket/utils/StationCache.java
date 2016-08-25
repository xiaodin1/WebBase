package com.fibbery.tiket.utils;

import com.fibbery.framework.utils.JdbcUtils;
import com.fibbery.framework.utils.PropertiesCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 获取12306里面station的信息并存储
 * Created by jiangnenghua on 2016/8/18.
 */
public class StationCache {

    private static Logger logger = LoggerFactory.getLogger(StationCache.class);

    private static final String MODULE = "tiket";

    private static final String property = "stationFileUrl";

    private static final String FILE_URL = PropertiesCache.getInstance().getProperty(MODULE,property);

    public void refresh(){
       /**todo 刷新过程:1.从远端Url获取数据存储到本地文件,从数据库取出存储上次获取的文件的信息(MD5+SHA1加密文件),两两对比,如果不相同
        * todo 则把新文件中的值存储到对应数据库中 **/
    }

    /**
     * 获取对应的station文件
     * @throws Exception
     */
    public void downloadStationsFile() throws Exception {
        URL url = new URL(FILE_URL);
        File file = new File("station.txt");
        FileWriter writer = new FileWriter(file);
        InputStream ins = (InputStream) url.getContent();
        BufferedReader br = new BufferedReader(new InputStreamReader(ins));
        String line = "";
        StringBuffer content = new StringBuffer();
        while((line = br.readLine()) != null){
            writer.write(line);
            content.append(line);
        }

        writer.flush();
        writer.close();

    }

    //文件写入表
    public void storeDB() throws Exception {
        StringBuffer content = new StringBuffer();
        File file = new File("station.txt");
        if (file == null || !file.exists()){
            logger.error("获取station.txt文件失败");
        }
        FileReader reader = new FileReader(file);
        char[] buff = new char[1024*4];
        while(reader.read(buff) != -1){
            content.append(buff);
        }
        Pattern pattern = Pattern.compile("@[\\u4e00-\\u9fa5_a-zA-Z0-9_\\|]+\\|{1}\\d+");
        Matcher m = pattern.matcher(content);
        Connection conn = JdbcUtils.getConnection();
        PreparedStatement ps = conn.prepareStatement("\n" +
                "insert into t_ticket_station(shuangpin, name, wubi, quanpin, jianpin, number) values(?, ?, ?, ?, ?, ?)");
        while(m.find()){
            String station = m.group();
            String[] params = station.split("\\|");
            //结构 应该是  @双拼|中文|五笔|全拼|简拼|编码
            ps.setString(1, params[0].substring(1));
            ps.setString(2, params[1]);
            ps.setString(3, params[2]);
            ps.setString(4, params[3]);
            ps.setString(5, params[4]);
            ps.setString(6, params[5]);
            ps.addBatch();
            m.appendReplacement(new StringBuffer(),"");
        }

        ps.executeBatch();
        System.out.println("ending");
    }

    public static void main(String[] args) throws Exception {
        new StationCache().storeDB();
    }

}
