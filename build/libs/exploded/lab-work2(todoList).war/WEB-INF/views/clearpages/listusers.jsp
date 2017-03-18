<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="table-responsive">

<table class="table table-striped">
<tr>
    <th>ID</th>
    <th>name</th>
    <th>email</th>
    <th>login</th>
    <th>passsword</th>
    <th>role</th>
    <th>enabled</th>
    <th></th>
</tr>
    <c:set var="baseUrl">todolist</c:set>

<c:forEach items="${userList}" var="user">

    <tr>
        <td><c:out value="${user.id}"></c:out></td>
        <td><c:out value="${user.name}"></c:out></td>
        <td><c:out value="${user.email}"></c:out></td>
        <td><c:out value="${user.login}"></c:out></td>
        <td><c:out value="${user.password}"></c:out></td>
        <td><c:out value="${user.role}"></c:out></td>
        <td><c:out value="${user.enabled}"></c:out></td>
        <%--<td><c:out value="${task.title}"></c:out></td>--%>
        <%--<td><c:out value="${task.annotation}"></c:out></td>--%>
        <%--<td><c:out value="${task.statusId}"></c:out></td>--%>
        <%--<td><c:out value="${task.typeId}"></c:out></td>--%>
        <%--<td><c:out value="${task.text}"></c:out></td>--%>
        <%--<td>Должен быть логин</td>--%>
            <%--<td><c:out value="${task.user.login}"></c:out></td>--%>

        <td><a href="/<c:out value="${baseUrl}" />/admin/user/edit?id=${user.id}">edit</a>
            /
            <a href="/<c:out value="${baseUrl}" />/admin/user/delete?id=${user.id}">del</a>
            /
            <a href="/<c:out value="${baseUrl}" />/admin/user/complete?id=${user.id}">complete</a></td>
    </tr>

    <%--<c:out value="${userItem.name}"></c:out>--%>
    <%--<c:out value="${userItem.type}"></c:out>--%>
</c:forEach>
</table>
</div>