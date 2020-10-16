# JavaWeb之Response

# 一、功能

功能：设置**响应消息**

+ 设置响应行
  + 格式：HTTP/1.1 200 OK
  + 设置状态码：setStatus(int sc)
+ 设置响应头
  + setHeader(String name, String value)
+ 设置响应体
  + 获取输出流
    + 字符输出流：PrintWriter getWriter()
    + 字节输出流：ServletOutputStream getOutputStream()
  + 使用输出流，将数据输出到浏览器客户端

# 二、案例

## 1、完成重定向

### 1.1 重定向实现

**重定向：**资源跳转的方式

![重定向](C:\Users\14455\Desktop\笔记\Image\response\重定向.png)

重定向（redirect）的特点：

+ 地址栏发生变化
+ 重定向可以访问其他站点（服务器）的资源
+ 重定向是两次请求，不能用request对象共享数据

转发（forward）的特点：

+ 转发地址栏路径不变
+ 转发只能访问当前服务器下的资源
+ 转发是一次请求，可以使用request对象来共享数据

```java
package web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向
 * */
@WebServlet("/responseDemo01")
public class Demo01Response extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo1...");
        //访问/responseDemo01，会自动跳转到/responseDemo02
        /*//1、设置状态码为302
        response.setStatus(302);
        //2、设置响应头location
        response.setHeader("location", "/servlet/responseDemo02");*/

        //重定向是两次请求，不能用request对象共享数据
        request.setAttribute("msg", "reponse");

        //动态获取虚拟目录
        String contextPath = request.getContextPath();
        //简单的重定向方法
        response.sendRedirect(contextPath + "/responseDemo02");
        //重定向可以访问其他站点（服务器）的资源
        //response.sendRedirect("http://www.baidu.com");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
```

```java
package web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/responseDemo02")
public class Demo02Response extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo22222222....");

        //重定向是两次请求，不能用request对象共享数据
        Object msg = request.getAttribute("msg");
        System.out.println(msg);    //null
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
```

### 1.2 路径写法

路径的分类：

+ 相对路径：通过相对路径不可以确定唯一资源

  + 如：./index.html
  + 不以/开头，以.开头的路径
  + 规则：找到当前资源和目标资源之间的相对位置关系
    + ./：当前目录
    + ../：后退一级目录

  ```html
  <!DOCTYPE html>
  <html lang="en">
  <head>
      <meta charset="UTF-8">
      <title>相对路径</title>
  </head>
  <body>
      <h1>找到当前资源和目标资源之间的相对位置关系</h1>
      <p>
          当前资源：location.html<br>
          http://localhost/servlet/location.html
      </p>
      <p>
          目标资源：<br>
          http://localhost/servlet/responseDem02
      </p>
      <a href="./responseDemo02">
          responseDemo02
      </a>
      <br>
      <!--不写./也能访问当前目录下的资源-->
      <a href="responseDemo02">
          responseDemo02
      </a>
      <!--../表示向上一级-->
      <br>
      <a href="../responseDemo02">
          responseDemo02
      </a>
  </body>
  </html>
  ```

+ 绝对路径：通过绝对路径可以确定唯一资源
  +  如：http://localhost:8080/servlet/responseDemo02  /servlet/responseDemo02
  + 以/开头的路径
  + 规则：判断定义的路径是给谁用的？判断请求从哪发出
    + 给客户端浏览器使用：需要加虚拟目录（项目的访问路径）
      + 建议虚拟目录动态获取：request.getContextPath()
      + <a>,<form>重定向...
    + 给服务器使用：不需要加虚拟目录
      + 转发路径

```java
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    //给客户端使用，需要加虚拟目录
	//动态获取虚拟目录
	String contextPath = request.getContextPath();
	//简单的重定向方法
	response.sendRedirect(contextPath + "/responseDemo02");        
    
    //给服务器使用，不用加虚拟目录
    //转发
    request.getRequestDispatcher("/responseDemo02").forward(request, response);
}
```

## 2、服务器输出字符数据到浏览器

步骤：

1、获取字符输出流

2、输出数据

中文**乱码**问题原因：编解码使用的字符集不一致

+ PrintWriter pw = response.getWriter();	默认编码是ISO-8859-1
+ 设置该流的默认编码，告诉浏览器应使用的编码
+ response.setContentType("text/html;charset=utf-8"); 在流获取前设置

![中文乱码](C:\Users\14455\Desktop\笔记\Image\response\中文乱码.png)

```java
package web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/responseDemo04")
public class Demo04Response extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取流对象之前，设置流的默认编码：ISO-8859-1设置为utf-8，防止中文乱码
        //response.setCharacterEncoding("utf-8");

        //直接用下面的方式
        //告诉浏览器，服务器发送的消息体数据的编码，建议浏览器使用该编码解码
        //response.setHeader("content-type", "text/html;charset=utf-8");
        //简单的形式，设置编码
        response.setContentType("text/html;charset=utf-8");

        //1、获取字符输出流
        PrintWriter pw = response.getWriter();	//默认编码是ISO-8859-1
        //2、输出数据
        pw.write("<h1>hello response</h1>");
        pw.write("你好 response");        //乱码
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
```

