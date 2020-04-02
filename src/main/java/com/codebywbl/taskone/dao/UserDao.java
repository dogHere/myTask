package com.codebywbl.taskone.dao;/*
    @author:bl
    @date:2020/04/01 20:12
    @description:
*/

import com.codebywbl.taskone.bean.User;

public interface UserDao {
    public void insertUser(User user);
    public User findUserById(String id);
    public int updateUser(User user);
}
