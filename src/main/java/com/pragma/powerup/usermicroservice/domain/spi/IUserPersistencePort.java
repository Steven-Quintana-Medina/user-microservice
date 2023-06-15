package com.pragma.powerup.usermicroservice.domain.spi;

import com.pragma.powerup.usermicroservice.domain.model.User;

public interface IUserPersistencePort {
    void saveUser(User user);
    boolean getOwner(Long id, Long rol);
    boolean getEmployee(Long id, Long rol);
}
