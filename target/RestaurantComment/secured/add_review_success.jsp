<%--
  Created by IntelliJ IDEA.
  User: Piotr
  Date: 24.11.2017
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Recenzja dodana pomyślnie</title>
</head>
<body>

<p>Recenzja dodana pomyślnie</p>
<form name="listPlaces" action="/detailPlace.do" method="post">


            <button type="submit" name="theButton" value="<%=session.getAttribute("ok")%>">powrót</button><br/>

</form>

</body>
</html>
