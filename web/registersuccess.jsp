<%@ page import="com.guru.mysqlshowcase.DTO.RegisterDTO.RegisterBean" %><%--
  Created by IntelliJ IDEA.
  User: Gurubalan
  Date: 30-08-2018
  Time: 08:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registered!</title>
</head>
<body>
<% RegisterBean registerBean=(RegisterBean) session.getAttribute("registerBean"); %>
<%= registerBean.getName() %> , You have been successfully registered!
<label>Try logging in now. <a href="index.jsp">Login</a></label>
</body>
</html>
