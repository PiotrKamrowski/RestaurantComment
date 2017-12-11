<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edytuj użytkownika</title>
</head>
<body>

<form name="addUser" action="/edituser.do" method="post">
    imie: <input type="text" name="name" value=""/><br/>
    nazwisko: <input type="text" name="last_name" value=""/><br/>
    hasło: <input type="text" name="password" value=""/><br/>
    data urodzenia rok-miesiąc-dzień: <input type="text" name="yyyy" value=""/>-<input type="text" name="mm" value=""/>-<input type="text" name="dd" value=""/><br/>
    miasto: <input type="text" name="city" value=""/><br/>
    <input type="submit" name="submit" value="Dodaj"/>
</form>


<button onclick="window.location.href='/secured/main.jsp'">Powrót</button> <br/>
<button onclick="window.location.href='/secured/delete.jsp'">Usuń użytkownika</button> <br/>

</body>
</html>
