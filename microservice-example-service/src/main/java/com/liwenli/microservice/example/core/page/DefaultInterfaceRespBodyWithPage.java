package com.liwenli.microservice.example.core.page;

import java.util.Collections;
import java.util.List;

public class DefaultInterfaceRespBodyWithPage<T> {

    private T data;

    private Integer total;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public DefaultInterfaceRespBodyWithPage() {
    }

    public DefaultInterfaceRespBodyWithPage(T data, Integer total) {
        this.data = data;
        this.total = total;
    }

    public static <T> DefaultInterfaceRespBodyWithPage<T> page(List<T> data, Integer total) {
        return new DefaultInterfaceRespBodyWithPage(data, total);
    }

    public static <T> DefaultInterfaceRespBodyWithPage<T> empty() {
        return new DefaultInterfaceRespBodyWithPage(Collections.emptyList(), 0);
    }


}
