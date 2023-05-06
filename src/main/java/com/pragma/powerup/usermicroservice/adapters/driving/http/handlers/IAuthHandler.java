package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.req.LoginReqDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.res.JwtResDto;

public interface IAuthHandler {
    JwtResDto login(LoginReqDto loginReqtDto);

}
