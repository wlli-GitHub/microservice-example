package com.liwenli.microservice.example.feign;

import com.liwenli.microservice.example.model.po.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * value:注册到eureka注册中心的服务名
 */
@FeignClient(value = "micro-service")
public interface FeignService {

    @GetMapping(value = "/api/user/page")
    public String helo();

    @PostMapping(value = "/api/test1")
    public String helo1(User user);

    //get方式请求
    /*@GetMapping("/api/v1/feign/operation/user/divisionChargeUser")
    UserInfo queryChargeUser(@RequestParam("deptCode") String deptCode, @RequestParam("divisionId") String divisionId);

    //post方式请求
    @PostMapping("/api/v1/feign/operation/company/initRelation")
    HttpRequestResultWrapper<Boolean> initCompanyRelation(@RequestBody CompanyBaseInfo companyBaseInfo);*/
}
