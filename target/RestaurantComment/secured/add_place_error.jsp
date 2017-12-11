<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add_place_r</title>
</head>
<body>
<h1>Sprawdź czy nie istnieje już takie samo miejsce lub poprawność wypełnionych pól</h1>

<form name="addPlace" action="/add_place.do" method="post">
    nazwa: <input type="text" name="name" value=""/><br/>
    miasto: <input type="text" name="city" value=""/><br/>
    ulica: <input type="text" name="street" value=""/><br/>
    numer: <input type="text" name="number" value=""/><br/>
    adres www <input type="text" name="www" value=""/><br/>
    <select name ="delivery">
        <option value="true">Tak</option>
        <option value="false">Nie</option>
    </select>
    <select name ="type">
        <option value="PIZZA">Pizza</option>
        <option value="SUSHI">Sushi</option>
        <option value="FASTFOOD">FastFood</option>
        <option value="POLISHKITCHEN">Polska Kuchnia</option>
        <option value="ITALY">Włoska Kuchnia</option>
        <option value="MEDITERRANEAN">Kuchnia Śródziemnomorska</option>
        <option value="ASIAN">Kuchnia Azjatycka</option>
        <option value="EXOTIC">Kuchnia Egzotyczna</option>
    </select>
    <input type="submit" name="submit" value="Dodaj"/>

    <button onclick="window.location.href='/secured/main.jsp'">Powrót</button> <br/>
</form>
</body>
</html>
