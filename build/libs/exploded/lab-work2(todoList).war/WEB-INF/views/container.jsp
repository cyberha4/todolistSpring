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
<jsp:include page="clearpages/${view}.jsp" />
</div>


</body>
</html>
