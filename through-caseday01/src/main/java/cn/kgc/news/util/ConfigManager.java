package cn.kgc.news.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    private static ConfigManager configManager;

    private static Properties properties=new Properties();

    private ConfigManager(){
        InputStream inputStream = ConfigManager.class.getClassLoader().getResourceAsStream("database.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static synchronized ConfigManager getConfigManager(){
        if (configManager==null){
            configManager=new ConfigManager();
        }
        return configManager;
    }

    public String getValue(String key){
        String property = properties.getProperty(key);
        return property;
    }


}
