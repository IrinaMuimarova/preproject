<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<%--
  Created by IntelliJ IDEA.
  User: А
  Date: 23.12.2019
  Time: 0:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User List</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>
        <button class="w3-btn w3-round-large" onclick="location.href='/add'">+</button>
    </h1>
</div>

<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-light-blue">
            <h2>Users</h2>
        </div>
        <table class="w3-table">
            <%
                List<User> names = (List<User>) request.getAttribute("userNames");
                if (names != null && !names.isEmpty()) {
                    for (User s : names) {
                        out.print("<tr><th>" + s.getId() + "</th><th>" + s.getName() + "</th><th>" + s.getLogin() +
                                "<form action = \"/edit\" method =\"get\">" +
                                    "<input type = \"hidden\" name=\"id\" value=\"" + s.getId() + "\">" +
                                    "<th class=\"w3-right-align\"><button class=\"w3-btn w3-round-large w3-margin-left \">Edit</button></th>" +
                                "</form>" +
                                "<form action = \"/delete\" method =\"get\">" +
                                    "<input type = \"hidden\" name=\"id\" value=\"" + s.getId() + "\">" +
                                    "<th class=\"w3-right-align\"><button class=\"w3-btn w3-round-large w3-margin-left\">Delete</button></th>" +
                                "</form>");
                    }
                } else {
                    out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n"
                            +
                            "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                            "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n" +
                            "   <h5>There are no users yet!</h5>\n" +
                            "</div>");

                }
            %>
        </table>
    </div>
</div>
</body>

</html>
