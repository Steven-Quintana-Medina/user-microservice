package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.domain.model.User;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.pragma.powerup.usermicroservice.domain.utils.UserConstansTest.*;
import static com.pragma.powerup.usermicroservice.domain.utils.Constants.OWNER_ROLE_ID;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserUseCaseTest {

    @Mock
    private IUserPersistencePort userPersistencePort;

    @Mock
    private User userMock;

    @Mock
    private UserUseCase userUseCaseMock;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        userUseCaseMock = new UserUseCase(userPersistencePort);
    }

    @Test
    public void testSaveClient() {
        when(userMock.getPhone()).thenReturn(VALID_PHONE_NUMBER);
        userUseCaseMock.saveClient(userMock);
        verify(userPersistencePort).saveUser(userMock);
    }

    @Test
    public void testSaveOwner() {
        when(userMock.getPhone()).thenReturn(VALID_PHONE_NUMBER);
        when(userMock.getBirthDate()).thenReturn(VALID_BIRTH_DATE);
        when(userMock.getDniNumber()).thenReturn(VALID_DNI_NUMBER);

        userUseCaseMock.saveOwner(userMock);

        verify(userPersistencePort).saveUser(userMock);
    }

    @Test
    public void testGetUserOwner() {
        when(userPersistencePort.getUser(VALID_USER_OWNER, OWNER_ROLE_ID)).thenReturn(true);
        when(userPersistencePort.getUser(VALID_USER_CLIENT, OWNER_ROLE_ID)).thenReturn(false);

        Assertions.assertFalse(userUseCaseMock.getUserOwner(VALID_USER_CLIENT));
        Assertions.assertTrue(userUseCaseMock.getUserOwner(VALID_USER_OWNER));
    }

}