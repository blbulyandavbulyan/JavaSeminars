package org.blbulyandavbulyan.jseminars.seminar5.homework.phonebook;

/**
 * Данная запись предоставляет человека, у которого есть номер телефона
 * @param name имя человека
 * @param phone номер телефона
 */
public record Person(String name, String phone){
    @Override
    public String toString() {
        return name + " " + phone;
    }
}
