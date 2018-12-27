<%@ page import="com.guru.mysqlshowcase.DTO.LoginDTO.Bean" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.guru.mysqlshowcase.DBConnect.DBConnection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logged in!</title>
</head>
<body>
<% Connection connection = DBConnection.getConnection();
    Bean bean=(Bean)session.getAttribute("bean");
    String query="select name from users where Email='"+bean.getEmail()+"';";
    try {
        PreparedStatement preparedStatement=connection.prepareStatement(query);
        ResultSet resultSet=preparedStatement.executeQuery();
        while (resultSet.next())
        {%>
          Hello! Mr.<%=resultSet.getString("name")%>, Your email ID is: <%= bean.getEmail() %>
        <%}
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>
</body>
</html>
