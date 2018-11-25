package com.community.cmsservice.controller;

import com.common.entity.master.User;
import com.community.cmsservice.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanhan
 * @Date: 2018/8/30 10:29
 * @Description:
 */
@RestController
@RequestMapping("base")
public class BaseController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("index")
    public String ss(){
        return "hahah";
    }

    @RequestMapping("save")
    @Transactional(rollbackFor = Exception.class)
    public String save(){
        User user=new User();
        user.setName("新的2");
        userRepository.save(user);
        return "保存成功";
    }
}
