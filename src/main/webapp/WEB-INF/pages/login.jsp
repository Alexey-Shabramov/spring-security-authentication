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

    <title>Spring Security - Login page</title>

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
                    <h1><strong>Login:</strong></h1>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>Sign in to out site</h3>
                            <p>(Please, enter your login and password)</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-key"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form:form role="form" action="j_spring_security_check" method='post' class="login-form">
                            <div class="form-group">
                                <label class="sr-only" for="form-username">Your login/nickname</label>
                                <input type="text" name="j_username" placeholder="Your login..."
                                       class="form-username form-control" id="form-username">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-password">Your password</label>
                                <input type="password" name="j_password" placeholder="Your password..."
                                       class="form-password form-control" id="form-password">
                            </div>
                            <input id="remember_me" name="remember-me" type="checkbox"/>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <label for="remember_me" class="inline">Remember me</label>
                            <button type="submit" class="btn">Sign in</button>
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



