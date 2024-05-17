<%--
  Created by IntelliJ IDEA.
  User: alcid
  Date: 17/05/2024
  Time: 08:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/login.css">
    <title>Login</title>
</head>
<body>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <!-- Tabs Titles -->

        <!-- Icon -->
        <div class="fadeIn first">
            <img src="/img/temp.png" id="icon" alt="User Icon" />
        </div>

        <!-- Login Form -->
        <form>
            <input type="text" id="login" class="fadeIn second" name="login" placeholder="CRM">
            <input type="text" id="password" class="fadeIn third" name="login" placeholder="senha">
            <input type="submit" class="fadeIn fourth" value="Entrar">
        </form>

        <!-- Remind Passowrd -->
        <div id="formFooter">
            <a class="underlineHover" href="#">Esqueceu a senha?</a>
        </div>

    </div>
</div>
</body>
</html>
