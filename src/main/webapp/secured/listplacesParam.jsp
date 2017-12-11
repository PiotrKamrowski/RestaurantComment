<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="place.Place" %><%--
  Created by IntelliJ IDEA.
  User: Piotr
  Date: 27.11.2017
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ListPlacesParam</title>
</head>
<body>
<form name="listPlaces" action="/detailPlace.do" method="post">

        <c:forEach items="${listParam}" var="Place">

            <button type="submit" name="theButton" value="${Place.id}">${Place.name}</button><br/>
        </c:forEach>

</form>



<button onclick="window.location.href='/secured/listplaces.jsp'">Powrót</button> <br/>


</body>
</html>