## 3、服务器输出字节数据到浏览器

步骤：

1、获取字节输出流

2、输出数据

```java
package web.response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/responseDemo05")
public class Demo05Response extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //1、获取字节输出流
        ServletOutputStream sos = response.getOutputStream();
        //2、输出数据
        sos.write("hello".getBytes());
        sos.write("你好".getBytes("utf-8"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
```

## 4、验证码

本质：是一张图片

目的：防止恶意表单注册

checkCodeServlet程序，实现验证码图片随机生成

```java
package web.response;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 100;
        int height = 50;
        //1、创建一对象，在内存中画图（验证码图片对象）
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //2、美化图片
        //2.1 填充背景色
        Graphics g = image.getGraphics();   //画笔对象
        g.setColor(Color.PINK); //设置画笔颜色
        g.fillRect(0,0, width, height);
        //2.2 画边框
        g.setColor(Color.BLUE);
        g.drawRect(0, 0, width - 1, height - 1);
        //2.3 写验证码
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        //生成随机角标
        Random ran = new Random();
        for (int i = 1; i <= 4; i++) {
            int index = ran.nextInt(str.length());  //在str长度中挑选一个随机数字
            //获取字符
            char ch = str.charAt(index);    //随机字符
            //写字符在图片上
            g.drawString(ch+"", width / 5 * i, height / 2);
        }
        //2.4 画干扰线
        g.setColor(Color.GREEN);
        //随机生成坐标点
        for (int i = 0; i < 5; i++) {
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);
            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }


        //3、将图片输出到页面展示
        ImageIO.write(image, "jpg", response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
```

注册页面，实现验证码点击更换

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>验证码案例</title>
    <script>
        /**
         * 分析：点击超链接或者图片，需要换一张
         * 1、给超链接和图片绑定单击事件
         * 2、重新设置图片的src属性值
         * */
        window.onload = function () {
            //1、获取图片对象
            var img = document.getElementById("checkCode");
            //2、绑定单击事件
            img.onclick = function () {
                //更新验证码
                updateImg();
            }

            //给超链接绑定单击事件
            var a = document.getElementById("change");
            a.onclick = function () {
                //拒绝超链接跳转
                a.href = "javascript:void(0);";
                //更新验证码
                updateImg();
            }

            //更改图片函数
            var updateImg = function () {
                //?后边跟参数，无意义，但是可以跳过浏览器缓存，生成新的图片
                //加时间戳，产生永不相同的数
                var date = new Date().getTime();
                img.src = "/servlet/checkCodeServlet?" + date;
            }
        }
    </script>
</head>
<body>
    <img id="checkCode" src="/servlet/checkCodeServlet"/>
    <a id="change" href="">看不清，换一张？</a>
</body>
</html>
```

# 三、ServletContext对象

## 1、概述

**ServletContext对象：**代表整个Web应用，可以和程序的**容器**（服务器）来通信

## 2、获取

+ 通过request对象获取：request.getServletContext();
+ 通过HttpServlet获取：this.getServletContext();

```java
package web.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContextDemo01")
public class Demo01ServletContext extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //ServletContext对象的获取
        //1、通过request对象获取：request.getServletContext();
        ServletContext context1 = request.getServletContext();
        //2、通过HttpServlet获取：this.getServletContext();
        ServletContext context2 = this.getServletContext();
        System.out.println(context1);   //org.apache.catalina.core.ApplicationContextFacade@5b17b5ce
        System.out.println(context2);   //org.apache.catalina.core.ApplicationContextFacade@5b17b5ce
        System.out.println(context1==context2); //true
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
```

## 3、功能

### 3.1 获取MIME类型

+ MIME类型：在互联网通信过程中定义的一种文件数据类型
+ 格式：大类型/小类型  text/html     image/jpeg
+ 获取：String getMimeType(String file)

```java
package web.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContextDemo02")
public class Demo02ServletContext extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、通过HttpServlet获取ServletContext对象
        ServletContext context = this.getServletContext();
        //2、定义一个文件名称
        String filename = "a.jpg";
        //3、获取MIME类型
        String mimeType = context.getMimeType(filename);
        System.out.println(mimeType);   //image/jpeg
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
```

### 3.2 域对象：共享数据

+ setAttribute(String name, Object value)
+ getAttribute(String name)
+ removeAttribute(String name)

ServletContext对象范围：所有用户所有请求的数据

```java
package web.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContextDemo03")
public class Demo03ServletContext extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、通过HttpServlet获取ServletContext对象
        ServletContext context = this.getServletContext();
        //设置数据
        context.setAttribute("msg", "hello");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
