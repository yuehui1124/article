package com.wofeng.articlemanagement.mvcConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author yueyueyue
 * @date 2019/4/15 14:58
 * Description: article-management
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer{



    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //registry.addViewController("/login").setViewName("login");
        registry.addViewController("/index").setViewName("index.html");
    }
}
