# JavaWeb之JavaScript

# 一、基础

## 1、概念

**JavaScript：**客户端脚本语言

+ 运行在客户端浏览器中的，每一个浏览器都有JavaScript的解析引擎。

+ 脚本语言：不需要编译，直接就可以被浏览器解析执行。

**功能：** 

+ 可以来增强用户和HTML页面的交互过程
+ 可以来控制HTML元素，让页面有一些动态的效果，增强用户的体验

## 2、脉络

JavaScript = ECMAScript + BOM + DOM

# 二、语法

## 1、与HTML的结合方式

+ 内部JS：标签内容就是JS代码
+ 外部JS：通过src属性引入外部的JS文件

注意：

+ script标签可以定义在html页面任意地方，但是定义位置会影响执行顺序
+ script可以定义多个

```html
<!DOCTYPE html>
<html lang="ch">
<head>
    <meta charset="UTF-8">
    <title>结合方式</title>
    <!--内部JS，可以放在任意位置-->
    <script>
        alert("Hello World");
    </script>
    <!--外部JS-->
    <script src="js/a.js"></script>
</head>
<body>
<input type="text">

</body>
</html>
```

a.js

```js
alert("我是外部JS文件");
```

## 2、注释

+ 单行注释：//
+ 多行注释：/**/

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JS注释</title>
    
    <script>
        //单行注释
        
        /*
         * 多行注释
         * */
    </script>
</head>
<body>

</body>
</html>
```

## 3、数据类型

+ 原始数据类型（基本类型）
  + number：数字。整数 / 小数 / Nan（not a number，一个不是数字的数字类型）
  + string：字符串。字符 / 字符串，如："abc"，"a"，'abc'
  + boolean：true或false
  + null：一个对象为空的占位符
  + undefined：未定义。如果一个变量没有给初始化值，则会被默认赋值为undefined
+ 引用数据类型：对象
  + BOM
  + DOM

## 4、变量

**变量：**一小块存储数据的内存空间

Java语言是强类型的语言，JavaScript是弱类型的语言。

+ **强类型：**开辟变量存储空间时，定义了空间将来存储的数据类型，只能存储固定类型的数据。
+ **弱类型：**在开辟变量存储时，不定义空间将来的存储数据类型，可以存放任意类型的数据

语法：var 变量名 = 初始化值;

```javascript
//定义变量
var a = 3;
alert(3)

a = "abc";
alert(a);

//定义number类型
var num = 1;
var num2 = 1.2;
var num3 = NaN;

//输出到页面上
document.write(num+"<br>");
document.write(num2+"<br>");
document.write(num3+"<br>");

//定义string类型
var str1 = "abc";
var str2 = 'def';
document.write(str1+"<br>");
document.write(str2+"<br>");

//定义boolean类型
var flag = true;
document.write(flag+"<br>");

//定义null
var obj1 = null;
var obj2 = undefined;
var obj3;
document.write(obj1+"<br>");
document.write(obj2+"<br>");
document.write(obj3+"<br>");
```

 typeof运算符：获取变量的类型

+ 注：null运算后得到的是object

```javascript
var num = 1;
document.write(num+"---"+typeof(num)+"<br>");
var num1 = NaN;
document.write(num1+"---"+typeof(num1)+"<br>");
var str = "abc";
document.write(str+"---"+typeof(str)+"<br>");
var obj = null;
document.write(obj+"---"+typeof(obj)+"<br>");
var obj1 = undefined;
document.write(obj1+"---"+typeof(obj1)+"<br>");

/*
1---number
abc---string
NaN---number
null---object
undefined---undefined
*/
```

## 5、运算符

+ 一元运算符：只有一个元素数的运算符。++，--等
+ 算数运算符：+，- ，*，/，%等
+ 赋值运算符：=，+=，-=等
+ 比较运算符：<，>，>=等
  + 类型相同，直接比较
    + 字符串：按字典顺序比较
  + 类型不同，先转换再比较
+ 逻辑运算符：&&，||，!
  + !：会将其他类型转换为boolean类型
+ 三元运算符：? :

**类型转换：**

+ string转number：按照字面值转换，如果字面值不是数字，则转为NaN（不是数字的数字）
+ boolean转number：true转为1，false转为0
+ 其他类型转boolean：
  + number：0或NaN为假，非0为真
  + string：除了空字符串，其他都是true
  + null和undefined：false
  + 非空对象：true

```javascript
var num = 3;
var a = num++;
document.write(num+"<br>");
document.write(a + "<br>");

var b = +"123";
//alert(typeof (b));
document.write(b+1 + "<br>");

var c = +"abc";
//alert(typeof (b));
document.write(c+1 + "<br>");       //NaN

document.write((3 > 4) + "<br>");     //false
document.write(("123" > 122) + "<br>");     //true

var num2 = 4;
var num3 = 0;
var num4 = NaN;
document.write(!!num2+ "<br>");      //true
document.write(!!num3+ "<br>");      //false
document.write(!!num4+ "<br>");      //false

str1 = "abc";
str2 = "";
document.write(!!str1+ "<br>");     //true
document.write(!!str2+ "<br>");     //false

var obj = null;
var obj2;
document.write(!!obj+ "<br>");     //false
document.write(!!obj2+ "<br>");     //false

var date = new Date();
document.write(!!date+"<br>");  //true

obj = "123";
if(obj != null && obj.length >0) {    //防止空指针异常
     alert(123);
}
//JS中可以这样定义简化书写
if(obj) {  //防止空指针异常
     alert(111)
}

