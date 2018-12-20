package com.mcrwayfun.service.impl;

import com.mcrwayfun.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/20
 */
@Service
public class DemoServiceImpl implements DemoService {

    public void sayHello(String name) {
        System.out.println("say hello to " + name);
    }
}
