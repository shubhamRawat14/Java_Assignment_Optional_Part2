package com.knoldus.KUP;
import java.util.Optional;
import java.util.stream.Stream;
public class PhoneBookCrawler {
    private PhoneBook phoneBook;

    public PhoneBookCrawler (PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
        System.out.println(phoneBook);
    }

    public String findPhoneNumberByNameAndPunishIfNothingFound(String name) {
        return phoneBook.findPhoneByName(name).orElseThrow(() -> new IllegalArgumentException("No Name or Number found"));
    }

    public String findPhoneByNameAndPrintPhoneBookIfNothingFound (String name) {
        return phoneBook.findPhoneByName(name).orElse(phoneBook.toString());
    }
    public Optional <String> findNumberByName (String name) {
        return Stream.of(phoneBook).map(phoneBook1 -> Optional.ofNullable(phoneBook1.getPhoneMap()
                .get(name))).findFirst().orElse(Optional.empty());
    }
    public String findPhoneNumberByNameAndPRintPhonebookIfNothingFoundByStreams(String name) {
        return Stream.of(phoneBook).map(phoneBook1 -> Optional.ofNullable(phoneBook1.getPhoneMap()
                        .get(name)).orElse(phoneBook1.toString()))
                .findFirst().get();
    }

    public String findPhoneNumberByNameOrNameByPhoneNumber (String name, String phoneNumber) {
        return Stream.of(phoneBook.findNumberByName(name),
                        phoneBook.findNameByNumber(phoneNumber)).
                filter(Optional :: isPresent).map(Optional :: get).findFirst().get();
    }

}
