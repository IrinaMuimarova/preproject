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
    <title>User List</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>
        <button class="w3-btn w3-round-large" onclick="location.href='/admin/add'">+</button>
    </h1>
</div>

<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-light-blue">
            <h2>Users</h2>
        </div>
        <table class="w3-table">
            <c:if test="${not empty userNames}">
                <c:forEach var="user" items="${requestScope.userNames}">
                    <tr>
                        <th>${user.getId()}</th>
                        <th>${user.getName()}</th>
                        <th>${user.getLogin()}</th>
                        <form action="<c:url value="/admin/edit"/>" method="get">
                            <input type="hidden" name="id" value= ${user.getId()}>
                            <th class=\"w3-right-align\">
                                <button class="w3-btn w3-round-large w3-margin-left">Edit</button>
                            </th>
                        </form>
                        <form action="/admin/delete" method="get">
                            <input type="hidden" name="id" value=${user.getId()}>
                            <th class="w3-right-align">
                                <button class="w3-btn w3-round-large w3-margin-left">Delete</button>
                            </th>
                        </form>
                    </tr>
                </c:forEach>
            </c:if>
            <c:if test="${empty userNames}">
                <div class="w3-panel w3-red w3-display-container w3-card-4 w3-round">
                    <span onclick="this.parentElement.style.display='none'" class="w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey">×</span>
                    <h5>There are no users yet!</h5>
                </div>
            </c:if>
        </table>
    </div>
</div>
</body>

</html>
