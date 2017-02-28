<%@ page import="models.pojo.Task" %>
<%@ page import="common.UsefulFunc" %><%--
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
<input type="datetime" name="3" id="2" value="<%=task.getFinishedTime()%>" placeholder="Input">

</body>
</html>
