package com.liwenli.microservice.example.core.resp;


import static com.liwenli.microservice.example.core.enums.RespMsgEnum.MSG_EXCEPTION;
import static com.liwenli.microservice.example.core.enums.RespMsgEnum.MSG_SUCCESS;

public class DefaultInterfaceRespVO<T> {
    /**
     * 响应头文件
     */
    private DefaultInterfaceRespHead head;

    /**
     * 响应正确内容
     */
    private T body;

    /**
     * 响应成功
     */
    public static DefaultInterfaceRespVO SUCCESS = new DefaultInterfaceRespVO(new DefaultInterfaceRespHead(MSG_SUCCESS.getRespCode(),MSG_SUCCESS.getRespContent()));

    /**
     * 响应异常
     */
    public static DefaultInterfaceRespVO EXCEPTION = new DefaultInterfaceRespVO(new DefaultInterfaceRespHead(MSG_EXCEPTION.getRespCode(), MSG_EXCEPTION.getRespContent()));


    public DefaultInterfaceRespVO() {
    }

    public DefaultInterfaceRespVO(DefaultInterfaceRespHead head) {
        this.head = head;
    }

    public DefaultInterfaceRespVO(DefaultInterfaceRespHead head, T body) {
        this.head = head;
        this.body = body;
    }

    public static <T> DefaultInterfaceRespVO<T> getSuccessRespVO(T data) {
        DefaultInterfaceRespVO result = new DefaultInterfaceRespVO();
        result.setHead(new DefaultInterfaceRespHead(MSG_SUCCESS.getRespCode(), MSG_SUCCESS.getRespContent()));
        result.setBody(data);
        return result;
    }

    public static DefaultInterfaceRespVO getCustomExceptionRespVO(String respCode, String respContent) {
        DefaultInterfaceRespVO result = new DefaultInterfaceRespVO();
        result.setHead(new DefaultInterfaceRespHead(respCode, respContent));
        return result;
    }

    public DefaultInterfaceRespHead getHead() {
        return head;
    }

    public void setHead(DefaultInterfaceRespHead head) {
        this.head = head;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }


}
