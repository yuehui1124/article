
package com.wofeng.articlemanagement.securityConfig;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


/**
 * @author yueyueyue
 * @date 2019/4/15 13:21
 * Description: article-management
 */

public interface UserDetailsService {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}

