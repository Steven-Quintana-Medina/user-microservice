package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class LoginReqDto {
    @Schema(title = "email", description = "email of a person", example = "Juan@gmail.com")
    @NotBlank
    private String mail;

    @Schema(title = "password", description = "password of a person", example = "admin")
    @NotBlank
    private String password;
}
