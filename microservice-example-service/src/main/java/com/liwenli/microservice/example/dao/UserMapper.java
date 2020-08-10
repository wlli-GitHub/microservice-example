package com.liwenli.microservice.example.dao;

import com.liwenli.microservice.example.core.page.Query;
import com.liwenli.microservice.example.model.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("userMapper")
public interface UserMapper {

    /**
     * 根据主键id删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 新增
     * @param record
     * @return
     */
    int insert(User record);

    /**
     * 根据主键id查询
     * @param id
     * @return
     */
    User selectByPrimaryKey(String id);

    /**
     * 校验用户名
     * @param userName 用户名
     *
     * @return
     */
    User checkUserName(@Param("userName") String userName);

    /**
     * 根据主键id更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(User record);

    /**
     * 获取分页条数
     * @param user
     * @return
     */
    int totalForPage(User user);

    /**
     * 获取分页数据
     * @param query
     * @return
     */
    List<User> dataForPage(Query<User> query);
}