package org.blbulyandavbulyan.jseminars.seminar2.homework;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.stream.IntStream;

public class Task2 {
    private final static Random random = new Random();
    public static int[] generateRandomArray(int count, int from, int to){
        return IntStream.generate(()->random.nextInt(from, to)).limit(count).toArray();
    }
    public static void main(String[] args) throws IOException {
        Logger fileLogger = Logger.getAnonymousLogger();
        FileHandler fileHandler = new FileHandler("log.txt");
        fileHandler.setFormatter(new SimpleFormatter());
        fileLogger.addHandler(fileHandler);
        int[] arrayForSorting = generateRandomArray(20, 0, 100);
        System.out.println(Arrays.toString(arrayForSorting));
        BubbleSortingWithLogging bubbleSortingWithLogging = new BubbleSortingWithLogging(fileLogger);
        bubbleSortingWithLogging.bubbleSort(arrayForSorting);
        System.out.println(Arrays.toString(arrayForSorting));
    }
}
