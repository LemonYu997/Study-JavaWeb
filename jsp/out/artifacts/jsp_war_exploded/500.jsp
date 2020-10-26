<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" language="java" %>
<html>
<head>
    <title>报错</title>
</head>
<body>
    <h1>服务器正忙</h1>
    <%
        String message = exception.getMessage();
        out.println(message);
    %>


</body>
</html>