var d = 3;
var e = 4;
var f = d > e ? 1 : 0;
alert(f);       //0
```

## 6、特殊语法

+ 语句以分号（;）结尾，如果一行只有一条语句，分号可以省略，不建议使用
+ 变量的定义使用var关键字，也可以不用，不建议使用
  + 用：定义的变量是局部变量
  + 不用：定义的变量是全局变量

```javascript
//如果一行只有一条语句，分号可以省略，不建议使用
var a = 3;
alert(a);

/*
* 变量的定义使用var关键字，也可以不使用，不建议使用
* */
var b = 4;      //局部变量
c = 5;          //全局变量
alert(b);
alert(c);
```

## 7、流程控制语句

+ if...else
+ switch
  + 在java中，switch语句可以接收的数据类型：byte int shot char 枚举 String
  + 在JS中，switch语句可以接收任意的数据类型
+ while
+ do...while
+ for

```javascript
var a;
switch (a) {
	case 1:
		alert("number");
		break;
	case "abc":
		alert("string");
		break;
	case true:
		alert("boolean");
		break;
	case null:
		alert("null");
		break;
	case undefined:
		alert("undefined");
		break;
}
```

# 三、基本对象

+ Function：函数对象
+ Array：数组
+ Boolean
+ Date
+ Math
+ Number
+ String
+ RegExp：正则表达式
+ Global：全局对象

## 1、Function对象

 ```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Function对象</title>
    <script>
        /*
         * Function：函数(方法)对象
         * 1、创建
         *      1、var fun = new Function(形式参数列表，方法体);       //不常用
         *      2、function 方法名称(形式参数列表) {方法体}
         *      3、var 方法名 = function(形式参数列表){方法体}
         * 2、属性
         *      length：形参的个数
         * 3、特点
         *      1、方法定义时，形参的类型不用写，返回值类型也不用写
         *      2、方法是一个对象，如果定义名称相同的方法，会覆盖
         *      3、在JS中，方法的调用只与方法的名称有关，和参数列表无关
         *      4、在方法声明中，有一个隐藏的内置对象(数组)，arguments，封装所有的实际参数
         * 4、调用
         *      方法名称(实际参数列表);
         * */

        //创建方式1
        var fun1 = new Function("a", "b", "alert(a);");
        // fun1(3,4);
        // alert(fun1.length);

        //创建方式2
        function fun2(a, b) {
            alert(a+b);
        }
        // fun2(3,4);
        // alert(fun2.length);

        //创建方式3
        var fun3 = function(a,b){
            alert(a+b);
        }
        // fun3(3,4);
        // alert(fun3.length);

        function fun4(a,b){
            alert(a);
            alert(b);
        }
        //方法调用
        // fun4(1);        //名字和参数列表不匹配，第二个是undefined
        // fun4(1,2,3);    //1,2

        //求两个数的和
        function add1(a,b) {
            return a+b;
        }
        var sum1 = add1(1,2);
        // alert(sum1);

        //求任意个数的和
        function add2(){
            var sum = 0;
            for (var i = 0; i < arguments.length; i++) {
                sum += arguments[i];
            }
            return sum;
        }
        var sum2 = add2(1,2,3,4);
        alert(sum2);
    </script>
</head>
<body>

</body>
</html>
 ```

## 2、Array对象

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Array对象</title>
    <script>
        /*
         * Array：数组对象
         * 1、创建 
         *      1、var arr = new Array(元素列表);
         *      2、var arr = new Array(默认长度);
         *      3、var arr = [元素列表];
         * 2、方法
         *      join(参数)：将数组中的元素按照指定的分隔符拼接为字符串
         *      push()：向数组的末尾添加一个或更多元素，并返回新的长度
         * 3、属性
         *      length：数组的长度
         * 4、特点
         *      1、JS中，数组元素的类型可变
         *      2、JS中，数组的长度可变
         * */
        //1、创建方式
        var arr1 = new Array(1,2,3);
        var arr2 = new Array(5);
        var arr3 = [1,2,3,4];

        document.write(arr1+"<br>");
        document.write(arr2+"<br>");
        document.write(arr3+"<br>");

        var arr = [1, "abc", true];
        document.write(arr[0] + "<br>");    //1
        document.write(arr[1] + "<br>");    //abc
        document.write(arr[2] + "<br>");    //true
        document.write(arr[3] + "<br>");    //undefined，数组长度可变

        //document.write(arr[10] + "<br>");
        arr[10] = "hehe";
        document.write(arr[10] + "<br>");   //hehe
        document.write(arr[9] + "<br>");    //undefined

        alert(arr.length);  //11
        document.write(arr.join("--") + "<br>");
        arr.push(11);
        document.write(arr.join("--") + "<br>");
    </script>
</head>
<body>

</body>
</html>
```

## 3、Date对象   

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Date对象</title>
    <script>
        /*
         * 1、创建
         *      var date = new Date();
         * 2、方法
         *      toLocaleString：返回当前date对象对应的时间本地字符串格式
         *      getTime()：获取毫秒值，返回当前时间对象描述的时间到1970年1月1日零点的毫秒值差
         * */

        var date = new Date();
        document.write(date + "<br>");
        document.write(date.toLocaleString() + "<br>");
        document.write(date.getTime() + "<br>");
    </script>
</head>
<body>

</body>
</html>
```

## 4、Math对象

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Math对象</title>
    <script>
        /*
         * 1、创建
         *      特点：Math对象不用创建，直接使用。Math.方法名();
         * 2、方法
         *      random()：[0,1)之间的随机数，含0不含1
         *      ceil(x)：向上取整
         *      floor(x)：向下取整
         *      round(x)：四舍五入最接近的整数
         * 3、属性
         *      PI
         * */
        document.write(Math.PI + "<br>");
        document.write(Math.random() + "<br>");
        document.write(Math.ceil(3.14) + "<br>");
        document.write(Math.floor(3.14) + "<br>");
        document.write(Math.round(3.14) + "<br>");

        /*
         * 取1~100之间的随机整数
         *      1、Math.random()产生随机数，范围[0,1]小数
         *      2、乘以100-->[0,99.99]小数
         *      3、舍弃小数部分：floor-->[0,99]整数
         *      4、+1-->[1,100]
         * */
        var num = Math.floor((Math.random() *100) + 1);
        document.write(num);
    </script>
</head>
<body>

</body>
</html>
```

