# Web服务器之Tomcat

# 一、Web回顾

## 1、软件架构

+ C/S：客户端/服务器端
+ B/S：浏览器/服务器端

## 2、资源分类

+ 静态资源：所有用户访问后，得到的结果一样，称为静态资源，可以直接被浏览器解析
  + html/css/javascript
+ 动态资源：每一个用户访问相同资源后，得到的结果可能不一样，需要先转换为静态资源，再返回给浏览器
  + servlet/jsp/php/asp

![资源分类](Img\tomcat\资源分类.png)

## 3、网络通信三要素

+ IP：电子设备（计算机）在网络中的唯一标识
+ 端口：应用程序在计算机中的唯一标识。0~65536
+ 传输协议：规定数据传输的规则
  + TCP：安全协议，三次握手，速度稍慢
  + UDP：不安全协议，速度快

# 二、Web服务器概述

服务器：安装了服务器软件的计算机

服务器软件：接收用户的请求，处理请求，做出响应

Web服务器软件：接收用户的请求，处理请求，做出响应

+ 在Web服务器软件中，可以部署Web项目，让用户通过浏览器来访问这些项目
+ Web容器

Java相关的常见的Web服务器软件：

+ WebLogic：oracle公司，大型JavaEE服务器，支持所有的JavaEE规范，收费的
+ WebSphere：IBM公司，大型JavaEE服务器，支持所有的JavaEE规范，收费的
+ JBOSS：JBOSS公司，大型JavaEE服务器，支持所有的JavaEE规范，收费的
+ Tomcat：Apache基金组织，中小型JavaEE服务器，仅仅支持少量的JavaEE规范，开源的，免费的。

JavaEE：Java语言在企业级开发中使用的技术规范的总和，一共规定了13项大的规范

# 三、Tomcat入门

## 1、下载、安装、卸载

下载：http://tomcat.apache.org/

安装：解压压缩包，目录不要有中文

卸载：删除目录

目录结构：

![目录结构](Img\tomcat\目录结构.png)

## 2、启动和关闭

启动：

+ bin/startup.bat，双击运行
+ 访问：浏览器输入：http://localhost:8080 回车访问
  + http://IP:8080，访问别人的Tomcat

启动中可能遇到的问题：

+ 黑窗口一闪而过

  + 原因：没有正确配置JAVA_HOME环境变量
  + 解决方案：正确配置JAVA_HOME环境变量

+ 启动报错：端口占用

  + 暴力：kill 8080端口进程

  ```shell
  netstat -ano
  #找到8080端口对应的PID(进程ID)
  #打开任务管理器，根据PID找到对应进程，右键结束进程
  ```

  + 温柔：修改自身端口号，不建议
    + 打开配置文件：conf/server.xml，修改其中的冲突port字段（好几个）
    + 一般会将tomcat的默认端口号修改为80，80端口号是http协议的默认端口号
      + 好处：访问时不用输入端口号

关闭：

+ 正常关闭：
  + bin/shutdown.bat 双击
  + 启动窗口中按ctrl+c
+ 强制关闭：点击启动窗口的×

## 3、配置

部署项目的方式：

+ 直接将项目放到webapps目录下

  + localhost:8080/hello：项目的访问路径-->虚拟路径
  + 简化部署：将项目打成war包，再将war包放置到webapps目录下

+ 配置conf/server.xml文件：如果存在其他项目，容易造成不好的影响

  ```xml
  <!--部署项目-->
  <Context docBase="项目路径" path="虚拟路径" />
  <!--访问方式：http://ip:port/虚拟路径/文件-->
  ```

+ 在conf/Catalina/localhost/创建任意名称xml文件，在文件中编写内容，xml文件名字即为虚拟路径

  ```xml
  <!--创建文件 conf/Catalina/localhost/test.xml-->
  <!--部署项目-->
  <Context docBase="项目路径"/>
  <!--访问方式：http://ip:port/test/文件-->
  ```

## 4、静态项目和动态项目

Java动态项目的目录结构：

+ 项目的根目录
  + WEB-INF目录
    + web.xml：web项目的核心配置文件
    + classes目录：放置字节码文件的目录
    + lib目录：防止依赖的jar包

## 5、IDEA集成部署

将Tomcat集成到IDEA中，并创建JavaEE项目，部署项目。

IDEA配置Tomcat：

![IDEA1](Img\tomcat\IDEA1.png)

![IDEA2](Img\tomcat\IDEA2.png)

创建项目时勾选如下选项：

![IDEA3](Img\tomcat\IDEA3.png)

部署项目：

![IDEA4](Img\tomcat\IDEA4.png)