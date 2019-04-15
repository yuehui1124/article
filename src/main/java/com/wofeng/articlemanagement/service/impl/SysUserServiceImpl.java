package com.wofeng.articlemanagement.service.impl;

import com.wofeng.articlemanagement.entity.SysUser;
import com.wofeng.articlemanagement.mapper.SysUserMapper;
import com.wofeng.articlemanagement.service.SysUserService;
import com.wofeng.articlemanagement.baseDao.MyServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author yueyueyue
 * @since 2019-04-15
 */
@Service
public class SysUserServiceImpl extends MyServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}
