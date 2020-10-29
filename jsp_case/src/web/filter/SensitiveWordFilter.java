package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 敏感词汇过滤器
 * */
@WebFilter("/*")
public class SensitiveWordFilter implements Filter {
    private List<String> list = new ArrayList<>();      //敏感词汇集合

    public void init(FilterConfig config) throws ServletException {
        try {
            //1、获取文件真实路径
            ServletContext servletContext = config.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");
            //2、读取文件
            //解决中文乱码
            InputStreamReader isr = new InputStreamReader(new FileInputStream(realPath), "utf-8");
            BufferedReader br = new BufferedReader(isr);
            //3、将文件的每一行数据添加到list中
            String line = null;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }

            br.close();

            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1、创建代理对象，增强getParameter方法
        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //增强getParameter方法
                //判断是否是getParameter方法
                if (method.getName().equals("getParameter")) {
                    //增强返回值
                    //获取返回值
                    String value = (String) method.invoke(req, args);
                    if(value != null) {
                        for (String str : list) {
                            if (value.contains(str)) {
                                value = value.replaceAll(str, "***");
                            }
                        }
                    }
                    return value;
                }
//                //判断方法名是否是getParameterMap
//                if (method.getName().equals("getParameterMap")) {
//                    Map<String, String[]> map = (Map) method.invoke(req, args);
//                    Set<String> values = map.keySet();
//                    for (String value : values) {
//                        //增强返回值
//                        //获取返回值
//                        if(value != null) {
//                            for (String str : list) {
//                                if (value.contains(str)) {
//                                    value = value.replaceAll(str, "***");
//                                }
//                            }
//                        }
//                    }
//                    return map;
//                }
//                //判断方法名是getParameterValue
//                if (method.getName().equals("getParameterMap")) {
//                    String[] values = (String[]) method.invoke(req, args);
//                    for (String value : values) {
//                        //增强返回值
//                        //获取返回值
//                        if(value != null) {
//                            for (String str : list) {
//                                if (value.contains(str)) {
//                                    value = value.replaceAll(str, "***");
//                                }
//                            }
//                        }
//                    }
//                    return values;
//                }

                return method.invoke(req, args);
            }
        });

        //2、放行
        chain.doFilter(proxy_req, resp);
    }

    public void destroy() {
    }
}
