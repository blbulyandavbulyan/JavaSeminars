package org.blbulyandavbulyan.jseminars.seminar1.classwork;

import java.util.Scanner;

//Написать программу, которая запросит пользователя ввести <Имя> в консоли.
//        Получит введенную строку и выведет в консоль сообщение “Привет, <Имя>!”
public class HelloUser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String userName = scanner.nextLine();
        System.out.println("Привет, " + userName);
    }
}
