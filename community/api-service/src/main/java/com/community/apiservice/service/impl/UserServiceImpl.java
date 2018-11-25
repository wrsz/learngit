package com.community.apiservice.service.impl;

import com.common.entity.master.User;
import com.community.apiservice.jpa.master.UserRepository;
import com.community.apiservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yanhan
 * @Date: 2018/9/1 15:58
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Cacheable(cacheNames = "user:all")
    public List<User> findAll(){
        return userRepository.findAll();
    }



}
