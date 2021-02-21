package com.org.hu.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil {

    private static final String CLAIM_KEY_USERNAME="sub";
    private static final String CLAIM_KEY_CREATED="created";
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expration}")
    private Long expiration;

    public String generateToken(UserDetails userDetails){
        Map<String,Object> claims=new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME,userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED,new Date());
        return generateToken(claims);
    }

    public String generateToken(Map<String,Object> claims){
        return Jwts.builder().setClaims(claims).setExpiration(generateExpirationDate()).signWith(SignatureAlgorithm.HS512,secret).compact();
    }

    /**
     * 生成TOken失效时间
     * @return
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis()+expiration*1000);
    }

    /**
     * 刷新token
     * @param token
     * @return
     */
    public String refreshToken(String token){
       Claims claims= getClaimsFromToken(token);
       claims.put(CLAIM_KEY_CREATED,new Date());
       return generateToken(claims);
    }

    public String getUserNameFromToken(String token){
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        }catch (Exception e){
            username=null;
        }
        return username;
    }

    private Claims getClaimsFromToken(String token) {
       Claims claims=null;
       try {
           claims=Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
       }catch (Exception e){
            e.printStackTrace();
       }
        return claims;
    }

    /**
     * 校验token 是否过期
     * @param token
     * @param userDetails
     * @return
     */
    public boolean validaetToken(String token,UserDetails userDetails){
        String username=getUserNameFromToken(token);
        return username.equals(userDetails.getUsername())&&!isTokenExprition(token);
    }

    private boolean isTokenExprition(String token) {
        Date date=getExpritionDateFromToken(token);
        return date.before(new Date());
    }

    private Date getExpritionDateFromToken(String token) {
       Claims claims= getClaimsFromToken(token);
       return claims.getExpiration();
    }

    /**
     * 判断token 是否可以刷新
     * @param token
     * @return
     */
    public boolean canRefresh(String token){
        return !isTokenExprition(token);
    }
}
