package com.tuc.myself.blog.service.impl;

import com.tuc.myself.blog.entity.user.User;
import com.tuc.myself.blog.exception.UserException;
import com.tuc.myself.blog.repository.UserRepository;
import com.tuc.myself.blog.service.UserService;
import com.tuc.myself.blog.utils.EncryptionUtils;
import com.tuc.myself.blog.utils.LogUtils;
import com.tuc.myself.blog.utils.SmsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.UUID;

/**
 * @Auther: tuc
 * @Date: 2020-03-02 14:52
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private SmsUtils smsUtils;

    @Override
    public String register(User user, String smsCode) {
        if (ObjectUtils.isEmpty(user) ||
                ObjectUtils.isEmpty(user.getTelephone()) ||
                ObjectUtils.isEmpty(user.getUsername()) ||
                ObjectUtils.isEmpty(user.getPassword()))
            throw new UserException("注册失败，请填写完整的信息");
        smsUtils.checkSmsCode(user.getTelephone(), smsCode);
        if (!ObjectUtils.isEmpty(userRepository.findByTelephone(user.getTelephone())))
            throw new UserException("注册失败，该电话号码已注册");
        if (!ObjectUtils.isEmpty(userRepository.findByUsername(user.getUsername())))
            throw new UserException("注册失败，该用户名已注册");

        String salt = UUID.randomUUID().toString();
        user.setPassword(EncryptionUtils.getMd5Password(user.getPassword(), salt));
        user.setSalt(salt);
        user.setStatus(1);
        user.setSex(0);
        LogUtils.setCreatedLog(user, "0");
        LogUtils.setModifiedLog(user, "0");
        User result = userRepository.save(user);
        if (ObjectUtils.isEmpty(result) || ObjectUtils.isEmpty(result.getId()))
            throw new UserException("服务繁忙，请稍后重试");
        return "注册成功";
    }

    @Override
    public String login(User user) {
        return null;
    }

    @Override
    public String smsLogin(String telephone, String smsCode) {
        return null;
    }

}
