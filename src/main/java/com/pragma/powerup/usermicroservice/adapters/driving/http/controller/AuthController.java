package com.pragma.powerup.usermicroservice.adapters.driving.http.controller;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.req.LoginReqDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.res.JwtResDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IAuthHandler;
import com.pragma.powerup.usermicroservice.config.Constants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final IAuthHandler authHandler;

    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> login(@Valid @RequestBody LoginReqDto loginReqDto) {
        JwtResDto token = authHandler.login(loginReqDto);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token.getToken());
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY,"valid user"));
    }
}
