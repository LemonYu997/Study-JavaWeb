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
