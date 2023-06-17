package org.blbulyandavbulyan.jseminars.seminar4.classwork.task2;

import java.io.PrintStream;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * Данный класс предоставляет обработчик команд, доступные команды
 */
public class CommandProcessor {
    private final StringStorage stringStorage;
    private final PrintStream ps;

    /**
     * Создаёт обработчик команд
     * @param stringStorage хранилище строк, над которым будут производиться манипуляции
     * @param ps сюда будет печататься результат команды, если таковой имеется
     */
    public CommandProcessor(StringStorage stringStorage, PrintStream ps){
        this.stringStorage = Objects.requireNonNull(stringStorage);
        this.ps = Objects.requireNonNull(ps);
    }
    private void tryToProcessStringAsIndex(String indexString, Consumer<Integer> indexConsumer){
        try{
            int stringIndex = Integer.parseInt(indexString);
            indexConsumer.accept(stringIndex);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("Неверная команда, после ~ введено не число!", e);
        }
        catch (IndexOutOfBoundsException e){
            throw new IllegalArgumentException("Неверная команда, индекс выходит за пределы хранилища!", e);
        }
    }

    /**
     * Обрабатывает переданную команду, доступные команды:
     * print - печатает все строки в хранилище в обратном порядке
     * print~num - печатает строку под индексом num и удаляет её из хранилища
     * revert - отменяет последнюю добавленную строку
     * text~num - добавляет text(вместо текста может быть любая строка, не содержащая ~) в хранилище в место под индексом num
     * Всё остальное, что не похоже ни на какую команду будет восприниматься как строка, которую нужно добавить в хранилище
     * @param processedCommand команда которую нужно обработать
     * @throws IllegalArgumentException если команда, которую передали неверная
     */
    public void processCommand(String processedCommand){
        String[] splitCommand = processedCommand.split("~");
        String action = splitCommand[0];
        switch (action){
            case "print"->{
                if(splitCommand.length == 2){
                    tryToProcessStringAsIndex(splitCommand[1], (index)-> {
                        //выводим строку
                        ps.println(stringStorage.get(index));
                        stringStorage.remove(index);
                    });
                }
                else if(splitCommand.length == 1){
                    //печать всех добавленных строк в обратном порядке
                    if(stringStorage.isEmpty())ps.println("Хранилище пусто!");
                    stringStorage.forEachReversed(ps::println);
                }
            }
            case "revert" ->{
                if(splitCommand.length == 1)stringStorage.revert();
                else throw new IllegalArgumentException("Неверная команда, после revert ничего не ожидалось!");
            }
            default -> {
                if(splitCommand.length == 1){
                    //просто добавляем новую строку
                    stringStorage.insert(splitCommand[0], 0);
                }
                else if(splitCommand.length == 2){
                    tryToProcessStringAsIndex(splitCommand[1], (index)-> stringStorage.insert(splitCommand[0], index));
                }
            }
        }
    }
}
