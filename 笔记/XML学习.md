# XML和Jsoup

# 一、概述

**XML：**Extensible Markup Language 可扩展标记语言

**可扩展：**标签都是自定义的 <user> <student>

```xml
<user id='1'>
	<name>zhangsan</name>
    <age>23</age>
</user>

<user id='2'>
	<name>lisi</name>
    <age>24</age>
</user>
```

**功能**：存储数据。

+ 作为**配置文件**使用。
+ 在网络中传输

xml与Html的区别：

+ xml的标签都是自定义的，html标签是预定义的
+ xml的语法严格，html语法松散
+ xml是存储数据的，html是展示数据的

# 二、语法

## 1、基本语法

+ xml文档的后缀名为 .xml
+ xml第一行必须定义为文档声明
+ xml文档有且仅有一个根标签
+ 属性值必须使用引号（单双均可）引起来
+ 标签必须正确关闭
+ xml标签名称区分大小写

```xml
<?xml version='1.0' encoding="UTF-8" standalone="yes"?>

<users>
    <user id='1'>
        <name>zhangsan</name>
        <age>23</age>
        <gender>male</gender>
    </user>

    <user id='2'>
        <name>lisi</name>
        <age>24</age>
        <gender>male</gender>
    </user>
</users>
```

## 2、组成部分

+ 文档声明
  + 格式：<?xml 属性列表 ?>
  + 属性列表：
    + version：版本号，必须的属性
    + encoding：编码方式，告知解析引擎当前文档使用的字符集，默认值：ISO-8859-1
    + standalone：是否独立，yes不依赖其他文件，no依赖其他文件
+ 指令：结合CSS展示数据，已不用
+ 标签：标签名称自定义
  + 规则：
    + 名称可以包含字母、数字、以及其他的字符
    + 名称不能以数字或者标点符号开始
    + 名称不能以字母 xml（或者XML、Xml等）开始
    + 名称不能包含空格
+ 属性
  + id属性值唯一
+ 文本
  + CDATA区：该区域中数据会被原样展示

```xml
<![CDATA[ 数据 ]]> 
<![CDATA[ if(a>b) a=b]]>
```

## 3、约束

作为框架使用者：

+ 能够在xml中引入约束文档
+ 能够简单的读懂约束文档

![约束](Img\xml\约束.png)

分类：

+ DTD：一种简单的约束技术

  + 内部dtd：将约束规则定义在xml文档中
  + 外部dtd：将约束的规则定义在外部的dtd文件中
    + 本地 <!DOCTYPE 根标签名 SYSTEM "dtd文件的位置">
    + 网络 <!DOCTYPE 根标签名 PUBLIC "dtd文件名字" "dtd文件的位置URL">

  ```dtd
  <!ELEMENT students (student*) >
  <!ELEMENT student (name,age,sex)>
  <!ELEMENT name (#PCDATA)>
  <!ELEMENT age (#PCDATA)>
  <!ELEMENT sex (#PCDATA)>
  <!ATTLIST student number ID #REQUIRED>
  ```

  ```xml
  <?xml version="1.0" encoding="UTF-8" ?>
  <!DOCTYPE students SYSTEM "student.dtd">
  
  <students>
  	<student number="s001">
  		<name>tom</name>
  		<age>18</age>
  		<sex>male</sex>
  	</student>
  	<student number="s002">
  		<name>lisi</name>
  		<age>24</age>
  		<sex>male</sex>
  	</student>
  </students>
  ```

+ Schema：一种复杂的约束技术

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!-- 
	1.填写xml文档的根元素
	2.引入xsi前缀.  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	3.引入xsd文件命名空间.  xsi:schemaLocation="http://www.itcast.cn/xml  student.xsd"
	4.为每一个xsd约束声明一个前缀,作为标识  xmlns="http://www.itcast.cn/xml" 
 -->
<students xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xmlns="http://www.itcast.cn/xml"
          xsi:schemaLocation="http://www.itcast.cn/xml  student.xsd"
>
    <student number="s_0001">
        <name>tom</name>
        <age>18</age>
        <sex>male</sex>
    </student>

</students>
```

## 4、解析

**解析：**操作xml文档，将文档中的数据读取到内存中

操作xml文档：

+ 解析（读取）：将文档中的数据读取到内存中
+ 写入：将内存中的数据保存到xml文档中，持久化存储

解析xml的方式：

+ DOM：将标记语言文档一次性加载进内存，在内存中形成一棵DOM树
  + 优点：操作方便，可以对文档进行CRUD的所有操作
  + 缺点：消耗内存
+ SAX：逐行读取，基于事件驱动
  + 优点：不占内存
  + 缺点：只能读取

xml常见的解析器：

+ JAXP：sun公司提供的解析器，支持dom和sax两种思想
+ DOM4J：非常好用
+ Jsoup：Java的HTML解析器，可以直接解析URL地址、HTML文本内容，提供省力API，通过DOM、CSS以及类似JQuery的操作方法取出和操作数据
+ PULL：Android操作系统内置的解析器，sax方式

![DOM树](Img\xml\DOM树.png)

# 三、Jsoup

## 1、快速入门

使用步骤：

+ 导入jar包
+ 获取Document对象
+ 获取对应的标签
+ 获取数据

```xml
<?xml version="1.0" encoding="UTF-8" ?>

<students>
	<student number="s_0001">
		<name>Tom</name>
		<age>18</age>
		<sex>male</sex>
	</student>
	<student number="s_0002">
		<name>Jack</name>
		<age>20</age>
		<sex>male</sex>
	</student>
</students>
```

```java
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

```

##  2、Jsoup对象

### 2.1 Jsoup对象

Jsoup：工具类，可以解析html或者xml文档，返回Document

+ parse：解析html或xml文档，返回Document
  + parse(File in, String charsetName)：解析xml或者html文件
  + parse(String html)：解析xml或html字符串
  + parse(URL url, int timeoutMillis)：通过网络路径获取指定的html或xml文档对象

```java
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

```

### 2.2 Document对象

Document：文档对象，代表内存中的	parse(String html)DOM树

获取Element对象的方法：

+ getElementById(String id)：根据id属性值获取唯一的element对象
+ getElementsByTag(String tagName)：根据标签名称获取元素对象集合
+ getElementsByAttribute(String key)：根据属性名称获取元素对象集合
+ getElementsByAttributeValue(String key, String value)：根据对应的属性名和值获取元素对象集合

```java
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
```

### 2.3 Elements对象

Elements：元素Element对象的集合，可以当做ArrayList<Element>来使用

### 2.4 Element对象

Element：元素对象

获取子元素对象：

+ getElementById(String id)：根据id属性值获取唯一的element对象
+ getElementsByTag(String tagName)：根据标签名称获取元素对象集合
+ getElementsByAttribute(String key)：根据属性名称获取元素对象集合
+ getElementsByAttributeValue(String key, String value)：根据对应的属性名和值获取元素对象集合

获取属性值：

+ String attr(String attributeKey)：根据属性名称（不区分大小写）获取属性值

获取文本内容：

+ String text()：获取所有子标签的文本内容
+ String  html()：获取标签体的所有内容（包括子标签的字符串内容）

```java
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
```

### 2.5 Node对象

Node：节点对象，Document和Element的父类

## 3、选择器

快捷查询方式：

+ Selector：选择器
  + 使用方法：Elements select(String cssQuery)
  + 语法：参考Selector类中定义的语法
+ Xpath：xml路径语言，确定xml文档中某部分位置的语言
  + 使用Jsoup的Xpath需要额外导入jar包
  + 查询w3cschool参考手册

```java
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
```

```java
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
```

