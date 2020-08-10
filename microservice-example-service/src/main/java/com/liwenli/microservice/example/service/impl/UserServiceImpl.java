package com.liwenli.microservice.example.service.impl;

import com.liwenli.microservice.example.core.exception.CustomException;
import com.liwenli.microservice.example.core.page.DefaultInterfaceRespBodyWithPage;
import com.liwenli.microservice.example.core.page.Query;
import com.liwenli.microservice.example.core.resp.DefaultInterfaceRespBody;
import com.liwenli.microservice.example.dao.UserMapper;
import com.liwenli.microservice.example.model.po.User;
import com.liwenli.microservice.example.service.IUserService;
import com.liwenli.microservice.example.utils.SnowflakeIdWorkerUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static com.liwenli.microservice.example.core.enums.CustomExceptionEnum._0000001;

/**
 * @author lwl
 * @Description
 * @date
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public DefaultInterfaceRespBodyWithPage page(Query<User> query) {

        int total = userMapper.totalForPage(query.getData());
        if (new Integer(0).equals(total)) {
            return DefaultInterfaceRespBodyWithPage.empty();
        }
        List<User> data = userMapper.dataForPage(query);
        return DefaultInterfaceRespBodyWithPage.page(data,total);
    }

    @Override
    public DefaultInterfaceRespBody save(User user) throws CustomException{
        //用户名不能重复
        if(StringUtils.isNotEmpty(user.getUserName())){
            User userDB = userMapper.checkUserName(user.getUserName());
            if(userDB != null){
                throw new CustomException(_0000001.getCode(),_0000001.getContent()+"用户名已存在！");
            }
        }
        //执行新增操作
        user.setId(SnowflakeIdWorkerUtil.SIWU.nextId());
        userMapper.insert(user);
        return DefaultInterfaceRespBody.data(true);
    }

    @Override
    public DefaultInterfaceRespBody update(User user, String id) throws CustomException{
        //用户名不能重复
        if(StringUtils.isNotEmpty(user.getUserName())){
            User userDB = userMapper.checkUserName(user.getUserName());
            if(userDB != null && !userDB.getId().equals(id)){
                throw new CustomException(_0000001.getCode(),_0000001.getContent()+"用户名已存在！");
            }
        }
        //执行更新操作
        user.setId(id);
        userMapper.updateByPrimaryKey(user);
        return DefaultInterfaceRespBody.data(true);
    }

    @Override
    public DefaultInterfaceRespBody delete(String id) {
        if(StringUtils.isNotEmpty(id)){
            List<String> userIdList = Arrays.asList(id.split(","));
            for (String userId:userIdList) {
                userMapper.deleteByPrimaryKey(userId);
            }
        }
        return DefaultInterfaceRespBody.data(true);
    }

    @Override
    public DefaultInterfaceRespBody selectById(String id) {
        if(StringUtils.isNotEmpty(id)){
            User user = userMapper.selectByPrimaryKey(id);
            return DefaultInterfaceRespBody.data(user);
        }
        return DefaultInterfaceRespBody.empty();
    }


}
