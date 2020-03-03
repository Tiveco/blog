package com.tuc.myself.blog.utils;

import com.tuc.myself.blog.exception.SmsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * @Auther: tuc
 * @Date: 2020-03-03 14:39
 */
@Component
public class SmsUtils {

    @Autowired
    private RedisUtils redisUtils;

    public boolean checkSmsCode(String telephone, String smsCode){
        if (ObjectUtils.isEmpty(smsCode)) throw new SmsException("请填写正确的验证码");
        String redisSmsCode = getRedisSmsCode(telephone);
        if (!smsCode.equals(redisSmsCode)) throw new SmsException("验证码错误，请重新输入");
        return true;
    }

    public String getRedisSmsCode(String telephone) {
        Object smsCode = redisUtils.get("sms:code::" + telephone);
        if (ObjectUtils.isEmpty(smsCode)) throw new SmsException("验证码失效，请重新获取验证码");
        return smsCode.toString();
    }

}
