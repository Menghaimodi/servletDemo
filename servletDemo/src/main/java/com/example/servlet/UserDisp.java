package com.example.servlet;

import com.example.PAO.UserInfoDAO;
import com.example.bean.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "UserDisp", value = "/UserDisp")
public class UserDisp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //配置输出字符集
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //告诉浏览器, 服务器发送的消息体数据的编码. 建议浏览器使用该编码解码
        response.setHeader("content-type","text/html;charset=utf-8");

        PrintWriter out = response.getWriter();
        out.print("<center>");
        UserInfoDAO userInfoDAO = new UserInfoDAO();
        ArrayList<Users> list = new ArrayList<>();
        try {
            list= (ArrayList<Users>) userInfoDAO.userDisp2();//遍历list
            request.setAttribute("list",list);//保存了一个变量名为list的数据，数据内容就是从数据库中读取的所有用户信息
            //如何把request中保存的数据返回给客户端
            request.getRequestDispatcher("disp.jsp").forward(request,response);//带数据的页面挑战
//            response.sendRedirect("disp.jsp");//也可以运行页面跳转，但是不带数据
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request,response);
    }
}
