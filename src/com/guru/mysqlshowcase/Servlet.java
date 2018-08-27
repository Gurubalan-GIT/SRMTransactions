package com.guru.mysqlshowcase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter printWriter=res.getWriter();
        if(req.getParameter("loginsubmit")!=null){
            String Email=req.getParameter("email");
            String Password=req.getParameter("password");
            //Bean bean=new Bean();
            //bean.setEmail(Email);
            //bean.setEmail(Password);
            //LoginServiceImpl loginService = new LoginServiceImpl();
           // Boolean result=loginService.doLoginService(bean);
            Connection connection=DBConnection.getConnection();
            String query="select * from users where Email=? and pwd=?";
            PreparedStatement ps= null;
            try {
                ps = connection.prepareStatement(query);
                ps.setString(1,Email);
                ps.setString(2,Password);
                ResultSet rs=ps.executeQuery();
                if(rs.next())
                {
                    printWriter.print("Helllloooo");
                }
                else
                {
                    printWriter.print("FAIL");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            printWriter.print("<html> <body> Failed! </body </html>");
        }
    }
}
