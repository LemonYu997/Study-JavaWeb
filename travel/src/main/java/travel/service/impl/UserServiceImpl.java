package travel.service.impl;

import travel.dao.UserDao;
import travel.dao.impl.UserDaoImpl;
import travel.domain.User;
import travel.service.UserService;
import travel.util.MailUtils;
import travel.util.UuidUtil;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    /**
     * 注册用户
     */
    @Override
    public boolean regist(User user) {
        //1、根据用户名查询用户对象
        User u = userDao.findByUsername(user.getUsername());
        //判断u是否为null
        if (u != null) {
            //用户名存在，注册失败
            return false;
        }
        //2、保存用户信息
        //2.1 设置激活码，唯一字符串
        user.setCode(UuidUtil.getUuid());
        //2.2 设置激活状态
        user.setStatus("N");    //Y 激活，N 未激活

        userDao.save(user);

        //3、激活邮件发送，邮件正文，实际部署时超链接按照实际域名来
        String content = "<a href='http://localhost:80/travel/user/active?code=" + user.getCode() + "'>点击激活【旅游网】</a>";
        MailUtils.sendMail(user.getEmail(), content, "激活邮件");
        return true;
    }

    /**
     * 激活用户
     */
    @Override
    public boolean active(String code) {
        //1、根据激活码查询用户对象
        User user = userDao.findByUserCode(code);
        if (user != null) {
            //2、调用dao的修改激活状态的方法
            userDao.updateStatus(user);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 登录用户
     */
    @Override
    public User login(User user) {
        return userDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}
