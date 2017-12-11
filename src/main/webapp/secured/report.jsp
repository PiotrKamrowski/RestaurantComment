<%@ page import="restaurantcomment.place.Place" %><%--
  Created by IntelliJ IDEA.
  User: Piotr
  Date: 04.12.2017
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zareportuj</title>
</head>
<body>


<form name="check" action="/report.do" method="post">
    powód: <input type="text" name="text" value=""/><br/>
    <input type="hidden" name="id" value="<% Place place =(Place)session.getAttribute("detail");
    out.print(place.getId());%>>"/>
    <input type="submit" name="submit" value="Dodaj"/>
</form>


</body>
</html>
