package com.wofeng.articlemanagement.service.impl;

import com.wofeng.articlemanagement.baseDao.BusinessMessage;
import com.wofeng.articlemanagement.entity.SysRole;
import com.wofeng.articlemanagement.mapper.SysRoleMapper;
import com.wofeng.articlemanagement.service.SysRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author yueyueyue
 * @since 2019-04-17
 */
@Slf4j
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper roleMapper ;

    public BusinessMessage getRole(){
        BusinessMessage businessMessage  =new BusinessMessage();
       try {
          businessMessage.setData(this.roleMapper.selectAll());
          businessMessage.setSuccess(true);
       }catch (Exception e) {
           log.error("查询角色失败");
           businessMessage.setSuccess(false);
       }
       return businessMessage;
    }



}
