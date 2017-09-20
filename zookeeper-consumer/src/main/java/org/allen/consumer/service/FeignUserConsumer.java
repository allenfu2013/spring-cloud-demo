package org.allen.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(value="registry-center")
public interface FeignUserConsumer {

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public String getUser(@PathVariable("userId") Long userId);
}
