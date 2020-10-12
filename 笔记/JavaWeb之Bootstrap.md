# JavaWeb之Bootstrap

# 一、概述

**Bootstrap：**一个前端开发的矿建，来自Twitter

框架：一个半成品软件，开发人员在框架上进行开发，简化编码

好处：

+ 定义了很多CSS样式和JS插件，可以直接使用这些样式和插件，得到丰富的页面效果
+ 响应式布局
  + 同一套页面可以兼容不同分辨率的设备
  + 实现：依赖于栅格系统，将一行平均分为12个格子，可以指定元素占几个格子

# 二、快速入门

1、下载

2、引入到项目中

3、创建html页面，引入必要的资源文件

模板

```html
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>HelloWorld</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.5.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<h1>你好，世界！</h1>


</body>
</html>
```

# 三、栅格系统

响应式布局

+ 同一套页面可以兼容不同分辨率的设备
+ 实现：依赖于栅格系统，将一行平均分为12个格子，可以指定元素占几个格子
+ 步骤：
  + 定义容器，相当于之前的table
    + 容器分类：
      + container：两边有留白
      + container-fluid：每一种设备都是100%宽度
  + 定义行，相当于之间的tr，样式：row
  + 定义元素，指定该元素在不同的设备上，所占的格子数目。样式：col-设备代号-格子数目
    + 设备代号：
      + xs：超小屏幕 手机（<768px）：col-xs-12
      + sm：小屏幕 平板（>=768px）
      + md：中等屏幕 桌面显示器（>=992px）
      + lg：大屏幕 大桌面显示器（>=1200px） 

注意事项：

+ 一行中如果格子数目超过12，则超出部分自动换行
+ 栅格类属性可以向上兼容，栅格类适用于与屏幕宽度大于或等于分界点大小的设备
+ 如果设备宽度小于了设置栅格类属性的设备代码的最小值，会一个元素占满一整行

```html
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>栅格系统</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.5.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>

    <style>
        .inner{
            border: 1px solid red;
        }
    </style>
</head>
<body>
    <!--1、定义容器-->
    <div class="container-fluid">
        <!--2、定义行-->
        <div class="row">
            <!--3、定义元素，在大显示器一行12个格子，在pad上一行6个格子-->
            <div class="col-lg-1 col-sm-2 inner">栅格</div>
            <div class="col-lg-1 col-sm-2 inner">栅格</div>
            <div class="col-lg-1 col-sm-2 inner">栅格</div>
            <div class="col-lg-1 col-sm-2 inner">栅格</div>
            <div class="col-lg-1 col-sm-2 inner">栅格</div>
            <div class="col-lg-1 col-sm-2 inner">栅格</div>
            <div class="col-lg-1 col-sm-2 inner">栅格</div>
            <div class="col-lg-1 col-sm-2 inner">栅格</div>
            <div class="col-lg-1 col-sm-2 inner">栅格</div>
            <div class="col-lg-1 col-sm-2 inner">栅格</div>
            <div class="col-lg-1 col-sm-2 inner">栅格</div>
            <div class="col-lg-1 col-sm-2 inner">栅格</div>
        </div>
        <div class="row">
            <!--3、定义元素，在大显示器一行12个格子，在pad上一行6个格子-->
            <div class="col-xs-4 inner">栅格</div>
            <div class="col-xs-4 inner">栅格</div>
            <div class="col-xs-4 inner">栅格</div>
        </div>
    </div>

</body>
</html>
```



# 四、全局CSS样式

全局CSS样式：

+ 按钮
+ 图片
+ 表格
+ 表单

按钮和图片

```html
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>CSS全局样式</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.5.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
    <a class="btn btn-default" href="#">Link</a>
    <button class="btn btn-default" type="submit">Button</button>
    <input class="btn btn-default" type="button" value="Input">
    <input class="btn btn-default" type="submit" value="Submit">

    <!-- Standard button -->
    <button type="button" class="btn btn-default">（默认样式）Default</button>

    <!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
    <button type="button" class="btn btn-primary">（首选项）Primary</button>

    <!-- Indicates a successful or positive action -->
    <button type="button" class="btn btn-success">（成功）Success</button>

    <!-- Contextual button for informational alert messages -->
    <button type="button" class="btn btn-info">（一般信息）Info</button>

    <!-- Indicates caution should be taken with this action -->
    <button type="button" class="btn btn-warning">（警告）Warning</button>

    <!-- Indicates a dangerous or potentially negative action -->
    <button type="button" class="btn btn-danger">（危险）Danger</button>

    <!-- Deemphasize a button by making it look like a link while maintaining button behavior -->
    <button type="button" class="btn btn-link">（链接）Link</button>

    <hr>

    <img src="img/banner_1.jpg" class="img-responsive">
    <img src="img/banner_1.jpg" class="img-responsive img-rounded">
    <img src="img/banner_1.jpg" class="img-responsive img-thumbnail">
    <img src="img/banner_1.jpg" class="img-responsive img-circle">

</body>
</html>
```

组件：

+ 导航条
+ 分页条

插件：

+ 轮播图

```html
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>插件轮播图</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.5.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img src="img/banner_1.jpg" alt="...">
        </div>
        <div class="item">
            <img src="img/banner_2.jpg" alt="...">
        </div>
        <div class="item">
            <img src="img/banner_3.jpg" alt="...">
        </div>
    </div>

    <!-- Controls -->
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
</body>
</html>
```

