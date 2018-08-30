package com.guru.mysqlshowcase.Servlets;

import com.guru.mysqlshowcase.DTO.RegisterDTO.RegisterBean;
import com.guru.mysqlshowcase.Service.ServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter printWriter=res.getWriter();
        RequestDispatcher requestDispatcher;
        if(req.getParameter("regsubmit")!=null){
            String Email=req.getParameter("email");
            String Password=req.getParameter("password");
            String name=req.getParameter("name");
            int age=Integer.parseInt(req.getParameter("age"));
            String gender=req.getParameter("gender");
            RegisterBean registerBean=new RegisterBean();
            registerBean.setEmail(Email);
            registerBean.setPassword(Password);
            registerBean.setName(name);
            registerBean.setAge(age);
            registerBean.setGender(gender);
            ServiceImpl registerService = new ServiceImpl();
            RegisterBean result=registerService.doRegisterService(registerBean);
            if(result.getIsValid()==0){
                HttpSession httpSession=req.getSession(true);
                httpSession.setAttribute("registerBean",registerBean);
                res.sendRedirect("registersuccess.jsp");
            }
            else{
                printWriter.print("Failure!");
            }
        }
    }
}
