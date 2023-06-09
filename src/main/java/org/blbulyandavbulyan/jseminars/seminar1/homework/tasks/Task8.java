package org.blbulyandavbulyan.jseminars.seminar1.homework.tasks;

import org.blbulyandavbulyan.jseminars.seminar1.homework.core.Numbers;

//Задан массив, например, nums = [1,7,3,6,5,6].
//Написать программу, которая найдет индекс i для этого массива
//такой, что сумма элементов с индексами < i равна сумме
//элементов с индексами > i.
public class Task8 {
    public static void main(String[] args) {
        System.out.println(Numbers.findMiddleIndex(new int[]{1,7,3,6,5,6}));
    }
}
