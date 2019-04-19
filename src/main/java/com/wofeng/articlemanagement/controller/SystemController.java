package com.wofeng.articlemanagement.controller;


import com.wofeng.articlemanagement.baseDao.BusinessMessage;
import com.wofeng.articlemanagement.securityConfig.CurrentUser;
import com.wofeng.articlemanagement.securityConfig.MyUserDetail;
import com.wofeng.articlemanagement.service.impl.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yueyueyue
 * @date 2019/4/15 15:48
 * Description: article-management
 */

@RestController
public class SystemController {

    @Autowired
    private SystemService systemService;

    @GetMapping("getAuthentication")
    public BusinessMessage<Object> index(Authentication authentication) {
        BusinessMessage<Object> message = new BusinessMessage<>();
        message.setData(authentication.getPrincipal());
        message.setSuccess(true);
        return message;
    }

    @GetMapping("/getFirstMenus")
    public BusinessMessage<String> getMenus(String menuIds) {
        return this.systemService.getMenus(menuIds);
    }

    @GetMapping("/getTwoMenus")
    public BusinessMessage<Object> getTwoMenus(String firstMenuId) {
        return this.systemService.getTwoMenus(firstMenuId);
    }


}
