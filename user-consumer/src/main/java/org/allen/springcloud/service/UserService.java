package org.allen.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.allen.springcloud.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getByUserIdFallback")
    public User getByUserId(long userId) {
        return restTemplate.getForObject("http://user-service/user/getByUserId?userId={userId}", User.class, userId);
    }

    public User getByUserIdFallback(long userId) {
        return null;
    }
}
