package com.pragma.powerup.usermicroservice.config.security.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtProvider {
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    private final Key secretKey;
    @Value("${jwt.expiration}")
    private int expiration;

    public JwtProvider(@Value("${jwt.secret}") String key) {
        this.secretKey = Keys.hmacShaKeyFor(key.getBytes());
    }


    public String generateToken(UserDetails userDetails) {
        String rol = userDetails.getAuthorities().toString();
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .claim("rol", rol)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 180L))
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validate(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public String getUserNameFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody().getSubject();
    }
}
