package org.blbulyandavbulyan.jseminars.seminar1.homework.tasks;

import org.blbulyandavbulyan.jseminars.seminar1.homework.Numbers;

import java.util.Collection;

//2) Вывести все простые числа от 1 до 1000
public class Task2 {
    public static void main(String[] args) {
        Collection<Integer> primeNumbers = Numbers.findPrimeNumbers(1, 1000);
        for (var primeNumber : primeNumbers) {
            System.out.println(primeNumber);
        }
    }
}
