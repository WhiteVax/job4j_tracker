package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) {
        if (!(password.length() > 8 && password.length() <= 32)) {
            throw new IllegalArgumentException(String.format("Wrong length password %d.", password.length()));
        }

        if (password.equals(password.toLowerCase()) || password.equals(password.toUpperCase())) {
            throw new IllegalArgumentException(String.format(
                    "Does not contain a top or bottom character %s.", password));
        }

        boolean isDigit = false;
        boolean isSpace = false;
        for (var ch: password.toCharArray()) {
            if (Character.isDigit(ch)) {
                isDigit = true;
            }
            if (!Character.isLetterOrDigit(ch)) {
                isSpace = true;
            }
        }

        if (!isDigit || !isSpace) {
            throw new IllegalArgumentException(String.format(
                    "Does not contain a number or symbol %s.", password));
        }

        if (password.toLowerCase().contains("qwerty")
                || password.toLowerCase().contains("password")
                || password.toLowerCase().contains("user")
                || password.toLowerCase().contains("admin")
                || password.contains("12345")) {
            throw new IllegalArgumentException(String.format("Password is simple %s.", password));
        }

        return password;
    }
}

