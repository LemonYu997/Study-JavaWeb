package dao;

import domain.User;

import java.util.List;
import java.util.Map;

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

    /**
     * 查询总记录数
     *
     * @param condition*/
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 分页条件查询
     * */
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
