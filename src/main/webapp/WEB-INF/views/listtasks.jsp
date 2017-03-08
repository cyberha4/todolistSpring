<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Список задач</h1>

<c:set var="baseUrl">todolist</c:set>

<a href="/<c:out value="${baseUrl}" />/addtusk">Добавить задачу</a>
<table border="1" width="100%" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>title</th>
        <th>annotation</th>
        <th>status</th>
        <th>type</th>
        <th>text</th>
        <th>Name</th>
        <th></th>
    </tr>

<c:forEach items="${tasksList}" var="task">

    <tr>
    <td><c:out value="${task.id}"></c:out></td>
    <td><c:out value="${task.title}"></c:out></td>
    <td><c:out value="${task.annotation}"></c:out></td>
    <td><c:out value="${task.statusId}"></c:out></td>
    <td><c:out value="${task.typeId}"></c:out></td>
    <td><c:out value="${task.text}"></c:out></td>
    <td><c:out value="${task.user.login}"></c:out></td>

        <td><a href="/<c:out value="${baseUrl}" />/edittask?id=${task.id}">edit</a>
            /
        <a href="/<c:out value="${baseUrl}" />/delete?id=${task.id}">del</a></td>
        <a href="/<c:out value="${baseUrl}" />/complete?id=${task.id}">del</a></td>
    </tr>

    <%--<c:out value="${userItem.name}"></c:out>--%>
    <%--<c:out value="${userItem.type}"></c:out>--%>
</c:forEach>
</table>
</body>
</html>
