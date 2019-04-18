package com.wofeng.articlemanagement;

import com.wofeng.articlemanagement.entity.SysUser;
import com.wofeng.articlemanagement.mapper.SysUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleManagementApplicationTests {
    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Test
    public void contextLoads() {
        List<SysUser> user = this.userMapper.selectAll();

        System.out.println(this.passwordEncoder.encode("123456"));

if (user.size()> 0) {
    System.out.println("chenggong");
}
    }

}
