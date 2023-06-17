package org.blbulyandavbulyan.jseminars.seminar3.homework.utils;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.blbulyandavbulyan.jseminars.seminar3.homework.utils.Lists.mergeSort;
import static org.junit.jupiter.api.Assertions.*;
import static org.blbulyandavbulyan.utils.Lists.generateRandomNumbers;

public class MergeSortTest {
    private <T extends Comparable<T>>void mergeCheck(List<T> first, List<T> second){
        first.sort(T::compareTo);
        second.sort(T::compareTo);
        List<T> expected = new ArrayList<>();
        expected.addAll(first);
        expected.addAll(second);
        expected.sort(T::compareTo);
        List<T> actual = Lists.merge(first, second);
        if(!actual.equals(expected)){
            var logger =  LoggerFactory.getLogger(this.getClass());
            logger.info(()-> "Первый список для объединения: " + first);
            logger.info(()-> "Второй список для объединения: " + second);
        }
        assertEquals(expected, actual);
    }
    @Test
    public void mergeTest(){
        List<Integer> first = generateRandomNumbers(40, 0, 10);
        List<Integer> second = generateRandomNumbers(30, 0, 20);
        mergeCheck(first, second);
    }
    @Test
    public void specialMergeTest(){
        List<Integer> first = new ArrayList<>(List.of(1, 2, 8, 20, 22, 23, 36, 40, 42, 43, 46, 56, 67, 71, 72, 78, 81, 102, 105, 115, 115, 117, 123, 137, 143, 145, 152, 172, 183, 198));
        List<Integer> second = new ArrayList<>(List.of(2, 10, 15, 21, 35, 67, 68, 69, 71, 78, 87, 91, 91, 91, 98, 106, 115, 131, 140, 144, 145, 157, 168, 179, 180, 180, 190, 194, 194, 199));
        mergeCheck(first, second);
    }
    @Test
    public void specialMergeTest2(){
        mergeCheck(new ArrayList<>(List.of(17, 20, 30, 30, 54, 54, 65, 65, 65, 70, 76, 77, 88, 89, 105, 120, 120, 124, 126, 133, 149, 153, 155, 163, 164, 178, 187, 189, 191, 191)), new ArrayList<>(List.of(11, 12, 13, 20, 22, 31, 31, 36, 37, 45, 51, 54, 57, 66, 68, 69, 83, 102, 104, 107, 123, 147, 151, 158, 162, 171, 173, 175, 179, 197)));
    }
    @Test
    public void specialMergeTest3(){
        mergeCheck(new ArrayList<>(List.of(3, 12, 20, 21, 25, 29, 39, 42, 68, 71, 74, 85, 88, 89, 95, 101, 112, 131, 135, 140, 142, 157, 162, 163, 165, 177, 182, 186, 194, 199)), new ArrayList<>(List.of(2, 4, 8, 13, 17, 18, 38, 47, 54, 55, 57, 59, 64, 76, 82, 82, 85, 90, 91, 99, 104, 110, 111, 144, 159, 163, 164, 175, 194, 197)));
    }
    @Test
    public void firstAndSecondEquals(){
        List<Integer> first = generateRandomNumbers(40, Integer.MIN_VALUE, Integer.MAX_VALUE);
        mergeCheck(first, first);
    }
    @Test
    public void mergeSortTest(){
        List<Integer> expected = generateRandomNumbers(100, -200, 200);
        List<Integer> actual = new ArrayList<>(expected);
        expected.sort(Integer::compareTo);
        actual = mergeSort(actual);
        assertEquals(expected, actual);
    }
}
