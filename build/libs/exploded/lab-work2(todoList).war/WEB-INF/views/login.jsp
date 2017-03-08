<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script src="http://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.js"></script>
    <title>Login</title>
</head>
<body>
Session id = <%=request.getSession().getAttribute("id") %><br>
Session name = <%=request.getSession().getAttribute("name") %><br>

<div>
    <a href="/todolist/registration">Регистрация</a><br>
    <form id="commentForm" method="post" action="/todolist/login">
        <fieldset>
            <legend>Authorization</legend>
            <p>
                <label for="login">Login</label>
                <input id="login" name="login" minlength="4" type="text" required>
            </p>
            <p>
                <label for="password">Password</label>
                <input id="password" type="password" name="password" required>
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
