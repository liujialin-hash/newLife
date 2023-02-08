package myFirstProjectDay01;

import myFirstProject.day01.Base.BaseDao;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestMethod01 extends BaseDao {


//    public static void main(String[] args) {
//
//        //声明链接
//        Connection con=null;
//        //声明PreparedStatement用于操作数据库
//        PreparedStatement pst=null;
//        //声明结果集
//        ResultSet rs=null;
//
//        //开始链接驱动
//        try {
//            /*链接驱动*/
//            Class.forName("com.mysql.jdbc.Driver");
//            /*链接数据库*/
//            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school?useUnicode=true&characterEncoding=utf8","root","root");
//            String sql="select * from license_info";
//            pst=con.prepareStatement(sql);
//            rs=pst.executeQuery();
//
//           while (rs.next()){
//               System.out.println(rs.getString(2));
//           }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public void test01(){
        String sql="update license_info set human_name='老郑' where id=1";
//        Object params[]={"刘大胆",1};

        int update = update(null, sql);
        System.out.println(update);
    }

}
