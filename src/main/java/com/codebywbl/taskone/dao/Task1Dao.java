package com.codebywbl.taskone.dao;/*
    @author:bl
    @date:2020/04/01 20:12
    @description:
*/

import com.codebywbl.taskone.bean.User;

import java.util.List;

public interface Task1Dao {

    public void insertUser(User user);  //插入用户
    public User findUserById(String id);  //根据id查询用户
    public int updateUser(User user);   //更新用户
    public User findUserByName(String name);  //根据名字查找用户
    public List<User> findUserByAge(Integer age1,Integer age2);   //根据年龄范围查找数据
    public User findUserByHobby(String hobby);   //根据爱好查找数据
    public User findUserByDescription(String name,String val);   //根据description中的字段值查找数据
}
