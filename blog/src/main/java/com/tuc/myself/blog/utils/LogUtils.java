package com.tuc.myself.blog.utils;

import com.tuc.myself.blog.entity.BaseEntity;

import java.util.Date;

/**
 * @Auther: tuc
 * @Date: 2020-03-03 14:47
 */
public class LogUtils {

    public static BaseEntity setModifiedLog(BaseEntity entity, String modifiedUser){
        entity.setModifiedUser(modifiedUser);
        entity.setModifiedTime(new Date());
        return entity;
    }

    public static BaseEntity setCreatedLog(BaseEntity entity,String createdUser){
        entity.setModifiedUser(createdUser);
        entity.setCreatedTime(new Date());
        return entity;
    }
}
