<%@ page import="restaurantcomment.place.Place" %>
<%@ page import="restaurantcomment.review.Review" %><%--
  Created by IntelliJ IDEA.
  User: Piotr
  Date: 21.11.2017
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Szczegóły restauracji</title>
</head>
<body>

<% Place place = (Place)session.getAttribute("detail");%>

<h1><%=place.getName()%></h1>
<h2><%=place.getCity()%></h2>
<h3>Adres</h3>
<p><%=place.getStreet()%>/<%=place.getNumber()%></p>
<h3>Rodzaj</h3>
<p><%=place.getType()%></p>
<h3>Adres www</h3><h5>serwis nie odpowiada za błędny adres www</h5>
<p><%=place.getWww()%></p>
<H3><% if(place.isDelivery()){
    out.print("Jest możliwy dowóz");
}else{out.print("Nie ma możliwości dowozu");}%></H3>

<h3><%="Średnia ocena:"+session.getAttribute("sumMark")%> </h3>
<h3><%="Średni czas dostawy to:"+session.getAttribute("sumTime")%> </h3>


<button onclick="window.location.href='/secured/report.jsp'">Zgłoś błędne dane/niezgodne treści</button> <br/>
<button onclick="window.location.href='/secured/add_review.jsp'">Dodaj receznje</button> <br/>
<button onclick="window.location.href='/secured/list_places.jsp'">Powrót</button> <br/>


<c:choose>
    <c:when test="${fn:length(listReview)>0}">

<table>
    <tr>
        <th>Nazwa użytkownika</th>
        <th width="200">recenzja                               </th>
        <th> czas dostawy w minutach </th>
        <th>ocena</th>
        <th>Data</th>
    </tr>

    <c:forEach items="${listReview}" var="Review">

    <tr>
        <td><form name="listPlaces" action="/user_detail.do" method="post">
            <button type="submit" name="id" value="${Review.posted_by}">${Review.username}</button></form></td>
        <td>${Review.review}</td>
        <td>${Review.delivery_time}</td>
        <td>${Review.overal_mark}</td>
        <td>${Review.date}</td>
        <td><c:set var = "nick" scope = "session" value = "${sessionScope.user_nick}"/>
            <c:if test = "${Review.username == nick}">
                <form name="delete" action="/deletereview.do" method="post">
                    <button type="submit" name="review_id" value="${Review.id}">Usuń recenzje</button><br/>
                </form>
            </c:if></td>
    </tr>

    </c:forEach>
</table>
</c:when>
    <c:otherwise>

        <h2>Nie ma jeszcze zadnych recenzji do tego miejsca</h2>

    </c:otherwise>
</c:choose>

</body>
</html>


