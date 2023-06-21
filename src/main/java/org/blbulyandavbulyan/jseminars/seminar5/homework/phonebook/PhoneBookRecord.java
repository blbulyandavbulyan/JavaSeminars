package org.blbulyandavbulyan.jseminars.seminar5.homework.phonebook;

import java.util.Collection;

/**
 * Данный класс предоставляет запись в телефонной книге
 * @param name имя человека
 * @param phones его телефоны
 */
public record PhoneBookRecord(String name, Collection<String> phones) {
    @Override
    public String toString() {
        return name + " " + phones;
    }
}
