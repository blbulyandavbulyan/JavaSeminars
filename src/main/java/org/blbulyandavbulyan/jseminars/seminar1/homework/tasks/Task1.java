package org.blbulyandavbulyan.jseminars.seminar1.homework.tasks;

import org.blbulyandavbulyan.jseminars.seminar1.homework.core.Numbers;

import java.util.Scanner;

//1) Вычислить сумма чисел от 1 до n
public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите n: ");
        int n = scanner.nextInt();
        System.out.println(Numbers.findSum(n));
    }
}
