<%--
  Created by IntelliJ IDEA.
  User: Gurubalan
  Date: 27-08-2018
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up!</title>
    <!--  Bootstrap CSS  -->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <form action="Profile" method="post">
        <div class="form-group">
            <label for="email">Email address</label>
            <input type="email" class="form-control" id="email" name="email" required>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>
        <div class="form-group">
            <label for="age">Age</label>
            <input type="number" class="form-control" id="age" name="age" required>
        </div>
        <div class="form-group">
            <label for="gender">Gender</label>
            <select name="gender" id="gender">
                <option value="Male">Male</option>
                <option value="Female">Female</option>
            </select>
        </div>
        <div class="text-center">
            <button name="regsubmit" type="submit" class="btn btn-info" id="submit-button" value="Submit">Sign Up</button>
        </div>
        <div>
            <label>Already a member? <a href="index.jsp">Login</a></label>
        </div>
    </form>
</div><!-- Bootstrap JS -->
<script src="assets/js/bootstrap.min.js"></script>
</body>
</html>
