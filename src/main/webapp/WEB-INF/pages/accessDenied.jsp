<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Spring Security - Access denied!</title>

    <script src="//code.jquery.com/jquery-1.9.1.js"></script>

</head>
<body>
<div id="main">
    <div id="content">
        <%@include file="jspf/header.jspf" %>
        <h3>Access denied! You can't do this operation. <a href="<c:url value='/' />">Return to the home page</a>.</h3>
        <%@include file="jspf/footer.jspf" %>
    </div>
</div>
</body>
</html>
