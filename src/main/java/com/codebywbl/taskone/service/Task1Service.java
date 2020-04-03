package com.codebywbl.taskone.service;/*
    @author:bl
    @date:2020/04/01 21:32
    @description:
*/

import com.codebywbl.taskone.DaoImpl.Task1Imp;
import com.codebywbl.taskone.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Task1Service {
    @Autowired
    private Task1Imp userImp;

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

    public List<User> findUserByAge(Integer age1,Integer age2){
        return userImp.findUserByAge(age1,age2);
    }

    public User findUserByHobby(String hobby){
        return userImp.findUserByHobby(hobby);
    }

    public User findUserByDescription(String name,String val){
        return userImp.findUserByDescription(name,val);
    }


}
