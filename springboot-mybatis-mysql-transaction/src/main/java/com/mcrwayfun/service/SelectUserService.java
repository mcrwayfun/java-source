package com.mcrwayfun.service;

import com.mcrwayfun.entity.User;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2019/01/23
 * @description
 */
public interface SelectUserService {

    User selectUserById(Long id);
}
