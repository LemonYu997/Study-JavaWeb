package xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;

/*
 * Jsoup快速入门
 * 1、导包
 * */
public class Demo01Jsoup {
    public static void main(String[] args) throws Exception {
        //2、获取Document对象
        //2.1获取student.xml的path路径
        String path = Demo01Jsoup.class.getClassLoader().getResource("student.xml").getPath();
        //2.2解析xml文档，加载文档进内存，获取dom树-->Document
        Document doucument = Jsoup.parse(new File(path), "utf-8");
        //3、获取元素对象 Element
        Elements elements = doucument.getElementsByTag("name");
        System.out.println(elements.size());        //2
        //3.1获取第一个name的Element对象
        Element element = elements.get(0);
        //3.2获取数据
        String name = element.text();
        System.out.println(name);                   //Tom
    }
}
