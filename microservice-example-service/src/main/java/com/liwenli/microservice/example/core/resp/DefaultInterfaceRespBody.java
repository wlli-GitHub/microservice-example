package com.liwenli.microservice.example.core.resp;

public class DefaultInterfaceRespBody<T> {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DefaultInterfaceRespBody() {
    }

    public DefaultInterfaceRespBody(T data) {
        this.data = data;
    }

    public static <T> DefaultInterfaceRespBody<T> data(T data) {
        return new DefaultInterfaceRespBody(data);
    }

    public static <T> DefaultInterfaceRespBody<T> empty() {
        return new DefaultInterfaceRespBody();
    }
}
