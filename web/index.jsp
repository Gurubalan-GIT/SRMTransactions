<%--
  Created by IntelliJ IDEA.
  User: Gurubalan
  Date: 20-08-2018
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>SRM Transactions</title>
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
          <div class="text-center">
              <button name="loginsubmit" type="submit" class="btn btn-info" id="submit-button" value="Submit">Login</button>
          </div>
          <div>
              <label>Not a member yet? <a href="/signup.jsp">Sign up!</a></label>
          </div>
      </form>
  </div>
  <script src="assets/js/bootstrap.min.js"></script>
  </body>
</html>
