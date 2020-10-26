<%@ page import="domain.User" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL练习4 获取值</title>
</head>
<body>
    <h1>EL获取对象的数据</h1>
    <%
        User user = new User();
        user.setName("张三");
        user.setAge(23);
        user.setBirthday(new Date());

        request.setAttribute("u", user);

        List list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add(user);

        request.setAttribute("list", list);

        Map map = new HashMap();
        map.put("sname", "李四");
        map.put("gender", "男");
        map.put("user", user);

        request.setAttribute("map", map);
    %>

    ${requestScope.u} <br>   <%-- domain.User@752c226f --%>

    <%-- 通过对象的属性获取数据
        setter或getter方法，去掉set或者get，再将剩余部分，首字母变小写
        setName --> name
    --%>

    ${requestScope.u.name} <br> <%-- 张三 --%>
    ${requestScope.u.age} <br>  <%-- 23 --%>
    ${u.birthday} <br>          <%-- Mon Oct 26 18:55:56 CST 2020 --%>
    ${u.birthday.year} <br>     <%-- 120 (1900+120=2020) --%>
    ${u.birthday.month} <br>    <%-- 9 --%>

    ${u.birStr} <br>            <%-- 2020-10-26 19:15:18 --%>

    <h1>获取List的值</h1>
    ${list} <br>                <%-- [aaa, bbb, domain.User@75cc58a9] --%>
    ${list[0]} <br>             <%-- aaa --%>
    ${list[1]} <br>             <%-- bbb --%>
    ${list[10]} <br>            <%-- 索引越界，什么都不显示，忽略异常，可以显示页面 --%>
    ${list[2]} <br>             <%-- domain.User@75cc58a9 --%>
    ${list[2].name} <br>        <%-- 张三 --%>

    <h1>获取Map的值</h1>
    ${map.gender} <br>          <%-- 男 --%>
    ${map["gender"]} <br>       <%-- 男 --%>
    ${map.user.name} <br>       <%-- 张三 --%>
</body>
</html>
