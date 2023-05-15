package com.pragma.powerup.usermicroservice.domain.service;

import com.pragma.powerup.usermicroservice.domain.exceptions.InvalidDniException;
import com.pragma.powerup.usermicroservice.domain.exceptions.InvalidPhoneException;
import com.pragma.powerup.usermicroservice.domain.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.format.DateTimeParseException;

import static com.pragma.powerup.usermicroservice.domain.utils.UserConstansTest.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Test
    public void testValidPhoneWithInvalidPhoneNumber() {
        for (String invalidPhoneNumber : INVALID_PHONE_NUMBERS) {
            assertThrows(InvalidPhoneException.class, () -> UserService.ValidPHone(invalidPhoneNumber));
        }
    }


    @Test
    void ValidFormatBirthDateTest() {
        for (String invalidBirthDate : INVALID_BIRTH_DATES) {
            assertThrows(DateTimeParseException.class, () -> UserService.ValidAge(invalidBirthDate));
        }
    }

    @Test
    void ValidDni() {
        for (String invalidDninNumber: INVALID_DNI_NUMBERS){
            assertThrows(InvalidDniException.class,()->UserService.ValidDni(invalidDninNumber));
        }
    }
}
