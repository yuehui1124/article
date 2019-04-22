package com.wofeng.articlemanagement.controller;


import com.wofeng.articlemanagement.baseDao.BusinessMessage;
import com.wofeng.articlemanagement.securityConfig.CurrentUser;
import com.wofeng.articlemanagement.service.SysRoleService;
import com.wofeng.articlemanagement.service.impl.SysRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author yueyueyue
 * @since 2019-04-18
 */
@RestController
@RequestMapping("/articlemanagement/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleServiceImpl roleService;

    @GetMapping("/getRole")
    public BusinessMessage getRole (){
        return this.roleService.getRole();
    }

}

