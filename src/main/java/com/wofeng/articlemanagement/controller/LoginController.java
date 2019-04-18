package com.wofeng.articlemanagement.controller;


import com.wofeng.articlemanagement.securityConfig.CurrentUser;
import com.wofeng.articlemanagement.securityConfig.MyUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yueyueyue
 * @date 2019/4/15 15:48
 * Description: article-management
 */

@Controller
public class LoginController {


    @RequestMapping("/")
    public String hello(@CurrentUser MyUserDetail userDetail) {
        if (userDetail == null){
            return "login";
        }
        return  "/index";
    }

    @GetMapping("getAuthentication")
    public Object index(Authentication authentication) {
        return authentication.getPrincipal();
    }


}
