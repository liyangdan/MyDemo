package com.example.dem.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by liyangdan on 2018/2/10.
 */
@Data
public class User {
    private long id;
    private String username;
    private Date createdata;
    private double score;

}

