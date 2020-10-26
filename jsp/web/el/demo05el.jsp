<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL练习5 隐式对象</title>
</head>
<body>
    <h1>隐式对象</h1>
    ${pageContext.request} <br>                 <%-- org.apache.catalina.connector.RequestFacade@466cd780 --%>
    <h4>动态获取虚拟目录</h4>
    ${pageContext.request.contextPath} <br>     <%-- /jsp --%>

    <%
        //动态获取虚拟目录
        response.sendRedirect(request.getContextPath() + "");
    %>

</body>
</html>
