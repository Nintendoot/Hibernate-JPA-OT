<%--
  Created by IntelliJ IDEA.
  User: olegtereshkov
  Date: 1.04.21
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
</head>
<body>
<form action="/user" method="post">

    <h2>All users</h2>

    <label>Name
        <input type="text" class="form-control" name="name">
    </label>
    <label>Login
        <input type="text" class="form-control" name="login">
    </label>
    <label>Password
        <input type="text" name="password">
    </label>

    <button type="submit" class="btn btn-primary">Submit</button>
</form>


</body>
</html>
