<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 25.02.2017
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/todolist/registration" method="post">
    <label for="login">Login:</label>
    <input type="text" name="login" id="login" value="" placeholder="Input">
    <br>
    <label for="password">Password:</label>
    <input type="password" name="password" id="password" value="" placeholder="Input">
    <br>
    <label for="email">E-MAIL:</label>
    <input type="text" name="email" id="email" value="" placeholder="Input">
    <br>
    <input type="submit" value="Submit" formmethod="post">
</form>

</body>
</html>
