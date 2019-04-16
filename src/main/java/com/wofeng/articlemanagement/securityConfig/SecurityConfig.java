package com.wofeng.articlemanagement.securityConfig;

import com.wofeng.articlemanagement.securityConfig.handler.MyAuthenticationFailureHandler;
import com.wofeng.articlemanagement.securityConfig.handler.MyAuthenticationSucessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author yueyueyue
 * @date 2019/4/15 11:24
 * Description: article-management
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    /**
     * HTTP请求安全处理
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    @Autowired
    private MyAuthenticationSucessHandler authenticationSucessHandler;
    @Autowired
    private MyAuthenticationFailureHandler authenticationFailureHandler;

    /**
     * 身份验证管理生成器
     * @param http
     * @throws Exception
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin() // 表单登录
                // http.httpBasic() // HTTP Basic
                // 登录跳转 URL
                    .loginPage("/authentication/require")
                // 处理表单登录 URL
                    .loginProcessingUrl("/login")
                // 处理登录成功
                    .successHandler(authenticationSucessHandler)
                // 处理登录失败
                    .failureHandler(authenticationFailureHandler)
                    .and()
                // 授权配置
                .authorizeRequests()
                // 登录跳转 URL 无需认证
                    .antMatchers("/authentication/require", "/login.html","/static/**").permitAll()
                    .anyRequest()  // 所有请求
                    .authenticated() // 都需要认证
                    .and().csrf().disable();
    }


    /**
     * WEB安全
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

}
