package org.blbulyandavbulyan.jseminars.seminar5.homework.phonebook;

import java.util.*;
import java.util.stream.Stream;

/**
 * Данный класс предоставляет некоторое подобие телефонной книги
 * поддерживается несколько телефонов для одного человека
 */
public class PhoneBook {
    /**
     * Здесь будут храниться имена и телефоны
     * в качестве ключа - имя
     * в качестве значения - множество телефонов(на всякий случай, чтобы не было дублирующихся телефонов у одного человека
     */
    private final Map<String, Set<String>> data = new HashMap<>();

    /**
     * Добавляет людей в справочник
     * @param people коллекция людей
     */
    public void add(Collection<Person> people){
        people.forEach(this::add);
    }

    /**
     * Добавляет человека в справочник
     * @param person человек, которого нужно добавить
     */
    public void add(Person person){
        data.computeIfAbsent(person.name(), (k) -> new HashSet<>()).add(person.phone());
    }

    /**
     * Находит телефоны по имени
     * @param name имя, по которому нужно искать
     * @return найденные телефоны или пустую коллекцию, если их нет
     */
    public Collection<String> phonesByName(String name){
        return data.getOrDefault(name, Collections.emptySet());
    }

    /**
     * Получает все записи в телефонной книге
     * @return поток, содержащий все записи в телефонной книге
     * @see PhoneBookRecord
     */
    public Stream<PhoneBookRecord> getAllRecords(){
        //почему не entry set ? не хотелось завязывать внешний код, на то что тут какой-то entry set, тогда не совсем понятно что такое ключ, а что значение
        //а вот record - тут всё понятно, два поля, которые имеют понятные названия (а не какие-то key и value)
        //к тому же, благодаря такому подходу никто не сможет поменять данные в этом классе в обход него
        //стримом просто удобней это конвертировать, вроде как на этот раз даже не так уродливо
        return data.entrySet().stream().map((e)->new PhoneBookRecord(e.getKey(), e.getValue()));
    }
}
