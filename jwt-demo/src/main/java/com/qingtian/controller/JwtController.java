package com.qingtian.controller;

import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.qingtian.util.JsonUtils;
import com.qingtian.util.JwtUtils;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/9/29
 */
@RestController
public class JwtController {

    public static final Logger log = LoggerFactory.getLogger(JwtController.class);

    @GetMapping("/getToken")
    public String getToken() {

        String phone = "15268920";
        // get token
        String jsonWebToken = JwtUtils.geneJsonWebToken(phone);
        // assert token is not blank
        if (StringUtils.isBlank(jsonWebToken)) {
            log.error("没有成功生成token串");
            // no token
            return JsonUtils.genInfoJsonStr(false, "没有成功生成token串");

        }
        return JsonUtils.genInfoJsonStr(true, jsonWebToken);
    }


    @GetMapping("/loginByToken")
    public String loginByToken(@RequestParam(value = "token") String token) {

        if (StringUtils.isBlank(token)) {
            return JsonUtils.genInfoJsonStr(false, "token不能为空");
        }

        // check the token is valid
        Claims claims = JwtUtils.checkJWT(token);

        if (claims == null) {
            return JsonUtils.genInfoJsonStr(false, "校验失败");
        } else {
            String phone = (String) claims.get("phone");
            log.info("phone={}",phone);
            return JsonUtils.genInfoJsonStr(true, "校验成功");
        }

    }
}
