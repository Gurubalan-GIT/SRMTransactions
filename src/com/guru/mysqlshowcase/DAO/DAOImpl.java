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
    int registerResult;
    @Override
    public Bean doLogin(Bean bean) {
        String Email=bean.getEmail();
        String Password=bean.getPassword();
        if(connection==null){
            System.out.print("Error 404");
        }
        else {
                String query1 = "select * from users where Email=? and pwd=?;";
                String query2="select Email,pwd,usertype from users;";
                try {
                    PreparedStatement ps;
                    ps = connection.prepareStatement(query1);
                    ps.setString(1, Email);
                    ps.setString(2, Password);
                    ResultSet resultSet = ps.executeQuery();
                    if(resultSet.next()){
                        bean.setValid(true);
                        PreparedStatement ps1;
                        ps1=connection.prepareStatement(query2);
                        ResultSet resultSet1=ps1.executeQuery();
                        while(resultSet1.next()){
                            String Cemail=resultSet1.getString("Email");
                            String Cpass=resultSet1.getString("pwd");
                            if(Cemail.equals(Email)&&Cpass.equals(Password)){
                                String Ctype=resultSet1.getString("usertype");
                                if(Ctype.equals("admin")){
                                    System.out.print(Ctype);
                                    bean.setAdmin(true);
                                    break;
                                }
                                else{
                                    System.out.print(Ctype);
                                    bean.setAdmin(false);
                                    break;
                                }
                            }
                        }
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
            String query="insert into users (Email, pwd, name, age, gender,usertype) VALUES ('"+registerBean.getEmail()+"','"+registerBean.getPassword()+"','"+registerBean.getName()+"','"+registerBean.getAge()+"','"+registerBean.getGender()+"','user');";
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
