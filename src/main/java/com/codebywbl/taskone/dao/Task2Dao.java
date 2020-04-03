package com.codebywbl.taskone.dao;/*
    @author:bl
    @date:2020/04/03 12:18
    @description:
*/

import com.codebywbl.taskone.bean.User;

import java.util.List;

public interface Task2Dao {
    public List<User> findAll();   //查询所有用户
    public void saveUser(User user);   //插入用户
    public User findUserById(String id);   //根据id查找用户
    public int updateUser(User user);   //更新用户
    public List<User> check(String age);   //根据age查找用户
    public List<User> check(String tj, String val);   //根据输入的非age条件查找用户
}
