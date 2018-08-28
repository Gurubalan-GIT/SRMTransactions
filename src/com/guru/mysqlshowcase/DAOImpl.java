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
        String Email=bean.getEmail();
        String Password=bean.getPassword();
        if(connection==null){
            System.out.print("Error 404");
        }
        else {
                Connection connection = DBConnection.getConnection();
                String query = "select * from users where Email=? and pwd=?;";
                PreparedStatement ps = null;
                try {
                    ps = connection.prepareStatement(query);
                    ps.setString(1, Email);
                    ps.setString(2, Password);
                    ResultSet rs = ps.executeQuery();
                    result=rs.next();
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
