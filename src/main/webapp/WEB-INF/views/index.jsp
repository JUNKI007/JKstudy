<%@ page language="java" pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"
%>
<html>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--</head>--%>
<body>
<h2>Hello World! 안녕 월드</h2>
<p>${serverTime}</p>
<form method="post" action="/user/test2">
    <input name="id">
    <input name="pw">
    <input type="submit">
</form>
</body>
</html>