# Web服务器之Servlet

# 一、概述

## 1、概念

Servlet：Server Applet，运行在服务器端的小程序。Servlet就是一个接口，定义了Java类被浏览器访问到（tomcat识别）的规则

将来自定义一个类，实现Servlet接口，复写方法，tomcat就可以识别。

![动态资源](Img\servlet\动态资源.png)

## 2、快速入门

+ 创建JavaEE项目

+ 定义一个类，实现Servlet接口

+ 实现接口中的抽象方法
+ 配置Servlet：在web.xml文件中配置

```java
//Servlet实现类
package web.servlet;

import javax.servlet.*;
import java.io.IOException;

/*
 * Servlet快速入门
 * */
public class Demo01Servlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //提供服务的方法
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello Servlet");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
         version="3.1">
    <!--配置Servlet-->
    <servlet>
        <servlet-name>demo01</servlet-name>
        <servlet-class>web.servlet.Demo01Servlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>demo01</servlet-name>
        <url-pattern>/demo01</url-pattern>
    </servlet-mapping>
</web-app>
```

## 3、执行原理

1、当服务器接收到客户端的请求后，会解析请求的URL路径，获取访问的Servlet的资源路径

2、查找web.xml文件，是否有对应的<url-pattern>标签体内容

3、如果有，则再找到对应的<servlet-class>全类名

4、tomcat会将字节码文件加载进内存，并且创建其对象

5、调用其方法

![执行原理](Img\servlet\执行原理.png)

# 二、Servlet基础

## 1、生命周期

生命周期：

+ 被创建：执行init方法，只执行一次
  + Servlet什么时候被创建？
    + 默认情况下，第一次被访问时，Servlet被创建
    + 可以配置执行Servlet的执行时机
  + Servlet的init方法，只执行一次，说明一个Servlet在内存中只存在一个对象，Servlet是单例的
    + 多个用户同时访问时，可能存在线程安全问题
    + 解决：尽量不要在Servlet中定义成员变量，即使定义了成员变量，也不要修改其值

```xml
在<Servlet>标签下配置
1、第一次被访问时，创建
    <load-on-startup>的值为负数
2、在服务器启动时，创建
    <load-on-startup>的值为0或正整数
```

+ 提供服务：执行service方法，执行多次
  + 每次访问Servlet时，Service方法都会被调用一次
+ 被销毁：执行destroy方法，执行一次
  + Servlet被销毁时执行，服务器关闭时，Servle被销毁。
  + 只有服务器正常关闭时才会执行，才会执行destroy方法
  + destroy方法在Servlet被销毁之前执行，一般用于释放资源

```java
package web.servlet;

import javax.servlet.*;
import java.io.IOException;

/*
 * Servlet的方法
 * */
public class Demo02Servlet implements Servlet {

    /*
     * 初始化方法
     * 在Servlet被创建时执行，只会执行一次
     * */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init...");
    }

    /*
     * 获取ServletConfig对象
     * ServletConfig：Servlet的配置对象
     * */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /*
     * 提供服务方法
     * 每一次Servlet被访问时执行，执行多次
     * */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service...");
    }
    
    /*
     * 获取Servlet的一些信息
     * 版本、作者等等
     * */
    @Override
    public String getServletInfo() {
        return null;
    }

    /*
     * 销毁方法
     * 在Servlet被杀死时（服务器正常关闭）执行，执行一次
     * */
    @Override
    public void destroy() {
        System.out.println("destroy...");
    }
}
```

## 2、Servlet3.0注解配置

好处：支持注解配置，可以需要web.xml

步骤：

+ 创建JavaEE项目，选择Servlet的版本3.0以上，可以不创建web.xml
+ 定义一个类，实现Servlet接口
+ 复写方法
+ 在类上使用@WebServlet注解，进行配置
  + @WebServlet("资源路径")

@WebServlet注解源码：

```java
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package javax.servlet.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebServlet {
    String name() default "";

    String[] value() default {};

    String[] urlPatterns() default {};

    int loadOnStartup() default -1;

    WebInitParam[] initParams() default {};

    boolean asyncSupported() default false;

    String smallIcon() default "";

    String largeIcon() default "";

    String description() default "";

    String displayName() default "";
}
```

```java
package web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/*
 * 注解配置
 * */
//@WebServlet(urlPatterns = "/demo03")，下边是简化写法
@WebServlet("/demo03")
public class Demo03Servlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("test");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
```

