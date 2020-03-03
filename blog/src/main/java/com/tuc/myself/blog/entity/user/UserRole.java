package com.tuc.myself.blog.entity.user;

import com.tuc.myself.blog.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * @Auther: tuc
 * @Date: 2020-03-02 13:38
 */
@Data
@Entity
@Table(name = "user_role_link")
public class UserRole extends BaseEntity {

    private static final long serialVersionUID = 740085085530748364L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    private Integer roleId;
}
