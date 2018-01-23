package com.chen.mapper;

import com.chen.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
public interface UserMapper {
    User getUser(long id);
    List<User> getAllUser();
    int addUser(User user);
    int delUser(long id);
    void updateUser(User user);

}
