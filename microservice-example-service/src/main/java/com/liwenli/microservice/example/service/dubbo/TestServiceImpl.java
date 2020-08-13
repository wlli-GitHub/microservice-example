package com.liwenli.microservice.example.service.dubbo;



import com.liwenli.microservice.example.model.User;
import com.liwenli.microservice.example.service.TestService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Service(version = "${dubbo.service.version}")
@Component
public class TestServiceImpl implements TestService {

    @Value("${server.port}")
    private String port;

    @Override
    public String testDubbo(User user){

        return user.getUserName()+user.getPassWord()+port+555;
        //

    }
}
