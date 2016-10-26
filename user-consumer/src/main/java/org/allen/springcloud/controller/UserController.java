package org.allen.springcloud.controller;

import org.allen.springcloud.dto.User;
import org.allen.springcloud.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/getByUserId", method = RequestMethod.GET)
    public User getByUserId(@RequestParam Long userId) {
        logger.info(String.format("[/user/getByUserId] userId:%s", userId));
        User user = userService.getByUserId(userId);
        return user;
    }
}
