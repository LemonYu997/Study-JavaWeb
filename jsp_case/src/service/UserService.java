package service;

import domain.User;

import java.util.List;

/**
 * 用户管理的业务接口
 * */
public interface UserService {
    /**
     * 查询所有用户信息
     * */
    public List<User> findAll();

    /**
     * 用户登录
     * */
    public User login(User user);

    /**
     * 保存User
     * */
    void addUser(User user);

    /**
     * 根据id删除User
     * */
    void deleteUser(String id);

    /**
     * 根据id查询
     * */
    User findUserById(String id);

    /**
     * 修改用户信息
     * */
    void updateUser(User user);

    /**
     * 批量删除选中用户
     * */
    void delSelectedUser(String[] ids);
}
