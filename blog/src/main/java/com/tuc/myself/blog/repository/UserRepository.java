package com.tuc.myself.blog.repository;

import com.tuc.myself.blog.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Auther: tuc
 * @Date: 2020-03-03 14:28
 */
public interface UserRepository extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {

    User findByTelephone(String telephone);

    User findByUsername(String username);
}