```

```java
package web.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContextDemo04")
public class Demo04ServletContext extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、通过HttpServlet获取ServletContext对象
        ServletContext context = this.getServletContext();
        //获取数据
        Object msg = context.getAttribute("msg");
        System.out.println(msg);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
```

### 3.3 获取文件的真实（服务器）路径

方法：String getRealPath(String path)

```java
String b = context.getRealPath("/b.txt");    //web目录下访问
String c = context.getRealPath("/WEB-INF/c.txt");	//WEB-INF目录下访问
String a = context.getRealPath("/WEB-INF/classes/a.txt");//src目录下的资源访问

System.out.println(b);   
//F:\Java\Project\Servlet\out\artifacts\Servlet_war_exploded\b.txt

System.out.println(c);
//F:\Java\Project\Servlet\out\artifacts\Servlet_war_exploded\WEB-INF\c.txt

System.out.println(a);
//F:\Java\Project\Servlet\out\artifacts\Servlet_war_exploded\WEB-INF\classes\a.txt
```

```java
package web.servletContext;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/servletContextDemo05")
public class Demo05ServletContext extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、通过HttpServlet获取ServletContext对象
        ServletContext context = this.getServletContext();
        //获取文件的服务器路径
        String b = context.getRealPath("/b.txt");    //web目录下访问
        System.out.println(b);   //F:\Java\Project\Servlet\out\artifacts\Servlet_war_exploded\b.txt
        String c = context.getRealPath("/WEB-INF/c.txt");
        System.out.println(c);  //F:\Java\Project\Servlet\out\artifacts\Servlet_war_exploded\WEB-INF\c.txt
        String a = context.getRealPath("/WEB-INF/classes/a.txt");//src目录下的资源访问
        System.out.println(a);  //F:\Java\Project\Servlet\out\artifacts\Servlet_war_exploded\WEB-INF\classes\a.txt
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
```

# 四、案例：文件下载

## 1、需求

1、页面显示超链接

2、点击超链接后弹出下载提示框

3、完成图片文件下载

## 2、分析

1、超链接直接指向的资源如果能被浏览器解析，则在浏览器中展示，如果不能解析，则弹出下载提示框

2、任何资源都必须弹出下载提示框

3、使用相应同设置资源的打开方式

content-disposition:attachment; filename=xxx

## 3、实现

1、定义页面，编辑超链接href属性，指向Servlet，传递资源参数filename

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>文件下载案例</title>
</head>
<body>
    <a href="/servlet/img/1.jpg">图片1</a>
    <a href="/servlet/img/1.avi">视频1</a>
    <hr>

    <a href="/servlet/downloadServlet?filename=1.jpg">图片1</a>
    <a href="/servlet/downloadServlet?filename=1.avi">视频1</a>

    <a href="/servlet/downloadServlet?filename=九尾.jpg">图片1</a>
</body>
</html>
```

2、定义Servlet

+ 获取请求参数，文件名称
+ 使用字节输入流加载文件进内存
+ 指定response的响应头：content-disposition:attachment; filename=xxx
+ 将数据写出到response输出流

```java
package web.download;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取请求参数，文件名称
        String filename = request.getParameter("filename");

        //2、使用字节输入流加载文件进内存
        //2.1 找到文件服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
        //2.2 用字节流关联
        FileInputStream fis = new FileInputStream(realPath);

        //3、设置response的响应头
        //3.1 设置响应头类型 content-type
        String mimeType = servletContext.getMimeType(filename); //获取文件的MIME类型
        response.setHeader("content-type", mimeType);
        //3.2 解决中文文件名问题
        //3.2.1 获取user-agent请求头
        String agent = request.getHeader("user-agent");
        //3.2.2 使用工具类方法编码文件名即可
        filename = DownLoadUtils.getFileName(agent, filename);
        //3.3 设置响应头打开方式 content-disposition
        response.setHeader("content-disposition", "attachment;filename=" + filename);

        //4、将输入流的数据写出到输出流中
        ServletOutputStream sos = response.getOutputStream();
        byte[] buff = new byte[1020*8];
        int len = 0;
        while((len = fis.read(buff)) != -1) {
            sos.write(buff, 0, len);
        }

        fis.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
```

3、中文文件名问题

解决思路：

+ 获取客户端使用的版本信息

+ 根据不同的版本信息，设置filename的编码方式不同

```java
package web.download;

import sun.misc.BASE64Encoder;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class DownLoadUtils {

    public static String getFileName(String agent, String filename) throws UnsupportedEncodingException {
        if (agent.contains("MSIE")) {
            // IE浏览器
            filename = URLEncoder.encode(filename, "utf-8");
            filename = filename.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            // 火狐浏览器
            BASE64Encoder base64Encoder = new BASE64Encoder();
            filename = "=?utf-8?B?" + base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
        } else {
            // 其它浏览器
            filename = URLEncoder.encode(filename, "utf-8");
        }
        return filename;
    }
}
```

