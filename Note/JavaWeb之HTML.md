# JavaWeb之HTML

# 一、Web概念

 **JavaWeb：**使用Java语言开发基于互联网的项目。

## 1、 软件架构

+ **C/S：**Client/Server，客户端/服务器端
  + 在用户本地有一个客户端程序，在远程有一个服务器端程序
  + 如：QQ、迅雷
  + 优点：用户体验好
  + 缺点：开发、安装、部署、维护麻烦

+ **B/S：**Browser/Server，浏览器/服务器
  + 只需要一个浏览器，用户通过不同的网（URL），客户访问不同的服务器端程序
  + 优点：开发、安装、部署、维护简单
  + 缺点
    + 如果应用过大，用户体验会受到影响
    + 对硬件要求过高

## 2、 B/S详解，资源分类

资源分类：

+ **静态资源：**使用静态网页开发技术发布的资源
  + 所有用户访问，得到的结果是一样的
  + 如：文本、图片、音频、视频，**HTML、CSS、JavaScript**
  + 如果用户请求的是静态资源，那么服务器会直接将静态资源发送给浏览器，浏览器中内置了静态资源的解析引擎，可以来展示静态资源
+ **动态资源：**使用动态网页技术发布的资源
  + 所有用户访问，得到的结果可能不一样
  + 如：**jsp/servlet**、php、asp
  + 如果用户请求的是动态资源，那么服务器会执行动态资源，转换为静态资源，再发送给浏览器

要学习动态资源，必须先学习静态资源：

+ HTML：用于搭建基础网页，展示页面的内容
+ CSS：用于美化页面，布局页面
+ JavaScript：控制页面的元素，让页面有一些动态的效果

![资源分类](C:\Users\14455\Desktop\笔记\Image\Html\资源分类.png)

# 二、HTML概念

## 1、 概念

**HTML：**Hypre Text Markup Language 超文本标记语言，最基础的网页开发语言。

+ **超文本：**用超链接的方法，将各种不同空间的文字信息组织在一起的网状文本
+ **标记语言：**由标签构成的语言。<标签名称>，如html，xml
  + 标记语言不是编程语言

## 2、 快速入门

**语法：**

1. html文档后缀名 .html 或者 .htm
2. 标签分为：
   + **围堵标签：**有开始标签和结束标签。如<html></html>
   + **自闭和标签：**开始标签和结束标签在一起。如<br/>
3. **标签嵌套：**
   + 需要正确嵌套，不能你中有我，我中有你
4. 在开始标签中可以**定义属性**，属性由键值对构成，值需要用引号（单双均可）引起来
5. html的标签不区分大小写，建议使用**小写**

```html
<html>      
    <head>
        <title>title</title>
    </head>
    <body>
        <font color = 'red'>Hello World</font><br/>
        <font color = 'green'>Hello World</font>
    </body>
</html>
```

## 3、 标签学习

+ **文件标签：**构成html最基本的标签
+ **文本标签：**和文本有关的标签
+ **图片标签：**和图片有关的标签
+ **列表标签：**和列表有关
+ **超链接标签：**超链接
+ **表格标签：**和表格有关

# 三、HTML文件标签

**文件标签：**构成html最基本的标签

+ html：html文档的根标签
+ head：头标签。用于指定html文档的一些属性，引入外部的资源
+ title：标题标签
+ body：体标签

```html
<!DOCTYPE html>
<html lang="ch">    <!--中国是ch-->
<head>
    <!--下面的语句用来告诉浏览器使用哪个字符集，如果是默认GBK，文档中的中文会乱码-->
    <meta charset="UTF-8">
    <title>测试</title>
</head>
<body>
测试是否会乱码
</body>
</html>

<!--注释格式-->
```

# 四、HTML文本标签

**文本标签：**和文本有关的标签。由于正文中输入html标签会被markdown识别，所以下边的标签不带<>符号。

+ h1 to h6：标题标签，自动换行
  + 字体大小逐渐递减
+ p：段落标签
+ br：换行标签
+ hr：显示一条水平线
  + color：颜色
  + width：宽度
  + size：高度
  + align：对齐方式
    + center：居中
    + left：左对齐
    + right：右对齐
+ b：字体加粗
+ i：斜体
+ font：字体，HTML5已弃用
  + color：颜色
  + size：大小
  + face：字体
+ center：文本居中，已弃用

**属性定义：**

+ color：颜色
  + 英文单词：red,green,blue，推荐使用
  + RGB(值1，值2，值3)：值的范围：0~255 如：rgb(0, 0, 255)即蓝色，基本不支持
  + #值1值2值3：值得范围：00~FF之间。如：#FF00FF
