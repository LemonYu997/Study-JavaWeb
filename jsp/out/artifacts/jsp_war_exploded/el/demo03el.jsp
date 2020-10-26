<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL练习3 获取值</title>
</head>
<body>
    <h1>EL获取域中的数据</h1>
    <%
        //在域中存储数据
        session.setAttribute("name", "李四");
        request.setAttribute("name", "张三");
        session.setAttribute("age", "23");
    %>
    <h3>el获取值</h3>
    ${requestScope.name} <br>   <%-- 张三 --%>
    ${sessionScope.age} <br>    <%-- 23 --%>
    ${sessionScope.haha} <br>   <%-- 什么都不显示 --%>

    ${name} <br>                <%-- 张三，因为先找request域 --%>
</body>
</html>
