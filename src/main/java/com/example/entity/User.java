package com.example.entity;

import lombok.Data;

import java.util.Date;
/**
 * Created by liyangdan on 2018/1/24.
 */

@Data
public class User {
    private long id;
    private String username;
    private Date createdata;
    private double score;

}
