package com.pragma.powerup.usermicroservice.adapters.driving.http.mapper.req;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.req.UserReqDto;
import com.pragma.powerup.usermicroservice.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserReqMapper {
    User toUser(UserReqDto userReqDto);
}
