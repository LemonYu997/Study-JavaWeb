package web.servlet;

        import javax.servlet.*;
        import javax.servlet.annotation.WebServlet;
        import java.io.IOException;

/*
 * 注解配置
 * */
//@WebServlet(urlPatterns = "/demo03")
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
