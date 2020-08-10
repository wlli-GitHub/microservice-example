package com.liwenli.microservice.example.core.page;

/**
 * @author
 * @description 分页查询传参公用对象
 * @date
 */
public class Query<T> {

    private T data;

    private int pageNum = 1;

    private int pageSize = 10;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getPageNum() {
        return (this.pageNum - 1) * this.pageSize;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Query() {
    }

    public Query(T data, int pageNum, int pageSize) {
        this.data = data;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }
}
