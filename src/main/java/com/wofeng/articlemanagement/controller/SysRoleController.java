package com.wofeng.articlemanagement.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author yueyueyue
 * @since 2019-04-15
 */
@Controller
@RequestMapping("/articlemanagement/sysRole")
public class SysRoleController {

    @RequestMapping("test")
    public String tttt(){
        return "success";
    }

}

