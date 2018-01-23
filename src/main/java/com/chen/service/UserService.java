package com.chen.service;

import com.chen.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface UserService {
    User getUserById(long id);
    List<User> getAllUser();
    int delUser(long id);
    int addUser(User user);
    void updateUser(User user);
}
