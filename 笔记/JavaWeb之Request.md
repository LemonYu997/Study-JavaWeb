# JavaWeb之Request

# 一、原理

## 1、Request/Response原理

Request对象和Response对象的原理：

+ request和response对象是由服务器创建的。

+ request对象是类获取请求消息，response对象是来设置响应消息。

![原理](C:\Users\14455\Desktop\笔记\Image\request\原理.png)

## 2、request对象继承体系结构

ServletRequest	接口

​	|	继承

HttpServletRequest	接口

​	|	实现

org.apache.catalina.connector.RequestFacade 类（tomcat）

# 二、request功能

## 1 获取请求消息数据

### 1.1 获取请求行数据

+ GET /Tomcat/requestDemo01?name=zhangsan HTTP/1.1

```java
package web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * 演示Request对象获取请求数据
 * 1、获取请求方式：GET
 *      String getMethod()
 * 2、（重点）获取虚拟目录：tomcat
 *      String getContextPath()
 * 3、获取Servlet路径：/demo01
 *      String getServletPath()
 * 4、获取GET方式请求参数：name=zhangsan
 *      String getQueryString()
 * 5、（重点）获取请求URI：tomcat/demo01
 *      String getRequestURI()：/tomcat/demo01
 *      String getRequestURL()：http://localhost/tomcat/demo01
 * 6、获取协议及版本：HTTP/1.1
 *      String getProtocol()
 * 7、获取客户机的IP地址：
 *      String getRemoteAddr()
 * */
@WebServlet("/requestDemo01")
public class Demo01Request extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取请求方式：GET
        String method = request.getMethod();
        System.out.println(method);
        //2、（重点）获取虚拟目录：/Tomcat
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        //3、获取Servlet路径：/requestDemo01
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        //4、获取GET方式请求参数：name=zhangsan
        String queryString = request.getQueryString();
        System.out.println(queryString);
        //5、（重点）获取请求URI：/Tomcat/requestDemo01
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        //6、获取协议及版本：HTTP/1.1
        String protocol = request.getProtocol();
        System.out.println(protocol);
        //7、获取客户机的IP地址：0:0:0:0:0:0:0:1
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);
    }
}
```

### 1.2 获取请求头数据

+ String getHeader(String name)：通过请求头的名称获取请求头的值
+ Enumeration<String> getHeaderNames()：获取所有的请求头名称

```java
package web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/*
 * 演示获取请求头数据
 * String getHeader(String name)：通过请求头的名称获取请求头的值
 * Enumeration<String> getHeaderNames()：获取所有的请求头名称
 * */
@WebServlet("/requestDemo02")
public class Demo02Request extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取所有请求头名称
        Enumeration<String> headerNames = request.getHeaderNames();
        //遍历
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            //2、(重点)通过请求头的名称获取请求头的值
            String value = request.getHeader(name);
            System.out.println(name+"---"+value);
        }
    }
}
```

获取请求头数据：user-agent

```java
package web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo03")
public class Demo03Request extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求头数据：user-agent
        String agent = request.getHeader("user-agent");
        //判断agent的浏览器版本
        if (agent.contains("Chrome")) {
            //谷歌
            System.out.println("谷歌来了");
        } else if (agent.contains("Firefox")) {
            //火狐
            System.out.println("火狐来了");
        }
    }
}
```

获取请求头数据：referer，防盗链功能

```java
package web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo04")
public class Demo04Request extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求头数据：referer
        String referer = request.getHeader("referer");
        System.out.println(referer);        //链接来源
        //防盗链操作
        if(referer != null){
            if(referer.contains("/Tomcat")) {
                //正常访问
                System.out.println("播放电影..");
            } else {
                //盗链
                System.out.println("想看电影请来XXXX");
            }
        }
    }
}
```

### 1.3 获取请求体数据

+ 请求体：只有POST请求方式，才有请求体，在请求体中封装了POST请求的请求参数
+ 步骤：
  + 获取流对象
    + BufferedReader getReader()：获取字符输入流，只能操作字符数据
    + ServletInputStream getInputStream()：获取字节输入流，可以操作所有类型数据
      + 在文件上传知识点后讲解
  + 再从流对象中拿数据

```java
package web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/requestDemo05")
public class Demon05Request extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求消息体       请求参数
        //1、获取字符流
        BufferedReader br = request.getReader();
        //2、读取数据
        String line = null;
        while((line = br.readLine()) != null) {
            System.out.println(line);	//username=zhangsan&password=123
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
```

## 2、其他功能

### 2.1 获取请求参数通用方式

不论GET还是POST请求方式都可以使用下列方法来获取请求参数

+ String getParameter(String name)：根据参数名称获取参数值 username=zhangsan&password=123

+ String[] getParameterValues(String name)：根据参数名称获取参数值的数组 hobby=xx&hobby=game

+ Enumeration<String> getParameterNames()：获取所有请求的参数名称 

