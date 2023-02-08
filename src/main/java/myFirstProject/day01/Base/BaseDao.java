package myFirstProject.day01.Base;

import myFirstProject.day01.Base.util.Configmanager;

import java.io.InputStream;
import java.sql.*;

public class BaseDao {
    /*驱动地址*/
    private String driver= getInstance().getValue("driver");

    private static Configmanager aaa=Configmanager.getInstance();

    /*
    * 如果报 Unknown initial character set index ‘255‘ received from server. Initial client character 错 添加?useUnicode=true&characterEncoding=utf8
    * 因为字符集不对
    * */
    private String url= getInstance().getValue("url");

    private String username=getInstance().getValue("username");

    private String password=getInstance().getValue("password");

    private Configmanager getInstance() {
        //类中是不可以调用方法的,除非是静态的
        return Configmanager.getInstance();
    }

    /*声明链接*/
    private Connection con=null;

    /*声明pst*/
    private PreparedStatement pst=null;

    /*声明结果集*/
    private ResultSet rs=null;

    /*链接数据库驱动*/
    private Connection getConnection(){
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    /*更新*/
    public int update(Object params[], String sql){
        con = getConnection();
        int count=0;
        try {
            /*将sql和参数加载到驱动中*/
            pst=con.prepareStatement(sql);
            if (params!=null){
                for (int i = 0; i < params.length; i++) {
                    pst.setObject(i+1,params[i]);
                }
            }
            count=pst.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        if (count!=0){
            System.out.println("操作成功");
        }
        extracted(con,pst,rs);
        return count;
    }

    public ResultSet executeQuery(String sql,Object[] params){
        con=getConnection();
        try {
            pst=con.prepareStatement(sql);
           if (params!=null){
               for (int i = 0; i < params.length; i++) {
                   pst.setObject(i+1,params[i]);
               }
           }
            rs=pst.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }
        extracted(con,pst,rs);
        return rs;
    }



    private void extracted(Connection con,PreparedStatement pst,ResultSet rs) {
        try {
            if (rs!=null){
                rs.close();
            }
            if (pst!=null){
                pst.close();
            }
            if (con!=null){
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
