package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.domain.api.IUserServicePort;
import com.pragma.powerup.usermicroservice.domain.model.User;
import com.pragma.powerup.usermicroservice.domain.services.UserService;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;

public class UserUseCase implements IUserServicePort {

    private IUserPersistencePort userPersistencePort;
    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public void saveClient(User user) {
        UserService.ValidPHone(user.getPhone());
        userPersistencePort.saveUser(user);
    }

    @Override
    public void saveOwner(User user) {
        UserService.ValidAge(user.getBirthDate());
        UserService.ValidPHone(user.getPhone());
        userPersistencePort.saveUser(user);
    }
}