## 5、RegExp对象：正则表达式

**正则表达式：**定义字符串的组成规则

**1、单个字符：[]**

如：[a] [ab] [a-zA-Z0-9_]

特殊符号代表特殊含义的单个字符：

+ \d：单个数字字符[0-9]

+ \w：单个单词字符[a-zA-Z0-9_]

**2、量词符号**

+ ?：表示出现0次或1次

+ *：表示0次或多次

+ +：表示1次或多次
+ {m,n}：表示 m<=数量<=n
  + m如果缺省，{,n}：最多n次
  + n如果缺省，{m,}：最少m次

**3、开始结束符号**

+ ^：开始
+ $：结束

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>正则表达式对象RegExp</title>
    <script>
        /*
         * 1、创建
         *      1、var reg = new RegExp("正则表达式");
         *      2、var reg = /正则表达式/;
         * 2、方法
         *      test(参数)：验证指定的字符串是否符合正则定义的规范
         * */
        var reg = new RegExp("\\w{6,12}");  //两个\是因为转义符号
        var reg2 = /^\w{6,12}$/;

        // alert(reg);
        // alert(reg2);

        var username = "zhangsan";
        //验证
        var flag = reg2.test(username);
        alert(flag);    //true

    </script>
</head>
<body>

</body>
</html>
```

## 6、Global对象：全局对象

特点：全局对象，这个Global中封装的方法不需要对象就可以直接调用。方法名();

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>全局对象Global</title>
    <script>
        /*
         * 1、特点：全局对象，这个Global中封装的方法不需要对象就可以直接调用。方法名();
         * 2、方法：
         *      encodeURI()：URL的编码
         *      decodeURI()：URL的解码
         *
         *      encodeURIComponent()：URL的编码，编码的字符更多
         *      decodeURIComponent()：URL的解码
         *
         *      parseInt()：将字符串转为数字
         *      逐一判断每一个字符是否是数字，直到不是数字为止，将前边数字部分转为number
         *      isNaN()：判断一个值是否是NaN
         *          NaN全都不认，自身参与==的比较是false
         *      eval()：将JS字符串，转为脚本代码执行
         * 3、URL编码
         * */
        var str = "苍蓝星";
        var encode = encodeURI(str);
        document.write(encode + "<br>");    //%E8%8B%8D%E8%93%9D%E6%98%9F
        var s = decodeURI(encode);
        document.write(s + "<br>");     //苍蓝星

        var str2 = "123abc";
        var number = parseInt(str2);
        // alert(number + 1);   //124

        var a = NaN;
        document.write(a == NaN);   //false
        document.write("<br>");
        document.write(isNaN(a));   //true

        var jscode = "alert(123)";
        eval(jscode);   //解析字符串并执行
    </script>
</head>
<body>

</body>
</html>
```

# 四、BOM

## 1、概念

**BOM：**Browser Object Model 浏览器对象模型

+ 将浏览器的各个组成部分封装为对象

## 2、组成

+ Window：窗口对象
+ Navigator：浏览器对象
+ Screen：显示器屏幕对象
+ History：历史记录对象
+ Location：地址栏对象

![BOM](Img\BOM.png)

## 3、Window：窗口对象

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Window对象</title>
</head>
<body>
    <input id="openBtn" type="button" value="打开窗口">
    <input id="closeBtn" type="button" value="关闭窗口">

    <script>
        /*
         * Window：窗口对象
         * 1、创建
         * 2、方法
         *      1、与弹出框有关的方法：
         *          alert() 显示带有以断消息和一个确认按钮的警告框
         *          confirm() 显示带有一段消息以及确认按钮和取消按钮的对话框
         *              如果用户点击确认按钮，方法返回true
         *              如果用户点击取消按钮，方法返回false
         *          prompt() 显示可提示用户输入的对话框
         *              返回值：获取用户输入的值
         *      2、与打开关闭有关的方法
         *          close()：关闭浏览器窗口
         *              谁调用就关闭谁
         *          open()：打开一个新的浏览器窗口
         *              返回一个新的Window对象
         *      3、与定时器有关的方法
         *          setTimeout()：在指定的毫秒数后调用函数或计算表达式
         *              参数：
         *                  JS代码或者方法对象
         *                  毫秒值
         *              返回值：唯一标识，用于取消定时器
         *          clearTimeout()：取消由setTimeout()方法设置的timeout
         *          setInterval()：按照指定的周期(以毫秒计)来调用函数或计算表达式
         *          clearInterval()：取消由setInterval()设置的timeout
         * 3、属性
         *      1、获取其他BOM对象：history，location，Navigator，Screen
         *      2、获取DOM对象：document
         * 4、特点
         *      Window对象不需要创建，可以直接使用window使用。window.方法名()
         *      window引用可以省略。方法名();
         * */

        //警告框
        alert("Hello window");
        window.alert("Hello window");

        //确认框
        var flag = confirm("确认退出？");   //两个按钮，确定or取消
        if (flag) {
            //退出
            alert("欢迎再次");
        } else {
            //提示
            alert("手别抖");
        }

        //输入框
        var result = prompt("请输入用户名");
        alert(result);

        //打开一个新窗口
        var openBtn = document.getElementById("openBtn");
        var newWindow;
        openBtn.onclick = function() {
            newWindow = open("https://www.baidu.com");
        }

        //关闭窗口
        var closeBtn = document.getElementById("closeBtn");
        closeBtn.onclick = function () {
            newWindow.close();    //关闭新窗口
        }

        //一次性定时器
        // setTimeout("fun()", 2000);
        var id1 = setTimeout(fun, 2000);
        clearTimeout(id1);
        function fun() {
            alert('boom...');
        }

        //循环定时器
        var id2 = setInterval(fun, 3000);
        clearInterval(id2);

        //获取history
        var h1 = window.history;
        var h2 = history;

        alert(h1);
        alert(h2);

        //获取document对象
        window.document.getElementById("");
        document.getElementById("");
    </script>
