package com.fibbery.tiket.utils;

import com.fibbery.framework.utils.PropertiesCache;

import java.io.*;
import java.net.URL;

/**
 * 获取12306里面station的信息并存储
 * Created by jiangnenghua on 2016/8/18.
 */
public class StationCache {

    private static final String MODULE = "tiket";

    private static final String property = "stationFileUrl";

    private static final String FILE_URL = PropertiesCache.getInstance().getProperty(MODULE,property);

    public void refresh(){
       /**todo 刷新过程:1.从远端Url获取数据存储到本地文件,从数据库取出存储上次获取的文件的信息(MD5+SHA1加密文件),两两对比,如果不相同
        * todo 则把新文件中的值存储到对应数据库中 **/
    }

    public static void main(String[] args) throws IOException {
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
}
