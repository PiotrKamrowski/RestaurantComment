<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Restaurant Comment</title>
</head>
<body>

<% String nick = String.valueOf(session.getAttribute("user_nick"));%>



<h2>Witaj <%= nick %>!</h2>


<button onclick="window.location.href='/secured/edit_user.jsp'">Edytuj użytkownika</button> <br/>
<button onclick="window.location.href='/secured/add_place.jsp'">Dodaj restauracje</button> <br/>
<button onclick="window.location.href='/viewPlace.do'">Przeglądaj Restauracje</button> <br/>
<button onclick="window.location.href='/userlist.do'">Lista Użytkownikow</button> <br/>
<button onclick="window.location.href='/logout.do'">Wyloguj</button> <br/>



</body>
</html>