## 3、IDEA与Tomcat的相关配置

IDEA会为每一个tomcat部署的项目单独建立一份配置文件。

![](Img\servlet\tomcat配置.png)

根据IDEA图形化界面修改的配置生成对应的配置文件。

工作空间项目 和 tomcat部署的web项目

+ tomcat真正访问的是“tomcat部署的web项目”，“tomcat部署的web项目”对应着“工作空间项目”的web目录下的所有资源
+ **WEB-INF目录下的资源不能被浏览器直接访问**，静态资源不要直接放在WEB-INF下

![tomcat项目](Img\servlet\tomcat项目.png)

tomcat的断点调试：使用小虫子（debug）启动

![debug](Img\servlet\debug.png)

## 4、Servlet的体系结构

Servlet接口

+ Servlet的子类GenericServlet抽象类：将Servlet接口中其他方法做了默认空实现，只将service()方法作为抽象
  + 将来定义Servlet类时，可以继承GenericServlet，实现service()方法即可
+ GenericServlet抽象类的子类HttpServlet抽象类：对http协议的一种封装，简化操作
  + 定义类继承HttpServlet
  + 复写doGet/doPost方法

```java
package web.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/*
 * Servlet的子类GenericServlet
 * 只用复写service方法
 * */
@WebServlet("/demo05")
public class Demo05Servlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("demo05 GenericServlet...");
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

/*
 * HttpServlet
 */
@WebServlet("/demo06")
public class Demo06Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
    }
}
```

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>login</title>
</head>
<body>
<form action="/Tomcat/demo06" method="post">
    <input name="username">
    <input type="submit" value="提交">
</form>
</body>
</html>
```

## 5、Servlet相关配置

urlPatterns：Servlet访问路径

+ 一个Servlet可以定义多个访问路径
+ 路径定义规则：
  + /xxx
  + /xxx/xxx：目录结构
  + *.xxx

```java
package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * urlPatterns路径配置
 * */
@WebServlet({"/demo07", "/d/d7", "/dd/*","*.do"})
public class Demo07Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo07...");
    }
}
```

# 三、HTTP

## 1、概述

**HTTP：**Hyper Text Transfer Protocol 超文本传输协议

传输协议：定义了客户端和服务器端通信时，发送数据的格式

特点：

+ 基于TCP/IP的高级协议
+ 默认端口号是80
  + http://www.baidu.com:80
  + 基于端口号80
  + 基于请求/响应模型的：一次请求对应一次响应
  + 无状态的：每次请求之间相互独立，不能交互数据

历史版本：

+ 1.0：每一次请求响应都会建立新的连接
+ 1.1：复用连接

## 2、请求消息数据格式

1、请求行

请求方式 请求url 请求协议/版本

+ 请求方式
  + HTTP有7种请求方式，常用有2种：
    + GET：
      + 请求参数在请求行中，在url后
      + 请求的url长度是由限制的
      + 不太安全
    + POST：
      + 请求参数在请求体中
      + 请求的url长度没有限制
      + 比较安全

2、请求头

请求头名称：请求头值

+ 常见的请求头：
  + User-Agent：浏览器告诉服务器，访问使用的浏览器版本信息
    + 可以在服务器端获取该头的信息，解决浏览器的兼容性问题
  + Referer：http://localhost:8080/Tomcat/login.html
    + 告诉服务器，当前请求从哪里来
    + 作用：
      + 防盗用
      + 统计工作

![referer](Img\servlet\referer.png)

3、请求空行

空行，用于分隔POST请求头和请求体

4、请求体（正文）

封装POST请求消息的请求参数

GET方式没有请求体

```http
POST /Tomcat/demo06 HTTP/1.1
Host: localhost:8080
Connection: keep-alive
Content-Length: 12
Cache-Control: max-age=0
Upgrade-Insecure-Requests: 1
Origin: http://localhost:8080
Content-Type: application/x-www-form-urlencoded
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.75 Safari/537.36 Edg/86.0.622.38
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
Sec-Fetch-Site: same-origin
Sec-Fetch-Mode: navigate
Sec-Fetch-User: ?1
Sec-Fetch-Dest: document
Referer: http://localhost:8080/Tomcat/login.html
Accept-Encoding: gzip, deflate, br
Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6
Cookie: Idea-a9babc01=eec227e0-2f2a-4a2c-8ee4-525a1ae091ed

username=aaa
```

## 3、响应消息数据格式

