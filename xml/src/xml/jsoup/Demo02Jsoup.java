package xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.net.URL;

/*
 * Jsoup对象
 * */
public class Demo02Jsoup {
    public static void main(String[] args) throws Exception {
        //获取Document对象
        //获取student.xml的path路径
        String path = Demo02Jsoup.class.getClassLoader().getResource("student.xml").getPath();
        //解析方式1：parse(File in, String charsetName)：解析xml或者html文件
        Document doucument1 = Jsoup.parse(new File(path), "utf-8");
        System.out.println(doucument1);

        //解析方式2：parse(String html)：解析xml或html字符串
        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "\n" +
                "<students>\n" +
                "\t<student number=\"s_0001\">\n" +
                "\t\t<name>Tom</name>\n" +
                "\t\t<age>18</age>\n" +
                "\t\t<sex>male</sex>\n" +
                "\t</student>\n" +
                "\t<student number=\"s_0002\">\n" +
                "\t\t<name>Jack</name>\n" +
                "\t\t<age>20</age>\n" +
                "\t\t<sex>male</sex>\n" +
                "\t</student>\n" +
                "</students>";
        Document document2 = Jsoup.parse(str);
        System.out.println(document2);

        //解析方式3：parse(URL url, int timeoutMillis)：通过网络路径获取指定的html或xml文档对象
        URL url = new URL("https://baike.baidu.com/item/jsoup/9012509?fr=aladdin");  //代表网络中的资源路径
        Document document3 = Jsoup.parse(url, 10000);
        System.out.println(document3);
    }
}
