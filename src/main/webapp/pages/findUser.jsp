<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Find User</title>
</head>
<body>
<h3>Find User</h3>
<p style="color: red">${errorMessage}</p>
<div class="container">
    <form action="/user/findByLogin" method="post">
        <label for="user-login-label">Login
            <input type="text" id="user-login-label" name="login">
        </label>
        <button type="submit">Find</button>
        <br>
    </form>
    <form action="/user/findById" method="post">
        <label for="user-id-label">Id
            <input type="text" id="user-id-label" name="id">
        </label>
        <button type="submit">Find</button>
        <br>
    </form>
    <a>${user}</a><br>
    <a href="/home">Back</a>
</div>
</body>
</html>
