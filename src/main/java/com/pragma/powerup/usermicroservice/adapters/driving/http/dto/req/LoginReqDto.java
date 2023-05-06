package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.req;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class LoginReqDto {
    @NotBlank
    private String mail;
    @NotBlank
    private String password;
}
