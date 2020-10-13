package web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo04")
public class Demo04Request extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求头数据：referer
        String referer = request.getHeader("referer");
        System.out.println(referer);        //链接来源
        //防盗链操作
        if(referer != null){
            if(referer.contains("/Tomcat")) {
                //正常访问
                System.out.println("播放电影..");
            } else {
                //盗链
                System.out.println("想看电影请来XXXX");
            }
        }
    }
}
