package com.codebywbl.taskone.controller;/*
    @author:bl
    @date:2020/04/01 21:35
    @description:
*/

import com.codebywbl.taskone.bean.User;
import com.codebywbl.taskone.service.Task1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
public class Task1Controller {
    @Autowired
    Task1Service task1Service;

    @RequestMapping(value = "/insertUser",method = RequestMethod.POST)
    public User insertUser(HttpServletRequest request) {
        User user = new User();
        user = getUser(request, user);
        task1Service.insertUser(user);
        return user;
    }
    //将前台数据封装到对应的javabean
    private User getUser(HttpServletRequest request, User user) {
        //得到参数map
        Map<String, String[]> map = request.getParameterMap();
        //得到map中key的set集合
        Set<String> set = map.keySet();
        //遍历set集合
        Iterator<String> iterator = set.iterator();
        //创建map集合
        Map<Object,Object> description = new HashMap<>();
        //封装bean
        while (iterator.hasNext()){
            String temp = iterator.next();
            //设置id
            if (user.getId() == null && "id".equals(temp)){
                user.setId(map.get("id")[0]);
            }else if (user.getName() == null && "name".equals(temp)){//设置name
                user.setName(map.get("name")[0]);
            } else if (user.getAge() == 0 && "age".equals(temp)){//设置age
                user.setAge(Integer.parseInt(map.get("age")[0]));
            }else if (user.getAddress() == null && "address".equals(temp)){//设置address
                user.setAddress(map.get("address")[0]);
            }else if (user.getHobby() == null && "hobby".equals(temp)){  //设置hobby
                String hobby = map.get("hobby")[0];
                String[] hobbies = null;
                //字符串拆分
                if (hobby.contains(",")) {
                    hobbies  = hobby.split(",");
                }else if (hobby.contains("|")){
                    hobbies  = hobby.split("\\|");
                }else if (hobby.contains(".")){
                    hobbies  = hobby.split("\\.");
                }else{
                    //如果没有拆分符，就实例化对象，然后赋值
                    hobbies = new String[1];
                    hobbies[0] = hobby;
                }
                user.setHobby(hobbies);
            }else {
                //设置description
                description.put(temp,map.get(temp)[0]);
            }
        }
        user.setDescription(description);
        return user;
    }

    @RequestMapping(value = "/findUserById",method = RequestMethod.GET)
    public User findUserById(@RequestParam(value = "id") String id) {
        System.out.println(id);
        return task1Service.findUserById(id);
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public int updateUser(HttpServletRequest request) {
        User user = new User();
        user = getUser(request,user);
        return task1Service.updateUser(user);
    }

    @RequestMapping(value = "/findUserByName",method = RequestMethod.GET)
    public User findUserByName(@RequestParam("name") String name){
        return task1Service.findUserByName(name);
    }

    @RequestMapping(value = "/findUserByAge",method = RequestMethod.GET)
    public User findUserByAge(@RequestParam("age") Integer age){
        return task1Service.findUserByAge(age);
    }

    @RequestMapping(value = "/findUserByHobby",method = RequestMethod.GET)
    public User findUserByHobby(@RequestParam("hobby") String hobby){
        return task1Service.findUserByHobby(hobby);
    }

    @RequestMapping(value = "/description",method = RequestMethod.GET)
    public User findUserByDescription(HttpServletRequest request){
        String name = null;
        Enumeration<String> names = request.getParameterNames();
        if (names.hasMoreElements()){
            name = names.nextElement();
        }
        String val = request.getParameter(name);
        return task1Service.findUserByDescription(name,val);
    }


}
