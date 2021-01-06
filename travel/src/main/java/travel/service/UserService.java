package travel.service;

import travel.domain.User;

public interface UserService {
    /**
     * 注册用户
     * */
    boolean regist(User user);

    /**
     * 激活用户
     * */
    boolean active(String code);

    /**
     * 登录用户
     * */
    User login(User user);
}
