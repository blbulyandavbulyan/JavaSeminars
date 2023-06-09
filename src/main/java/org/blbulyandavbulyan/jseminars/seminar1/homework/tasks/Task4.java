package org.blbulyandavbulyan.jseminars.seminar1.homework.tasks;

import org.blbulyandavbulyan.jseminars.seminar1.homework.core.Calculator;
import org.blbulyandavbulyan.jseminars.seminar1.homework.core.expressionsolver.ExpressionSolver;

import java.util.Scanner;

//4) (задание со *) Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69.
// Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.
public class Task4 {
    public static void main(String[] args) {
        //Данные вводить в формате: n1 op n2 = r
        // где, n1 - первое число с вопросиками,
        // op - операция(поддерживаемая калькулятором)
        // n2 - второе число с вопросиками
        // r - ожидаемый результат(тоже может быть с вопросиками)
        // поддерживаются только целые числа(причём не отрицательные, т.к. работу с отрицательными я не закладывал)
        Scanner scanner = new Scanner(System.in);
        ExpressionSolver expressionSolver = new ExpressionSolver(new Calculator());
        while (true){
            System.out.print("Введите ребус: ");
            String rebus = scanner.nextLine().trim();
            if(rebus.equals("exit"))return;
            try{
                expressionSolver.parseExpression(rebus);
                expressionSolver.iterateOverSolutions(System.out::println, ()-> System.out.println("Нет решений"));
            }
            catch (RuntimeException e){
                System.out.println("Вероятно вы ввели ребус в неверном формате");
                System.out.println(e.getMessage());
            }

        }

    }
}
