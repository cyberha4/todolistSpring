<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="resources.jsp" />

    <title>Login</title>
</head>
<body>
<jsp:include page="header.jsp" />

<c:if test="${not empty msg}">
    <div class="alert alert-${css} alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert"
                aria-label="Close">
            <span aria-hidden="true">×</span>
        </button>
        <strong>${msg}</strong>
    </div>
</c:if>

<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-lg-6">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        Авторизация на сайте</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-xs-12 col-sm-12 col-md-12 login-box">

                            <form id="loginForm" role="form" method="post" action="/todolist/login">
                                <div class="input-group">
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                    <input type="text" id="login" name="login" minlength="4" class="form-control" placeholder="Имя пользователя" required autofocus />
                                </div>
                                <div class="input-group">
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                                    <input type="password" id="password" name="password" class="form-control" placeholder="Ваш пароль" required />
                                </div>
                                <div class="col-xs-8">
                                    <button type="submit" type="button" class="btn btn-labeled btn-success">
                                        <span class="btn-label"><i class="glyphicon glyphicon-ok"></i></span>Войти</button>
                                </div>
                                <div class="col-xs-4">
                                    <p>
                                        <a href="#">Забыли свой пароль? (нужно реализовать)</a></p>
                                    У вас нет аккаунта? <a href="/todolist/registration">Регистрация</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="panel-footer">
                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" value="Remember">
                                    Запомнить меня (нужно реализовать)
                                </label>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $("#loginForm").validate();
</script>

</body>
</html>