+ width：宽度
  + 数值：width='20'，数值的单位，默认是px(像素)
  + 数值%：相对父元素的占比情况

```html
<!DOCTYPE html>
<html lang="ch">
<head>
    <meta charset="UTF-8">
    <title>文本标签</title>
</head>
<body>
    <!--注释-->
    <!--br 换行-->
    白日依山尽，<br/>
    黄河入海流。<br>

    <!--标题标签 h1~h6，自动换行-->
    黑马旅游网0
    <h1>黑马旅游网1</h1>
    <h2>黑马旅游网2</h2>
    <h3>黑马旅游网3</h3>
    <h4>黑马旅游网4</h4>
    <h5>黑马旅游网5</h5>
    <h6>黑马旅游网6</h6>

    <!--段落标签 p-->
    <p>1.这是第一段话</p>
    <p>2.这是第二段话</p>
    <p>3.这是第三段话</p>

    <!--显示一条水平线 hr-->
    <hr color="red" width="200" size="10" align="left"/>
    <hr color="#FF00FF" width="50%" size="5" />

    <!--字体加粗 b-->
    <b>加粗</b><br/>
    <!--斜体 i-->
    <i>斜体</i><br/>

    <!--字体 font，HTML5已放弃，现在用CSS控制-->
    <font color="red" size="20" face="宋体">白日依山尽</font>
    <font color="#FF00FF" size="20" face="宋体">白日依山尽</font>
    
     <!--文本居中 center，已启用-->
    <center>白日依山尽</center>>
</body>
</html>
```

案例：

```html
<!DOCTYPE html>
<html lang="ch">
<head>
    <meta charset="UTF-8">
    <title>HTML简介</title>
</head>
<body>
    <h1>
        HTML
    </h1>
    <hr color="yellow"/>
    <p>
        <font color="#FF0000">HTML称为超文本标记语言</font>，是一种<b><i>标识性的语言</i></b>。它包括一系列标签．通过这些标签可以将网络上的文档格式统一，使分散的Internet资源连接为一个逻辑整体。HTML文本是由HTML命令组成的描述性文本，HTML命令可以说明文字，图形、动画、声音、表格、链接等。
    </p>
    <p>
    超文本是一种组织信息的方式，它通过超级链接方法将文本中的文字、图表与其他信息媒体相关联。这些相互关联的信息媒体可能在同一文本中，也可能是其他文件，或是地理位置相距遥远的某台计算机上的文件。这种组织信息方式将分布在不同位置的信息资源用随机方式进行连接，为人们查找，检索信息提供方便。
    </p>
    <p>
    HTML的英文全称是 Hyper Text Markup Language，即超文本标记语言。HTML是由Web的发明者 Tim Berners-Lee和同事 Daniel W. Connolly于1990年创立的一种标记语言，它是标准通用化标记语言SGML的应用。用HTML编写的超文本文档称为HTML文档，它能独立于各种操作系统平台(如UNIX， Windows等)。使用HTML语言，将所需要表达的信息按某种规则写成HTML文件，通过专用的浏览器来识别，并将这些HTML文件“翻译”成可以识别的信息，即现在所见到的网页。
    </p>
    <hr color="yellow"/>

    <font color="gray" size="2">
        <center>
            拿来居中测试有限公司<br/>
            版权所有Copyright&copy;2019-2020，All Rights Reserved 家ICP备 16007882
        </center>
    </font>
</body>
</html>
```

![文本案例](C:\Users\14455\Desktop\笔记\Image\Html\文本案例.png)

**HTML特殊字符表：**

**注意：**由于makrdown会自动识别，所以实际写的时候格式是**&xx;**，要加上最后的分号

| 显示结果 | 描述        | 实体名称            | 实体编号 |
| :------- | :---------- | :------------------ | :------- |
|          | 空格        | &nbsp;              | &#160;   |
| <        | 小于号      | ‘&lt’;              | &#60;    |
| >        | 大于号      | ’&gt‘;              | &#62;    |
| &        | 和号        | ‘&amp’;             | &#38;    |
| "        | 引号        | ‘&quot’;            | &#34;    |
| '        | 撇号        | ‘&apos’; (IE不支持) | &#39;    |
| ￠       | 分          | ‘&cent’;            | &#162;   |
| £        | 镑          | ‘&pound’;           | &#163;   |
| ¥        | 人民币/日元 | ‘&yen’;             | &#165;   |
| €        | 欧元        | ‘&euro’;            | &#8364;  |
| §        | 小节        | ‘&sect’;            | &#167;   |
| ©        | 版权        | ‘&copy’;            | &#169;   |
| ®        | 注册商标    | ‘&reg’;             | &#174;   |
| ™        | 商标        | ‘&trade’;           | &#8482;  |
| ×        | 乘号        | ‘&times’;           | &#215;   |
| ÷        | 除号        | ‘&divide’;          | &#247;   |

