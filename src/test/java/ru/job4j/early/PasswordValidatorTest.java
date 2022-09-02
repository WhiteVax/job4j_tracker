package ru.job4j.early;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class PasswordValidatorTest {

    @Test
    void checkWrongLength() {
        var string = "";
        assertThatThrownBy(() -> PasswordValidator.validate(string))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkWrongLengthToLargeLength() {
        var string = "djvdfeqdDDhmgdrtuiolmbfe45679-832#";
        assertThatThrownBy(() -> PasswordValidator.validate(string))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll(String.format("Wrong length password %d.", string.length()));
    }

    @Test
    void checkWithoutBottom() {
        var string = "SADSAVSADAWDASD45679-832#";
        assertThatThrownBy(() -> PasswordValidator.validate(string))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll(String.format("Does not contain a top or bottom character %s.", string));
    }

    @Test
    void checkWithoutUp() {
        var string = "ssdfvcbdfgseg45679-832#";
        assertThatThrownBy(() -> PasswordValidator.validate(string))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll(String.format("Does not contain a top or bottom character %s.", string));
    }

    @Test
    void checkWithoutNumber() {
        var string = "ssdfvcbDdfgseg#";
        assertThatThrownBy(() -> PasswordValidator.validate(string))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll(String.format("Does not contain a number or symbol %s.", string));
    }

    @Test
    void checkWithoutSymbol() {
        var string = "ssdfvcbDdfgseg1235";
        assertThatThrownBy(() -> PasswordValidator.validate(string))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll(String.format("Does not contain a number or symbol %s.", string));
    }

    @Test
    void checkOnSimpleWords() {
        var number = "ssdfvcb%Ddfgseg12345";
        assertThatThrownBy(() -> PasswordValidator.validate(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll(String.format("Password is simple %s.", number));

        var user = "ssdfUsErvcb%Ddfgseg23%";
        assertThatThrownBy(() -> PasswordValidator.validate(user))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll(String.format("Password is simple %s.", user));

        var password = "ssdfPasSWOrdrvcb%Ddfgseg23%";
        assertThatThrownBy(() -> PasswordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll(String.format("Password is simple %s.", password));

        var qwerty = "ssdfQwErTyrvcb%Ddfgseg23%";
        assertThatThrownBy(() -> PasswordValidator.validate(qwerty))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll(String.format("Password is simple %s.", qwerty));
    }
}
