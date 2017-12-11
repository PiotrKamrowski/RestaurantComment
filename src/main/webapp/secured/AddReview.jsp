<%--
  Created by IntelliJ IDEA.
  User: Piotr
  Date: 21.11.2017
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add Review</title>
</head>
<body>

<form name="addPlace" action="/add_review.do" method="post">
    Recenzja: <input type="text" name="review" value=""/><br/>
    <select name ="delivery">
        <option value="true">Tak</option>
        <option value="false">Nie</option>
    </select><br/>
    Czas Dostawy w minutach:<select name ="time">
    <option value="30">30</option>
    <option value="60">60</option>
    <option value="90">90</option>
    <option value="120">120</option>
    <option value="150">150</option>
    </select>
    Ocena:<select name ="mark">
        <option value="STAR1">1</option>
        <option value="STAR2">2</option>
        <option value="STAR3">3</option>
        <option value="STAR3">4</option>
        <option value="STAR3">5</option>

    </select>
    <input type="submit" name="submit" value="Dodaj"/>


</form>
<button onclick="window.location.href='/secured/main.jsp'">Powrót</button> <br/>
</body>
</html>
