package com.chen.entity;

import lombok.Data;

import java.util.Date;


@Data
public class User {
    private long id;
    private String username;
    private Date createdata;
    private double score;


}
