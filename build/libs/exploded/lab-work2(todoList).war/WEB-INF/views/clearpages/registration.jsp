<div>
    <form id="commentForm" method="post" action="/todolist/registration">
        <fieldset>
            <legend>Please provide your login and email address (won't be published)</legend>
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
