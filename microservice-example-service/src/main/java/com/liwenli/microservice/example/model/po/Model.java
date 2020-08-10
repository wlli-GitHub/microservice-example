package com.liwenli.microservice.example.model.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author
 * @Description 实体类表基本字段
 * @date
 */
@Data
public class Model implements Serializable {
    /**
     * 是否删除（0-否 1-是）
     */
    private Integer isDeleted;

    /**
     * 创建人id
     */
    private String createId;

    /**
     * 创建人姓名
     */
    private String createName;

    /**
     * 创建时间（@JsonFormat注解：返回指定格式的日期字符串）
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新人id
     */
    private String updateId;

    /**
     * 更新人姓名
     */
    private String updateName;

    /**
     * 更新时间（@JsonFormat注解：返回指定格式的日期字符串）
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}
