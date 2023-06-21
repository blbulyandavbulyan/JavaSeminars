package org.blbulyandavbulyan.jseminars.seminar5.classwork;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Task1 {
    //Создать структуру для хранения Номеров паспортов и Фамилий сотрудников организации.
    //123456 Иванов
    //321456 Васильев
    //234561 Петрова
    //234432 Иванов
    //654321 Петрова
    //345678 Иванов
    //Вывести данные по сотрудникам с фамилией Иванов.
    public static Map<Integer, String> generateData(){
        HashMap<Integer, String> result = new HashMap<>();
        result.put(123456, "Иванов");
        result.put(321456, "Васильев");
        result.put(234561, "Петрова");
        result.put(234432, "Иванов");
        result.put(654321, "Петрова");
        result.put(345678, "Иванов");
        return result;
    }
    public static Collection<Map.Entry<Integer, String>> search(Map<Integer, String> data, String searchValue){
        Collection<Map.Entry<Integer, String>> result = new ArrayList<>();
        for(var entry : data.entrySet()){
            if(entry.getValue().equals(searchValue))
                result.add(entry);
        }
        return result;
    }

    public static void main(String[] args) {
        Map<Integer, String> data = generateData();
        System.out.println(data);
        var entries = search(data, "Иванов");
        for (var entry : entries) {
            System.out.printf("Найден %s с номером %d\n", entry.getValue(), entry.getKey());
        }
    }
}
