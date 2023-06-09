package org.blbulyandavbulyan.jseminars.seminar1.homework;


import java.util.HashMap;
import java.util.Scanner;

public class Calculator {
    public enum Operation{
        //зачем весь этот огород ?
        //таким образом можно писать 2 + 2 или например 2 ADD 2, аналогично и с другими операциями
        ADD("+"),
        SUBTRACT("-"),
        MULTIPLY("*"),
        DIVIDE("/");

        private final String shortSynonymForOperation;//строка содержащая короткий синоним для операции
        private static final HashMap<String, Operation> operationMapper = new HashMap<>();//хэш таблица для преобразования короткого синонима в операцию
        static {
            //заполнение хэш таблицы с короткими синонимами на операцию
            for(Operation op : values()){
                operationMapper.put(op.toString(), op);
            }
        }
        Operation(String shortSynonymForOperation) {
            this.shortSynonymForOperation = shortSynonymForOperation;
        }
        @Override
        public String toString() {
            return shortSynonymForOperation;
        }
        public static Operation getOperation(String operationStr){
            if(operationMapper.containsKey(operationStr))
                return operationMapper.get(operationStr);
            return valueOf(operationStr);
        }
    }
    public double calculate(double a, double b, Operation operation){
        switch (operation){
            case ADD -> {
                return a + b;
            }
            case SUBTRACT -> {
                return a-b;
            }
            case DIVIDE -> {
                return a/b;
            }
            case MULTIPLY -> {
                return a*b;
            }
            default -> throw new IllegalArgumentException("Operation not supported!");
        }
    }
    public boolean isValidOperation(String operation){
        try{
            Operation.getOperation(operation);
            return true;
        }
        catch (IllegalArgumentException e) {
            return false;
        }
    }

}
