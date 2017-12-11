<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Restaurant Comment Zaloguj</title>
</head>
<body>

<center>

<form name="addUser" action="/login" method="post">

    nazwa użytkownika: <input type="text" name="nick" value=""/><br/>
    hasło:             <input type="password" name="password" value=""/><br/>

    <input type="submit" name="submit" value="Zaloguj"/>
</form>

<button><a href="/add_user_view.jsp">Zarejestruj użytkownika</a></button> <br/>
</center>
</body>
</html>
