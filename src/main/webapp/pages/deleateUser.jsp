<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Deleate</title>
</head>
<body>
<p>${deleate}</p>
<p style="color: red">${errorMessage}</p>
<form action="/user/deleate" method="post">
    <label for="user-login-label">Login
        <input type="text" id="user-login-label" name="login">
    </label>
    <button type="submit">Deleate</button>
    <br>
    <a href="/home">Back</a>
</form>
</body>
</html>
