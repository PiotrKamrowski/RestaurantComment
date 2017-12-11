<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%--
  Created by IntelliJ IDEA.
  User: Piotr
  Date: 30.11.2017
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="restaurantcomment.user.User" %>
<%@ page import="restaurantcomment.place.Place" %>
<%@ page import="restaurantcomment.review.Review" %>
<html>
<head>
    <title>Użytkownik</title>
</head>
<body>


<% User user = (User)session.getAttribute("user_detail"); %>
<p>Nazwa użytkownika</p>
<h1><%=user.getNick()%></h1>
<p>Imie</p>
<h2><%=user.getName()%></h2>
<p>Nazwisko</p>
<h2><%=user.getLastname()%></h2>
<p>wiek</p>
<h2><%=user.getAge()%></h2>
<p>liczna recenzji</p>
<h2><%=user.getReviewsAdded().size()%></h2>

<h2>Recenzje dodane przez uzytkownika</h2>
<c:choose>
    <c:when test="${fn:length(listr)>0}">
        <table>
            <tr>
                <th>Nazwa Miejsca</th>
                <th>Data Dodania</th>
            </tr>

            <c:forEach items="${listr}" var="Review">

                <tr>
                    <td><form name="listPlaces" action="/detailPlace.do" method="post">
                        <button type="submit" name="theButton" value="${Review.place_id}">${Review.namePlace}</button></form></td>
                    <td>${Review.date}</td>
                </tr>

            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>

        <p>Użytkownik nie dodal jeszcze zadnej recenzji</p>


    </c:otherwise>

</c:choose>


<button onclick="window.location.href='/secured/main.jsp'">Powrót</button> <br/>


</body>
</html>
