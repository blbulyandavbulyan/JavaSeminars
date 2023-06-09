package org.blbulyandavbulyan.jseminars.seminar1.homework.core.expressionsolver;

import org.blbulyandavbulyan.jseminars.seminar1.homework.core.Calculator;

import java.util.function.Consumer;

// Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69.
// Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.
//
public class ExpressionSolver {
    private ComboPicker qPicker, wPicker, ePicker;
    private Calculator.Operation operation;
    private final Calculator calculator;
    public ExpressionSolver(Calculator calculator){
        this.calculator = calculator;
    }
    public void parseExpression(String expr){
        String[] parts = expr.split("=");
        if(parts.length != 2)throw new IllegalArgumentException("Частей, разделяемых = не две!");
        String leftEqualPart = parts[0].trim();
        ePicker = new ComboPicker(parts[1].trim(), ()->new IllegalArgumentException("Выражение после = не соответствует требуемому шаблону!"));
        String[] leftParts = leftEqualPart.split(" ");
        if(leftParts.length != 3)throw new IllegalArgumentException("Неверная левая часть выражения!");
        qPicker = new ComboPicker(leftParts[0].trim(), ()-> new IllegalArgumentException("Неверный левый операнд в левой части!"));
        wPicker = new ComboPicker(leftParts[2].trim(), ()->new IllegalArgumentException("Неверный правый операнд в левой части!"));
        try{
            operation = Calculator.Operation.getOperation(leftParts[1].trim());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Неверный оператор!", e);
        }
    }
    public void iterateOverSolutions(Consumer<ExpressionSolution> solutionConsumer, Runnable noElements){
        boolean found = false;
        while (ePicker.hasNext()){
            int e = ePicker.next();
            while (qPicker.hasNext()){
                int q = qPicker.next();
                while (wPicker.hasNext()){
                    int w = wPicker.next();
                    if((int)calculator.calculate(q, w, operation) == e){
                        solutionConsumer.accept(new ExpressionSolution(q, w, e, operation));
                        found = true;
                    }
                }
                wPicker.reset();
            }
            qPicker.reset();
        }
        if(!found) {
            if(noElements != null)noElements.run();
        }
    }
}
