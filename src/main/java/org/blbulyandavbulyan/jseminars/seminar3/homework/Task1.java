package org.blbulyandavbulyan.jseminars.seminar3.homework;

import java.util.List;

import static org.blbulyandavbulyan.jseminars.seminar3.homework.utils.Lists.mergeSort;
import static org.blbulyandavbulyan.utils.Lists.generateRandomNumbers;

//1. Реализовать алгоритм сортировки слиянием(метод взять из Интернета)
//P.S. Метод взят не с интернета, имеется моя импровизация, но я постарался и написал комментарии
public class Task1 {
    public static void main(String[] args) {
        List<Integer> randomList = generateRandomNumbers(100, 0, 1000);
        System.out.println(randomList);
        System.out.println(mergeSort(randomList));
    }
}
