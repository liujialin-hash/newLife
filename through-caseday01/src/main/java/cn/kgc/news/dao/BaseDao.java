package cn.kgc.news.dao;

import cn.kgc.news.util.ConfigManager;

import java.sql.*;

public class BaseDao {

    private ConfigManager getconfig(){
        ConfigManager configManager = ConfigManager.getConfigManager();
        return configManager;
    }

    private String driver=getconfig().getValue("driver");
    private String url=getconfig().getValue("url");
    private String username=getconfig().getValue("username");
    private String password=getconfig().getValue("password");

    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;
    //关闭链接
    public void closeAll(Connection con,PreparedStatement pst,ResultSet rs){
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
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //链接数据库
    private Connection getCon(){
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
    //更新
    public String update(String sql,Object[] params){
        con=getCon();
        int count=0;
        String result="";
        try {
            pst=con.prepareStatement(sql);
            if (params!=null){
                for (int i = 0; i < params.length; i++) {
                    pst.setObject(i+1,params[i]);
                }
            }
            count=pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (count!=0){
            System.out.println("操作成功");
            result="操作成功";
        }else {
            System.out.println("操作失败");
            result="操作失败";
        }
        closeAll(con,pst,null);
        return result;
    }

    //查询
    public ResultSet query(String sql,Object [] prarms){
        con=getCon();
        try {
            pst=con.prepareStatement(sql);
            if (prarms!=null){
                for (int i = 0; i < prarms.length; i++) {
                    pst.setObject(i+1,prarms[i]);
                }
            }
             rs = pst.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }




}
