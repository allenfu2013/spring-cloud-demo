package org.allen.registry.controller;

import org.allen.registry.model.UserDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public UserDTO getById(@PathVariable("userId") Long userId) {
        UserDTO dto = new UserDTO();
        dto.setId(userId);
        dto.setName("张三");
        return dto;
    }
}
