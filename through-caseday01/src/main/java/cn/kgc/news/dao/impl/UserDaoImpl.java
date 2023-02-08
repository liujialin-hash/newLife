package cn.kgc.news.dao.impl;

import cn.kgc.news.bean.user;
import cn.kgc.news.dao.BaseDao;
import cn.kgc.news.dao.UserDao;

import java.sql.ResultSet;

public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public user login(String username) throws Exception {

        String sql="select * from user where userName=?";
        Object [] params={username};
        ResultSet rs = query(sql, params);
        user users=null;
        while (rs.next()){
            users=new user();
            users.setId(rs.getInt(1));
            users.setUserName(rs.getString(2));
            users.setPassword(rs.getString(3));
            users.setEmail(rs.getString(4));
            users.setUserType(rs.getInt(5));

        }
        closeAll(null,null,rs);
        return users;
    }
}
