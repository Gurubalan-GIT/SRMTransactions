package com.guru.mysqlshowcase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOImpl{
    Connection connection=DBConnection.getConnection();
    public void CreateTable(){
        if(connection==null){
            System.out.print("Failed");
        }
        else{
            try{
                Statement statement=connection.createStatement();
                int result=statement.executeUpdate("CREATE TABLE `test`.`table1` ( `firstName` VARCHAR(30) NOT NULL , `lastName` VARCHAR(30) NOT NULL , `Age` INT(10) NOT NULL , `Gender` VARCHAR(30) NOT NULL )");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
