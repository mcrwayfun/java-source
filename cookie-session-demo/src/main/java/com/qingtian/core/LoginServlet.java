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
@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie = new Cookie("mcrwayfun",System.currentTimeMillis()+"");
        // 设置生命周期为MAX_VALUE，永久有效
        cookie.setMaxAge(Integer.MAX_VALUE);
        // MaxAge为负数，是一个临时Cookie，不会持久化
        // cookie.setMaxAge(-1);
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
