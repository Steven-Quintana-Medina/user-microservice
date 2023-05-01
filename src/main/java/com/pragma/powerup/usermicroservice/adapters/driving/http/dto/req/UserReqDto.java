package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserReqDto {
    private Long id;
    private String name;
    private String surname;
    private String dniNumber;
    private String phone;
    private String birthDate;
    private String mail;
    private String password;
    private String idRol;
}
