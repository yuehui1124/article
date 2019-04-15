package com.wofeng.articlemanagement;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@MapperScan("com.wofeng.articlemanagement.mapper")
@SpringBootApplication
@Slf4j
public class ArticleManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArticleManagementApplication.class, args);
    }

}