</body>
</html>
```

轮播图案例：

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>轮播图案例</title>
</head>
<body>
    <img id="img" src="img/banner1.png" width="100%">

    <script>
        /*
         * 分析：
         * 1、在页面上使用img标签展示图片
         * 2、定义一个方法，修改图片对象的src属性
         * 3、定义一个定时器，每个3秒调用方法一次
         * */

        //1、修改图片src属性
        var number = 1;
        function fun() {
            number++;
            //判断number是否大于3
            if (number > 3) {
                number = 1;
            }
            var img = document.getElementById("img");
            img.src = "img/banner" + number + ".png";
        }

        //2、定义定时器
        setInterval(fun, 3000);
    </script>
</body>
</html>
```

## 4、Location：地址栏对象

 ```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Location对象</title>
</head>
<body>
    <input type="button" id="btn" value="刷新">
    <input type="button" id="go" value="去新大陆">


    <script>
        /*
         * 1、创建（获取）
         *      1、window.location
         *      2、location
         * 2、方法
         *      reload() 重新加载当前文档，刷新
         * 3、属性
         *      href 设置或返回完整的URL
         * */

        //reload方法，定义一个按钮，点击按钮，刷新当前页面
        //1、获取按钮
        var btn = document.getElementById("btn");
        //2、绑定单击事件
        btn.onclick = function () {
            //3、刷新页面
            location.reload();
        }

        //获取href
        var href = location.href;
        // alert(href);

        //点击按钮，去访问www.baidu.com
        //1、获取按钮
        var go = document.getElementById("go");
        //2、绑定单击事件
        go.onclick = function () {
            location.href = "https://www.baidu.com";
        }
    </script>
</body>
</html>
 ```

自动跳转案例：

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>自动跳转案例</title>
    <style>
        p {
            text-align: center;
        }
        span{
            color: red;
        }
    </style>

</head>
<body>
    <p>
        <span id="time">5</span>秒之后，自动跳转首页...
    </p>

    <script>
        /*
         * 分析：
         * 1、显示页面效果 <p>
         * 2、倒计时读秒
         *      2.1 定义一个方法，获取span方法，修改span标签体的内容
         *      2.2 定义一个定时器，1秒执行一次该方法
         * 3、在方法中判断时间如果<=0，则跳转到首页
         * */
        //倒计时读秒效果实现
        var second = 5;
        var time = document.getElementById("time");
        function showTime() {
            second--;
            //时间如果<=0，则跳转到首页
            if (second <= 0) {
                location.href = "https://www.baidu.com";
            }
            time.innerHTML = second + "";
        }

        //设置定时器，1秒执行一次该方法
        setInterval(showTime, 1000);

    </script>
</body>
</html>
```

##  5、History：历史记录对象

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>History对象</title>
</head>
<body>
    <input type="button" id="btn" value="获取历史记录个数">
    <a href="05_案例2轮播图.html">05页面</a>
    <input type="button" id="forward" value="前进">
    <script>
        /*
         * 1、创建（获取）：
         *      1、window.history
         *      2、history
         * 2、方法：
         *      back() 加载history列表中的前一个URL
         *      forward() 加载history列表中的下一个URL
         *      go() 加载history列表中的某个具体页面
         * 3、属性：
         *      length 返回当前窗口历史列表中的URL数量
         * */
        //1、获取按钮
        var btn = document.getElementById("btn");
        //2、绑定单击事件
        btn.onclick = function () {
            //3、获取历史记录个数
            var length = history.length;
            alert(length);
        }

        //1、获取按钮
        var forward = document.getElementById("forward");
        //2、绑定单击事件
        forward.onclick = function () {
            //3、获取历史记录个数
            var length = history.forward();
        }
    </script>
</body>
</html>
```



# 五、DOM

## 1、简单学习

**DOM：**Document Object Model，文档对象模型。将标记语言文档的各个组成部分，封装为对象，可以使用这些对象，对标记语言文档进行CRUD的动态操作。

![DOM](Img\DOM.png)

![DOM2](Img\DOM2.png)

**功能：**控制html文档的内容

**W3C DOM标准分为3个组成部分：**

+ 核心DOM：针对任何结构化文档的标准模型
  + Document：文档对象
  + Element：元素对象
  + Attribute：属性对象
  + Text：文本对象
  + Comment：注释对象
  + Node：节点对象，其他5个父对象
+ XML DOM：针对XML文档的标准模型
+ HTML DOM：针对HTML文档的标准模型

代码：获取页面标签（元素）对象 Element

+ document.getElementById("Id值")：通过元素的id获取元素对象

操作Element对象：

+ 修改属性值
  + 明确获取对象是哪一个
  + 查看API文档，找其中哪写属性可以设置
