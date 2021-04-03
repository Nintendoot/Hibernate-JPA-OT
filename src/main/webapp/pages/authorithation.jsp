<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Authorithation</title>
</head>
<body>
<div class="container">
    <form action="/auth" method="post">

        <label for="user-login-label">Login</label>
        <input type="text" id="user-login-label" name="login">

        <label for="user-password-label">Password</label>
        <input type="text" id="user-password-label" name="password">

        <button type="submit" class="btn btn-primary">Submit</button>

    </form>
</div>
</body>
</html>
