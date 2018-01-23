package com.chen.service;

import com.chen.mapper.UserMapper;
import com.chen.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service(value = "userService")
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserById(long id) {
        return userMapper.getUser(id);
    }
    public int delUser(long id){
        return userMapper.delUser(id);
    }
    public int addUser(User user){
        return userMapper.addUser(user);
    }
    public List<User> getAllUser(){
        return userMapper.getAllUser();
    }
    public void updateUser(User user){
        userMapper.updateUser(user);
    }
}