# 五、图片标签

**img标签：**展示图片

+ **src：**指定图片的路径

**相对路径：**

+ 以 . 开头的路径
+ ./：代表当前路径 ./image/1.jpg
+ 什么都不写，默认是./
+ ../：上级目录

```html
<!DOCTYPE html>
<html lang="ch">
<head>
    <meta charset="UTF-8">
    <title>图片标签</title>
</head>
<body>
    <!--展示一张图片-->
    <!--图片加载失败后，加载alt中文字信息-->
    <img src="image/test.jpg" align="right" alt="猫猫" width="500" height="500"/>
</body>
</html>
```

# 六、列表标签

+ 有序列表
  + ol
  + li
+ 无序列表
  + ul
  + li

```html
 <!DOCTYPE html>
<html lang="ch">
<head>
    <meta charset="UTF-8">
    <title>列表标签</title>
</head>
<body>
    <!--有序列表 ol-->
    早上起床：
    <ol type="A" start="2">
        <li>睁眼</li>
        <li>看手机</li>
        <li>穿衣服</li>
        <li>洗漱</li>
    </ol>
    <!--无序列表 ol-->
    早上起床：
    <ul type="disc">    <!--圆点-->
        <li>睁眼</li>
        <li>看手机</li>
        <li>穿衣服</li>
        <li>洗漱</li>
    </ul>

    <ul type="square">  <!--方块-->
        <li>睁眼</li>
        <li>看手机</li>
        <li>穿衣服</li>
        <li>洗漱</li>
    </ul>

    <ul type="circle">  <!--圆圈-->
        <li>睁眼</li>
        <li>看手机</li>
        <li>穿衣服</li>
        <li>洗漱</li>
    </ul>
</body>
</html>
```

# 七、链接标签

a：定义一个超链接

属性：

+ href：指定访问资源的URL（统一资源定位符）
+ target：指定打开资源的方式
  + _self：在当前页面打开，默认值
  + _blank：在空白页面打开

```html
<!DOCTYPE html>
<html lang="ch">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <!--超链接 a-->
    <a href="http://www.baidu.com">点我</a>
    <br>
    <a href="http://www.baidu.com" target="_self">点我 本页面打开</a>
    <br>
    <a href="http://www.baidu.com" target="_blank">点我 空白页面打开</a>
    <br>
    <a href="5_列表标签.html">访问本地资源</a>
    <br>
    <a href="mailto:1445531395@qq.com">访问邮箱</a>
</body>
</html>
```

# 八、块标签

+ div：每一个div占满一整行，块级标签
+ span：文本信息在一行展示，行内标签 内联标签

```html
<!DOCTYPE html>
<html lang="cn">
<head>
    <meta charset="UTF-8">
    <title>块标签</title>
</head>
<body>
    <!--div span-->
    <span>测试一下</span>
    <span>有什么用呢</span>
    <br>
    <div id="test">测试一下</div>
    <div id="what">有什么用呢</div>
</body>
</html>
```

# 九、语义化标签

**语义化标签：**HTML5中，为了提高程序的可读性，提供了一些标签

+ header
+ footer

# 十、表格标签

+ table：定义表格
  + width：宽度
  + border：边框
  + cellpadding：定义内容和单元格的距离
  + cellspacing：定义单元格之间的距离，如果指定为0，则单元格的线会合为一条
  + bgcolor：背景色
  + align：对齐方式
+ tr：定义行
  + bgcolor：背景色
  + align：对齐方式
+ td：定义单元格
  + colspan：合并行
  + rowspan：合并列
+ th：定义表头单元格
+ caption：表格标题
+ thead：表示表格的头部分，增强可读性
+ tbody：表示表格的体部分，增强可读性
+ tfoot：表示表格的脚部分，增强可读性

![表格标签](C:\Users\14455\Desktop\笔记\Image\Html\表格标签.png)

