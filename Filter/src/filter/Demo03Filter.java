package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/*")
public class Demo03Filter implements Filter {
    /**
     * 在服务器启动后，会创建Filter对象，然后调用init方法
     * 只执行一次，用于加载资源
     * */
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init...");
    }

    /**
     * 每一次请求拦截资源时，会执行
     * 可以执行多次
     * */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("doFilter...");
        chain.doFilter(req, resp);
    }

    /**
     * 在服务器关闭后，Filter对象被销毁
     * 如果服务器是正常关闭，则会执行destroy方法
     * 只执行一次，用于释放资源
     * */
    public void destroy() {
        System.out.println("destroy...");
    }
}
