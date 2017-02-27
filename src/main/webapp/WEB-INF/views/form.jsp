<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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
    <form:form class="form-horizontal" method="post"
               action="${pageContext.request.contextPath}/add" modelAttribute="newPupilData" >

        <form:hidden path="id" />

        <spring:bind path="firstName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Имя</label>
                <div class="col-sm-4">
                    <form:input path="firstName" type="text" class="form-control"
                                id="firstName" placeholder="Имя" />
                    <form:errors path="firstName" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="lastName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Фамилия</label>
                <div class="col-sm-4">
                    <form:input path="lastName" type="text" class="form-control"
                                id="lastName" placeholder="Фамилия" />
                    <form:errors path="lastName" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="middleName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Отчество</label>
                <div class="col-sm-4">
                    <form:input path="middleName" type="text" class="form-control"
                                id="middleName" placeholder="Отчество" />
                    <form:errors path="middleName" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="birthday">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Дата рождения</label>
                <div class="col-sm-4">
                    <form:input path="birthday" type="date" class="form-control" id="birthday" placeholder="Дата рождения" />
                    <form:errors path="birthday" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="sex">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Пол</label>
                <div class="col-sm-4">
                    <label class="radio-inline">
                        <form:radiobutton path="sex" value="m" /> Мальчик
                    </label>
                    <label class="radio-inline">
                        <form:radiobutton path="sex" value="f" /> Девочка
                    </label> <br />
                    <form:errors path="sex" class="control-label"/>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="classNumber">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Класс</label>
                <div class="col-sm-1">
                    <form:select path="classNumber" class="form-control">
                        <form:options items="${classNumbers}" />
                    </form:select>
                    <form:errors path="classNumber" class="control-label" />
                </div>
                <div class="col-sm-1">
                    <form:select path="classLetter" class="form-control">
                        <form:options items="${classLetters}" />
                    </form:select>
                    <form:errors path="classLetter" class="control-label" />
                </div>
                <div class="col-sm-5"></div>
            </div>
        </spring:bind>

        <spring:bind path="address">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Адрес</label>
                <div class="col-sm-4">
                    <form:input path="address" type="text" class="form-control"
                                id="address" placeholder="Адрес" />
                    <form:errors path="address" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="homePhone">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Домашний телефон</label>
                <div class="col-sm-4">
                    <form:input path="homePhone" type="text" class="form-control"
                                id="homePhone" placeholder="Домашний телефон: 8(XXX)XXX-XX-XX" />
                    <form:errors path="homePhone" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="mobilePhone">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Мобильный телефон</label>
                <div class="col-sm-4">
                    <form:input path="mobilePhone" type="text" class="form-control"
                                id="mobilePhone" placeholder="Мобильный телефон: 8(XXX)XXX-XX-XX" />
                    <form:errors path="mobilePhone" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="email">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Email</label>
                <div class="col-sm-4">
                    <form:input path="email" type="text" class="form-control"
                                id="email" placeholder="Email" />
                    <form:errors path="email" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <div class="form-group">
            <label class="col-sm-2 control-label"></label>
            <div class="col-sm-4">
                <button type="submit" class="btn btn-primary">Добавить</button>
            </div>
        </div>



    </form:form>
</div>
</body>
</html>