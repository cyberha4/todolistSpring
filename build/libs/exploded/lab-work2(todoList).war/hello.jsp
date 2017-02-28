<%@ page import="common.UsefulFunc" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 28.02.2017
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%= UsefulFunc.appRoute%>/hello" method="post">
    <input type="submit" value="<%= UsefulFunc.sendEmail ? "Dont send mail?" : "Started send mail?"%>">
</form>


</body>
</html>
