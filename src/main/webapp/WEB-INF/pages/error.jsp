<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Error - repeat later!</title>
</head>
<body>

<div id="main">
    <%@include file="jspf/header.jspf" %>
    <div id="jspError">
        <h1>Sorry, but an error occurs. You can return to the <a href="<c:url value='/' />">home page</a>.</h1>
    </div>
</div>
<%@include file="jspf/footer.jspf" %>
</body>

</html>

