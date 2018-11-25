package com.community.apiservice;

import com.community.apiservice.service.UserService;
import org.databene.contiperf.PerfTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiServiceApplicationTests {
    @Autowired
    private  UserService userService;


    /**
     * 性能测试
     * 10万次查询，100个线程同时操作findAll方法
     */
    @Test
    @PerfTest(invocations = 100000, threads = 100)
    public void contextLoads() {
        userService.findAll();
    }


}
