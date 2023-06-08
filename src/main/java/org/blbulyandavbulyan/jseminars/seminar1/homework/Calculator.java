package org.blbulyandavbulyan.jseminars.seminar1.homework;


import java.util.HashMap;
import java.util.Scanner;

public class Calculator {
    enum Operation{
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
    public static double calculate(double a, double b, Operation operation){
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
                            Operation operation = Operation.getOperation(commandArgs[1]);
                            double b = Double.parseDouble(commandArgs[2]);
                            System.out.printf("%f %s %f = %f\n".formatted(a, operation.toString(), b, calculate(a, b, operation)));
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
