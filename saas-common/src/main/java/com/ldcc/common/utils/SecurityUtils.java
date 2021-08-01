package com.ldcc.common.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author ：wwg
 * @description ：安全服务工具类
 * @date ：2021/8/1 23:41
 */
public class SecurityUtils {

    /**
     * 获取Authentication
     */
    public static Authentication getAuthentication()
    {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
