package travel.web.servlet;

import travel.domain.Category;
import travel.service.CategoryService;
import travel.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet {

    private CategoryService service = new CategoryServiceImpl();

    /**
     * 查询所有
     * */
    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、调用service查询所有
        List<Category> cs = service.findAll();
        //2、序列化json返回
/*        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), cs);*/
        writeValue(cs, response);
    }

}
