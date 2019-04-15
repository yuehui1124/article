package com.wofeng.articlemanagement.service.impl;

import com.wofeng.articlemanagement.entity.TestStudent;
import com.wofeng.articlemanagement.mapper.TestStudentMapper;
import com.wofeng.articlemanagement.service.TestStudentService;
import com.wofeng.articlemanagement.baseDao.MyServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 测试学生表 服务实现类
 * </p>
 *
 * @author yueyueyue
 * @since 2019-04-15
 */
@Service
public class TestStudentServiceImpl extends MyServiceImpl<TestStudentMapper, TestStudent> implements TestStudentService {

}
