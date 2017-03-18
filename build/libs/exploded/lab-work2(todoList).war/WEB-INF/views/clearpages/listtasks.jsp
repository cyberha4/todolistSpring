<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h1>Список задач</h1>

<c:set var="baseUrl">todolist</c:set>

<a href="/<c:out value="${baseUrl}" />/task/edit">Добавить задачу</a>
<div class="table-responsive">

<table border="2" class="table table-striped">
    <tr>
        <th>ID</th>
        <th>title</th>
        <th>status</th>
        <th>type</th>
        <th>text</th>
        <th>create</th>
        <th>finished</th>
        <th></th>
    </tr>

<c:forEach items="${tasksList}" var="task">

    <tr>
    <td><c:out value="${task.id}"/></td>
    <td><c:out value="${task.title}"></c:out></td>
        <td><c:out value="${statuses[task.statusId]}"></c:out></td>>
    <td><c:out value="${types['1']}"></c:out></td>
    <td><c:out value="${task.text}"></c:out></td>
    <td><c:out value="${task.create}"></c:out></td>
    <td><c:out value="${task.finished}"></c:out></td>
    <%--<td><c:out value="${task.user.login}"></c:out></td>--%>

        <td><a href="/<c:out value="${baseUrl}" />/task/edit?id=${task.id}">edit</a>
            /
        <a href="/<c:out value="${baseUrl}" />/task/delete?id=${task.id}">del</a>
            /
        <a href="/<c:out value="${baseUrl}" />/task/complete?id=${task.id}">complete</a></td>
    </tr>

    <%--<c:out value="${userItem.name}"></c:out>--%>
    <%--<c:out value="${userItem.type}"></c:out>--%>
</c:forEach>

    <c:forEach items="${tasksList}" var="task">

        <tr>
            <td><c:out value="${task.id}"></c:out></td>
            <td><c:out value="${task.title}"></c:out></td>
            <td><c:out value="${statuses.task.statusId}"></c:out></td>>
            <td><c:out value="${types['1']}"></c:out></td>
            <td><c:out value="${task.text}"></c:out></td>
            <td><c:out value="${task.create}"></c:out></td>
                <%--<td><c:out value="${task.user.login}"></c:out></td>--%>

            <td><a href="/<c:out value="${baseUrl}" />/task/edit?id=${task.id}">edit</a>
                /
                <a href="/<c:out value="${baseUrl}" />/task/delete?id=${task.id}">del</a>
                /
                <a href="/<c:out value="${baseUrl}" />/task/complete?id=${task.id}">complete</a></td>
        </tr>

        <%--<c:out value="${userItem.name}"></c:out>--%>
        <%--<c:out value="${userItem.type}"></c:out>--%>
    </c:forEach>

</table>
</div>

