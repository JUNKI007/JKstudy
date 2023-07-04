<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<body>
<h2>Hello World!ddd</h2>
<c:forEach items="${keys}" var="key">
    <p>key : ${key}</p>
    <p>value : ${map.get(key)}</p>
</c:forEach>

</body>
</html>
