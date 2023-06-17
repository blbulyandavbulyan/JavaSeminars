package org.blbulyandavbulyan.jseminars.seminar4.homework;

import java.util.LinkedList;

import static org.blbulyandavbulyan.utils.Lists.generateRandomNumbers;
import static org.blbulyandavbulyan.utils.Lists.reverseList;
//1. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
public class Task1 {
    public static void main(String[] args) {
        LinkedList<Integer> randomLinkedList = generateRandomNumbers(20, 0, 200, LinkedList::new);
        System.out.println(randomLinkedList);
        System.out.println(reverseList(randomLinkedList));

    }
}
