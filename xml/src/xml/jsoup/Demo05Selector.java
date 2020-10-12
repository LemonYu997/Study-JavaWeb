package xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;

/*
 * 选择器查询
 * */
public class Demo05Selector {
    public static void main(String[] args) throws Exception {
        //获取student.xml的path路径
        String path = Demo05Selector.class.getClassLoader().getResource("student.xml").getPath();
        //获取Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");
        /*
         * 类比CSS
         * div {
         * }
         * #id{
         * }
         * */
        //1、查询name标签
        Elements elements = document.select("name");
        System.out.println(elements);       //name标签以及其中的内容
        //2、查询id值为test的元素
        Elements elements1 = document.select("#test");
        System.out.println(elements1);
        //3、获取student标签并且number属性值为s_0001的age子标签
        //3.1 获取student标签且number属性值为s_0001
        Elements elements2 = document.select("student[number='s_0001']");
        System.out.println(elements2);
        //3.2 获取student标签并且number属性值为s_0001的age子标签
        Elements elements3 = document.select("student[number='s_0001'] > age");
        System.out.println(elements3);
    }
}
