package com.example.controller;


import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import com.example.entity.User;
import com.example.service.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;

/**
 * Created by liyangdan on 2018/1/24.
 */

@RestController
@RequestMapping(value = "/users")     // 通过这里配置使下面的映射都在/users下，可去除
@Api(description = "用户相关接口文档")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    private final static  Logger logger = LoggerFactory.getLogger(UserController.class);

    public List<User> getUserList() {
        return null;
    }

    /**
     * 增加的时候，我通过用参数的方式来增加
     *
     //* @param user
     * @param id
     * @param username
     * @param createdata
     * @param score
     * @return
     */
    @ApiOperation("增加用户信息")//对方法进行解释
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", dataType = "long", required = true, value = "键值", defaultValue = ""),
            @ApiImplicitParam(paramType = "query", name = "username", dataType = "String", required = true, value = "用户名", defaultValue = "null"),
            @ApiImplicitParam(paramType = "query", name = "createdata", dataType = "Date", required = false, value = "日期", defaultValue = ""),
            @ApiImplicitParam(paramType = "query", name = "score", dataType = "double", required = false, value = "分数", defaultValue = "0.0")})
    @RequestMapping(value ="/addUser",method = RequestMethod.PUT)//或者post
    public User addUser(Integer id,  String username, String createdata, double score) throws Exception{
        // 这里为了方便直接将输入内容返回
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null; //初始化date
        date = sdf.parse(createdata);
//        try {
//            date = sdf.parse(createdata); //Mon Jan 14 00:00:00 CST 2013
//        } catch (ParseException e) {
//           // e.printStackTrace();
//            System.out.println("------异常");
//        }
        User user=new User();
        user.setId(id);
        user.setCreatedata(date);
        user.setScore(score);
        user.setUsername(username);
        userService.addUser(user);


        return user;
    }


    /**
     *
     * @param id
     * @param user
     * @return
     */
    @ApiOperation(value = "/update", notes = "根据ID修改用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "id", value = "用户ID", required = true, dataType = "long"),
            @ApiImplicitParam(paramType = "body", name = "user", value = "用户信息", required = true, dataType = "User") })
    //@RequestMapping(value = "/update", method = RequestMethod.PUT)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public User update(@PathVariable long id, @RequestBody User user) {
        // 这里为了方便直接将输入内容返回
        user.setId(id);
        userService.updateUser(user);
        return user;
    }


    @ResponseBody
    @RequestMapping(value ="/RetrieveById", method= RequestMethod.GET)
    @ApiOperation(value="根据id查询信息")
//    @ApiImplicitParam(paramType="query", name = "userNumber", value = "用户编号", required = true, dataType = "Integer")
    public User RetrieveById(@RequestParam Long id){
        return userService.getUserById(id);
    }

    @ResponseBody
    @RequestMapping(value ="/RetrieveAll", method= RequestMethod.GET)
    @ApiOperation(value="查询所有信息")
//    @ApiImplicitParam(paramType="query", name = "userNumber", value = "用户编号", required = true, dataType = "Integer")
    public List<User> RetrieveAll(){
//        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
//        StatusPrinter.print(lc);
        logger.debug("test........");
        System.out.println("debug:——————"+logger.isDebugEnabled());
        System.out.println("info-----"+logger.isInfoEnabled());
        System.out.println("error----"+logger.isErrorEnabled());
        System.out.println("trance-----"+logger.isTraceEnabled());
        //logger.info("&&&&logger******");
//        logger.warn("finish:{}", userService.getAllUser());

        return userService.getAllUser();
    }

    @ResponseBody
    @RequestMapping(value ="/deleteUser", method= RequestMethod.DELETE)
    @ApiOperation(value="根据id删除信息")
//    @ApiImplicitParam(paramType="query", name = "userNumber", value = "用户编号", required = true, dataType = "Integer")
    public int DeleteById(@RequestParam Long id){
        userService.delUser(id);
        return 1;
    }


}