+ 修改标签体内容  
  + 获取元素对象
  + 使用innerHTML属性，修改标签体内容 

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>DOM获取元素对象</title>
</head>
<body>
    <img id="light" src="../img/off.png">
    <h1 id="title">大标题</h1>
    <script>
        //通过id获取元素对象
        // var light = document.getElementById("light");
        // alert("换图片");
        // light.src = "../img/on.png";

        //获取h1标签对象
        var title = document.getElementById("title");
        alert("换内容");
        //修改内容
        title.innerHTML = "超级大标题";
    </script>
</body>
</html>
```

**事件：**

功能：某些组件被执行了某些操作后，触发某些代码的执行

**如何绑定事件：**

+ 直接在html标签上，指定事件的属性（操作），属性值就是JS代码，耦合度高
  + 事件：onclick---单击事件
+ 通过JS获取元素对象，指定时间属性，设置一个函数

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>事件绑定</title>
</head>
<body>
    <!--第一种方式，耦合度高-->
    <img id="light" src="../img/off.png" onclick="fun();">
    <!--第二种方式-->
    <img id="light2" src="../img/off.png">

    <script>
        function fun(){
            alert('被点了');
            alert('又被点了');
        }

        function fun2() {
            alert('还点我？')
        }

        //1、获取light2对象
        let light2 = document.getElementById("light2");
        //2、绑定事件
        light2.onclick = fun2;
    </script>
</body>
</html>
```

开关灯的案例：

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>案例1：开关灯</title>
</head>
<body>
    <img id="light" src="../img/off.png">

    <script>
        /*
         * 分析：
         * 1、获取图片对象
         * 2、绑定单击事件
         * 3、每次点击切换图片
         * 规则：
         *      如果灯是开的 on，切换图片为off
         *      如果灯是开的 off，切换图片为on
         * 使用标记flag完成
         * */
        //1、获取图片对象
        var light = document.getElementById("light");
        var flag = false;   //代表灯是灭的。off
        //2、绑定单击事件
        light.onclick = function() {
            //判断，如果灯是开的，则灭掉
            if (flag) {
                light.src = "../img/off.png";
                flag = false;
            } else {    //灯灭则打开
                light.src = "../img/on.png";
                flag = true;
            }
        }
    </script>
</body>
</html>
```

## 2、Document对象 

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document对象</title>
</head>
<body>
    <div id="div1">div1</div>
    <div id="div2">div2</div>
    <div id="div3">div3</div>

    <div class="cls1">div4</div>
    <div class="cls1">div5</div>

    <input type="text" name="username">

    <script>
        /*
         * Document：文档对象
         * 1、创建（获取）：在html dom模型中可以使用window对象来获取
         *      1、window.document
         *      2、document
         * 2、方法
         *      1、获取Element对象
         *          1、getElementById()：根据id属性值获取元素对象，id属性值一般唯一
         *          2、getElementsByTagName()：根据元素名称获取元素对象们，返回值是一个数组
         *          3、getElementsByClassName()：根据Class属性值获取元素对象们，返回一个数组
         *          4、getElementsByName()：根据name属性值获取元素对象们，返回值是一个数组
         *      2、创建其他DOM对象
         *          createAttribute(name)
         *          createComment()
         *          createElement()
         *          createTextNode()
         * 3、属性
         * */

        //根据元素名称获取元素对象们，返回值是一个数组
        var divs = document.getElementsByTagName("div");
        // alert(divs.length);
        //根据Class属性值获取元素对象们，返回值是一个数组
        var div_cls = document.getElementsByClassName("cls1");
        // alert(div_cls.length);
        //根据name属性值获取元素对象们，返回值是一个数组
        var ele_username = document.getElementsByName("username");
        // alert(ele_username.length);

        var table = document.createElement("table");
        alert(table);

    </script>

</body>
</html>
```

## 3、Element：元素对象

获取/创建：通过document来获取和创建

方法：

+ removeAttribute()：删除属性
+ setAttribute()：设置属性

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Element对象</title>
</head>
<body>
    <a>点我试一试</a>
    <input type="button" id="btn_set" value="设置属性">
    <input type="button" id="btn_remove" value="删除属性">

<script>
    //获取btn
    var btn_set = document.getElementById("btn_set");
    btn_set.onclick = function(){
        //1、获取a标签
        var element_a = document.getElementsByTagName("a")[0];
        element_a.setAttribute("href", "https://www.baidu.com");
    }

    //获取btn
    var btn_remove = document.getElementById("btn_remove");
    btn_remove.onclick = function(){
        //1、获取a标签
        var element_a = document.getElementsByTagName("a")[0];
        element_a.removeAttribute("href");
    }
</script>
</body>
</html>
```

## 4、Node：节点对象

**Node：**节点对象，其他5个的父对象 

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Node对象</title>
    <style>
        div {
            border: 1px solid red;
        }
        #div1 {
             width: 200px;
             height: 200px;
        }
        #div2 {
            width: 100px;
            height: 100px;
        }
        #div3 {
            width: 100px;
            height: 100px;
            border: 1px solid red;
        }
    </style>
</head>
    <div id="div1">
        <div id="div2">
            div2
        </div>
        div1
    </div>
    <a href="javascript:void(0);" id="del">删除子结点</a>
    <a href="javascript:void(0);" id="add">添加子结点</a>
<!--    <input type="button" id="del" value="删除子结点">-->

    <script>
        /*
         * 1、特点：所有DOM对象都可以被认为是一个节点
         * 2、方法：
         *      CRUD DOM树：
         *      appendChild()：向节点的子结点列表的结尾添加新的子结点
         *      removeChild()：删除(并返回)当前节点的指定子结点
         *      replaceChild()：用新节点替换一个子结点
         * 3、属性
         *      parentNode
         * */

        //1、获取超链接
        var element_a = document.getElementById("del");
        //2、绑定单击事件
        element_a.onclick = function () {
            var div1 = document.getElementById("div1");
            var div2 = document.getElementById("div2");
            div1.removeChild(div2);
        }

        //1、获取超链接
        var element_add = document.getElementById("add");
        //2、绑定单击事件
        element_add.onclick = function () {
            var div1 = document.getElementById("div1");
            //给div1添加子结点
            //创建div节点
            var div3 = document.createElement("div");
            div3.setAttribute("id", "div3");
            div1.appendChild(div3);
        }

        /*
         * 超链接功能：
         * 1、可以被点击，样式
         * 2、点击后跳转到href指定的url
         * 需求：保留1功能，去掉2功能
         * 实现:href="javascript:void(0);"
         * */

        var div2 = document.getElementById("div2");
        var div1 = div2.parentNode;
        alert(div1);
    </script>
</body>
</html>
```

