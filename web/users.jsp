<%@ page import="java.sql.Connection" %>
<%@ page import="com.guru.mysqlshowcase.DBConnect.DBConnection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h3>User Table</h3><br>
    <table class="table table-bordered table-hover table-responsive-sm">
        <thead>
            <tr>
                <th>Email</th>
                <th>Password</th>
                <th>Name</th>
                <th>Age</th>
                <th>Gender</th>
                <th>Permission</th>
            </tr>
        </thead>
        <tbody>
        <%
            Connection connection= DBConnection.getConnection();
            String query="select * from users;";
            try {
                PreparedStatement preparedStatement=connection.prepareStatement(query);
                ResultSet resultSet=preparedStatement.executeQuery();
                while (resultSet.next())
                {%>
                    <tr>
                        <td><%=resultSet.getString("Email")%></td>
                        <td><%=resultSet.getString("pwd")%></td>
                        <td><%=resultSet.getString("name")%></td>
                        <td><%=resultSet.getString("age")%></td>
                        <td><%=resultSet.getString("gender")%></td>
                        <td><%=resultSet.getString("usertype")%></td
                    </tr>
               <%}
            } catch (SQLException e) {
                e.printStackTrace();
            }
        %>
        </tbody>
    </table>
</div>
<script src="assets/js/bootstrap.min.js"></script>
</body>
</html>
