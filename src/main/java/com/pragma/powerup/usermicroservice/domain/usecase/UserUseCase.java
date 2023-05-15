package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.domain.api.IUserServicePort;
import com.pragma.powerup.usermicroservice.domain.model.User;
import com.pragma.powerup.usermicroservice.domain.services.UserService;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;

import static com.pragma.powerup.usermicroservice.domain.utils.Constants.CLIENT_ROLE_ID;
import static com.pragma.powerup.usermicroservice.domain.utils.Constants.OWNER_ROLE_ID;

public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;
    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public void saveClient(User user) {
        UserService.ValidPHone(user.getPhone());
        user.setIdRol(CLIENT_ROLE_ID);
        userPersistencePort.saveUser(user);
    }

    @Override
    public void saveOwner(User user) {
        UserService.ValidDni(user.getDniNumber());
        UserService.ValidAge(user.getBirthDate());
        UserService.ValidPHone(user.getPhone());
        user.setIdRol(OWNER_ROLE_ID);
        userPersistencePort.saveUser(user);
    }

    @Override
    public boolean getUserOwner(Long id) {
        return userPersistencePort.getUser(id,OWNER_ROLE_ID);
    }
}
