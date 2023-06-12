package org.blbulyandavbulyan.jseminars.seminar2.homework;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class BubbleSortingWithLogging {
    private final Logger logger;
    public BubbleSortingWithLogging(Logger logger){
        this.logger = logger;
    }
    public void bubbleSort(int[] arr){
        logger.info("Операция сортировки начата");
        boolean sorted = true;
        int counter = 1;
        for(int endSortingIndex = arr.length - 1; endSortingIndex >= 1; endSortingIndex--){
            logger.info("Проход сортировки %d".formatted(counter++));
            for (int i = 0; i < endSortingIndex; i++) {
                if(arr[i] > arr[i+1]){
                    logger.info("Обмен значений под индексами %d %d".formatted(i, i+1));
                    //обмен значений
                    int temp = arr[i+1];
                    arr[i+1]=arr[i];
                    arr[i] = temp;
                    sorted = false;
                }
            }
            if(sorted)break;
        }
        logger.info("Операция сортировки закончена");
    }

}
