package com.wofeng.articlemanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yueyueyue
 * @date 2019/4/15 15:48
 * Description: article-management
 */

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String hello() {
        //这边我们,默认是返到templates下的login.html
        return "login";
    }

}
