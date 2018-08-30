package com.guru.mysqlshowcase.DAO;
import com.guru.mysqlshowcase.DBConnect.DBConnection;
import com.guru.mysqlshowcase.DTO.LoginDTO.Bean;
import com.guru.mysqlshowcase.DTO.RegisterDTO.RegisterBean;

import java.sql.*;

interface DAO{
    Bean doLogin(Bean bean);
    RegisterBean doRegister(RegisterBean registerBean);
}
public class DAOImpl implements DAO{
    Connection connection= DBConnection.getConnection();
    //Boolean result;
    int registerResult;
    @Override
    public Bean doLogin(Bean bean) {
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
                    if(resultSet.next()){
                        bean.setValid(true);
                    }
                    else{
                        bean.setValid(false);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
       return bean;
    }
    @Override
    public RegisterBean doRegister(RegisterBean registerBean) {
        if(connection==null){
            System.out.print("Error 404");
        }else {
            String query="insert into users (Email, pwd, name, age, gender) VALUES ('"+registerBean.getEmail()+"','"+registerBean.getPassword()+"','"+registerBean.getName()+"','"+registerBean.getAge()+"','"+registerBean.getGender()+"');";
            PreparedStatement ps = null;
            try {
                ps = connection.prepareStatement(query);
                registerResult=ps.executeUpdate();
                if(registerResult>0){
                    registerBean.setIsValid(0);
                }
                else {
                    registerBean.setIsValid(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return registerBean;
    }
}
