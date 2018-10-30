package com.qingtian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class CookieSessionDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CookieSessionDemoApplication.class, args);
    }
}
