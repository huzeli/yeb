package com.org.hu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.org.hu.config.security.component.JwtTokenUtil;
import com.org.hu.mapper.AdminMapper;
import com.org.hu.mapper.MenuMapper;
import com.org.hu.mapper.RoleMapper;
import com.org.hu.pojo.Admin;
import com.org.hu.pojo.RespBean;
import com.org.hu.pojo.Role;
import com.org.hu.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-02-20
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 登录成功返回token
     * @param username
     * @param password
     * @param code
     * @param request
     * @return
     */
    @Override
    public RespBean login(String username, String password, String code, HttpServletRequest request) {
      String captcha= (String) request.getSession().getAttribute("captcha");

      if(StringUtils.isEmpty(code)||!captcha.equalsIgnoreCase(code)){
          return RespBean.error("验证码输入错误，请重新输入！");
      }
        //登录
       UserDetails userDetails= userDetailsService.loadUserByUsername(username);
       if(userDetails==null||!passwordEncoder.matches(password,userDetails.getPassword())){
           return RespBean.error("用户名或密码错误");
       }
       if(!userDetails.isEnabled()){
           return RespBean.error("用户被禁用,请联系管理员s");
       }
       //更新登录用户对象
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
       //生成token
       String token=jwtTokenUtil.generateToken(userDetails);
       Map<String,Object> tokenMap=new HashMap<>();
       tokenMap.put("token",token);
       tokenMap.put("tokenHead",tokenHead);
       return RespBean.success("登录成功",tokenMap);
    }

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    @Override
    public Admin getAdminInfo(String username) {
        return adminMapper.selectOne(new QueryWrapper<Admin>().eq("username",username).eq("enabled",true));
    }

    @Override
    public List<Role> getRoles(Integer adminId) {
        return roleMapper.getRoles(adminId);
    }
}
