package com.pragma.powerup.usermicroservice.domain.services;

import com.pragma.powerup.usermicroservice.domain.exceptions.InvalidPhoneException;
import com.pragma.powerup.usermicroservice.domain.exceptions.UnderAgeException;
import com.pragma.powerup.usermicroservice.domain.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Service
public class UserService {
    public static void ValidPHone(String phone) {
        String regexPhone = "^\\+.{12}$";
        if (!phone.matches(regexPhone)) {
            throw new InvalidPhoneException();
        }
    }

    public static void ValidAge(String age) {
        if (isMinor(age)){
            throw new UnderAgeException();
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
