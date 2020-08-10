package com.liwenli.microservice.example.core.enums;

public enum RespMsgEnum {

    /**
     * 执行成功
     */
    MSG_SUCCESS("200", "执行成功"),
    /**
     * 执行失败
     */
    MSG_EXCEPTION("500", "执行失败"),

    ;

    /**
     * 响应码
     **/
    private String respCode;

    /**
     * 响应内容
     **/
    private String respContent;

    /**
     * 构造函数（需要传入响应码和相应内容）
     **/
    RespMsgEnum(String code, String content) {
        respCode = code;
        respContent = content;
    }

    /**
     * 响应码
     **/
    public String getRespCode() {
        return respCode;
    }

    /**
     * 响应内容
     **/
    public String getRespContent() {
        return respContent;
    }

}
