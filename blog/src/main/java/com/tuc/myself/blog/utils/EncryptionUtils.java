package com.tuc.myself.blog.utils;

import org.springframework.util.DigestUtils;

/**
 * @Auther: tuc
 * @Date: 2020-03-03 15:01
 */
public class EncryptionUtils {

    public static String getMd5Password(String password,String salt){
        String md5Password=salt+password+salt;
        for (int i = 0; i <10; i++) {
            md5Password= DigestUtils.md5DigestAsHex(md5Password.getBytes());
        }
        return md5Password;
    }
}
