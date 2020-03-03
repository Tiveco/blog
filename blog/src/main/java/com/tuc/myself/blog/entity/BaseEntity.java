package com.tuc.myself.blog.entity;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -5425346500432710882L;

    private String createdUser;//创建作者
    private Date createdTime;//创建时间
    private String modifiedUser;//修改作者
    private Date modifiedTime;//修改时间
}
