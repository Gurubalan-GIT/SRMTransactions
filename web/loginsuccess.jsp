<%@ page import="com.guru.mysqlshowcase.DTO.LoginDTO.Bean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logged in!</title>
</head>
<body>
Hello! Your email ID is: <%  Bean bean=(Bean)session.getAttribute("bean"); %> <%= bean.getEmail() %>
</body>
</html>
