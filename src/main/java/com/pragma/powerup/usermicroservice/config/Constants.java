package com.pragma.powerup.usermicroservice.config;

public class Constants {

    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    //response key
    public static final String RESPONSE_MESSAGE_KEY = "message";
    public static final String RESPONSE_ERROR_MESSAGE_KEY = "error";

    //response code 200
    public static final String PERSON_CREATED_MESSAGE = "User created successfully";

    //response code 400
    public static final String WRONG_CREDENTIALS_MESSAGE = "Wrong credentials";
    public static final String DNI_ALREADY_EXISTS_MESSAGE = "A user already exists with this dni";
    public static final String MAIL_ALREADY_EXISTS_MESSAGE = "A person with that mail already exists";
    public static final String INVALID_PHONE = "A person has an invalid phone number";
    public static final String INVALID_DNI = "A person has an invalid dni";
    public static final String UNDER_AGE = "A person is a minor";
}