```html
<!DOCTYPE html>
<html lang="cn">
<head>
    <meta charset="UTF-8">
    <title>表格标签</title>
</head>
<body>
<table border="1" width="50%" cellpadding="0" cellspacing="0" bgcolor="aqua" align="center">
    <thead>
        <caption>学生信息表</caption>
        <tr>
            <!--        <td>编号</td>-->
            <!--        <td>姓名</td>-->
            <!--        <td>成绩</td>-->
            <th>编号</th>
            <th>姓名</th>
            <th>成绩</th>
        </tr>
    </thead>

    <tbody>
        <tr bgcolor="yellow" align="center">
            <td rowspan="2">1</td>
            <td>关二</td>
            <td>80</td>
        </tr>
        <tr>
<!--            <td>2</td>-->
            <td>张三</td>
            <td>70</td>
        </tr>
    </tbody>

    <tfoot>
        <tr>
            <td>3</td>
            <td colspan="2">赵四</td>
<!--            <td>85</td>-->
        </tr>
    </tfoot>
</table>
</body>
</html>
```

# 十一、综合案例

## 1、分析

+ 使用table来完成布局
+ 如果某一行只有一个单元格，则使用tr、td完成
+ 如果某一行有多个单元格，则将table嵌套进tr、td中

## 2、实现

```html
<!DOCTYPE html>
<html lang="ch">
<head>
    <meta charset="UTF-8">
    <title>旅游网案例</title>
</head>
<body>

    <!--采用table完成布局-->
    <!--最外层的table，用于整个页面的布局-->
    <table width="100%" align="center">
        <!--第一行-->
        <tr>
            <td>
                <img src="image/toptop.png" width="100%" alt="">
            </td>
        </tr>
        <!--第二行-->
        <tr>
            <td>
                <!--嵌套table-->
                <table>
                    <tr>
                        <td width="30%">
                            <img src="image/logo.png">
                        </td>
                        <td align="center">
                            <img src="image/search.png" >
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <!--第三行-->
        <tr>
            <td>
                <table width="100%" align="center" bgcolor="#ffd700">
                    <tr align="center" height="45">
                        <td>
                            <a href="">首页</a>
                        </td>
                        <td>
                            <a href="">酒店</a>
                        </td>
                        <td>
                            <a href="">客栈公寓</a>
                        </td>
                        <td>
                            <a href="">国内机票</a>
                        </td>
                        <td>
                            <a href="">港澳台机票</a>
                        </td>
                        <td>
                            <a href="">旅游度假</a>
                        </td>
                        <td>
                            <a href="">景点门票</a>
                        </td>
                        <td>
                            <a href="">火车票</a>
                        </td>
                        <td>
                            <a href="">团购特卖</a>
                        </td>
                        <td>
                            <a href="">目的地</a>
                        </td>
                        <td>
                            <a href="">飞猪国际</a>
                        </td>
                        <td>
                            <a href="">我的旅行</a>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <!--第四行-->
        <tr>
            <td>
                <img src="image/top.png" width="100%">
            </td>
        </tr>
        <!--第五行-->
        <tr>
            <td>
                <img src="image/img1.png" width="100%">
            </td>
        </tr>
        <!--第六行-->
        <tr>
            <td>
                旅游度假
                <hr color="yellow">
            </td>

        </tr>
        <!--第七行-->
        <tr>
            <td>
                <img src="image/img2.png" width="100%">
            </td>
        </tr>
        <!--第八行-->
        <tr>
            <td>
                <img src="image/img3.png" width="100%">
            </td>
        </tr>
        <!--第九行-->
        <tr>
            <td>
                <img src="image/img4.png" width="100%">
            </td>
        </tr>
        <!--第十行-->
        <tr>
            <td>
                <img src="image/bottom.png" width="100%">
            </td>
        </tr>
        <!--第十一行-->
        <tr>
            <td>
                <font color="gray" size="2">
                    <center>
                        拿来居中测试有限公司<br/>
                        版权所有Copyright&copy;2019-2020，All Rights Reserved 家ICP备 16007882
                    </center>
                </font>
            </td>
        </tr>
    </table>

</body>
</html>
```

# 十二、表单标签

## 1、form标签

**表单：**用于采集用户输入的数据，用于和服务器进行交互。

使用的标签：form，用于定义表单的，可以定义一个范围，范围代表采集用户数据的范围。

**form的属性：**

+ action：指定提交数据的URL
+ method：指定提交方式，一共7种，两种比较常用
  + **get：**
    + 请求参数会在地址栏中显示，会封装到请求行中
    + 请求参数的长度是有限制的
    + 不太安全
  + **post：**
    + 请求参数不会在地址栏中显示，会封装在请求体中（HTTP协议）
    + 请求参数的大小没有限制
    + 较为安全

表单项中的数据要想被提交，必须指定其name属性

```html
<!DOCTYPE html>
<html lang="ch">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<!--form：用于定义表单的，可以定义一个范围，范围代表采集用户数据的范围-->
<form action="#" method="get">
    用户名：<input name="username"> <br>
    <input type="submit" value="登录">
</form>
    密码：<input name="password"> <br>
</body>
</html>
```