## 5、动态表格案例

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>动态表格案例</title>
    <style>
        table {
            border: 1px solid;
            margin: auto;
            width: 500px;
        }
        td,th{
            text-align: center;
            border: 1px solid;
        }
        div{
            text-align: center;
            margin: 50px;
        }
    </style>
</head>
<body>
    <div>
        <input type="text" id="id" placeholder="请输入编号">
        <input type="text" id="name" placeholder="请输入姓名">
        <input type="text" id="gender" placeholder="请输入性别">
        <input type="button" id="btn_add" value="添加">
    </div>

    <table>
        <caption>学生信息表</caption>
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>操作</th>
        </tr>

        <tr>
            <td>1</td>
            <td>令狐冲</td>
            <td>男</td>
            <td><a href="javascript:void(0);" onclick="delTr(this);">删除</a></td>
        </tr>

        <tr>
            <td>2</td>
            <td>任我行</td>
            <td>男</td>
            <td><a href="javascript:void(0);" onclick="delTr(this);">删除</a></td>
        </tr>

        <tr>
            <td>3</td>
            <td>岳不群</td>
            <td>男</td>
            <td><a href="javascript:void(0);" onclick="delTr(this);">删除</a></td>
        </tr>
    </table>

    <script>
        /*
         * 分析：
         * 1、添加
         *      1、给添加按钮绑定单击事件
         *      2、获取文本框的内容
         *      3、创建td，设置td的文本为文本框的内容
         *      4、创建tr
         *      5、将td添加到tr中
         *      6、获取table，将tr添加到table中
         * 2、删除
         *      1、确定点击的是哪一个超链接
         *          <a href="javascript:void(0);" onclick="delTr(this);">删除</a>
         *      2、如何删除
         *          removeChild()：通过父节点删除子结点
         * */

        //1、获取按钮
        document.getElementById("btn_add").onclick = function () {
            //2、获取文本框的内容
            var id = document.getElementById("id").value;
            var name = document.getElementById("name").value;
            var gender = document.getElementById("gender").value;

            //3、创建td，赋值td的标签体
            //id的td
            var td_id = document.createElement("td");
            var text_id = document.createTextNode(id);
            td_id.appendChild(text_id);
            //name的td
            var td_name = document.createElement("td");
            var text_name = document.createTextNode(name);
            td_name.appendChild(text_name);
            //gender的td
            var td_gender = document.createElement("td");
            var text_gender = document.createTextNode(gender);
            td_gender.appendChild(text_gender);
            //a标签的td
            var td_a = document.createElement("td");
            var ele_a = document.createElement("a");
            // javascript:void(0);
            ele_a.setAttribute("href", "javascript:void(0);");
            ele_a.setAttribute("onclick", "delTr(this);");
            var text_a = document.createTextNode("删除");
            ele_a.appendChild(text_a);
            td_a.appendChild(ele_a);

            //4、创建tr
            var tr = document.createElement("tr");

            //5、添加td到tr中
            tr.appendChild(td_id);
            tr.appendChild(td_name);
            tr.appendChild(td_gender);
            tr.appendChild(td_a);

            //6、获取table
            var table = document.getElementsByTagName("table")[0];
            table.appendChild(tr);
        }
        
        //删除方法
        function delTr(obj) {
            var table = obj.parentNode.parentNode.parentNode;
            var tr = obj.parentNode.parentNode;
            table.removeChild(tr);
        }
    </script>
</body>
</html>
```

## 6、HTML DOM

* 标签体的设置和获取：innerHTML
* 使用html元素对象的属性

* 控制样式 
  * 使用元素的style属性设置
  * 提前定义好类选择器的样式，通过元素的className属性来设置class属性值

innerHTML示例

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HTMLDOM</title>
</head>
<body>
    <div id="div1">
        div
    </div>

    <script>
        var div = document.getElementById("div1");
        var innerHTML = div.innerHTML;
        // alert(innerHTML);
        //div标签中替换一个文本输入框
        // div.innerHTML = "<input type='text'>";
        //div标签中追加一个文本输入框
        div.innerHTML += "<input type='text'>";
    </script>
</body>
</html>
```

动态表格案例优化：

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>动态表格优化</title>
    <style>
        table {
            border: 1px solid;
            margin: auto;
            width: 500px;
        }
        td,th{
            text-align: center;
            border: 1px solid;
        }
        div{
            text-align: center;
            margin: 50px;
        }
    </style>
</head>
<body>
<div>
    <input type="text" id="id" placeholder="请输入编号">
    <input type="text" id="name" placeholder="请输入姓名">
    <input type="text" id="gender" placeholder="请输入性别">
    <input type="button" id="btn_add" value="添加">
</div>

