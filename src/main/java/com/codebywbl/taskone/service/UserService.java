package com.codebywbl.taskone.service;/*
    @author:bl
    @date:2020/04/01 21:32
    @description:
*/

import com.codebywbl.taskone.DaoImpl.UserImp;
import com.codebywbl.taskone.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class UserService {
    @Autowired
    private UserImp userImp;

    public void insertUser(User user) {
        userImp.insertUser(user);
    }
    public User findUserById(String id) {
        return userImp.findUserById(id);
    }
    public int updateUser(User user) {
        return userImp.updateUser(user);
    }

    public User findUserByName(String name){
        return userImp.findUserByName(name);
    }

    public User findUserByAge(Integer age){
        return userImp.findUserByAge(age);
    }

    public User findUserByHobby(String hobby){
        return userImp.findUserByHobby(hobby);
    }

    public User findUserByDescription(String name,String val){
        return userImp.findUserByDescription(name,val);
    }
}
