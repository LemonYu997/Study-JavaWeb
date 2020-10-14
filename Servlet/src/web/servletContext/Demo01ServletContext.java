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
