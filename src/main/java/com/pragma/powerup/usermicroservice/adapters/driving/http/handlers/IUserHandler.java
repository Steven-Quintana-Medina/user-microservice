package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.req.UserReqDto;
public interface IUserHandler {
    void saveClient(UserReqDto userReqDto);

    void saveOwner(UserReqDto userReqDto);

    boolean getUserOwner(Long id);
}
