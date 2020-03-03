package com.tuc.myself.blog.entity.user;

import com.tuc.myself.blog.entity.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @Auther: tuc
 * @Date: 2020-03-02 13:35
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "role")
public class Role extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String rolename;
    private Integer status;
}
