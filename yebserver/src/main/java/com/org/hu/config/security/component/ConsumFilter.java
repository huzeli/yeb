package com.org.hu.config.security.component;

import com.org.hu.pojo.Menu;
import com.org.hu.pojo.Role;
import com.org.hu.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 权限控制
 *
 */
@Component
public class ConsumFilter implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private IMenuService menuService;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object obj) throws IllegalArgumentException {
        //获取请求的URL
        String requestUrl=((FilterInvocation)obj).getRequestUrl();
        AntPathMatcher matcher=new AntPathMatcher();
        List<Menu> menus=menuService.getMenusWithRole();
        for(Menu menu:menus){
            if(matcher.match(menu.getUrl(),requestUrl)){
                String[] str=menu.getRoles().stream().map(Role::getName).toArray(String[]::new);
                return SecurityConfig.createList(str);
            }
        }

        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
