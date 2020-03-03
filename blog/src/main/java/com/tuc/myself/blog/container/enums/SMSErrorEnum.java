package com.tuc.myself.blog.container.enums;

import lombok.Getter;

/**
 * @Auther: tuc
 * @Date: 2020-03-03 9:50
 */
@Getter
public enum SMSErrorEnum {

    DENY_IP_RANGE("源IP地址所在的地区被禁用"),
    OUT_OF_SERVICE("平台短信业务停机，请及时联系管理员"),
    MOBILE_NUMBER_ILLEGAL("手机号码格式错误"),
    BUSINESS_LIMIT_CONTROL("短信发送频率超限"),
    AMOUNT_NOT_ENOUGH("平台短信业务余额不足，请及时联系管理员"),
    SignatureNonceUsed("验证码重复请求，请稍后重试");

    private String message;

    SMSErrorEnum(String message) {
        this.message = message;
    }
}
