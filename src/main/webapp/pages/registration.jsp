<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<p style="color: red">${errorMessage}</p>
<div class="container">
    <form action="/reg" method="post">
        <h2>Registration</h2>

        <label for="user-name-label">Name</label>
        <input type="text" id="user-name-label" name="name">

        <label for="user-login-label">Login</label>
        <input type="text" id="user-login-label" name="login">

        <label for="user-password-label">Password</label>
        <input type="text" id="user-password-label" name="password">

        <button type="submit" class="btn btn-primary">Sign in</button>
    </form>
</div>
</body>
</html>
