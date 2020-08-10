package com.liwenli.microservice.example.controller;

import com.liwenli.microservice.example.core.exception.CustomException;
import com.liwenli.microservice.example.core.page.Query;
import com.liwenli.microservice.example.core.resp.DefaultInterfaceRespVO;
import com.liwenli.microservice.example.feign.FeignService;
import com.liwenli.microservice.example.model.po.User;
import com.liwenli.microservice.example.service.IUserService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "用户管理")
@RequestMapping(value = "/api/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    IUserService userService;

    @Autowired
    FeignService feignService;

    @ApiOperation(value = "分页查询用户列表", notes = "分页查询用户列表")
    @GetMapping(value = "/page")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "name", value = "姓名", dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "页数", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "页面大小", dataType = "Integer")
    })
    public DefaultInterfaceRespVO querySaleContractForPage(@RequestParam(value = "name", required = false) String name,
                                                           @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                                           @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {

        Query<User> query = new Query();
        query.setPageNum(pageNum);
        query.setPageSize(pageSize);
        User user = new User();
        user.setName(name);
        query.setData(user);
        try {
            return DefaultInterfaceRespVO.getSuccessRespVO(userService.page(query));
        } catch (Exception e) {
            logger.error("查询数据异常", e);
            return DefaultInterfaceRespVO.EXCEPTION;
        }
    }

    @ApiOperation(value = "新增用户", notes = "新增用户")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功响应内容", response = User.class)
    })
    @PostMapping(value = "/save")
    public DefaultInterfaceRespVO save(@RequestBody User user) {
        try {
            return DefaultInterfaceRespVO.getSuccessRespVO(userService.save(user));
        } catch (CustomException e) {
            logger.error("新增数据异常", e);
            return DefaultInterfaceRespVO.getCustomExceptionRespVO(e.getCode(),e.getMessage());
        }catch (Exception e) {
            logger.error("新增数据异常", e);
            return DefaultInterfaceRespVO.EXCEPTION;
        }
    }

    @ApiOperation(value = "更新用户", notes = "更新用户")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功响应内容", response = User.class)
    })
    @PutMapping(value = "/{id}")
    public DefaultInterfaceRespVO update(@PathVariable(value = "id") String id,
                                         @RequestBody User user) {
        try {
            return DefaultInterfaceRespVO.getSuccessRespVO(userService.update(user,id));
        } catch (Exception e) {
            logger.error("更新数据异常", e);
            return DefaultInterfaceRespVO.EXCEPTION;
        }
    }

    @ApiOperation(value = "根据主键id删除用户", notes = "根据主键id删除用户（删除多个使用逗号隔开）")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功响应内容", response = User.class)
    })
    @DeleteMapping(value = "/{id}")
    public DefaultInterfaceRespVO delete(@PathVariable(value = "id") String id) {
        try {
            return DefaultInterfaceRespVO.getSuccessRespVO(userService.delete(id));
        } catch (Exception e) {
            logger.error("删除数据异常", e);
            return DefaultInterfaceRespVO.EXCEPTION;
        }
    }

    @ApiOperation(value = "根据主键id查询用户", notes = "根据主键id查询用户")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功响应内容", response = User.class)
    })
    @GetMapping(value = "/{id}")
    public DefaultInterfaceRespVO selectById(@PathVariable(value = "id") String id) {
        try {
            return DefaultInterfaceRespVO.getSuccessRespVO(userService.selectById(id));
        } catch (Exception e) {
            logger.error("查询数据异常", e);
            return DefaultInterfaceRespVO.EXCEPTION;
        }
    }



}
