package com.liwenli.microservice.example.core.exception;

import com.liwenli.microservice.example.core.enums.CustomExceptionEnum;

public class CustomException extends Exception {

    /**
     * 异常响应码
     */
    private String code;

    public CustomException(String code,String msg) {
        super(msg);
        this.code = code;
    }

    public CustomException(CustomExceptionEnum msg) {
        super(msg.getContent());
        this.code = msg.getCode();
    }

    public String getCode() {
        return code;
    }

}
