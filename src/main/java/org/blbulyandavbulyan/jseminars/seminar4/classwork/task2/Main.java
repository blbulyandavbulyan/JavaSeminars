package org.blbulyandavbulyan.jseminars.seminar4.classwork.task2;

import org.blbulyandavbulyan.jseminars.seminar4.classwork.stringstorage.BaseStringStorage;

import java.util.Scanner;

//📔 **Текст задачи:**
//Реализовать консольное приложение, которое:
//
//1. Принимает от пользователя строку вида
//
//text~num
//
//1. Нужно рассплитить строку по ~, сохранить text в связный список на позицию num.
//2. Если введено print~num, выводит строку из позиции num в связном списке и удаляет её из списка.
//</aside>
//
//22:10
//<aside>
//📔 **Текст задачи:**
//Реализовать консольное приложение, которое:
//
//1. Принимает от пользователя и “запоминает” строки.
//2. Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
//3. Если введено revert, удаляет предыдущую введенную строку из памяти.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CommandProcessor commandProcessor = new CommandProcessor(new BaseStringStorage(), System.out);
        boolean exited = false;
        while (!exited){
            System.out.print("Введите команду> ");
            String command = sc.nextLine();
            if(command.equalsIgnoreCase("exit"))exited =true;
            else{
                try{
                    commandProcessor.processCommand(command);
                }
                catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
