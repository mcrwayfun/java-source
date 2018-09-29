package com.mcrwayfun.jwtdemo.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description json web token操作工具类
 * @date Created in 2018/9/28
 */
public class JwtUtils {

    public static final Logger log = LoggerFactory.getLogger(JwtUtils.class);

    /**
     * subject
     */
    public static final String SUBJECT = "mcrwayfun-test-jwt";

    /**
     * 过期时间，毫秒，一周
     */
    public static final long EXPIRE = 1000 * 60 * 60 * 24 * 7;

    /**
     * 密钥
     */
    public static final String APP_SECRET = "f=-adfsGD213rzf8kjknerwe/*-";

    /**
     * 生成jwt
     *
     * @param phone     用户手机
     * @return jwt
     * @author mcrwayfun
     * @date 2018/9/28
     */
    public static String geneJsonWebToken(String phone) {

        if (StringUtils.isBlank(phone)) {
            return null;
        }

        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("phone", phone)
                .setIssuedAt(new Date())
                // 过期时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                // 签名算法
                .signWith(SignatureAlgorithm.HS256, APP_SECRET).compact();

        return token;
    }


    /**
     * 校验token
     *
     * @param token
     * @return
     */
    public static Claims checkJWT(String token) {

        try {
            // 验证jwt
            final Claims claims = Jwts.parser().setSigningKey(APP_SECRET).
                    parseClaimsJws(token).getBody();
            // 校验通过
            return claims;
        } catch (Exception e) {
            log.error("校验jwt出现了问题:{}", e.getMessage());
        }
        // 不通过返回null
        return null;
    }
}
