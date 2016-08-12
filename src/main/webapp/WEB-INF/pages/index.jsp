<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Spring security project</title>
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
    <script src="//code.jquery.com/jquery-1.9.1.js"></script>

</head>
<body>
<div id="main">
    <div id="content">
        <%@include file="jspf/header.jspf" %>

        <%@include file="jspf/footer.jspf" %>
    </div>
</div>
</body>
</html>
