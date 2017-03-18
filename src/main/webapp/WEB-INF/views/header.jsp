<%@ page import="org.springframework.security.core.context.SecurityContextImpl" %>
<%@ page import="com.cyberha4.models.pojo.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div class="jumbotron">
        <p>Some text</p>
    </div>

<div class="navbar navbar-inverse" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Task manager</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="/todolist/task/list">Tasks</a></li>
                <li><a href="#Profile">Profile</a></li>
                <li><a href="/todolist/welcome">About</a></li>
            </ul>
            <% if (request.getSession().getAttribute("SPRING_SECURITY_CONTEXT") == null) {%>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/todolist/registration"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                <li><a href="/todolist/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </ul>
            <% } else {%>
            <ul class="nav navbar-nav navbar-right">
                <%SecurityContextImpl sci = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
                User user = (User) sci.getAuthentication().getPrincipal();
                %>
                <li><p class="navbar-text">Hello, <%=user.getLogin()%>
                    <a href="/todolist/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
                </p></li>
            </ul>
            <% }%>
        </div><!--/.nav-collapse -->
    </div>
</div>

<%--<c:if test="${not empty msg}">--%>
    <% if (request.getParameter("error") != null) { %>
    <div class="alert alert-warning alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert"
                aria-label="Close">
            <span aria-hidden="true">x</span>
        </button>
        <strong><%=request.getParameter("error")%></strong>
    </div>
<%--</c:if>--%>
<% } %>

<% if (request.getParameter("msg") != null) { %>
<div class="alert alert-success alert-dismissible" role="alert">
    <button type="button" class="close" data-dismiss="alert"
            aria-label="Close">
        <span aria-hidden="true">x</span>
    </button>
    <strong><%=request.getParameter("error")%></strong>
</div>
<% } %>

<c:if test="${not empty error}">
<div class="alert alert-warning alert-dismissible" role="alert">
    <button type="button" class="close" data-dismiss="alert"
            aria-label="Close">
        <span aria-hidden="true">x</span>
    </button>
    <strong>${error}</strong>
</div>
</c:if>

<c:if test="${not empty msg}">
<div class="alert alert-success alert-dismissible" role="alert">
    <button type="button" class="close" data-dismiss="alert"
            aria-label="Close">
        <span aria-hidden="true">x</span>
    </button>
    <strong>${msg}</strong>
</div>
</c:if>
<%--<%=request.getSession().getAttributeNames().nextElement() %>--%>

Session id = <%=request.getSession().getAttribute("id") %><br>
Session name = <%=request.getSession().getAttribute("name") %><br>
