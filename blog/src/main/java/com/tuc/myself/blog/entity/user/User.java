package com.tuc.myself.blog.entity.user;

import com.tuc.myself.blog.entity.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @Auther: tuc
 * @Date: 2020-03-02 13:28
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "user")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String telephone;
    private String idcard;
    private String salt;
    private Integer sex;
    private String email;
    private String avatar;
    private String wechat;
    private String tencent;
    private Integer status;
}
