package org.blbulyandavbulyan.jseminars.seminar5.classwork;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Task3 {
//    Взять набор строк, например,Мороз и солнце день чудесный Еще ты дремлешь друг прелестный Пора красавица проснись.
//    Написать метод, который отсортирует эти строки по длине с помощью TreeMap. Строки с одинаковой длиной не должны “потеряться”.
    public static TreeMap<Integer, String> sortByLength(List<String> strings){
        TreeMap<Integer, String> result = new TreeMap<>();
        strings.forEach(s-> result.put(s.length(), s));
        return result;
    }

    public static void main(String[] args) {
        String sentence = "Мороз и солнце день чудесный Еще ты дремлешь друг прелестный Пора красавица проснись";
        var result = sortByLength(Arrays.stream(sentence.split(" ")).toList());
        System.out.println(result);
    }
}
