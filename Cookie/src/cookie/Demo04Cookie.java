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
 * 发送Cookie
 * */
@WebServlet("/cookieDemo04")
public class Demo04Cookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、创建Cookie对现象
        Cookie c = new Cookie("msg", "setMaxAge");
        //2、设置cookie的存活事件
        c.setMaxAge(30);        //将cookie持久化到硬盘，30秒后会自动删除cookie文件
        c.setMaxAge(-1);        //浏览器关掉后cookie就消失
        c.setMaxAge(0);         //删除cookie
        //3、发送Cookie
        response.addCookie(c);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
