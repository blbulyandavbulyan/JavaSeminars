package org.blbulyandavbulyan.jseminars.seminar3.homework;

import static org.blbulyandavbulyan.utils.Lists.generateRandomNumbers;
import static org.blbulyandavbulyan.jseminars.seminar3.homework.utils.Lists.removeEvenNumbers;
public class Task2 {
    public static void main(String[] args) {
        //Пусть дан произвольный список целых чисел, удалить из него четные числа
        var randomNumbers = generateRandomNumbers(10, 0, 100);
        System.out.println(randomNumbers);
        removeEvenNumbers(randomNumbers);
        System.out.println(randomNumbers);
    }
}
