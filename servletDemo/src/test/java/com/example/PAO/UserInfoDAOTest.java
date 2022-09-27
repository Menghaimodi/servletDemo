package com.example.PAO;

import com.example.bean.Users;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserInfoDAOTest {

    @Test
    void userDisp() throws Exception{
        UserInfoDAO userInfoDAO = new UserInfoDAO();
        List list = userInfoDAO.userDisp();
//        System.out.println(list.toString());
//        遍历list,迭代器iterator
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            HashMap<Object, Object> user = new HashMap<>();
            user= (HashMap<Object, Object>) iterator.next();
            System.out.print(user.get("id"));
            System.out.print("---");
            System.out.print(user.get("uname"));
            System.out.print("---");
            System.out.print(user.get("uage"));
            System.out.print("---");
            System.out.println();
        }
    }
    @Test
    public void userDisp2() throws Exception{
        UserInfoDAO userInfoDAO = new UserInfoDAO();
        List list = userInfoDAO.userDisp2();
        Iterator iterator=list.iterator();
        while (iterator.hasNext()) {
            Users user = new Users();
            user= (Users) iterator.next();
            System.out.print(user.getId());
            System.out.print("---");
            System.out.print(user.getUname());
            System.out.print("---");
            System.out.print(user.getUage());
            System.out.print("---");
            System.out.println();
        }
    }

    @Test
    public void userAddTest() throws Exception{
        UserInfoDAO userInfoDAO = new UserInfoDAO();
        userInfoDAO.userAdd2();
        userDisp2();
    }

    @Test
    public void userAddTest2() throws Exception{
        UserInfoDAO userInfoDAO = new UserInfoDAO();
        userInfoDAO.userAdd("你好",24);
        userDisp2();
    }
}