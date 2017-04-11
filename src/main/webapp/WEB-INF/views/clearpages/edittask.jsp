<%@ page import="com.cyberha4.models.pojo.Task" %>
<%@ page import="com.cyberha4.common.UsefulFunc" %>
<%@ page import="java.sql.Date" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 27.02.2017
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>edit task</h2>
<% Task task = (Task) request.getAttribute("task"); %>
<%=task.getAnnotation()%><br>Title |
<c:out value="${newTask.title}"/><br>

<spring:form method="post"  modelAttribute="task" action="/todolist/task/edit">
    <spring:errors path="title" cssClass="error" /><br>
    <spring:label path = "title">Title</spring:label>
    <spring:input type="hidden" path="id"/><br>
    <spring:input type="hidden" path="version"/><br>

    <spring:input path="title"/><br>

    <spring:errors path="annotation" cssClass="error" /><br>
    <spring:label path = "annotation">Annotation</spring:label>
    <spring:input path="annotation"/><br>

    <spring:errors path="text" cssClass="error" /><br>
    <spring:label path = "text">Text</spring:label>
    <spring:input path="text"/><br>

    <% if (task.getId() != 0){ %>
    <spring:errors path="create" class="control-label" /><br>
    Created time : <c:out value="${task.create}"/><br
    <spring:errors path="statusId" class="control-label" /><br>
    <spring:label path = "statusId">Status</spring:label>
    <c:out value="${task.statusId}"/><br>
    <c:out value="${statuses.task.statusId}"/><br>
    <% }%>
    <%--<spring:input type="hidden" path="statusId"/>--%>
    <%--<spring:input type="hidden" path="create"/>--%>
    <%--<% } %>--%>

    <spring:errors path="finished" class="control-label" /><br>
    <spring:label path = "finished">Finished</spring:label>
    <spring:input type="date" min="<%=String.valueOf(new Date(System.currentTimeMillis()))%>" path="finished"/><br>


    <spring:label path = "typeId">Importance</spring:label>
    <spring:errors path="typeId" class="control-label" />
    <spring:select path="typeId" class="form-control">
        <spring:option value="0" label="--- Select ---" />
        <%--@elvariable id="types" type="java.util.List"--%>
        <spring:options items="${types}" />
    </spring:select><br>
    <spring:errors path="statusId" cssClass="error" /><br>
    <spring:button>Save task</spring:button>
</spring:form>

</body>
</html>
