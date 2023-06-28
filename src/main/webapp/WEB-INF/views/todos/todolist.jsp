<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table>
  <tr>
    <td>id</td>
    <td>content</td>
    <td>작성자</td>
    <td>작성일</td>
    <td>check</td>
    <td>수정</td>
  </tr>
  <c:forEach items="${todolist}" var = "todo">
    <tr>
      <td>${todo.id}</td>
      <td>${todo.content}</td>
      <td>${todo.createAt}</td>
      <td>${todo.name}</td>
      <td>${todo.checked}</td>
    </tr>
  </c:forEach>
  <%--<%--%>
  <%--    List<TodoJoinUser> todos = (List<TodoJoinUser>)request.getAttribute("todolist");--%>
  <%--    if(todos!=null && todos.size() != 0){--%>
  <%--        for (TodoJoinUser todo :todos) {%>--%>
  <%--            <tr>--%>
  <%--                <td><%= todo.getId()%></td>--%>
  <%--                <td><%= todo.getContent()%></td>--%>
  <%--                <td><%= todo.getCreateAt()%></td>--%>
  <%--                <td><%= todo.getName()%></td>--%>
  <%--                <td><%= todo.isChecked()%></td>--%>
  <%--                <%--%>
  <%--                    if(session.getAttribute("uid") == todo.getUid()){--%>
  <%--                %>--%>
  <%--                <td>--%>
  <%--                    <a href="/todoupdate?todoid=<%= todo.getId()%>">수정</a>--%>
  <%--                </td><%--%>
  <%--                    }--%>
  <%--                %>--%>
  <%--            </tr>--%>
  <%--        <%--%>
  <%--        }--%>
  <%--    }--%>
  <%--    %>--%>
</table>