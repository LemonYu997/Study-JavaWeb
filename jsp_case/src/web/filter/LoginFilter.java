package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录验证的过滤器
 * */
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1、强制转换
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //2、获取资源的请求路径
        String uri = request.getRequestURI();
        //3、判断是否包含登录相关资源路径，要注意排除掉css/js/图片/验证码等资源
        if (uri.contains("/login.jsp") || uri.contains("/loginServlet") || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts/") || uri.contains("/checkCodeServlet")) {
            //包含，用户要登录，放行
            chain.doFilter(req, resp);
        } else {
            //不包含，需要验证用户是否登录
            //4、从session中获取user
            Object user = request.getSession().getAttribute("user");
            if (user != null) {
                //登录了，放行
                chain.doFilter(req, resp);
            } else {
                //没有登录，跳转登录页面
                request.setAttribute("login_msg", "您尚未登录，请登录");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
