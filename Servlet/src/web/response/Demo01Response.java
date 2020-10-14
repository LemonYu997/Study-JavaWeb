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
