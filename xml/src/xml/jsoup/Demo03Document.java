package xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;

/*
 * Document对象/Element对象
 * */
public class Demo03Document {
    public static void main(String[] args) throws Exception {
        //1、获取student.xml的path路径
        String path = Demo03Document.class.getClassLoader().getResource("student.xml").getPath();
        //2、获取Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");
        //3、获取元素对象
        //3.1 获取所有student对象
        Elements elements = document.getElementsByTag("student");
        System.out.println(elements);       //所有student
        //3.2 获取属性名为id的元素对象们
        Elements elements1 = document.getElementsByAttribute("id");
        System.out.println(elements1);      //Tom
        //3.3 获取number属性值为s_0001的元素对象
        Elements elements2 = document.getElementsByAttributeValue("number", "s_0001");
        System.out.println(elements2);      //Tom的所有数据
        //3.4 获取id值为test的元素对象
        Element element = document.getElementById("test");
        System.out.println(element);        //Tom
    }
}
