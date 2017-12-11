<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add_user_view</title>
</head>

<h1>Podana nazwa urzytniownika już istnieje podaj inną</h1>


<body>
<form name="addUser" action="/add_user.do" method="post">
    imie: <input type="text" name="name" value=""/><br/>
    nazwisko: <input type="text" name="last_name" value=""/><br/>
    nazwa użytkownika: <input type="text" name="nick" value=""/><br/>
    hasło: <input type="text" name="password" value=""/><br/>
    data urodzenia rok-miesiąc-dzień: <input type="text" name="yyyy" value=""/>-<input type="text" name="mm" value=""/>-<input type="text" name="dd" value=""/><br/>
    miasto: <input type="text" name="city" value=""/><br/>
    <select name ="gender">
        <option value="MALE">mężczyzna</option>
        <option value="FEMALE">kobieta</option>
    </select>
    <input type="submit" name="submit" value="Dodaj"/>
</form>

</body>
</html>
