package org.blbulyandavbulyan.jseminars.seminar4.classwork;

import java.util.*;

import static org.blbulyandavbulyan.utils.Times.measureTime;

//1) Замерьте время, за которое в ArrayList добавятся 10000 элементов.
//2) Замерьте время, за которое в LinkedList добавятся 10000 элементов. Сравните с предыдущим.
public class MeasureLinkedAndArrayListsAddingTime {
    public static void main(String[] args) {
        final int N = 100_000_000;
        System.out.println("Добавления элементов в ArrayList: ");
        System.out.println(measureTime(()-> addElementsInList(new ArrayList<>(), N)));
        System.out.println("Добавление элементов в LinkedList: ");
        System.out.println(measureTime(()-> addElementsInList(new LinkedList<>(), N)));
    }
    public static void addElementsInList(List<Integer> list, int count){
        for(int i = 0; i < count; i++){
            list.add(list.size() > 0 ? list.size() - 1 : 0, i);
        }
    }
}
