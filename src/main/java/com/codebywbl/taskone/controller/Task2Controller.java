package com.codebywbl.taskone.controller;/*
    @author:bl
    @date:2020/04/02 16:59
    @description:
*/

import com.codebywbl.taskone.bean.User;
import com.codebywbl.taskone.service.Task2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Task2Controller {
    @Autowired
    Task2Service task2Service;

    /*Task2*/
    //异常调试方法
    @RequestMapping("/test")
    public void test(){
        int i = 10 / 0;
    }

    //在index.ftl页面加载完成之后，通过ajax发送请求，获取信息
    @RequestMapping("/index1")
    @ResponseBody
    public List<User> index1(){
        List<User> users = task2Service.index();
        return users;
    }
    //先访问index2请求，转发到index页面
    @RequestMapping("/index")
    public String index2(){
        return "index";
    }

    //处理模态框(员工插入)
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    @ResponseBody
    public void saveUser(HttpServletRequest request,User user){
        Map<Object,Object> map = new HashMap<>();
        String[] split = null;
        user.setHobby(request.getParameter("hobby").split(";"));  //设置爱好
        String[] descriptions = request.getParameter("discription").split(";");  //设置description
        for (String description : descriptions) {
            if (description.contains(":")){
                split = description.split(":");
                if (split.length == 2)
                    map.put(split[0],split[1]);
            }
        }
        user.setDescription(map);
        task2Service.saveUser(user);
        return;
    }

    //先查询到user对象
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    @ResponseBody
    public User user(@PathVariable("id") String id){
        return task2Service.getUser(id);
    }

    //用户更新
    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public void updateUser(@PathVariable("id")String id,HttpServletRequest request,User user){
        //User user = new User();
        Map<Object,Object> map = new HashMap<>();
        String[] split = null;
        user.setId(id); //设置id
        user.setHobby(request.getParameter("hobby").split(";"));  //设置爱好
        String[] descriptions = request.getParameter("discription").split(";");  //设置description
        for (String description : descriptions) {
            split = description.split(":");
            map.put(split[0],split[1]);
        }
        user.setDescription(map);
        task2Service.update(user);
    }

    //根据输入条件查询数据
    @RequestMapping(value = "/check",method = RequestMethod.GET)
    @ResponseBody
    public List<User> check(HttpServletRequest request){
        //获得条件
        String tj = request.getParameter("tj");
        //获得条件对应的值
        String val = request.getParameter("val");
        //如果条件是age，那么进行针对age查询
        if ("age".equals(tj)){
            return task2Service.check(val);
        }else if (val.equals("")){
            //如果条件值为空，那么就查询全部
            return task2Service.index();
        } else{
            //否则，按条件和值进行查询
            return task2Service.check(tj,val);
        }
    }
}
