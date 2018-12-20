package com.mcrwayfun.controller;

import com.mcrwayfun.aspect.Loggable;
import com.mcrwayfun.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("/log")
    @Loggable
    public Map<String, Object> log(@RequestParam("name") String name,
                                   @RequestParam("age") String age) {
        Map<String, Object> retMap = new HashMap<String, Object>();
        retMap.put("retCode", 500);
        retMap.put("retMsg", "测试拦截日志");

        return retMap;
    }
}
