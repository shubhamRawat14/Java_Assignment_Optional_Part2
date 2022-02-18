package com.knoldus.KUP;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.assertj.core.api.Assertions.assertThat;

public class PhoneBookCrawlertests {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private final PhoneBookCrawler phoneBookCrawler = new PhoneBookCrawler(new PhoneBook());

    @Test
    public void findPhoneNUmberByNameAndPunishIfNothingFound () {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("No Name or Number found");
        phoneBookCrawler.findPhoneNumberByNameAndPunishIfNothingFound("Shubham");
    }
    @Test
    public void findPhoneByNameAndPrintPhoneBookIfNothingFound() {

        String actualBook = phoneBookCrawler.findPhoneByNameAndPrintPhoneBookIfNothingFound("Shubham");
        assertThat(actualBook).isEqualTo("{Fire Station=101, Ambulance=102, Disaster Management=108, Police=100}");
    }
    @Test
    public void findNumberByNameOrNameByPhoneNumber_CorrectIfFoundByName() {
        String actualNumber = phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("Ambulance", "123123");
        assertThat(actualNumber).isEqualTo("102");
    }

    @Test
    public void findNumberByName_CorrectIfFound(){
        String actualNumber = phoneBookCrawler.findPhoneByNameAndPrintPhoneBookIfNothingFound("Disaster Management");
        assertThat(actualNumber).isEqualTo("108");
    }

    @Test
    public void findNumberByNameOrNameByNumber_CorrectIfFoundByNumber () {
        String name = phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("Post Office", "102");
        assertThat(name).isEqualTo("Ambulance");
    }
}
