<%--
  Created by IntelliJ IDEA.
  User: olegtereshkov
  Date: 1.04.21
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Users</title>
</head>
<body>
<form action="/user/allUsers" method="get">
    <h2>История</h2>
    <c:forEach var="us" items="${all}">

        <td>${us}</td>
        <br>
    </c:forEach>
</form>
</body>
</html>
