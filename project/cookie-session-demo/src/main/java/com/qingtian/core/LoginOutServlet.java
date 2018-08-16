package com.qingtian.core;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/8/16
 */
@WebServlet(name = "loginOutServlet", urlPatterns = "/logout")
public class LoginOutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();
        Cookie cookie = null;

        // get Cookie
        for (Cookie ck : cookies) {

            if ("mcrwayfun".equals(ck.getName())) {
                cookie = ck;
                break;
            }
        }

        if (null != cookie) {
            // 删除一个cookie
            // cookie.setMaxAge(0);
            cookie.setMaxAge(-1);
            resp.addCookie(cookie);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
