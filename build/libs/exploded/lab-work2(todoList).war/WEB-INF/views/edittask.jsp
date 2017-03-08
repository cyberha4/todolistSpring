<%@ page import="com.cyberha4.models.pojo.Task" %>
<%@ page import="com.cyberha4.common.UsefulFunc" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
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

<form action="<%= UsefulFunc.appRoute%>/edittask" method="post">
    <label for="title">title:</label>
    <input type="text" name="title" id="title" value="<%=task.getTitle()%>" placeholder="Input">
    <br>
    <label for="annotation">annotation:</label>
    <input type="text" name="annotation" id="annotation" value="<%=task.getAnnotation()%>" placeholder="Input">
    <br>
    <label for="status">status:</label>
    <input type="text" name="status" id="status" value="<%=task.getStatusId()%>" placeholder="Input">
    <br>
    <label for="status">type:</label>
    <input type="text" name="type" id="type" value="<%=task.getTypeId()%>" placeholder="Input">
    <br>
    <label for="text">text:</label>
    <textarea name="text" id="text" placeholder="Input"><%=task.getText()%></textarea>
    <br>
    <label for="finished">finished time:</label>
    <input type="datetime" name="finished" id="finished" value="<%=task.getFinishedTime()%>" placeholder="Input">
    <br>
    <label>finished time:</label>
    <input type="date" name="calendar" value="2017-02-28"
           max="2017-06-04" min="2017-01-29">
    <br>
    <input type="hidden" name="id" id="id" value="<%=task.getId()%>" placeholder="Input">
    <br>

    <input type="submit" value="Submit">
</form>

<spring:form method="post"  modelAttribute="task" action="/todolist/task/edit">
    <spring:input path="title"/>

    <spring:input path="annotation"/>
    <%--<spring:select path="statusId">--%>
        <%--<spring:option value="0" label="testStatus" />--%>
        <%--<spring:option value="1" label="testStatus1" />--%>
        <%--<spring:option value="2" label="testStatus2" />--%>
        <%--<spring:option value="3" label="testStatus3" />--%>
    <%--</spring:select>--%>

    <spring:select path="statusId" class="form-control">
        <spring:option value="0" label="--- Select ---" />
        <%--@elvariable id="statuses" type="java.util.List"--%>
        <spring:options items="${statuses}" />
    </spring:select><br>
    <spring:errors path="title" class="control-label" /><br>
    <spring:errors path="statusId" class="control-label" /><br>
    <spring:button>Next Page</spring:button>
</spring:form>

</body>
</html>
