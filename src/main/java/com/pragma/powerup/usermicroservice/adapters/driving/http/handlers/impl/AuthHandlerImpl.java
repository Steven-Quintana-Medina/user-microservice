package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter.UserDetailsServiceImpl;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.req.LoginReqDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.res.JwtResDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IAuthHandler;
import com.pragma.powerup.usermicroservice.config.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
@RequiredArgsConstructor
public class AuthHandlerImpl implements IAuthHandler {

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    JwtProvider jwtProvider;

    @Override
    public JwtResDto login(LoginReqDto loginReqDto) {
        UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(loginReqDto.getMail());
        String jwt = jwtProvider.generateToken(userDetails);
        return new JwtResDto(jwt);
    }
}
