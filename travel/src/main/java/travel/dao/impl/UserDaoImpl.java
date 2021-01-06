package travel.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import travel.dao.UserDao;
import travel.domain.User;
import travel.util.JDBCUtils;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 根据用户名查询用户信息
     */
    @Override
    public User findByUsername(String username) {
        User user = null;

        //template方法如果没有查询成功会出现异常，try/catch使其返回null
        try {
            //1、定义sql
            String sql = "select * from tab_user where username = ?";
            //2、执行sql
            user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username);
        } catch (Exception e) {

        }

        return user;
    }

    /**
     * 用户保存
     **/
    @Override
    public void save(User user) {
        //1、定义sql
        String sql = "insert into tab_user(username, password, name, birthday, sex, telephone, email, status, code)"
                + "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        //2、执行sql
        template.update(sql, user.getUsername(),
                user.getPassword(),
                user.getName(),
                user.getBirthday(),
                user.getSex(),
                user.getTelephone(),
                user.getEmail(),
                user.getStatus(),
                user.getCode());
    }

    /**
     * 根据激活码查询用户对象
     * */
    @Override
    public User findByUserCode(String code) {
        User user = null;

        try {
            String sql = "select * from tab_user where code = ?";
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), code);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    /**
     * 修改用户激活状态
     * */
    @Override
    public void updateStatus(User user) {
        String sql = "update tab_user set status = 'Y' where uid = ?";
        template.update(sql, user.getUid());
    }

    /**
     * 用户登录时根据用户名和密码查询
     * */
    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user = null;

        //template方法如果没有查询成功会出现异常，try/catch使其返回null
        try {
            //1、定义sql
            String sql = "select * from tab_user where username = ? and password = ?";
            //2、执行sql
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
        } catch (Exception e) {

        }

        return user;
    }
}
