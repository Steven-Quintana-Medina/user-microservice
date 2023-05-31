package com.pragma.powerup.usermicroservice.domain.utils;

import com.pragma.powerup.usermicroservice.domain.model.User;

public class UserConstansTest {
    public static final String VALID_PHONE_NUMBER = "+573004014079";
    public static final String[] INVALID_PHONE_NUMBERS = {"1234567", "+57300A014079", "+57300401407", "573004014079"};
    public static final String VALID_BIRTH_DATE = "03-05-2005";
    public static final String[] INVALID_BIRTH_DATES = {"03/05/2005", "SS-DD-2005", "08-25-2005"};
    public static final String VALID_DNI_NUMBER = "100074634";
    public static final String[] INVALID_DNI_NUMBERS = {"1000D74634", "dsdsdsad"};
    public static final Long VALID_USER_OWNER = 7L;
    public static final Long VALID_USER_CLIENT = 20L;
    public static final User USER = new User(
            1L,
            "Juan",
            "Pérez",
            "12345678",
            "+573004015479",
            "01-01-2000",
            "juan.perez@example.com",
            "115315",
            4L);
}
