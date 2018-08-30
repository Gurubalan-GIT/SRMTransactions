package com.guru.mysqlshowcase.Servlets;

import com.guru.mysqlshowcase.DTO.LoginDTO.Bean;
import com.guru.mysqlshowcase.Service.ServiceImpl;
import com.guru.mysqlshowcase.DTO.RegisterDTO.RegisterBean;

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
        if(req.getParameter("loginsubmit")!=null){
            String Email=req.getParameter("email");
            String Password=req.getParameter("password");
            Bean bean=new Bean();
            bean.setEmail(Email);
            bean.setPassword(Password);
            ServiceImpl loginService = new ServiceImpl();
            Bean result=loginService.doLoginService(bean);
            if(result.getValid()){
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
            RegisterBean registerBean=new RegisterBean();
            registerBean.setEmail(Email);
            registerBean.setPassword(Password);
            registerBean.setName(name);
            registerBean.setAge(age);
            registerBean.setGender(gender);
            ServiceImpl registerService = new ServiceImpl();
            RegisterBean result=registerService.doRegisterService(registerBean);
            if(result.getIsValid()==0){
                printWriter.print("Success");
            }
            else{
                printWriter.print("Failure!");
            }
        }
    }
}
