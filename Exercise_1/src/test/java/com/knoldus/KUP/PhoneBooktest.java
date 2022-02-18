package com.knoldus.KUP;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.util.NoSuchElementException;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

public class PhoneBooktest {
    @Rule
    public ExpectedException exp = ExpectedException.none();
    private final PhoneBook phoneBook = new PhoneBook();

    @Test
    public void findNumberByName_CorrectIfFound() {
        Optional <String> phoneNumber = phoneBook.findPhoneByName("Police");
        assertThat(phoneNumber.get()).isEqualTo("100");
    }
    @Test
    public void findPhoneNumberByName_CorrectIfNotFound () {
        exp.expect(NoSuchElementException.class);
        Optional <String> phoneNumber = phoneBook.findNumberByName("Pooja");
        phoneNumber.get();
    }

    @Test
    public void findNameByPhoneNumber_CorrectIfFound () {
        Optional <String> name = phoneBook.findNameByNumber("100");
        assertThat(name.get()).isEqualTo("Police");
    }

    @Test
    public void findNameByPhoneNumber_CorrectIfNotFound () {
        exp.expect(NoSuchElementException.class);
        Optional <String> phoneNumber = phoneBook.findNameByNumber("131231");
        phoneNumber.get();
    }


}
