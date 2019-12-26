<%--
  Created by IntelliJ IDEA.
  User: А
  Date: 23.12.2019
  Time: 0:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add new User</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Edit User</h1>
</div>
<div class="w3-container w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-center w3-green">
            <h2>Edit user</h2>
        </div>
        <form method="post" class="w3-selection w3-light-grey w3-padding">
            <label>ID: <input type="text" name="id" required value="${user.getId()}" disabled class="w3-input w3-animate-input w3-border w3-round-large"
                style="width: 30%"></label>
            <label>Name:
                <input type="text" name="name" required value="${user.getName()}" class="w3-input w3-animate-input w3-border w3-round-large"
                       style="width: 30%"><br/>
            </label>
            <label>Login:
                <input type="text" name="login" required value="${user.getLogin()}"
                       class="w3-input w3-animate-input w3-border w3-round-large"
                       style="width: 30%"><br/>
            </label>
            <label>Password:
                <input type="password" name="password" required value="${user.getPassword()}" class="w3-input w3-animate-input w3-border w3-round-large"
                       style="width: 30%"><br/>
            </label>
            <label>Role:
                <select class="w3-select" name="role" required>
                    <c:if test="${user.getRole() == 'admin'}">
                        <option value="admin" selected = selected>admin</option>
                        <option value="user">user</option>
                    </c:if>
                    <c:if test="${user.getRole() == 'user'}">
                        <option value="admin">admin</option>
                        <option value="user" selected = selected>user</option>
                    </c:if>
                </select>
            </label>
            <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Edit</button>
        </form>
    </div>

    <div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
        <button class="w3-btn w3-round-large" onclick="location.href='/admin'">Back to main</button>
    </div>
</body>
</html>
