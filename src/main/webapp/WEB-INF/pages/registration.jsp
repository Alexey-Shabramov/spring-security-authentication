<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Spring Security - Client registration</title>

    <!-- CSS -->
    <link href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value='/resources/bootstrap/css/bootstrap.min.css' />">
    <link rel="stylesheet" href="<c:url value='/resources/font-awesome/css/font-awesome.min.css' />">
    <link rel="stylesheet" href="<c:url value='/resources/css/form-elements.css' />">
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css' />">

    <link rel="shortcut icon" href="<c:url value='/resources/ico/favicon.png' />">
    <link rel="apple-touch-icon-precomposed" sizes="144x144"
          href="<c:url value='/resources/ico/apple-touch-icon-144-precomposed.png' />">
    <link rel="apple-touch-icon-precomposed" sizes="114x114"
          href="<c:url value='/resources/ico/apple-touch-icon-114-precomposed.png' />">
    <link rel="apple-touch-icon-precomposed" sizes="72x72"
          href="<c:url value='/resources/ico/apple-touch-icon-72-precomposed.png' />">
    <link rel="apple-touch-icon-precomposed"
          href="<c:url value='/resources/ico/apple-touch-icon-57-precomposed.png' />">
</head>
<body>
<%--header for each page--%>
<%@include file="jspf/header.jspf" %>

<!-- Top content -->
<div class="top-content">

    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1><strong>Registration</strong>:</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>Client registration</h3>
                            <p>Enter your login, email and password:</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-key"></i>
                        </div>
                    </div>

                    <div class="form-bottom">
                        <form:form role="form" action="registration" method='post' class="login-form"
                                   commandName="registrationForm">
                            <%--validate message (errors)--%>
                            <%@include file="jspf/errors.jspf" %>
                            <div class="form-group">
                                <label class="sr-only" for="form-username">Login</label>
                                <form:input type="text" name="login" placeholder="Your login..."
                                            class="form-username form-control" id="form-username" path="login"
                                            value="${requestScope.registrationForm.login}"/>
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-password">Пароль</label>
                                <form:input type="password" name="password" placeholder="Your password..."
                                            class="form-password form-control" id="form-password" path="password"/>
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-secondary-password">Repeat your password</label>
                                <form:input type="password" name="secondaryPassword"
                                            placeholder="Repeat your password..."
                                            class="form-secondary-password form-control" id="form-secondary-password"
                                            path="secondaryPassword"/>
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-email">Your email address</label>
                                <form:input type="text" name="email" placeholder="Enter your email address Ваш email..."
                                            class="form-secondary-password form-control" id="form-email" path="email"
                                            value="${requestScope.registrationForm.email}"/>
                            </div>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <button type="submit" class="btn">Sign up</button>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<%@include file="jspf/footer.jspf" %>

</body>
</html>



