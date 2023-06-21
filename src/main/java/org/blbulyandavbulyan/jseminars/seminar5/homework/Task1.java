package org.blbulyandavbulyan.jseminars.seminar5.homework;

import org.blbulyandavbulyan.jseminars.seminar5.homework.phonebook.Person;
import org.blbulyandavbulyan.jseminars.seminar5.homework.phonebook.PhoneBook;

import java.util.Comparator;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        fillPhoneBook(phoneBook);
        printPhoneBook(phoneBook);
    }
    //метод заполняющий телефонную книгу значениями
    public static void fillPhoneBook(PhoneBook pb){
        List<Person> people = List.of(new Person("Иван", "42323335"), new Person("Иван", "434535345"), new Person("Анатолий", "32435323"));
        pb.add(people);
    }

    /**
     * Печатает телефонную книгу, отсортированную в порядке количества телефонов у каждого человека
     * @param pb телефонная книга для распечатки
     */
    public static void printPhoneBook(PhoneBook pb){
        pb.getAllRecords().sorted(Comparator.comparingInt(v->v.phones().size())).forEach(System.out::println);
    }
}
