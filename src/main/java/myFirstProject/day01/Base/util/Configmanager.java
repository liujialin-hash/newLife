package myFirstProject.day01.Base.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*加载数据库配置文件*/
public class Configmanager {
    //单例
    private static Configmanager configManager;
    //读取.properties文件的帮助类
    private static Properties properties;
    //私有化构造器
    private Configmanager(){
        //读取配置文件的信息到输入流中
        InputStream inputStream = Configmanager.class.getClassLoader().getResourceAsStream("database.properties");
        //将数据加载到propertise
        try {
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Configmanager getInstance(){
    if (configManager==null){
        configManager=new Configmanager();
    }
    return configManager;
    }

    public String getValue(String key){
        String property = properties.getProperty(key);
        return property;
    }

}
