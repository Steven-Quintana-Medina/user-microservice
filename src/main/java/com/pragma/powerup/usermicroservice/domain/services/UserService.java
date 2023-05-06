package com.pragma.powerup.usermicroservice.domain.services;

import com.pragma.powerup.usermicroservice.domain.exceptions.InvalidDniException;
import com.pragma.powerup.usermicroservice.domain.exceptions.InvalidPhoneException;
import com.pragma.powerup.usermicroservice.domain.exceptions.UnderAgeException;
import com.pragma.powerup.usermicroservice.domain.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import static com.pragma.powerup.smallsquaremicroservice.domain.utils.Constants.REGEX_NUM_VALUES;
import static com.pragma.powerup.smallsquaremicroservice.domain.utils.Constants.REGEX_VALID_PHONE;

@Service
public class UserService {
    public static void ValidPHone(String phone) {
        if (!phone.matches(REGEX_VALID_PHONE)) {
            throw new InvalidPhoneException();
        }
    }

    public static void ValidAge(String age) {
        if (isMinor(age)){
            throw new UnderAgeException();
        }
    }

    public static void ValidDni(String nit) {
        if (!nit.matches(REGEX_NUM_VALUES)) {
            throw new InvalidDniException();
        }
    }

    private static boolean isMinor(String dateString) {
        LocalDate birthDate = parseDate(dateString);
        LocalDate now = LocalDate.now();
        Period age = Period.between(birthDate, now);
        return age.getYears() < 18;
    }

    private static LocalDate parseDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(dateString, formatter);
    }
}
