<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL练习2 运算符</title>
</head>
<body>
    <h3>算数运算符</h3>
    ${3 + 4} <br>   <%-- 7 --%>
    ${3 / 4} <br>   <%-- 0.75 --%>
    ${3 div 4} <br> <%-- 0.75 --%>
    ${3 mod 4} <br> <%-- 3 --%>
    <h3>比较运算符</h3>
    ${3 == 4} <br>   <%-- false --%>
    <h3>逻辑运算符</h3>
    ${3 > 4 && 3 < 4} <br>      <%-- false --%>
    ${3 > 4 and 3 < 4} <br>     <%-- false --%>

    <h3>empty运算符</h3>
    <%
        String str1 = "abc";
        String str2 = "";
        String str3 = null;
        request.setAttribute("str1", str1);
        request.setAttribute("str2", str2);
        request.setAttribute("str3", str3);
    %>
    ${empty str1} <br>      <%-- false，不为空，长度>0 --%>
    ${empty str2} <br>      <%-- true，长度为0 --%>
    ${empty str3} <br>      <%-- true，为空 --%>
    ${not empty str1} <br>  <%-- true，不为空，长度>0 --%>
</body>
</html>
