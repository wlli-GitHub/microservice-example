package com.liwenli.microservice.example.core.enums;

public enum CustomExceptionEnum {

    /**
     * 提交数据异常
     */
    _0000001("0000001", "提交数据异常"),

    /**
     * 获取数据失败
     */
    _0000002("0000002", "获取数据失败"),

    ;

    /**
     * 响应码
     **/
    private String code;

    /**
     * 响应内容
     **/
    private String content;

    CustomExceptionEnum(String code, String content) {
        this.code = code;
        this.content = content;
    }

    public String getCode() {
        return code;
    }

    public String getContent() {
        return content;
    }

}
