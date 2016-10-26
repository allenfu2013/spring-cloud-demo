package org.allen.springcloud.controller;

import org.allen.springcloud.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/getByUserId", method = RequestMethod.GET)
    public User getByUserId(@RequestParam Long userId) {
        logger.info(String.format("[/user/getByUserId] userId:%s", userId));
        User user = restTemplate.getForObject("http://user-service/user/getByUserId?userId={userId}", User.class, userId);
        return user;
    }
}
