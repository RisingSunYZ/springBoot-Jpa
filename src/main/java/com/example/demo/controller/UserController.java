package com.example.demo.controller;

import com.example.demo.UserDao;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/list")
    public List<User> getAll(){
        return this.userDao.findAll();
    }

    @RequestMapping("/get/{id}")
    public User get(@PathVariable("id") String id){
        return this.userDao.findOne(Integer.parseInt(id));
    }

    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable("id") String id){
        this.userDao.delete(Integer.parseInt(id));
    }

    @RequestMapping("/add")
    public User add(User user){
        return this.userDao.save(user);
    }

}
