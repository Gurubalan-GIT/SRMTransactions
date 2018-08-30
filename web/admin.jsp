<%@ page import="java.sql.Connection" %>
<%@ page import="com.guru.mysqlshowcase.DBConnect.DBConnection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
</head>
<body>
<%
    Connection connection= DBConnection.getConnection();
    String query="select * from users;";
    try {
        PreparedStatement preparedStatement=connection.prepareStatement(query);
        ResultSet resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){

        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>
<script src="assets/js/bootstrap.min.js"></script>
</body>
</html>
