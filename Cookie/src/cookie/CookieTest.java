package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 提醒上次访问时间的案例
 * */
@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应的消息体的数据格式以及编码
        response.setContentType("text/html;charset=utf-8");

        //1、获取所有Cookie
        Cookie[] cookies = request.getCookies();
        boolean flag = false;   //没有cookie为lastTime
        //2、遍历cookie数组
        if(cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                //3、获取cookie的名称
                String name = cookie.getName();
                //4、判断名称是否是lastTime
                if("lastTime".equals(name)) {
                    //有该Cookie，不是第一次访问
                    flag = true;                //现在应该有lastTime了

                    //响应数据
                    //获取Cookie的value，时间
                    String value = cookie.getValue();
                    System.out.println("解码前：" + value);
                    //URL解码
                    value = URLDecoder.decode(value, "utf-8");
                    System.out.println("解码后：" + value);
                    response.getWriter().write("<h1>欢迎回来，您上次访问时间为：" + value + "</h1>");

                    //更新Cookie的value
                    //获取当前时间的字符串，重新设置cookie的值，重新发送cookie
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String str_date = sdf.format(date);
                    //时间字符串中有空格，tomcat无法解析，需要用URL编码解析
                    System.out.println("编码前：" + str_date);
                    //URL编码
                    str_date = URLEncoder.encode(str_date, "utf-8");
                    System.out.println("编码后：" + str_date);
                    cookie.setValue(str_date);
                    //设置cookie的存活时间 1个月
                    cookie.setMaxAge(60*60*24*30);
                    response.addCookie(cookie);

                    //程序结束
                    break;
                }
            }
        }

        //没有cookie，第一次访问
        if(cookies == null || cookies.length == 0 || flag == false) {
            //设置Cookie的value
            //获取当前时间的字符串，重新设置cookie的值，重新发送cookie
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String str_date = sdf.format(date);
            //时间字符串中有空格，tomcat无法解析，需要用URL编码解析
            System.out.println("编码前：" + str_date);
            //URL编码
            str_date = URLEncoder.encode(str_date, "utf-8");
            System.out.println("编码后：" + str_date);
            //设置一个cookie
            Cookie cookie = new Cookie("lastTime", str_date);
            cookie.setValue(str_date);
            //设置cookie的存活时间 1个月
            cookie.setMaxAge(60*60*24*30);
            response.addCookie(cookie);

            response.getWriter().write("<h1>您好，欢迎您首次访问</h1>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
