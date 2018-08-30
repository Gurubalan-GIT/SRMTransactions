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
                String query1 = "select * from users where Email='"+Email+"' and pwd='"+Password+"';";
                String query2="select Email,pwd,usertype from users where Email='"+Email+"' and pwd='"+Password+"' and usertype='admin';";
                try {
                    PreparedStatement ps;
                    ps = connection.prepareStatement(query1);
                    ResultSet resultSet = ps.executeQuery();
                    if(resultSet.next()){
                        bean.setValid(true);
                        PreparedStatement ps1;
                        ps1=connection.prepareStatement(query2);
                        ResultSet resultSet1=ps1.executeQuery();
                        if(resultSet1.next()){
                            bean.setAdmin(true);
                        }
                        else{
                            bean.setAdmin(false);
                        }
                       /* PreparedStatement ps1;
                        ps1=connection.prepareStatement(query2);
                        ResultSet resultSet1=ps1.executeQuery();
                        while(resultSet1.next()){
                            String Cemail=resultSet1.getString("Email");
                            String Cpass=resultSet1.getString("pwd");
                            if(Cemail.equals(Email)&&Cpass.equals(Password)){
                                String Ctype=resultSet1.getString("usertype");
                                if(Ctype.equals("admin")){
                                    bean.setAdmin(true);
                                    break;
                                }
                                else{
                                    bean.setAdmin(false);
                                    break;
                                }
                            }
                        }*/
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
        String Email=registerBean.getEmail();
        if(connection==null){
            System.out.print("Error 404");
        }else {
            String query1="select Email from users where Email='"+Email+"';";
            String query2="insert into users (Email, pwd, name, age, gender,usertype) VALUES ('"+registerBean.getEmail()+"','"+registerBean.getPassword()+"','"+registerBean.getName()+"','"+registerBean.getAge()+"','"+registerBean.getGender()+"','user');";
            try {
                PreparedStatement ps;
                ps = connection.prepareStatement(query1);
                ResultSet resultSet=ps.executeQuery();
                if(resultSet.next()){
                    registerBean.setResultSetValid(true);
                    registerBean.setEmailExits(0);
                }
                else{
                    registerBean.setResultSetValid(false);
                    registerBean.setEmailExits(1);
                    PreparedStatement ps2=connection.prepareStatement(query2);
                    registerResult=ps2.executeUpdate();
                    if(registerResult>0){
                        registerBean.setIsValid(0);
                    }
                    else {
                        registerBean.setIsValid(1);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return registerBean;
    }
}
