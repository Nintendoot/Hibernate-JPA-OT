<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
</head>
<body>
<p>${add}</p>
<p style="color: red">${errorMessage}</p>
<h3>Add User</h3>
<form action="/user" method="post">
    <label for="user-name-label">Name
        <input type="text" id="user-name-label" name="name">
    </label><br>
    <label for="user-login-label">Login
        <input type="text" id="user-login-label" name="login">
    </label><br>
    <label for="user-password-label">Password
        <input type="text" id="user-password-label" name="password">
    </label><br>
    <label for="user-role-label">Role
        <input type="text" id="user-role-label" name="role">
    </label><br>
    <button type="submit">Add</button>
</form>
<a href="/home">Back</a>
</body>
</html>