<table>
    <caption>学生信息表</caption>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>操作</th>
    </tr>

    <tr>
        <td>1</td>
        <td>令狐冲</td>
        <td>男</td>
        <td><a href="javascript:void(0);" onclick="delTr(this);">删除</a></td>
    </tr>

    <tr>
        <td>2</td>
        <td>任我行</td>
        <td>男</td>
        <td><a href="javascript:void(0);" onclick="delTr(this);">删除</a></td>
    </tr>

    <tr>
        <td>3</td>
        <td>岳不群</td>
        <td>男</td>
        <td><a href="javascript:void(0);" onclick="delTr(this);">删除</a></td>
    </tr>
</table>

<script>

    //使用innerHTML添加
    document.getElementById("btn_add").onclick = function () {
        //2、获取文本框的内容
        var id = document.getElementById("id").value;
        var name = document.getElementById("name").value;
        var gender = document.getElementById("gender").value;

        //获取table
        var table = document.getElementsByTagName("table")[0];
        //追加一行
        table.innerHTML += "<tr>\n" +
            "        <td>" + id + "</td>\n" +
            "        <td>" + name + "</td>\n" +
            "        <td>" + gender + "</td>\n" +
            "        <td><a href=\"javascript:void(0);\" onclick=\"delTr(this);\">删除</a></td>\n" +
            "    </tr>";
    }

    //删除方法
    function delTr(obj) {
        var table = obj.parentNode.parentNode.parentNode;
        var tr = obj.parentNode.parentNode;
        table.removeChild(tr);
    }
</script>
</body>
</html>
```

控制样式：

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>控制样式</title>
    <style>
        .d1{
            border: 1px solid red;
            width: 100px;
            height: 100px;
        }
        .d2{
            border: 1px solid blue;
            width: 200px;
            height: 200px;
        }
    </style>
</head>
<body>
    <div id="div1">div</div>
    <div id="div2">div</div>

<script>
    var div1 = document.getElementById("div1");
    div1.onclick = function () {
        //修改样式方式1
        div1.style.border = "1px solid red";
        div1.style.width = "200px";

        //font-size-->fontSize
        div1.style.fontSize = "20px";
    }

    var div2 = document.getElementById("div2");
    div2.onclick = function () {
        div2.className = "d1";
    }

</script>
</body>
</html>
```

## 7、事件监听机制

**概念：**某些**组件**被执行了**某些操作**后，触发**某些代码**的执行

**事件：**某些操作，如：单击、双击、键盘按下、鼠标移动

**事件源：**某些组件，如：按钮、文本输入框

**注册监听：**将事件，事件源，监听器结合在一起。当事件源上发生了某个事件，则触发执行某个监听器代码。

常见的事件：

+ 点击事件
  + onclick：单击事件
  + ondblclick：双击事件
+ 焦点事件
  + onblur：失去焦点
    + 一般用于表单校验
  + onfocus：获得焦点
+ 加载事件
  + onload：一张页面或一副图享完成加载
+ 鼠标事件
  + onmousedown：鼠标被按下
    + 定义方法时，定义一个形参，接收event对象，event对象的button属性可以获取鼠标的哪个键被点击了
  + onmousemove：鼠标移动
  + onmouseout：鼠标移开
  + onmouseover：鼠标移到某元素上
  + onmouseup：鼠标按键被松开
+ 键盘事件
  + onkeydown：某个键盘按下
  + onkeyup：某个键盘哦是那个开
  + onkeypress：键盘按下并松开
+ 选中和改变
  + onchange：域的内容被改变
  + onselect：文本被选中
+ 表单事件
  + onsubmit：表单提交
    + 可以阻止表单提交
      + 方法返回false则表单被阻止提交
  + onreset：表单重置

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>常见事件</title>
</head>
<body>
    <form action="#" id="form" onsubmit="return checkForm();">
        <input name="username" id="username">
        <select id="city">
            <option>--请选择--</option>
            <option>北京</option>
            <option>上海</option>
        </select>
        <input type="submit" value="提交">
    </form>

    <script>
        //1、失去焦点事件
        document.getElementById("username").onblur = function () {
            alert("失去焦点了");
        }

        //2、加载完成事件 onload
        window.onload = function () {
            // alert("加载完成了");
            document.getElementById("username").onblur = function () {
                // alert("失去焦点了");
            }
        }

        //3、鼠标移动到元素之上的事件
        document.getElementById("username").onmouseover = function () {
            // alert("鼠标来了");
        }

        //4、鼠标点击事件
        document.getElementById("username").onmousedown = function (event) {
            // alert("鼠标点击了");
            // alert(event.button);
        }

        //5、键盘点击事件
        document.getElementById("username").onkeydown = function (event) {
            if(event.keyCode == 13) {
                alert("提交表单");
            }
        }

        //6、内容改变事件
        document.getElementById("city").onchange = function (event) {
            alert("改变了");
        }

        //7、表单提交事件
        // document.getElementById("form").onsubmit = function () {
        //     //校验用户名格式是否正确
        //     var flag = true;
        //     return flag;
        // }

        function checkForm() {
            return false;
        }
    </script>
