package com.example.dem.service;

import com.example.dem.entity.User;
import com.example.dem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liyangdan on 2018/2/10.
 */
@Component("userService")
@Service(value = "userService")
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserById(long id) {

        return userMapper.getUser(id);
    }
    @Override
    public int delUser(long id){
        return userMapper.delUser(id);
    }
    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }
    @Override
    public List<User> getAllUser(){
        return userMapper.getAllUser();
    }
    @Override
    public void updateUser(User user){
        userMapper.updateUser(user);
    }
}
