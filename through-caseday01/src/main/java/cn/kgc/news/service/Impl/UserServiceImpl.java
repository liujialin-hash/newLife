package cn.kgc.news.service.Impl;

import cn.kgc.news.bean.user;
import cn.kgc.news.dao.UserDao;
import cn.kgc.news.dao.impl.UserDaoImpl;
import cn.kgc.news.service.UserService;
import org.junit.jupiter.api.Test;

public class UserServiceImpl implements UserService {
    UserDao userDao;
    private UserServiceImpl(){
        //父类的引用指向子类的对象
        userDao=new UserDaoImpl();
    }

    @Override
    public user login(String username) throws Exception {
        return userDao.login(username);
    }
    @Test
    public void test(){
        UserService userService=new UserServiceImpl();
        try {
            user login = userService.login("小周");
            System.out.println(login);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
