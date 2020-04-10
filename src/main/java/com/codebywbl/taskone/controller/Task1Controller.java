package com.codebywbl.taskone.controller;/*
    @author:bl
    @date:2020/04/01 21:35
    @description:
*/

import com.codebywbl.taskone.bean.User;
import com.codebywbl.taskone.service.Task1Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
@Api(tags = "员工管理")
@RestController
public class Task1Controller {
    @Autowired
    Task1Service task1Service;

    //异常调试方法
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ApiOperation("全局异常捕获测试")
    public void test(){
        int i = 10 / 0;
    }

    @ApiOperation("添加用户")
    @ApiImplicitParam(name = "request",value = "获取前提交的数据")
    @RequestMapping(value = "/insertUser",method = RequestMethod.POST)
    public User insertUser(HttpServletRequest request) {
        User user = new User();
        user = getUser(request, user);
        task1Service.insertUser(user);
        return user;
    }
    //将前台数据封装到对应的javabean(由于存在map等集合类型数据，不能完成自动映射)
    //该段代码意为：非基本字段（id,name,age,address,hobby）的数据，都认为是对象description属性(map)中的数据
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

    //根据id查找数据
    @ApiOperation("根据用户id查询用户")
    @ApiImplicitParam(name = "id",value = "要查找的用户的id")
    @RequestMapping(value = "/findUserById",method = RequestMethod.GET)
    public User findUserById(@RequestParam(value = "id") String id) {
        System.out.println(id);
        return task1Service.findUserById(id);
    }

    //根据用户id，去更改数据库中id为对应值数据
    @ApiOperation("根据用户id更新用户")
    @ApiImplicitParam(name = "request",value = "获取前台提交的数据，根据数据中的id找到要修改的用户，然后修改",dataType = "String")
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public int updateUser(HttpServletRequest request) {
        User user = new User();
        user = getUser(request,user);
        return task1Service.updateUser(user);
    }

    //根据name查找数据
    @ApiOperation("根据名字查找用户")
    @ApiImplicitParam(name = "name",value = "获取前台提交的数据，根据数据中的name找到用户",dataType = "String")
    @RequestMapping(value = "/findUserByName",method = RequestMethod.GET)
    public User findUserByName(@RequestParam("name") String name){
        return task1Service.findUserByName(name);
    }

    //根据年龄去查询，url中接受两个参数age1，age2，会根据两个数，查询出大于小的数并且小于大的数的用户集合
    @ApiOperation("根据年龄范围查找用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "age1",value = "age范围的其中一个参数",required = true,dataType = "Integer"),
            @ApiImplicitParam(name = "age2",value = "age范围的令一个参数",required = true,dataType = "Integer")})
    @RequestMapping(value = "/findUserByAge",method = RequestMethod.GET)
    public List<User> findUserByAge(@RequestParam("age1") Integer age1,@RequestParam("age2") Integer age2){
        return task1Service.findUserByAge(age1>age2?age2:age1,age2>age1?age2:age1);
    }

    //根据hobby中的值，去数据库查询对应的数据
    @ApiOperation("根据爱好查找用户")
    @ApiImplicitParam(name = "hobby",value = "根据数据中的hobby找到用户",dataType = "String")
    @RequestMapping(value = "/findUserByHobby",method = RequestMethod.GET)
    public User findUserByHobby(@RequestParam("hobby") String hobby){
        return task1Service.findUserByHobby(hobby);
    }

    //根据用户输入的数据，去数据库中查询description的子数据中是否有对应的值
    @ApiOperation("根据description查找用户")
    @ApiImplicitParam(name = "request",value = "获取前台提交的数据，根据数据中的description中的数据查找用户",dataType = "HttpServletRequest")
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
