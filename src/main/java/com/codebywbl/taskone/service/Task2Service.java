package com.codebywbl.taskone.service;/*
    @author:bl
    @date:2020/04/02 17:03
    @description:
*/

import com.codebywbl.taskone.DaoImpl.Task2Imp;
import com.codebywbl.taskone.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Task2Service {
    @Autowired
    Task2Imp task2Imp;

    public List<User> index(){
        return task2Imp.findAll();
    }

    public void saveUser(User user) {
        task2Imp.saveUser(user);
    }

    public User getUser(String id) {
        return task2Imp.findUserById(id);
    }

    public void update(User user) {
        task2Imp.updateUser(user);
    }

    //专门处理age的条件查询
    public List<User> check(String val) {
        return task2Imp.check(val);
    }
    //专门处理字符串数据
    public List<User> check(String tj, String val) {
        return task2Imp.check(tj,val);
    }
}
