package com.community.cmsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class CmsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmsServiceApplication.class, args);
    }
}
