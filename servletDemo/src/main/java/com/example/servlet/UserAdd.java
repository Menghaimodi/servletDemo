package com.example.servlet;

import com.example.PAO.UserInfoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserAdd", value = "/UserAdd")
public class UserAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String uname;
      int uage;
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //告诉浏览器, 服务器发送的消息体数据的编码. 建议浏览器使用该编码解码
        response.setHeader("content-type","text/html;charset=utf-8");
      uname=request.getParameter("uname");
      uage= Integer.parseInt(request.getParameter("uage"));
        System.out.println(uname);
        System.out.println(uage);
        UserInfoDAO userInfoDAO = new UserInfoDAO();
        try {
            userInfoDAO.userAdd(uname,uage);
        } catch (Exception e) {
            System.out.println("User add error!!!");
        }
        response.sendRedirect("UserDisp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request,response);
    }
}
