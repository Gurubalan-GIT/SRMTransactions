package com.guru.mysqlshowcase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

interface DAO{
    Boolean doLogin(Bean bean);
}
public class DAOImpl implements DAO{
    Connection connection=DBConnection.getConnection();
    ResultSet resultSet;
    Boolean result;
    @Override
    public Boolean doLogin(Bean bean) {
        if(connection==null){
            System.out.print("Error 404");
        }
        else{
            try {
                Statement statement=connection.createStatement();
                String query="select * from sqlshowcasedb.users where Email='"+bean.getEmail()+"' and pwd='"+bean.getPassword()+"';";
                resultSet=statement.executeQuery(query);
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
