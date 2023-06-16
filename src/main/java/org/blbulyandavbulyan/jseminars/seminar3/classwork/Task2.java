package org.blbulyandavbulyan.jseminars.seminar3.classwork;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//📌 Заполнить список названиями планет Солнечной
//системы в произвольном порядке с повторениями.
//📌 Вывести название каждой планеты и количество его
//повторений в списке.
//Пройти по списку из предыдущего задания и удалить
//повторяющиеся элементы.

public class Task2 {
    //раз уж запихнул стримы, то пихаю их до конца
    public static void main(String[] args) {
        String[] pl = { "Меркурий", "Венера", "Венера", "Марс", "Земля", "Юпитер", "Сатурн", "Уран", "Нептун" };
//        String [] pl = {"d", "d", "d", "a", "F", "F"};
        List<String> listOfPlanets = toList(pl);
        System.out.println(calculateDuplicates(listOfPlanets));
        System.out.println(listOfPlanets);
        List<String> planetsWithoutDuplicates = removeDuplicates(listOfPlanets);
        System.out.println(planetsWithoutDuplicates);
    }

    public static  <T>List<T> removeDuplicates(List<T> list){
        return list.stream().distinct().toList();
    }

    /**
     * Переводит массив T в List<T>
     * @param arr входной массив
     * @return список содержащий все элементы массива arr
     * @param <T> тип элемента в массиве и списке
     */
    public static <T>List<T> toList(T[] arr){
        return Arrays.stream(arr).toList();
    }

    /**
     * Считает количество повторений элемента в списке
     * @param data коллекция, в которой нужно подсчитать количество дубликатов
     * @return Map, где ключ - элемент списка, а значение - количество повторений
     * @param <T> тип элементов в списке
     */
    public static <T> Map<T, Integer> calculateDuplicates(Collection<T> data){
        return data.stream().collect(Collectors.toMap(Function.identity(), (v)-> 1, Integer::sum));
    }
}
