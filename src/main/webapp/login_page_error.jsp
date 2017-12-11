<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Błędne dane logowania</title>
</head>
<body>

<h1>Błętnie wprowadzone dane zaloguj się jeszcze raz </h1>


<form name="addUser" action="/login" method="post">
    nazwa użytkownika: <input type="text" name="nick" value=""/><br/>
    hasło: <input type="password" name="password" value=""/><br/>
    <input type="submit" name="submit" value="Zaloguj"/>
</form>

</body>
</html>
