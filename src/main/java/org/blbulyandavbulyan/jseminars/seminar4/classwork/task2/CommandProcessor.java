package org.blbulyandavbulyan.jseminars.seminar4.classwork.task2;

import java.io.PrintStream;
import java.util.function.Consumer;
public class CommandProcessor {
    private final StringStorage stringStorage;
    private final PrintStream ps;
    public CommandProcessor(StringStorage stringStorage, PrintStream ps){
        this.stringStorage = stringStorage;
        this.ps = ps;
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
    public void processCommand(String processedCommand){
        String[] splitCommand = processedCommand.split("~");
        String action = splitCommand[0];
        switch (action){
            case "print"->{
                if(splitCommand.length == 2){
                    tryToProcessStringAsIndex(splitCommand[1], (index)-> ps.println(stringStorage.get(index)));
                }
                else if(splitCommand.length == 1){
                    //печать всех добавленных строк в обратном порядке
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
