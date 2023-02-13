package com.excercise.customerservice.utils;

import lombok.experimental.UtilityClass;
import org.springframework.security.crypto.bcrypt.BCrypt;

@UtilityClass
public class PasswordUtils {

    private static final String KEY_HASHING = "TN";

    public static String encryptPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean decryptPassword(String password, String hashed) {
        return BCrypt.checkpw(password, hashed);
    }
}

