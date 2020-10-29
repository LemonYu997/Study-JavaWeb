package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class Demo07Filter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo07执行了...");
        chain.doFilter(req, resp);
        System.out.println("filterDemo07回来了...");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
