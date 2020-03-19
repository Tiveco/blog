package com.tuc.myself.blog.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.tuc.myself.blog.container.ResponseResult;
import com.tuc.myself.blog.exception.SmsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: tuc
 * @Date: 2020-03-02 15:15
 */
@RestController
@RequestMapping("/sms")
public class ShortMessageService {

    @Value("${aliyun.param.sms.accessKeyId}")
    private String accessKeyId;
    @Value("${aliyun.param.sms.accessSecret}")
    private String accessSecret;

    @Autowired
    private RedisUtils redisUtils;

    @GetMapping("/send/{mobile}")
    public ResponseResult<String> sendSms(@PathVariable("mobile") String mobile) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);
        String code = RandomUtils.sixRandomCode();
        redisUtils.set("sms:code::"+mobile,code,3*60);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", mobile);
        request.putQueryParameter("SignName", "阿牧");
        request.putQueryParameter("TemplateCode", "SMS_171852172");
        request.putQueryParameter("TemplateParam", "{\"code\":"+code+"}");

        System.out.println("Redis Sms Code: " + redisUtils.get("sms:code::" + mobile));
//        try {
//            CommonResponse response = client.getCommonResponse(request);
//            if (response.getHttpStatus() != 200) {
//                JSONObject respJSON = JSON.parseObject(JSON.toJSONString(response.getData()));
//                String respCode = respJSON.getString("Code");
//                // String respCode = "isv.MOBILE_NUMBER_ILLEGAL";
//                respCode = respCode.substring(respCode.indexOf(".")+1);
//                String errorMessage = ObjectUtils.isEmpty(SMSErrorEnum.valueOf(respCode)) ?
//                        "短信服务异常" : SMSErrorEnum.valueOf(respCode).getMessage();
//            }
//        } catch (ServerException e) {
//            e.printStackTrace();
//        } catch (ClientException e) {
//            e.printStackTrace();
//        }
        return new ResponseResult<>(code);
    }

}
