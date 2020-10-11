# JavaWeb之CSS

# 一、概念

**CSS：**Cascading Style Sheets层叠样式表

**层叠：**多个样式可以作用在同一个HTML的元素上，同时生效

优点：

+ 功能强大
+ 将内容展示和样式控制分离
  + 降低耦合度（解耦）
  + 让分工协作更容易
  + 提高开发效率

# 二、CSS使用：CSS与HTML结合

## 1、内联样式

在标签内使用style属性指定CSS代码。

```html
<div style="color: red;">hello css</div> 
<!--键值对-->
```

## 2、内部样式

在head标签内，定义Style标签，Style标签的标签体内容就是CSS代码

 ```html
<!DOCTYPE html>
<html lang="ch">
<head>
    <meta charset="UTF-8">
    <title>内部样式</title>
    <style>
        div{
            color:blue;
        }
    </style>
</head>
<body>
<!--在head标签内，定义Style标签，style标签的标签体内容就是CSS代码-->
    <div>Hello CSS</div>
</body>
</html>
 ```

## 3、外部样式

1. 定义CSS资源文件
2. 在head标签内，定义link标签，引用外部资源文件
   + rel 属性是必须的，规定当前文档与被链接文档/资源之间的关系。
   + stylesheet：要导入的样式表的URL

html文件：

```html
<!DOCTYPE html>
<html lang="ch">
<head>
    <meta charset="UTF-8">
    <title>外部样式</title>
    <link rel="stylesheet" href="css/a.css">
</head>
<body>
<!--
1、定义CSS资源文件
2、在head标签内，定义link标签，引用外部资源文件-->
    <div>hello css</div>
    <div>hello css</div>
</body>
</html>
```

另一种导入CSS文件的方式（不常用）：

```css
<!DOCTYPE html>
<html lang="ch">
<head>
    <meta charset="UTF-8">
    <title>外部样式</title>
<!--<link rel="stylesheet" href="css/a.css">-->
    <style>
        @import "css/a.css";
    </style>

</head>
<body>
<!--
1、定义CSS资源文件
2、在head标签内，定义link标签，引用外部资源文件-->
<div>hello css</div>
<div>hello css</div>
</body>
</html>
```

css文件：

```css
div{
    color:green;
}
```

**注意：**

+ 3种方式，CSS作用范围越来越大
+ 第一种方式不常用，常用的是内部样式和外部样式

# 三、CSS语法

格式：

```css
选择器{
	属性名1:属性值1;
    属性名2:属性值2;
    属性名3:属性值3;
    ...
}
```

**选择器：**筛选具有相似特征的元素

**注意：**

+ 每一对属性需要用分号;隔开
+ 最后一对属性可以不需要分号

# 四、选择器

**选择器：**筛选具有相似特征的元素，分为**基本选择器**和**扩展选择器**

## 1、基本选择器

+ id选择器：选择器具体的id属性值的元素，建议在一个html页面中id值唯一
  + 语法：#id属性值{}，表示选择id为XXX的元素
+ 元素选择器：选择具有相同标签名称的元素
  + 语法：标签名称{}
  + 注意：id选择器优先级高于元素选择器
+ 类选择器：选择具有相同的class属性值的元素 
  + 语法：.class属性值{}
  + 注意：类选择器的优先级高于元素选择器

```html
<!DOCTYPE html>
<html lang="ch">
<head>
    <meta charset="UTF-8">
    <title>基础选择器</title>
    <style>
        #div1{
            color: red;
        }
        div{
            color: green;
        }
        .cls1{
            color: blue;
        }
    </style>
</head>
<body>
<!--
基础选择器
    1.id选择器
    2.元素选择器
    3.类选择器
-->
    <div id="div1">id选择器</div>
    <div>元素选择器</div>

    <p class="cls1">类选择器</p>
</body>
</html>
```

## 2、扩展选择器

+ 通用选择器：选择所有元素
  + 语法：*{}
+ 并集选择器：同时选择两种元素
  + 语法：选择器1,选择器2{}
+ 子选择器：筛选选择器1下的选择器 2
  + 语法：选择器1 选择器2{}
+ 父选择器：筛选选择器2的父元素选择器1
  + 语法：选择器1>选择器2{}
+ 属性选择器：选择元素名称，属性名=属性值的元素
  + 语法：元素名称[属性名="属性值"]{}
+ 伪类选择器：选择一些元素具有的状态
  + 语法：元素:状态{}
  + 如：<a>
    + link：初始化的状态
    + visited：被访问过的状态
    + active：正在访问状态
    + hover：悬浮状态

```html
<!DOCTYPE html>
<html lang="ch">
<head>
    <meta charset="UTF-8">
    <title>扩展选择器</title>
    <style>
        div p{
            color: red;
        }
        div>p{
            border: 1px solid;
        }
        input[type='text']{
            border: 5px solid
        }
        a:link{
            color: pink;
        }
    </style>
</head>
<body>
    <div>
        <p>被选中</p>
    </div>
    <p>没有被选中</p>
    <div>没有被选中</div>

    <input type="text">
    <input type="password">
    <br>

    <a href="#">伪类选择器</a>
</body>
</html>
```

# 五、属性

字体、文本、背景、边框、尺寸、盒子模型 

## 1、字体和文本

+ font-size：字体大小
+ color：文本颜色
+ text-align：对齐方式
+ line-height：行高

## 2、边框

border：设置边框，复合属性

## 3、尺寸

+ width：宽度
+ height：高度

## 4、背景

background：设置背景，复合属性

