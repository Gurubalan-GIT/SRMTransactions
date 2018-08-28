package com.guru.mysqlshowcase.DAO;
import com.guru.mysqlshowcase.DBConnect.DBConnection;
import com.guru.mysqlshowcase.LoginDTO.Bean;
import com.guru.mysqlshowcase.RegisterDTO.RegisterBean;

import java.sql.*;

interface DAO{
    Boolean doLogin(Bean bean);
    int doRegister(RegisterBean registerBean);
}
public class DAOImpl implements DAO{
    Connection connection= DBConnection.getConnection();
    Boolean result;
    int registerResult;
    @Override
    public Boolean doLogin(Bean bean) {
        String Email=bean.getEmail();
        String Password=bean.getPassword();
        if(connection==null){
            System.out.print("Error 404");
        }
        else {
                String query = "select * from users where Email=? and pwd=?;";
                PreparedStatement ps = null;
                try {
                    ps = connection.prepareStatement(query);
                    ps.setString(1, Email);
                    ps.setString(2, Password);
                    ResultSet resultSet = ps.executeQuery();
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

    @Override
    public int doRegister(RegisterBean registerBean) {
        if(connection==null){
            System.out.print("Error 404");
        }else {
            String query="insert into users (Email, pwd, name, age, gender) VALUES ('"+registerBean.getEmail()+"','"+registerBean.getPassword()+"','"+registerBean.getName()+"','"+registerBean.getAge()+"','"+registerBean.getGender()+"');";
            PreparedStatement ps = null;
            try {
                ps = connection.prepareStatement(query);
                registerResult=ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(registerResult>0){
            return 0;
        }
        else {
            return 1;
        }
    }
}
