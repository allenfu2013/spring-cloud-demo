package org.allen.consumer.controller;

import org.allen.consumer.service.FeignUserConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private FeignUserConsumer feignUserConsumer;

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public String add(@PathVariable(value = "userId") Long userId) {
        return feignUserConsumer.getUser(userId);
    }

}
