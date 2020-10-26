<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>EL练习1</title>
</head>
<body>
    <%-- isELIgnored="true" 表示忽略所有el写法，不解析直接展示--%>
    ${3 > 4}    <%-- 解析后，页面显示false --%>
    \${3 > 4}   <%-- 单独忽略，不解析，页面显示${3 > 4} --%>
</body>
</html>