+ Map<String, String[]> getParameterMap()：获取所有参数的map集合 

  ```java
  package web.request;
  
  import javax.servlet.ServletException;
  import javax.servlet.annotation.WebServlet;
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest;
  import javax.servlet.http.HttpServletResponse;
  import java.io.BufferedReader;
  import java.io.IOException;
  import java.util.Enumeration;
  import java.util.Map;
  import java.util.Set;
  
  @WebServlet("/requestDemo06")
  public class Demo06Request extends HttpServlet {
      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          //post 获取请求参数
          //1、根据参数名称获取参数值
          String username = request.getParameter("username");
          System.out.println("post");
          System.out.println(username);
          //2、根据参数获取值的数组
          String[] hobbies = request.getParameterValues("hobby");
          for (String hobby : hobbies) {
              System.out.println(hobby);
          }
          System.out.println("--------------");
          //3、获取所有参数的请求名称
          Enumeration<String> parameterNames = request.getParameterNames();
          while (parameterNames.hasMoreElements()){
              String name = parameterNames.nextElement();
              System.out.println(name);
              String value = request.getParameter(name);
              System.out.println(value);
              System.out.println("--------------");
          }
          //4、获取所有参数的map集合
          Map<String, String[]> parameterMap = request.getParameterMap();
          //遍历
          Set<String> keySet = parameterMap.keySet();
          for (String name : keySet) {
              //根据键获取值
              String[] values = parameterMap.get(name);
              System.out.println(name);
              for (String value : values) {
                  System.out.println(value);
              }
              System.out.println("--------------------");
          }
      }
      protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //get 获取请求参数
          /*        //根据参数名称获取参数值
          String username = request.getParameter("username");
          System.out.println( "post");
          System.out.println(username);*/
              //只用写一份代码
      this.doPost(request, response);
  }
  ```

### 2.2 中文乱码问题

GET方式：tomcat8已经将GET方式乱码问题解决了

POST方式：会乱码

解决：在获取参数前，设置request的编码request.setCharacterEncoding("utf-8");

```java
package web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo07")
public class Demo07Request extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置流的编码
        request.setCharacterEncoding("utf-8");	//防止乱码
        //获取请求参数username
        String username = request.getParameter("username");
        System.out.println(username);		
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
```

### 2.3 请求转发

**请求转发**：一种在服务器内部的资源跳转方式

步骤：

+ 通过request对象获取请求转发器对象：RequestDispatcher getRequestDispatcher(String path)
+ 使用RequestDispatcher对象来进行转发：forward(ServletRequest request, ServletResponse response)

特点：

+ 浏览器地址栏路径不发生变化
+ 只能转发到当前的服务器内部资源中
+ 转发是一次请求

```java
package web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo08")
public class Demo08Request extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo888888被访问了");
        //转发到demo9资源
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/requestDemo09");
//        requestDispatcher.forward(request, response);
        request.getRequestDispatcher("/requestDemo09").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
```

### 2.4 共享数据

**域对象：**一个有作用范围的对象，可以在范围内共享数据。

**request域：**代表一次请求的范围，一般用于请求转发的多个资源中共享数据

方法：

+ setAttribute(String name, Object obj)：存储数据
+ Object getAttribute(String name)：通过键获取值
+ removeAttribute(String name)：通过键移出键值对

```java
package web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo08")
public class Demo08Request extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo888888被访问了");
        //转发到demo9资源
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/requestDemo09");
//        requestDispatcher.forward(request, response);

        //存储数据到request域中
        request.setAttribute("msg", "hello");

        request.getRequestDispatcher("/requestDemo09").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
```

```java
package web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo09")
public class Demo09Request extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo9999999被访问了");

        //获取数据
        Object msg = request.getAttribute("msg");
        System.out.println(msg);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
```

### 2.5 获取ServletContext

servletContext getservletContext()：

```java
package web.request;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo10")
public class Demo010Request extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
        System.out.println(servletContext);
        //org.apache.catalina.core.ApplicationContextFacade@4a188ce7
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
```

# 三、登录案例

## 1、需求

1、编写login.html登录界面

​	username&password两个输入框

2、使用Druid数据库连接池技术，操作mysql，test数据库中的user表

3、使用JDBCTemplate技术封装到JDBC

4、登录成功跳转到SuccessServlet展示：登陆成功！用户名，欢迎您

5、登录失败跳转到FailServlet展示：登录失败，用户名或密码错误

## 2、分析和实现

### 2.1 创建项目

创建项目，导入html页面、配置文件、jar包

login.html中form表单action路径的写法：虚拟目录+Servlet的资源路径

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form action="/login_test/loginServlet" method="post">
        用户名:<input type="text" name="username"> <br>
        密码:<input type="password" name="password"><br>

        <input type="submit" value="登录">

    </form>
</body>
</html>
```

### 2.2 创建数据库环境

![案例分析](C:\Users\14455\Desktop\笔记\Image\request\案例分析.png)

```mysql
CREATE DATABASE test;
USE test;

CREATE TABLE USER(
		id INT PRIMARY KEY AUTO_INCREMENT,
		username VARCHAR(32) UNIQUE NOT NULL,
		password VARCHAR(32) NOT NULL
);

INSERT INTO USER VALUES(1, "superuser", "123456");
```

### 2.3 创建domain包，创建类User 

```java
package main;

