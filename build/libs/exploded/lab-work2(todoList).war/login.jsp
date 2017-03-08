<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script src="http://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.js"></script>
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
    <p>Path do jsp-directory <%=request.getContextPath()%></p>

</div>

<div>
    <a href="/todolist/registration">Регистрация</a><br>
    <form id="commentForm" method="post" action="/todolist/login">
        <fieldset>
            <legend>Please provide your name, email address (won't be published) and a comment</legend>
            <p>
                <label for="login">Login</label>
                <input id="login" name="login" minlength="6" type="text" required>
            </p>
            <p>
                <label for="password">Password</label>
                <input id="password" type="password" name="password" required>
            </p>
            <p>
                <label for="curl">URL (optional)</label>
                <input id="curl" type="url" name="url">
            </p>
            <p>
                <label for="ccomment">Your comment (required)</label>
                <textarea id="ccomment" name="comment" required></textarea>
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
