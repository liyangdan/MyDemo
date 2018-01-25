package com.chen.entity;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.Data;

import java.util.Date;


@Data
public class User {
    private long id;
    private String username;
    private Date createdata;
    private double score;

}
