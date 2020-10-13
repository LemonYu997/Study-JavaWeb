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