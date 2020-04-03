package com.codebywbl.taskone.DaoImpl;/*
    @author:bl
    @date:2020/04/02 17:04
    @description:
*/

import com.codebywbl.taskone.bean.User;
import com.codebywbl.taskone.dao.Task2Dao;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class Task2Imp implements Task2Dao {
    @Autowired
    private MongoTemplate mongoTemplate;

    //查询所有数据
    @Override
    public List<User> findAll() {
        Query query = new Query(Criteria.where("").is(""));
        List<User> users = mongoTemplate.find(query, User.class);
        return users;
    }

    //保存用户
    @Override
    public void saveUser(User user) {
        mongoTemplate.save(user);
    }

    //根据用户的id查询用户（单个）
    @Override
    public User findUserById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        User user = mongoTemplate.findOne(query,User.class);
        return user;
    }

    //根据传入的user更新数据
    @Override
    public int updateUser(User user) {
        //查找其id字段与传入user的id相同的数据
        Query query = new Query(Criteria.where("id").is(user.getId()));
        //进行更新操作
        Update update = new Update().set("name",user.getName())
                .set("age",user.getAge())
                .set("address",user.getAddress())
                .set("hobby",user.getHobby())
                .set("description",user.getDescription());
        UpdateResult result = mongoTemplate.updateFirst(query,update,User.class);
        if (result != null){
            //返回应修改的行数
            return (int)result.getModifiedCount();
        }else{
            return 0;
        }
    }
    //根据年龄查询数据（多个）
    @Override
    public List<User> check(String val) {
        Query query = new Query(Criteria.where("age").is(Integer.parseInt(val)));
        List<User> users = mongoTemplate.find(query, User.class);
        return users;
    }

    //根据非年龄的条件查询数据（多个）
    @Override
    public List<User> check(String tj, String val) {
        Query query = new Query(Criteria.where(tj).is(val));
        List<User> users = mongoTemplate.find(query, User.class);
        return users;
    }
}
