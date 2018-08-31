<%--
  Created by IntelliJ IDEA.
  User: Gurubalan
  Date: 31-08-2018
  Time: 03:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
</head>
<body>
<input type="button" onclick="location.href='/users.jsp';" value="User-Table (Root)" class="btn-success" style="border-radius: 8px;"/>
<input type="button" onclick="location.href='/users.jsp';" value="Students-Table" class="btn-primary" style="border-radius: 8px;"/>
<input type="button" onclick="location.href='/users.jsp';" value="Course-Table (Related with Students)" class="btn-danger" style="border-radius: 8px;"/>
<input type="button" onclick="location.href='/users.jsp';" value="Bank-Table" class="btn-secondary" style="border-radius: 8px;"/>
<input type="button" onclick="location.href='/users.jsp';" value="Account Table (Related with Bank-Table)" class="btn-dark" style="border-radius: 8px;"/>
<script src="assets/js/bootstrap.min.js"></script>
</body>
</html>
