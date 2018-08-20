package com.guru.mysqlshowcase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if(req.getParameter("button")!=null){
            DAOImpl dao=new DAOImpl();
            dao.CreateTable();
        }
    }
}
