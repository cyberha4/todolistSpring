<%@ page import="com.cyberha4.common.UsefulFunc" %><%--
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
</head>
<body>
<script>
    $(function()
    {
        alert('Подключена локальная версия jQuery через собственный хостинг');
    });
</script>

<form action="<%= UsefulFunc.appRoute%>/hello" method="post">
    <input type="submit" value="<%= UsefulFunc.sendEmail ? "Dont send mail?" : "Started send mail?"%>">
</form>


</body>
</html>
