package org.blbulyandavbulyan.jseminars.seminar3.homework;

import org.blbulyandavbulyan.jseminars.seminar3.homework.utils.MinMaxAverage;

import java.util.List;

import static org.blbulyandavbulyan.utils.Lists.generateRandomNumbers;
import static org.blbulyandavbulyan.jseminars.seminar3.homework.utils.Lists.findMinMaxAndAverage;
public class Task3 {
    public static void main(String[] args) {
        //Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
        List<Integer> randomNumbers = generateRandomNumbers(10, 0, 100);
        System.out.println(randomNumbers);
        MinMaxAverage minMaxAverage = findMinMaxAndAverage(randomNumbers);
        System.out.printf("Минимум: %d\nМаксимум: %d\nСреднее: %.1f\n", minMaxAverage.getMin(), minMaxAverage.getMax(), minMaxAverage.getAverage());
    }
}
