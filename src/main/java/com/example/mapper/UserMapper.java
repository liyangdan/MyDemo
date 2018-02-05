package com.example.mapper;

import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by liyangdan on 2018/1/24.
 */

@Mapper
public interface UserMapper {
    User getUser(long id);
    List<User> getAllUser();
    int addUser(User user);
    int delUser(long id);
    void updateUser(User user);

}
