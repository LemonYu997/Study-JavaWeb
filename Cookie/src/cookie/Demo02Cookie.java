package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Cookie快速入门
 * 获取Cookie
 * */
@WebServlet("/cookieDemo02")
public class Demo02Cookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //3、获取Cookie
        Cookie[] cookies = request.getCookies();
        //遍历Cookies
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                String value = cookie.getValue();
                System.out.println(name + ":" + value);
                /*
                 * 先用同一个浏览器访问/cookieDemo01，再访问/cookieDemo02，才能获取cookie中的数据
                 * JSESSIONID:881467DFD67204725380336E971A0F67
                 * msg:hello
                 * Idea-a9babc01:eec227e0-2f2a-4a2c-8ee4-525a1ae091ed
                 * */
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
