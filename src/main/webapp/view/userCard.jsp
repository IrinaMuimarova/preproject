<%--
  Created by IntelliJ IDEA.
  User: А
  Date: 26.12.2019
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>UserCard</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="w3-card-4">
    <header class="w3-container w3-blue">
        <h1>${user.getName()}</h1>
    </header>

    <div class="w3-container">
        <p>Login: ${user.getLogin()}</p>
        <p>Role: ${user.getRole()}</p>
    </div>
    <c:if test="${user.getRole() == 'admin'}">
        <div class="w3-container w3-opacity w3-left-align w3-padding">
            <button class="w3-btn w3-round-large" onclick="location.href='/admin'">Admin</button>
        </div>
    </c:if>
</div>
</body>
</html>
