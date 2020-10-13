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
