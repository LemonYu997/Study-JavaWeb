package xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;

/*
 * Element对象
 * */
public class Demo04Element {
    public static void main(String[] args) throws Exception {
        //获取student.xml的path路径
        String path = Demo04Element.class.getClassLoader().getResource("student.xml").getPath();
        //获取Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");
        //1、通过Document对象获取name标签，获取所有的name标签
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());        //2

        //2、通过Element对象获取子标签对象
        Element element_student = document.getElementsByTag("student").get(0);
        Elements ele_name = element_student.getElementsByTag("name");
        System.out.println(ele_name.size());        //1

        //3、获取student对象的属性值
        String number = element_student.attr("number");
        System.out.println(number);                 //s_0001

        //获取文本内容
        String text = ele_name.text();
        String html = ele_name.html();
        System.out.println(text);                   //Tom，只有纯文本内容
        System.out.println(html);                   //<>Tom<>，连子标签也获取到
    }
}
