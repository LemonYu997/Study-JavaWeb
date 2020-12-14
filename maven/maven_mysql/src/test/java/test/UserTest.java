package test;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import org.junit.Test;

import java.util.List;

public class UserTest {
    @Test
    public void findAll() throws Exception{
        UserDao userDao = new UserDaoImpl();
        List<User> list = userDao.findAll();
        for (User user : list) {
            System.out.println(user.getUsername());
        }
    }
}
