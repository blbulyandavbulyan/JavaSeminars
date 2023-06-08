package org.blbulyandavbulyan.jseminars.seminar1.homework.expressionsolver;

import org.blbulyandavbulyan.jseminars.seminar1.homework.Calculator;

// Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69.
// Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.
//
public class ExpressionSolver {
    private ComboPicker q, w, e;
    private Calculator.Operation operation;
    private Calculator calculator;
    public ExpressionSolver(String expr, Calculator calculator){
        this.calculator = calculator;
        String[] parts = expr.split("=");
        if(parts.length != 2)throw new IllegalArgumentException("Частей, разделяемых = не две!");
        String leftEqualPart = parts[0].trim();
        e = new ComboPicker(parts[1].trim(), ()->new IllegalArgumentException("Выражение после = не соответствует требуемому шаблону!"));
        String[] leftParts = leftEqualPart.split(" ");
        if(leftParts.length != 3)throw new IllegalArgumentException("Неверная левая часть выражения!");
        q = new ComboPicker(leftParts[0].trim(), ()-> new IllegalArgumentException("Неверный левый операнд в левой части!"));
        w = new ComboPicker(leftParts[2].trim(), ()->new IllegalArgumentException("Неверный правый операнд в левой части!"));
        try{
            operation = Calculator.Operation.getOperation(leftParts[1].trim());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Неверный оператор!", e);
        }
    }
    public void printAllSolutions(){
        boolean found = false;
        while (e.hasNext()){
            int expectedResult = e.next();
            while (q.hasNext()){
                int qV = q.next();
                while (w.hasNext()){
                    int wV = w.next();
                    if((int)calculator.calculate(qV, wV, operation) == expectedResult){
                        System.out.printf("%d %s %d = %d\n", qV, operation.toString(), wV, expectedResult);
                        found = true;
                    }
                }
                w.reset();
            }
            q.reset();
        }
        if(!found) System.out.println("Нет решений!");
    }
    public static void main(String[] args) {
        String rebus = "29 + ?? = ?9";
        new ExpressionSolver(rebus, new Calculator()).printAllSolutions();
    }
}
