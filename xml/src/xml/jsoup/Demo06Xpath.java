package xml.jsoup;

import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.util.List;

/*
 * Xpath
 * */
public class Demo06Xpath {
    public static void main(String[] args) throws Exception {
        //获取student.xml的path路径
        String path = Demo06Xpath.class.getClassLoader().getResource("student.xml").getPath();
        //获取Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");
        //根据Document对象，创建JXDocument对象
        JXDocument jxDocument = new JXDocument(document);
        //结合xpath语法查询
        //1、查询所有的student标签
        List<JXNode> jxNodes = jxDocument.selN("//student");
        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
        }
        //2、查询所有student标签下的name标签
        List<JXNode> jxNodes2 = jxDocument.selN("//student/name");
        for (JXNode jxNode : jxNodes2) {
            System.out.println(jxNode);
        }
        //3、查询student标签下带有id属性的name标签
        List<JXNode> jxNodes3 = jxDocument.selN("//student/name[@id]");
        for (JXNode jxNode : jxNodes3) {
            System.out.println(jxNode);
        }
        //4、查询student标签下带有id属性的name标签，id属性值为test
        List<JXNode> jxNodes4 = jxDocument.selN("//student/name[@id='test']");
        for (JXNode jxNode : jxNodes4) {
            System.out.println(jxNode);
        }
    }
}
