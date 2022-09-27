package com.example.PAO;

import com.example.bean.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserInfoDAO {
    final private String className="com.mysql.cj.jdbc.Driver";
    final private String connstr="jdbc:mysql://localhost:3306/usertest?serverTimezone=Asia/Shanghai";
    final private String username="root";
    final private String passwd="1111";

    private Connection conn;

//    获取链接的方法
    public Connection getConn()throws Exception{
        Class.forName(className);
        conn= DriverManager.getConnection(connstr,username,passwd);
        return conn;
    }

//    读取一个表的内容
    public List userDisp() throws Exception{

        String sqlStr="select * from users";
        Statement sta = getConn().createStatement();
        ResultSet rs = sta.executeQuery(sqlStr); //获取语句对象并执行SQL语句（Statement接口）
        ArrayList<HashMap> list = new ArrayList<>();//保存所有记录
        while (rs.next()){
            HashMap<String, Object> user = new HashMap<>();//整合一条记录{{id:1}}
            user.put("id",rs.getObject(1));//id
            user.put("uname",rs.getObject(2));//uname
            user.put("uage",rs.getObject(3));//uage
            list.add(user);
        }
      //关闭链接
        rs.close();
        sta.close();
        conn.close();
        return list;
    }
    public List userDisp2() throws Exception{
        String sqlStr="select * from users";
        Statement sta = getConn().createStatement();
        ResultSet rs = sta.executeQuery(sqlStr); //获取语句对象并执行SQL语句（Statement接口）
        ArrayList<Users> list = new ArrayList<>();
        while (rs.next()) {
            Users user = new Users();
            user.setId(rs.getInt("id"));
            user.setUname(rs.getString("uname"));
            user.setUage(rs.getInt("uage"));//封装一条记录
            list.add(user);
        }
        //关闭链接
        rs.close();
        sta.close();
        conn.close();
        return list;
    }
    public void userAdd2() throws Exception{
        //sql语句
        String sqlStr="insert into users (uname,uage) values('罗春梅',45)";
        Statement sta = getConn().createStatement();
        sta.executeUpdate(sqlStr);
        //关闭
        sta.close();
        conn.close();
    }

    public void userAdd(String uname,int uage) throws Exception{
        //sql语句
        String sqlStr="insert into users (uname,uage) values(?,?)";
        PreparedStatement sta = getConn().prepareStatement(sqlStr);
        sta.setString(1,uname);
        sta.setInt(2,uage);
        sta.executeUpdate();
        //关闭
        sta.close();
        conn.close();
    }
}
