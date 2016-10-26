package org.allen.springcloud.controller;

import org.allen.springcloud.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/getByUserId", method = RequestMethod.GET)
    public User getById(@RequestParam Long userId) {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("[/getByUserId], host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
        User user = getByUserId(userId);
        return user;
    }

    // mock get user service
    private User getByUserId(Long userId) {
        User user = new User();
        user.setUserId(userId);
        user.setUsername("allen");
        user.setAge(18);
        user.setSex("male");
        return user;
    }
}
