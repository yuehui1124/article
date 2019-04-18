package com.wofeng.articlemanagement.securityConfig;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.lang.annotation.*;

/**
 * @author yueyueyue
 * @date 2019/4/17 18:28
 * Description: article-management 当前登录用户
 */

@Target({ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@AuthenticationPrincipal
public @interface CurrentUser {
}
