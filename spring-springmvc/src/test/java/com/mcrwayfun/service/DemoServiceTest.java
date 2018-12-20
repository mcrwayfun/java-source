package com.mcrwayfun.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-service.xml"})
public class DemoServiceTest {

    public static final Logger log = LoggerFactory.getLogger(DemoServiceTest.class);

    @Autowired
    private DemoService demoService;

    @Test
    public void sayHello() {
        String result = demoService.sayHello("mcrwayfun");
        log.info(result);
    }
}