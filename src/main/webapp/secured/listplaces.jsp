<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="place.Place" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Piotr
  Date: 21.11.2017
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>List places</title>
</head>
<body>



<%@ page import="place.Place" %>

<% List<Place> list = (List<Place> )session.getAttribute("listPlaces"); %>

<h3>Kryteria wyszukiwania</h3>
<form name="listParam" action="/list_param.do" method="post">
    Miasto: <input type="text" name="city" value=""/><br/>
    Rodzaj: <select name ="type">
        <option value="">Wszystkie</option>
        <option value="PIZZA">Pizza</option>
        <option value="SUSHI">Sushi</option>
        <option value="FASTFOOD">FastFood</option>
        <option value="POLISHKITCHEN">Polska Kuchnia</option>
        <option value="ITALY">Włoska Kuchnia</option>
        <option value="MEDITERRANEAN">Kuchnia Śródziemnomorska</option>
        <option value="ASIAN">Kuchnia Azjatycka</option>
        <option value="EXOTIC">Kuchnia Egzotyczna</option>
    </select>
    <input type="submit" name="submit" value="Przeglądaj"/>
</form>
<%--<select id="food" name="fooditems">
    <c:forEach items="${listPlaces}" var="food">
        <option value="${Place.name}">
                ${Place.city}
        </option>
    </c:forEach>
</select>--%>


<form name="listPlaces" action="/detailPlace.do" method="post">
<table>
<c:forEach items="${listPlaces}" var="Place">

    <button type="submit" name="theButton" value="${Place.id}">${Place.name}</button><br/>
</c:forEach>
</table>
</form>



<button onclick="window.location.href='/secured/main.jsp'">Powrót</button> <br/>
</body>
</html>


