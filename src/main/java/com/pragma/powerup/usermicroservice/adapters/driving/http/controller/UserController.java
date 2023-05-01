package com.pragma.powerup.usermicroservice.adapters.driving.http.controller;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.req.UserReqDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IUserHandler;
import com.pragma.powerup.usermicroservice.config.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/create-user/")
@RequiredArgsConstructor
public class UserController {
    private final IUserHandler userHandler;

    @PostMapping("client/")
    public ResponseEntity<Map<String, String>> saveClient(@RequestBody UserReqDto userReqDto) {
        userHandler.saveClient(userReqDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.PERSON_CREATED_MESSAGE));
    }

    @PostMapping("owner/")
    public ResponseEntity<Map<String, String>> saveOwmer(@RequestBody UserReqDto userReqDto) {
        userHandler.saveOwner(userReqDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.PERSON_CREATED_MESSAGE));
    }


}
