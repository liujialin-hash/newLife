package cn.kgc.news.dao;

import cn.kgc.news.bean.user;

public interface UserDao {
    public user login(String username) throws Exception;
}
