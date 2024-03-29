package ru.job4j.early;

import ru.job4j.ex.ElementNotFoundException;

import static java.lang.Character.*;

public class PasswordValidator {

    public static String validate(String password) throws IllegalArgumentException {
        String[] invalidValue = {"qwerty", "12345", "password", "admin", "user"};
        boolean digit = false;
        boolean lowerCase = false;
        boolean upperCase = false;
        boolean isNotletterOrDigit = false;
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (8 > password.length() || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (!isLetterOrDigit(c)) {
                isNotletterOrDigit = true;
            }
            if (isDigit(c)) {
                digit = true;
            }
            if (isUpperCase(c)) {
                upperCase = true;
            }
            if (isLowerCase(c)) {
                lowerCase = true;
            }
            if (isNotletterOrDigit && digit && upperCase && lowerCase) {
                break;
            }
        }
        if (!upperCase) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!lowerCase) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!digit) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!isNotletterOrDigit) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        for (int i = 0; i < invalidValue.length; i++) {
            if (password.toLowerCase().contains(invalidValue[i])) {
                throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
            }
        }
        return password;
    }
}
