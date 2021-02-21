package com.org.hu.config.security;

import com.org.hu.pojo.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthencationFilter extends OncePerRequestFilter {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
       String authHeader= request.getHeader(tokenHeader);
       //存在token
       if(null!=authHeader&&authHeader.startsWith(tokenHead)){
           String authToken= authHeader.substring(tokenHead.length());
           String username=jwtTokenUtil.getUserNameFromToken(authToken);
           //存在用户名，但是未登录
           if(null!=username&&null== SecurityContextHolder.getContext().getAuthentication()){
            //登录
              UserDetails userDetails= userDetailsService.loadUserByUsername(username);
              //校验token是否有效,重新设置用户对象
              if(jwtTokenUtil.validaetToken(authToken,userDetails)){
                  UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                  usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                  SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
              }
           }
       }

        filterChain.doFilter(request,response);
    }
}
