package com.liwenli.microservice.example.service;

import com.liwenli.microservice.example.core.exception.CustomException;
import com.liwenli.microservice.example.core.page.DefaultInterfaceRespBodyWithPage;
import com.liwenli.microservice.example.core.page.Query;
import com.liwenli.microservice.example.core.resp.DefaultInterfaceRespBody;
import com.liwenli.microservice.example.model.po.User;

/**
 * @author lwl
 * @Description
 * @date
 */
public interface IUserService {

    /**
     * 分页查询
     * @param query
     * @return
     */
    DefaultInterfaceRespBodyWithPage page(Query<User> query);

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    DefaultInterfaceRespBody save(User user) throws CustomException;

    /**
     * 更新用户信息
     * @param user
     * @param id 主键id
     * @return
     */
    DefaultInterfaceRespBody update(User user, String id) throws CustomException;

    /**
     * 根据主键id删除用户信息
     * @param id
     * @return
     */
    DefaultInterfaceRespBody delete(String id);

    /**
     * 根据主键id查询用户信息
     * @param id
     * @return
     */
    DefaultInterfaceRespBody selectById(String id);




}
