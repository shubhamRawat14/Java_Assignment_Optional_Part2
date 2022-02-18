package com.knoldus.KUP;

import java.util.Optional;
import java.util.HashMap;
import java.util.Map;
public class PhoneBook {
     static Map <String,String> contact= new HashMap<>();
    PhoneBook(){
        contact.put("Police","100");
        contact.put("Fire Station","101");
        contact.put("Ambulance","102");
        contact.put("Disaster Management","108");
    }
    public Optional<String> findPhoneByName(String name){
        if (contact.containsKey(name)) {
            return Optional.of(contact.get(name));
        }
        return Optional.empty();
    }
    @Override
    public String toString() {
        return ""+contact;
    }
    public Map<String, String> getPhoneMap() {
        return contact;
    }

    public void setPhoneMap(Map<String, String> phoneMap) {
        this.contact = phoneMap;
    }

    public Optional <String> findNumberByName (String name) {
        if (contact.containsKey(name)) {
            return Optional.of(contact.get(name));
        }
        return Optional.empty();
    }

    public Optional <String> findNameByNumber (String phoneNumber) {
        for (Map.Entry<String, String> entry : contact.entrySet()) {
            if (entry.getValue() == phoneNumber) {
                return Optional.of(entry.getKey());
            }
        }
        return Optional.empty();
    }

}
