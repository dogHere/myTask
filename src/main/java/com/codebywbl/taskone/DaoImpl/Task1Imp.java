package com.codebywbl.taskone.DaoImpl;/*
    @author:bl
    @date:2020/04/01 20:19
    @description:
*/

import com.codebywbl.taskone.bean.User;
import com.codebywbl.taskone.dao.Task1Dao;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@Component
public class Task1Imp implements Task1Dao {

    @Autowired
    private MongoTemplate mongoTemplate;

    //插入数据
    @Override
    public void insertUser(User user) {
        mongoTemplate.save(user);  //save方法，如果新增数据的主键已经存在，则会对对应的数据进行修改
        //insert方法，如果新增数据的主键已经存在，则会抛出异常
        //批操作，insert，可以一次性插入一整个列表，save需要遍历列表，进行一个一个的插入
    }

    //根据id查找数据
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

    @Override
    public User findUserByName(String name){
        Query query = new Query(Criteria.where("name").is(name));
        User user = mongoTemplate.findOne(query,User.class);
        return user;
    }

    @Override
    public List<User> findUserByAge(Integer age1,Integer age2){
        Query query = new Query(Criteria.where("age").lt(age2).gt(age1));
        List<User> users = mongoTemplate.find(query, User.class);
        return users;
    }

    @Override
    public User findUserByHobby(String hobby){
        Query query = new Query(Criteria.where("hobby").is(hobby));
        User user = mongoTemplate.findOne(query,User.class);
        return user;
    }

    @Override
    public User findUserByDescription(String name,String val){
        Query query = new Query(Criteria.where("description." + name).is(val));
        User user = mongoTemplate.findOne(query,User.class);
        return user;
    }


}
