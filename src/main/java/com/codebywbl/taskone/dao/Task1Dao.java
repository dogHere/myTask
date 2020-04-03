package com.codebywbl.taskone.dao;/*
    @author:bl
    @date:2020/04/01 20:12
    @description:
*/

import com.codebywbl.taskone.bean.User;

public interface Task1Dao {
    public void insertUser(User user);
    public User findUserById(String id);
    public int updateUser(User user);
    public User findUserByName(String name);
    public User findUserByAge(Integer age);
    public User findUserByHobby(String hobby);
    public User findUserByDescription(String name,String val);
}
