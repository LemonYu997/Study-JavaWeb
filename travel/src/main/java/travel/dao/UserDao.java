package travel.dao;

import travel.domain.User;

public interface UserDao {
    /**
     * 根据用户名查询用户信息
     * */
    public User findByUsername(String username);

    /**
     * 用户保存
     **/
    public void save(User user);

    /**
     * 根据激活码查找用户
     * */
    User findByUserCode(String code);

    /**
     * 更新激活码状态
     * */
    void updateStatus(User user);

    /**
     * 用户登录时根据用户名和密码查询
     * */
    User findByUsernameAndPassword(String username, String password);
}
