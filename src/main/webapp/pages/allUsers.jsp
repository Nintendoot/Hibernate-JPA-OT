<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Users</title>
</head>
<body>
<form action="/user/allUsers" method="get">
    <h3>All users</h3>
    <c:forEach var="us" items="${all}">
        <td>${us}</td>
        <br>
    </c:forEach>
</form>
<a href="/home">Back</a>
</body>
</html>
