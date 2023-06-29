
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <form method="post" action="/user/update">
    <input type="text" value="${password}" name="password">
    <input type="text" value="${name}" name="name">
    <input type="submit">
  </form>
</body>
</html>