/*
 * 用户的实体类JavaBean
 * */
public class User {
    private int id;
    private String username;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
```

JDBC工具类

```java
package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC工具类，使用Druid连接池
 * */
public class JDBCUtils {

    private static DataSource ds;

    static {
        try {
            //1、加载配置文件
            Properties pro = new Properties();
            //使用ClassLoader加载配置文件，获取字节输入流
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);

            //2、初始化连接池对象
            ds = DruidDataSourceFactory.createDataSource(pro);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接池对象
     * */
    public static DataSource getDataSource(){
        return ds;
    }


    /**
     * 获取连接Connection对象
     * */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
```

配置文件

```properties
#mysql5.0+版本
#driverClassName=com.mysql.jdbc.Driver
#url=jdbc:mysql://localhost:3306/test

#mysql8.0+版本
driverClassName=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC
username=root
password=root
initialSize=5
maxActive=10
maxWait=3000
```

### 2.4 创建dao包，创建类UserDao，提供login的方法

```java
package dao;

import main.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

/**
 * 操作数据库中User表的类
 * */
public class UserDao {

    //声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 登陆方法
     * @param loginUser 只有用户名和密码
     * @return User 用户全部数据
     * */
    public User login(User loginUser) {
        try {
            //1、编写sql
            String sql = "select * from user where username = ? and password = ?";
            //2、调用query方法
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());
            return user;        //查找出数据
        } catch (DataAccessException e) {
            e.printStackTrace();    //记录日志
            return null;        //没找到对应数据
        }
    }
}
```

测试：

```java
package test;

import dao.UserDao;
import main.User;
import org.junit.Test;	//没有的话要自己导包

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
```

### 2.5 编写web.servlet.LoginServlet类

```java
package web.servlet;

import dao.UserDao;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、设置编码
        req.setCharacterEncoding("utf-8");
        //2、获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //3、封装user对象
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);
        //4、调用UserDao的login方法
        UserDao dao = new UserDao();
        User user = dao.login(loginUser);
        //5、判断user
        if (user == null) {
            //登录失败，请求转发
            req.getRequestDispatcher("/failServlet").forward(req, resp);
        } else {
            //登录成功，存储数据
            req.setAttribute("user", user);
            //转发successServlet
            req.getRequestDispatcher("/successServlet").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
```

### 2.6 成功页面和失败页面

```java
package web.servlet;

import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取request域中共享的user对象
        User user = (User) request.getAttribute("user");

        if(user != null) {
            //给页面写一句话
            //设置编码
            response.setContentType("text/html;charset=utf-8");
            //输出
            response.getWriter().write("登录成功！" + user.getUsername() + "，欢迎您");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
```

```java
package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/failServlet")
public class FailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //给页面写一句话
        //设置编码
        response.setContentType("text/html;charset=utf-8");
        //输出
        response.getWriter().write("登录失败，用户名或密码错误");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
```

# 四、 BeanUtils

## 1、基本使用

BeanUtils工具类，简化数据封装，导包commons-beanutils-1.8.0.jar

```java
package web.servlet;

import dao.UserDao;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、设置编码
        req.setCharacterEncoding("utf-8");

/*        //2、获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //3、封装user对象
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);*/

        //2、获取所有请求参数
        Map<String, String[]> map = req.getParameterMap();
        //3、创建User对象
        User loginUser = new User();
        //3.1使用BeanUtils封装
        try {
            BeanUtils.populate(loginUser, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //4、调用UserDao的login方法
        UserDao dao = new UserDao();
        User user = dao.login(loginUser);

        //5、判断user
        if (user == null) {
            //登录失败，请求转发
            req.getRequestDispatcher("/failServlet").forward(req, resp);
        } else {
            //登录成功，存储数据
            req.setAttribute("user", user);
            //转发successServlet
            req.getRequestDispatcher("/successServlet").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
```

## 2、JavaBean

**JavaBean：**标准的Java类 

要求：

+ 类必须被public修饰
+ 必须提供空参的构造器
+ 成员变量必须使用private修饰
+ 提供公共setter和getter方法

功能：封装数据

概念：

+ 成员变量：类中定义的变量，整个类中都可以访问，有默认初始化值
+ **属性：**setter和getter方法截取后的产物
  + 例如：getUsername()-->Username-->username

```java
    private String gender;						//成员变量：gender
    public void setHehe(String gender) {		//属性：hehe
        this.gender = gender;
    }
	public String getHehe() {		//属性：hehe
        return gender;
    }
```

## 3、方法

1、setProperty(Object bean, String name, Object value)：将值放入对象的指定属性中

2、getProperty(Object bean, String name)：获得对象中指定属性的值

3、populate(Object objm, Map map)：将map集合的键值对信息，封装到对应的JavaBean对象中

```java
package test;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class BeanUtilsTest {

    @Test
    public void test() {
        User user = new User();

        try {
            //在这里hehe是属性
            BeanUtils.setProperty(user, "hehe", "male");
            System.out.println(user);
            //User{id=0, username='null', password='null', gender='male'}
            String gender = BeanUtils.getProperty(user, "hehe");
            System.out.println(gender); //male
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
```