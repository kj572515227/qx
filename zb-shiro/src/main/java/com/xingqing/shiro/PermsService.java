package com.xingqing.shiro;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Component;

/**
 * js调用 thymeleaf 实现按钮权限
 * @version V1.0
 * @date 2018年7月11日
 * @author superzheng
 */
@Component("perms")
public class PermsService
{
    public boolean hasPerm(String permission)
    {
        return SecurityUtils.getSubject().isPermitted(permission);
    }
}
