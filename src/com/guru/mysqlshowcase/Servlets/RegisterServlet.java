package com.guru.mysqlshowcase.Servlets;

import com.guru.mysqlshowcase.DTO.RegisterDTO.RegisterBean;
import com.guru.mysqlshowcase.Service.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter printWriter=res.getWriter();
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
                res.setContentType("text/html");
                printWriter.print("<script type=\"text/javascript\">alert('You have been successfully registered. Try logging in!'); window.location.href='/index.jsp'; </script>");
            }
            else{
                printWriter.print("Failure!");
            }
        }
    }
}
