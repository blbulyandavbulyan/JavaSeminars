package org.blbulyandavbulyan.jseminars.seminar5.homework;

import java.util.Arrays;

import static org.blbulyandavbulyan.jseminars.seminar5.homework.heap.HeapSort.heapSort;
import static org.blbulyandavbulyan.utils.Lists.generateRandomNumbers;

public class Task2 {
    //2) Реализовать алгоритм пирамидальной сортировки (HeapSort)(найти метод в Интернете и включить в проект)
    public static void main(String[] args) {
        int arr[] = generateRandomNumbers(20, 0, 100).stream().mapToInt(x -> x).toArray();
        System.out.println(Arrays.toString(arr));
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
