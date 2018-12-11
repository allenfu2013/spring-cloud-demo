package org.allen.eureka.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class DemoController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/trace-1", method = RequestMethod.GET)
    public String trace1() {
        log.info("===call trace-1===");
        return restTemplate.getForEntity("http://trace-2/trace-2", String.class).getBody();
    }

    @RequestMapping(value = "/trace-2", method = RequestMethod.GET)
    public String trace2() throws InterruptedException {
        log.info("===call trace-2===");
        Thread.sleep(1000);
        return "Trace";
    }
}
