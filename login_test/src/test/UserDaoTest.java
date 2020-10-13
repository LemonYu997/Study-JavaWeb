package test;

import dao.UserDao;
import domain.User;
import org.junit.Test;  //没有的话要自己导包

/**
 * 测试UserDao类
 * */
public class UserDaoTest {
    @Test
    public void testLogin() {
        User loginuser = new User();
        loginuser.setUsername("superuser");
        loginuser.setPassword("123456");

        UserDao dao = new UserDao();
        User user = dao.login(loginuser);
        System.out.println(user);
    }
}
