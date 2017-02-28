<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div>
    <a href="/todolist/registration">Регистрация</a><br>
    <% String message = (request.getParameter("message") != null) ? request.getParameter("message") : ""; %>
    <h3><%=message %></h3>
    <form action="/todolist/login" method="post">
        <label for="login">Login:</label>
        <input type="text" name="login" id="login" value="" placeholder="логин">
        <br>
        <label for="password">Password:</label>
        <input type="password" name="password" id="password" value="" placeholder="пароль">

        <input type="submit" value="Submit" formmethod="post">
    </form>
</div>

</body>
</html>
