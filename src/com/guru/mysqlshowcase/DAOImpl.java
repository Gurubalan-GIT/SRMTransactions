package com.guru.mysqlshowcase;
import java.sql.*;

interface DAO{
    Boolean doLogin(Bean bean);
}
public class DAOImpl implements DAO{
    Connection connection=DBConnection.getConnection();
    Boolean result;
    @Override
    public Boolean doLogin(Bean bean) {
        if(connection==null){
            System.out.print("Error 404");
        }
        else{
            try {
                Statement statement=connection.createStatement();
                String query="select * from users where Email='"+bean.getEmail()+"' and pwd='"+bean.getPassword()+"';";
                ResultSet resultSet=statement.executeQuery(query);
                result=resultSet.next();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(result){
            return true;
        }
        else{
            return false;
        }
    }
}