**表单项标签：**

+ label：指定输入项的文字描述信息
  + label的for属性一般会和input的id属性值对应，如果对应了，则点击label区域，会让input输入框获取焦点。
+ input：可以通过type属性值，改变元素展示的样式
  + type属性：
    + text：文本输入框
      + placeholder属性：指定输入框的提示信息，当输入框的内容发生变化，会自动清空提示信息
    + password：密码输入框
    + radio：单选框
      + **注意：要想让多个单选框实现单选的效果，则多个单选框的name属性必须一样**
      + 一般会给每一个单选框提供value属性，指定其被选中后提交的值
      + checked属性：指定默认值
    + checkbox：复选框
      + 一般会给每一个单选框提供value属性，指定其被选中后提交的值
      + checked属性：指定默认值
    + file：文件选择框
    + hidden：隐藏域，用于提交一些看不到的信息
    + submit：提交按钮，提交表单
    + button：普通按钮
    + image：图片提交按钮，需要src属性输入图片路径，点一下图片就相当于提交
    + color：取色器，H5新加
    + date：日期，年月日，H5新加
    + datetime-local：日期，年月日时间，H5新加
    + eamil：邮箱，会自动对输入内容进行格式校验，H5新加
    + number：数字，只能输入数字，H5新加
+ select：下拉列表
  + 子元素：oprion，指定列表项
+ textarea：文本域
  + cols：指定列数，每一行有多少字符
  + rows：默认多少行

```html
<!DOCTYPE html>
<html lang="ch">
<head>
    <meta charset="UTF-8">
    <title>表单项</title>
</head>
<body>
    <form action="#" method="get">
        <label for="username">
            用户名：<input type="text" name="username" placeholder="请输入用户名" id="username">
        </label> <br>
        密码：<input type="password" name="password" placeholder="请输入密码"> <br>
        性别：<input type="radio" name="gender" value="male" checked> 男
        <input type="radio" name="gender" value="female"> 女 <br>
        爱好：<input type="checkbox" name="hobby" value="shopping"> 电影
        <input type="checkbox" name="hobby" value="java"> Java
        <input type="checkbox" name="hobby" value="game"> 游戏 <br>
        图片：<input type="file" name="file"> <br>
        隐藏域：<input type="hidden" name="id" value="aaa"> <br>

        取色器：<input type="color" name="color"> <br>
        生日：<input type="date" name="birthday"> <br>
        生日：<input type="datetime-local" name="birthday"> <br>
        邮箱：<input type="email" name="email"> <br>
        年龄：<input type="number" name="age"> <br>

        省份：<select name="province">
                <option>--请选择--</option>
                <option value="1">北京</option>
                <option value="2">上海</option>
                <option value="3">广州</option>
             </select>
        <br>

        自我描述：
        <textarea cols="20" rows="5" name="des">

        </textarea>
        <br>
        <input type="submit" value="登录"> <br>
        <input type="button" value="按钮"> <br>
        <input type="image" src="image/logo.png"> <br>
    </form>
</body>
</html>
```

## 2、案例

```html
<!DOCTYPE html>
<html lang="ch">
<head>
    <meta charset="UTF-8">
    <title>表单案例</title>
</head>
<body>
    <!--定义表单-->
    <form action="#" method="post">
        <table border="1" align="center" width="500">
            <tr>
                <td><label for="username">用户名</label></td>
                <td><input type="text" name="username" id="username"> </td>
            </tr>
            <tr>
                <td><label for="password">密码</label></td>
                <td><input type="password" name="password" id="password"> </td>
            </tr>
            <tr>
                <td><label for="email">Email</label></td>
                <td><input type="email" name="email" id="email"> </td>
            </tr>
            <tr>
                <td><label for="name">姓名</label></td>
                <td><input type="text" name="name" id="name"> </td>
            </tr>
            <tr>
                <td><label for="tel">手机号</label></td>
                <td><input type="text" name="tel" id="tel"> </td>
            </tr>
            <tr>
                <td><label>性别</label></td>
                <td><input type="radio" name="gender" value="male">男
                <input type="radio" name="gender" value="female">女 </td>
            </tr>
            <tr>
                <td><label for="birthday">出生日期</label></td>
                <td><input type="date" name="birthday" id="birthday"> </td>
            </tr>
            <tr>
                <td><label for="checkcode">验证码</label></td>
                <td><input type="text" name="checkcode" id="checkcode">
                    <img src="image/logo.png">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="注册"></td>
            </tr>
        </table>
    </form>
</body>
</html>
```

效果如下：

![表单](C:\Users\14455\Desktop\笔记\Image\Html\表单.png)