package com.tuc.myself.blog.controller;

import com.tuc.myself.blog.container.ResponseResult;
import com.tuc.myself.blog.entity.user.User;
import com.tuc.myself.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: tuc
 * @Date: 2020-03-02 14:26
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register/{smsCode}")
    public ResponseResult<String> register(@RequestBody User user, @PathVariable("smsCode") String smsCode) {
        return new ResponseResult<>(userService.register(user, smsCode));
    }

    @PostMapping
    public ResponseResult<String> login(@RequestBody User user) {
        return new ResponseResult<>(userService.login(user));
    }

    @GetMapping
    public ResponseResult<String> smsLogin(@RequestParam("telephone") String telephone, @RequestParam("smsCode") String smsCode) {
        return new ResponseResult<>(userService.smsLogin(telephone, smsCode));
    }

}
