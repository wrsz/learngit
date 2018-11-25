package com.community.cmsservice.jpa;

import com.common.entity.master.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yanhan
 * @Date: 2018/8/30 15:29
 * @Description:
 */
public interface UserRepository extends JpaRepository<User,Long>
        {


}
