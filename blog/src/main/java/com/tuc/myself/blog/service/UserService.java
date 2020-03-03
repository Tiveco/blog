package com.tuc.myself.blog.service;

import com.tuc.myself.blog.entity.user.User;

/**
 * @Auther: tuc
 * @Date: 2020-03-02 14:51
 */
public interface UserService {

    String register(User user, String smsCode);

    String login(User user);

    String smsLogin(String telephone, String smsCode);

}
