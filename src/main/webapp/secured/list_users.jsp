<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="restaurantcomment.user.User" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista użytkowników</title>
</head>
<body>

<h2>ListUżytkowników</h2>

        <table>
        <tr>
        <th>Nazwa użytkownika</th>
        <th>ilość dodanych recenzji</th>
        </tr>

        <c:forEach items="${listOfUsers}" var="User">

            <tr>
                <td><form name="listPlaces" action="/user_detail.do" method="post">
                    <button type="submit" name="id" value="${User.userId}">${User.nick}</button></form></td>
                <td>${User.reviewsAdd}</td>
            </tr>

        </c:forEach>



            <button onclick="window.location.href='/secured/main.jsp'">Powrót</button> <br/>

</body>
</html>
