package com.tuc.myself.blog.utils;

import java.util.Random;

/**
 * @Auther: tuc
 * @Date: 2020-03-03 13:13
 */
public class RandomUtils {

    public static String sixRandomCode() {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }
}
