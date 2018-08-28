package com.guru.mysqlshowcase;

import com.guru.mysqlshowcase.login.Bean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter printWriter=res.getWriter();
        RequestDispatcher requestDispatcher;
        if(req.getParameter("loginsubmit")!=null){
            String Email=req.getParameter("email");
            String Password=req.getParameter("password");
            Bean bean=new Bean();
            bean.setEmail(Email);
            bean.setPassword(Password);
            ServiceImpl loginService = new ServiceImpl();
            Boolean result=loginService.doLoginService(bean);
            if(result){
                HttpSession httpSession=req.getSession(true);
                httpSession.setAttribute("bean",bean);
                res.sendRedirect("loginsuccess.jsp");
            }
            else{
                res.setContentType("text/html");
                printWriter.print("<script type=\"text/javascript\">alert('You are not a registered user. Please Sign up!'); window.location.href='/signup.jsp'; </script>");
            }
        }
        else if(req.getParameter("regsubmit")!=null){
            String Email=req.getParameter("email");
            String Password=req.getParameter("password");
            String name=req.getParameter("name");
            int age=Integer.parseInt(req.getParameter("age"));
            String gender=req.getParameter("gender");
        }
    }
}
