package dao.impl;

import dao.UserDao;
import domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    public List<User> findAll() throws Exception{
        //把数据库结果集转成java的List集合
        List<User> list = new ArrayList<User>();
        //先获取contection对象
        Connection connection = null;
        //获取真正操作数据的对象
        PreparedStatement pst = null;
        //执行数据库查询操作
        ResultSet rs = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //先获取contection对象
            connection = DriverManager.getConnection("jdbc.mysql://test", "root", "root");
            //获取真正操作数据的对象
            pst = connection.prepareCall("select * from user");
            //执行数据库查询操作
            rs = pst.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
            pst.close();
            rs.close();
        }
        return list;
    }
}
