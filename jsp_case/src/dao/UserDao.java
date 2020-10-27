package dao;

import domain.User;

import java.util.List;

/**
 * 用户操作的DAO
 * */
public interface UserDao {
    /**
     * 用户列表
     * */
    public List<User> findAll();

    /**
     * 用户登录
     * */
    public User findUserByUsernameAndPassword(String username, String password);

    /**
     * 添加用户
     * */
    void add(User user);

    /**
     * 删除用户
     * */
    void delete(int parseInt);

    /**
     * 根据id查找用户
     * */
    User findById(int parseInt);

    /**
     * 修改用户信息
     * */
    void update(User user);
}