</body>
</html>
```

## 8、表格全选案例

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>表格全选</title>
    <style>
        table {
            border: 1px solid;
            margin: auto;
            width: 500px;
        }
        td,th{
            text-align: center;
            border: 1px solid;
        }
        div{
            margin-top: 10px;
            margin-left: 40%;
        }
        .out{
            background-color: white;
        }
        .over{
            background-color: pink;
        }
    </style>
    <script>
        /*
         * 分析：
         * 1、全选
         *      获取所有的checkbox
         *      遍历checkbox，设置每一个checkbox的状态为选中
         * 2、全不选
         * 3、选中
         * */

        //1、在页面加载完之后绑定事件
        window.onload = function () {
            //2、给全选按钮绑定单击事件
            document.getElementById("selectAll").onclick = function () {
                //全选
                //1、获取所有的checkbox
                var cbs = document.getElementsByName("cb");
                //2、遍历
                for (var i = 0; i < cbs.length; i++) {
                    //3、设置每一个checkbox的状态为选中 checked
                    cbs[i].checked = true;
                }
            }

            //2、给全不选按钮绑定单击事件
            document.getElementById("unSelectAll").onclick = function () {
                //全不选
                //1、获取所有的checkbox
                var cbs = document.getElementsByName("cb");
                //2、遍历
                for (var i = 0; i < cbs.length; i++) {
                    //3、设置每一个checkbox的状态为未选中 false
                    cbs[i].checked = false;
                }
            }

            //3、给反选按钮绑定单击事件
            document.getElementById("selectRev").onclick = function () {
                //反选
                //1、获取所有的checkbox
                var cbs = document.getElementsByName("cb");
                //2、遍历
                for (var i = 0; i < cbs.length; i++) {
                    //3、选中状态则变未选中，否则相反
                    cbs[i].checked = !cbs[i].checked;
                }
            }

            //4、第一个选中则全选
            document.getElementById("firstCb").onclick = function () {
                //1、获取所有的checkbox
                var cbs = document.getElementsByName("cb");
                //2、遍历
                for (var i = 0; i < cbs.length; i++) {
                    //3、设置每一个cb的状态和第一个cb状态一样
                    cbs[i].checked = this.checked;
                }
            }

            //给所有tr绑定鼠标移到元素之上和移出元素事件
            var trs = document.getElementsByTagName("tr");
            //2、遍历
            for (var i = 0; i < trs.length; i++) {
                //移到元素之上
                trs[i].onmouseover = function () {
                    this.className = "over";
                }
                //移出元素
                trs[i].onmouseout = function () {
                    this.className = "out";
                }
            }
        }
    </script>
</head>
<body>

    <table>
        <caption>学生信息表</caption>
        <tr>
            <th><input type="checkbox" name="cb" id="firstCb"></th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>操作</th>
        </tr>

        <tr>
            <td><input type="checkbox" name="cb"></td>
            <td>1</td>
            <td>令狐冲</td>
            <td>男</td>
            <td><a href="javascript:void(0);" onclick="delTr(this);">删除</a></td>
        </tr>

        <tr>
            <td><input type="checkbox" name="cb"></td>
            <td>2</td>
            <td>任我行</td>
            <td>男</td>
            <td><a href="javascript:void(0);" onclick="delTr(this);">删除</a></td>
        </tr>

        <tr>
            <td><input type="checkbox" name="cb"></td>
            <td>3</td>
            <td>岳不群</td>
            <td>男</td>
            <td><a href="javascript:void(0);" onclick="delTr(this);">删除</a></td>
        </tr>
    </table>
    <div>
        <input type="button" id="selectAll" value="全选">
        <input type="button" id="unSelectAll" value="全不选">
        <input type="button" id="selectRev" value="反选">
    </div>
</body>
</html>
```

## 9、表单检验案例

```html
<!DOCTYPE html>
<html lang="ch">
<head>
    <meta charset="UTF-8">
    <title>表单校验案例</title>
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
        .error{
            color: red;
        }
    </style>
    <script>
        /*
         * 分析：
         * 1、给表单绑定onsubmit事件，监听器中判断每一个方法校验的结果。
         *      如果都为true，则监听器方法返回true。
         *      如果都为false，则监听器方法返回false
         * 2、定义一些方法分别校验各个表单项
         * 3、给各个表单项绑定onblur事件。
         * */

        window.onload = function () {
            //1、给表单绑定onsubmit事件，监听器中判断每一个方法校验的结果。
            document.getElementById("form").onsubmit = function () {
                //调用用户名校验方法 checkUsername();
                //调用密码校验方法  checkPassword();
                return checkUsername() && checkPassword();
            }

            //给用户名和密码框分别绑定离焦事件
            document.getElementById("username").onblur = checkUsername();
            document.getElementById("password").onblur = checkPassword();
        }

        //校验用户名方法
        function checkUsername() {
            //1、获取用户名的值
            var username = document.getElementById("username").value;
            //2、定义正则表达式
            var reg_username = /^\w{6,12}$/;
            //3、判断值是否符合正则的规则
            var flag = reg_username.test(username);
            //4、提示信息
            var s_username = document.getElementById("s_username");
            if (flag) {
                //提示绿色对勾
                s_username.innerHTML = "<img width='35' height='25' src='img/true.png'>";
            } else {
                //提示红色用户名有误
                s_username.innerHTML = "用户名格式有误";
            }
            return flag;
        }

        //校验密码方法
        function checkPassword() {
            //1、获取密码的值
            var password = document.getElementById("password").value;
            //2、定义正则表达式
            var reg_password = /^\w{6,12}$/;
            //3、判断值是否符合正则的规则
            var flag = reg_password.test(password);
            //4、提示信息
            var s_password = document.getElementById("s_password");
            if (flag) {
                //提示绿色对勾
                s_password.innerHTML = "<img width='35' height='25' src='img/true.png'>";
            } else {
                //提示红色密码有误
                s_password.innerHTML = "密码格式有误";
            }
            return flag;
        }
    </script>
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
            <form action="#" method="get" id="form">
                <table>
                    <tr>
                        <td class="td_left"><label for="username">用户名</label></td>
                        <td class="td_right"><input type="text" name="username" id="username" placeholder="请输入用户名"><span id="s_username" class="error"></span> </td>
                    </tr>
                    <tr>
                        <td class="td_left"><label for="password">密码</label></td>
                        <td class="td_right"><input type="password" name="password" id="password" placeholder="请输入密码"><span id="s_password" class="error"></span>  </td>
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

