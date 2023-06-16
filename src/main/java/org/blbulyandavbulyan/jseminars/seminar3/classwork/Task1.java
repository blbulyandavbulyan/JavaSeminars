package org.blbulyandavbulyan.jseminars.seminar3.classwork;

import java.util.List;

import static org.blbulyandavbulyan.utils.Lists.generateRandomNumbers;

// Заполнить список десятью случайными числами.
//📌 Отсортировать список методом sort() и вывести его на
//экран.
public class Task1 {
    public static void main(String[] args){
        List<Integer> integers = generateRandomNumbers(10, 0, 100);
        System.out.println(integers);
        integers.sort(Integer::compareTo);
        System.out.println(integers);
    }

}
