package com.codebywbl.taskone.dao;/*
    @author:bl
    @date:2020/04/03 12:18
    @description:
*/

import com.codebywbl.taskone.bean.User;

import java.util.List;

public interface Task2Dao {
    public List<User> findAll();
    public void saveUser(User user);
    public User findUserById(String id);
    public int updateUser(User user);
    public List<User> check(String val);
    public List<User> check(String tj, String val);
}
