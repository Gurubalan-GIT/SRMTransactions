package com.guru.mysqlshowcase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if(req.getParameter("loginsubmit")!=null){
            String Email=req.getParameter("email");
            String Password=req.getParameter("password");
            Bean bean=new Bean();
            bean.setEmail(Email);
            bean.setEmail(Password);
            LoginServiceImpl loginService = new LoginServiceImpl();
            Boolean result=loginService.doLoginService(bean);
            PrintWriter printWriter=res.getWriter();
            if(result){
                printWriter.print("<html> <body> Success! </body </html>");
            }
            else{
                printWriter.print("<html> <body> Sign up! </body </html>");
            }
        }
        else {
            res.sendRedirect("");
        }
    }
}
