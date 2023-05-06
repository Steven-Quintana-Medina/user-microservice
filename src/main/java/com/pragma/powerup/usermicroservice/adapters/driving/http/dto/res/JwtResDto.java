package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.res;

public class JwtResDto {
    private String token;

    public JwtResDto() {
    }

    public JwtResDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
