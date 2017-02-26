<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>List of pupils</title>
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.css" />" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/resources/bootstrap/js/bootstrap.js" />"></script>
</head>
<body>
<br/>

    <div class="container">
        <h1>Список учеников:</h1>
        <button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/form'">Добавить</button>
        <br/><br/>
        <table class="table table-striped">
            <tr><th width="20%">Фамилия Имя Отчество</th><th>Класс</th><th>Дата рождения</th><th width="20%">Адрес</th>
                <th>Домашний телефон</th><th>Мобильный телефон</th><th>Email</th><th></th></tr>
            <c:choose>
                <c:when test="${empty pupilsData}">
                    <tr><td colspan="8" align="center">Нет данных</td></tr>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${pupilsData}" var="pupilData">
                        <tr>
                            <td>${pupilData.lastName} ${pupilData.firstName} ${pupilData.middleName}</td>
                            <td>${pupilData.classNumber} ${pupilData.classLetter}</td>
                            <td><fmt:formatDate pattern="dd.MM.yyyy" value="${pupilData.birthday}" /></td>
                            <td>${pupilData.address}</td>
                            <td>${pupilData.homePhone}</td>
                            <td>${pupilData.mobilePhone}</td>
                            <td>${pupilData.email}</td>
                            <td>
                                <button class="btn btn-danger" onclick="location.href='${pageContext.request.contextPath}/delete/${pupilData.id}'">Удалить</button>
                                <%--<a class="btn btn-danger" href="${pageContext.request.contextPath}/delete/${pupilData.id}" role="button">Удалить</a>--%>
                            </td>
                        </tr>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </table>
    </div>
</body>
</html>
