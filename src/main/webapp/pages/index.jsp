<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<title>Home</title>
</head>
<body>
<sec:authorize access="hasRole('User')">
    <a href="/user/deleate">Deleate user</a><br>
    <a href="/user">Add user</a><br>
    <a href="/user/find">Find user</a><br>
    <a href="/user/allUsers">All users</a><br>
    <a href="/log">Logout</a>
</sec:authorize>
<sec:authorize access="isAnonymous()">
    <a href="/auth">Authorithation</a><br>
    <a href="/reg">Registration</a><br>
</sec:authorize>
</body>
</html>
