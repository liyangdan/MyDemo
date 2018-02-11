package com.example.service;

import com.example.entity.User;

import java.util.List;
/**
 * Created by liyangdan on 2018/1/24.
 */

public interface UserService {
    User getUserById(long id);
    List<User> getAllUser();
    int delUser(long id);
    int addUser(User user);
    void updateUser(User user);
}
