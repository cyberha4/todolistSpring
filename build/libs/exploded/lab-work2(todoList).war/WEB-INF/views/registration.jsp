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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script src="http://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.js"></script>

</head>
<body>

<div>
    <a href="/todolist/registration">Регистрация</a><br>
    <form id="commentForm" method="post" action="/todolist/registration">
        <fieldset>
            <legend>Please provide your name, email address (won't be published) and a comment</legend>
            <p>
                <label for="login">Login</label>
                <input id="login" name="login" minlength="6" type="text" required>
            </p>
            <p>
                <label for="password">Password</label>
                <input id="password" type="password" minlength="6" name="password" required>
            </p>
            <p>
                <label for="email">E-mail</label>
                <input id="email" type="email" name="email">
            </p>
            <p>
                <input class="submit" type="submit" value="Submit">
            </p>
        </fieldset>
    </form>
    <script>
        $("#commentForm").validate();
    </script>


</div>


</body>
</html>
