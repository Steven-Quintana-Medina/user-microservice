package com.pragma.powerup.usermicroservice.config;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.*;
import com.pragma.powerup.usermicroservice.domain.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.util.Collections;
import java.util.Map;

import static com.pragma.powerup.usermicroservice.config.Constants.DNI_ALREADY_EXISTS_MESSAGE;
import static com.pragma.powerup.usermicroservice.config.Constants.MAIL_ALREADY_EXISTS_MESSAGE;
import static com.pragma.powerup.usermicroservice.config.Constants.RESPONSE_ERROR_MESSAGE_KEY;
import static com.pragma.powerup.usermicroservice.config.Constants.UNDER_AGE;
import static com.pragma.powerup.usermicroservice.config.Constants.INVALID_PHONE;


@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(MailAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleMailAlreadyExistsException(
            MailAlreadyExistsException mailAlreadyExistsException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, MAIL_ALREADY_EXISTS_MESSAGE));
    }

    @ExceptionHandler(DniNumberAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> dniNumberAlreadyExistsException(
            DniNumberAlreadyExistsException dniNumberAlreadyExistsException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, DNI_ALREADY_EXISTS_MESSAGE));
    }

    @ExceptionHandler(UnderAgeException.class)
    public ResponseEntity<Map<String, String>> handleUnderAgeException(
            UnderAgeException underAgeException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, UNDER_AGE));
    }


    @ExceptionHandler(InvalidPhoneException.class)
    public ResponseEntity<Map<String, String>> handleInvalidPhoneException(
            InvalidPhoneException invalidPhoneException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, INVALID_PHONE));
    }
}
