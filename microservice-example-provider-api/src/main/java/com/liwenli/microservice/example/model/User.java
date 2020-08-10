package com.liwenli.microservice.example.model;

import java.io.Serializable;

public class User implements Serializable{
    /**
     * 姓名
     */
    private String userName;
    private String passWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