```html
<!DOCTYPE html>
<html lang="ch">
<head>
    <meta charset="UTF-8">
    <title>属性</title>
    <style>
        p{
            color: #FF0000;
            font-size: 30px;
            text-align: center;
            line-height: 100px;
            /*
                border 边框
            */
            border: 1px solid red;
        }
        div{
            border: 1px solid red;
            height: 200px;
            width: 200px;
            /*
                background 背景
            */
            background: url("image/test.jpg");
        }
    </style>
</head>
<body>
    <p>字体属性</p>

    <div>尺寸属性</div>
</body>
</html>
```

## 5、盒子模型：控制布局

+ margin：外边距
+ padding：内边距
  + 默认情况下内边距会影响整个盒子大小 
  + box-sizing：设置盒子的属性，让width和height就是最终盒子的大小
+ float：浮动
  + left
  + right

```html
<!DOCTYPE html>
<html lang="ch">
<head>
    <meta charset="UTF-8">
    <title>盒子模型</title>
    <style>
        div{
            border: 1px solid red;
            width: 100px;
        }
        .div1{
            width: 100px;
            height: 100px;
            /*
            外边距
            margin-left: 50px;
            margin-top: 50px;
            */
        }
        .div2{
            width: 200px;
            height: 200px;
            /*
            设置盒子的属性，让width和height就是最终盒子的大小
            */
            box-sizing: border-box;
            padding: 50px;
        }
        .div3{
            float: left;
        }
        .div4{
            float: left;
        }
        .div5{
            float: left;
        }
    </style>
</head>
<body>
    <div class="div2">
        <div class="div1"></div>
    </div>
    <div class="div3">aaaa</div>
    <div class="div4">bbbb</div>
    <div class="div5">cccc</div>
</body>
</html>
```

![盒子模型](C:\Users\14455\Desktop\笔记\Image\Html\盒子模型.png)

# 六、案例：美化注册页面

```html
<!DOCTYPE html>
<html lang="ch">
<head>
    <meta charset="UTF-8">
    <title>注册案例</title>
    <style>
        *{
            margin: 0px;
            padding: 0px;
            box-sizing: border-box;
        }
        body{
            background: gray;
        }
        .rg_layout{
            width: 900px;
            height: 500px;
            border: 8px solid #EEEEEE;
            background: white;
            /*
                让div水平居中
            */
            margin: auto;
            margin-top: 15px;
        }
        .rg_left{
            float: left;
            margin: 15px;
        }
        .rg_left > p:first-child{
            color: #FFD026;
            font-size: 20px;
        }
        .rg_left > p:last-child{
            color: #A6A6A6;
            font-size: 20px;
        }
        .rg_center{
            float: left;
            width: 450px;
        }
        .rg_right{
            float: right;
            margin: 15px;
        }
        .rg_right > p{
            color: #A6A6A6;
            font-size: 15px;
        }
        .rg_right p a {
            color: pink;
        }
        .td_left{
            width: 100px;
            text-align: right;
            height: 45px;
        }
        .td_right{
            padding-left: 50px;
        }
        #username, #password, #email, #name, #tel, #birthday{
            width: 251px;
            height: 32px;
            border: 1px solid gray;
            /*
                设置边框圆角
            */
            border-radius: 5px;
            padding-left: 10px;
        }
        #checkcode{
            width: 110px;
            height: 32px;
            border: 1px solid gray;
            border-radius: 5px;
            padding-left: 10px;
        }
        #btn_sub{
            width: 150px;
            height: 40px;
            background: #FFD026;
            border: 1px solid #FFD026;
        }
    </style>

</head>
<body>

<div class="rg_layout">
    <div class="rg_left">
        <p>新用户注册</p>
        <p>USER REGISTER</p>
    </div>
    <div class="rg_center">
        <div class="rg_form">
            <!--定义表单-->
            <form action="#" method="post">
                <table>
                    <tr>
                        <td class="td_left"><label for="username">用户名</label></td>
                        <td class="td_right"><input type="text" name="username" id="username" placeholder="请输入用户名"> </td>
                    </tr>
                    <tr>
                        <td class="td_left"><label for="password">密码</label></td>
                        <td class="td_right"><input type="password" name="password" id="password" placeholder="请输入密码"> </td>
                    </tr>
                    <tr>
                        <td class="td_left"><label for="email">Email</label></td>
                        <td class="td_right"><input type="email" name="email" id="email" placeholder="请输入邮箱"> </td>
                    </tr>
                    <tr>
                        <td class="td_left"><label for="name">姓名</label></td>
                        <td class="td_right"><input type="text" name="name" id="name" placeholder="请输入姓名"> </td>
                    </tr>
                    <tr>
                        <td class="td_left"><label for="tel">手机号</label></td>
                        <td class="td_right"><input type="text" name="tel" id="tel" placeholder="请输入手机号"> </td>
                    </tr>
                    <tr>
                        <td class="td_left"><label>性别</label></td>
                        <td class="td_right"><input type="radio" name="gender" value="male">男
                            <input type="radio" name="gender" value="female">女 </td>
                    </tr>
                    <tr>
                        <td class="td_left"><label for="birthday">出生日期</label></td>
                        <td class="td_right"><input type="date" name="birthday" id="birthday"> </td>
                    </tr>
                    <tr>
                        <td class="td_left"><label for="checkcode">验证码</label></td>
                        <td class="td_right">
                            <input type="text" name="checkcode" id="checkcode" placeholder="请输入验证码">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="注册" id="btn_sub"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <div class="rg_right">
        <p>已有账号<a href="#">立即登录</a></p>
    </div>
</div>
</body>
</html>
```

![注册案例](C:\Users\14455\Desktop\笔记\Image\Html\注册案例.png)