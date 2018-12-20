package com.mcrwayfun.controller;

import com.mcrwayfun.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/20
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    public static final Logger log = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private DemoService demoService;

    @GetMapping("/sayHello")
    public String sayHello() {
        String result = demoService.sayHello("mcrwayfun");
        log.info(result);
        return result;
    }
}
