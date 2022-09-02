package ru.job4j.early;

import java.util.regex.Pattern;

public class PasswordValidator {

    public static String validate(String password) {
        if (!(password.length() > 8 && password.length() <= 32)) {
            throw new IllegalArgumentException(String.format("Wrong length password %d.", password.length()));
        }

        if (!password.matches("(.*[a-z].*)(.*[A-Z].*)")) {
            throw new IllegalArgumentException(String.format(
                    "Does not contain a top or bottom character %s.", password));
        }

        if (!password.matches("(.*\\W.*)(.*\\d.*)")) {
            throw new IllegalArgumentException(String.format(
                    "Does not contain a number or symbol %s.", password));
        }

        if (Pattern.compile(Pattern.quote("qwerty"), Pattern.CASE_INSENSITIVE).matcher(password).find()
                || Pattern.compile(Pattern.quote("password"), Pattern.CASE_INSENSITIVE).matcher(password).find()
                || Pattern.compile(Pattern.quote("user"), Pattern.CASE_INSENSITIVE).matcher(password).find()
                || Pattern.compile(Pattern.quote("admin"), Pattern.CASE_INSENSITIVE).matcher(password).find()
                || password.contains("12345")) {
            throw new IllegalArgumentException(String.format("Password is simple %s.", password));
        }

        return password;
    }
}

