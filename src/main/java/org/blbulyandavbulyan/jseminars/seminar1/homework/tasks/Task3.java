package org.blbulyandavbulyan.jseminars.seminar1.homework.tasks;
//3) Реализовать простой калькулятор

import org.blbulyandavbulyan.jseminars.seminar1.homework.core.Calculator;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        System.out.println("Наберите help для справки");
        while (true){
            try{
                String command = scanner.nextLine().toUpperCase();
                switch (command){
                    case "EXIT" ->{
                        return;
                    }
                    case "HELP"->{
                        System.out.println("Если вы наберёте exit, то выйдете из программы");
                        System.out.println("Вы можете складывать, вычитать и умножать числа, для этого запишите сначала число, потом пробел, операцию, снова пробел и снова число");
                        System.out.println("Операции обозначаются так же как и в математике +, -, * - стандартно. / - деление");
                        System.out.println("Вместо классических обозначений операций сложения, умножения, деления, вычитания, вы так же можете использовать английские слова для их обозначения");
                        System.out.println("Например: 2 ADD 2 будет иметь такой же результат как и 2 + 2, доступный список ключевых слов: MULTIPLY, DIVIDE, ADD, SUBTRACT");
                    }
                    default -> {
                        String[] commandArgs = command.split(" ");
                        if(commandArgs.length == 3){
                            double a = Double.parseDouble(commandArgs[0]);
                            Calculator.Operation operation = Calculator.Operation.getOperation(commandArgs[1]);
                            double b = Double.parseDouble(commandArgs[2]);
                            System.out.printf("%f %s %f = %f\n".formatted(a, operation.toString(), b, calculator.calculate(a, b, operation)));
                        }
                        else System.err.println("Неверное количество аргументов!");
                    }
                }
            }
            catch (NumberFormatException e){
                System.err.println("Кажется вы ввели не число на первой или второй позиции");
            }
            catch (IllegalArgumentException e){
                System.err.println("Вы ввели неверную операцию");
            }
        }

    }
}
