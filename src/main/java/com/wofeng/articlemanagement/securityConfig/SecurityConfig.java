package com.wofeng.articlemanagement.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.SQLOutput;

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

    /**
     * 身份验证管理生成器
     * @param http
     * @throws Exception
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login","/login.html").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //指定登录页的路径
                .loginPage("/login")
                //指定自定义form表单请求的路径
                .loginProcessingUrl("/authentication/form")
                .failureUrl("/login?error")
                .defaultSuccessUrl("/success")
                //必须允许所有用户访问我们的登录页（例如未验证的用户，否则验证流程就会进入死循环）
                //这个formLogin().permitAll()方法允许所有用户基于表单登录访问/login这个page。
                .permitAll();
        //默认都会产生一个hiden标签 里面有安全相关的验证 防止请求伪造 这边我们暂时不需要 可禁用掉
        http .csrf().disable();

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
   /* @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()//配置权限
                    .antMatchers("/static/**").permitAll()
                    .anyRequest().authenticated()//任意请求需要登录
                    .and()
                .formLogin()//开启formLogin默认配置
                //请求时未登录跳转接口
                    .loginPage("/login")
                //用户密码错误跳转接口
                    .failureUrl("/login")
                    .permitAll()
                //登录成功跳转接口
                    .defaultSuccessUrl("/index",true)
                //post登录接口，登录验证由系统实现
                    .loginProcessingUrl("/login")
                //要认证的用户参数名，默认username
                    .usernameParameter("username")
                //要认证的密码参数名，默认password
                    .passwordParameter("password");

    }*/
}
