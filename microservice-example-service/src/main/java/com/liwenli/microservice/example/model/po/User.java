package com.liwenli.microservice.example.model.po;

import lombok.Data;

import java.io.Serializable;

/**
 * @author
 */
@Data
public class User extends Model implements Serializable {

    /**
     * 主键id
     */
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户类型
     */
    private Integer type;

    /**
     * 手机号码
     */
    private String mobilePhone;


}