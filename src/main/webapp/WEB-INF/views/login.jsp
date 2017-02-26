<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Eschool</title>
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/bootstrap/css/signin.css" />" rel="stylesheet">
</head>

<body>
<form:form class="form-signin" method="post" action="${pageContext.request.contextPath}/" modelAttribute="userLoginData">
    <h2 class="form-signin-heading">Вход в систему</h2>
    <form:input class="input-block-level" path="login" placeholder="Логин" />
    <form:input type="password" class="input-block-level" path="password" placeholder="Пароль" />
    <button class="btn btn-large btn-primary" type="submit">Войти</button>

    <c:if test="${not empty errorLoginMessage}">
        <br/><br/>
        <p style="color:red; text-align:center;">${errorLoginMessage}</p>
    </c:if>

</form:form>
</body>
</html>