package org.blbulyandavbulyan.jseminars.seminar1.homework;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Данный класс содержит методы для решения задач 1 и 2, 8
 * */
public class Numbers {
    /**
     * Вспомогательный метод для проверки на валидность параметров from, to используется в других функциях этого класса
     * @param from нижняя граница
     * @param to верхня граница
     * @throws IllegalArgumentException если from > to
     * */
    private static void throwIfFromLargeThanTo(int from, int to){
        if(from > to)throw new IllegalArgumentException("%d должно быть не больше %d".formatted(from, to));
    }
    /**
     * Считает сумму целых чисел от from до to
     * @param from нижняя граница(включительно)
     * @param to верхняя граница(включительно)
     * @return возвращает сумму целых чисел от from до to
     * @throws IllegalArgumentException если from > to
     * */
    public static int findSum(int from, int to){
        throwIfFromLargeThanTo(from, to);
        int result = 0;
        for(int i = from; i  <= to; i++){
            result+=i;
        }
        return result;
    }
    /**
     * Считает сумму целых чисел от 1 до to
     * @param n верхняя граница(включительно)
     * @throws IllegalArgumentException если n < 1
     * */
    public static int findSum(int n){
        return findSum(1, n);
    }
    /**
     * Проверяет, является ли n простым
     * @param n натуральное число для проверки
     * @return true если n простое, иначе false
     * */
    public static boolean isPrime(int n){
        throwIfFromLargeThanTo(1, Integer.MAX_VALUE);
        for (int i = 2; i < n; i++) {
            if(n % i == 0)return false;
        }
        return n != 1;
    }


    /**
     * Ищет все простые числа от from до to
     * @param from нижняя граница(включительно)
     * @param to верхняя граница(включительно)
     * @return коллекцию, содержащую найденные простые числа
     * @throws IllegalArgumentException если from > to
     * */
    public static Collection<Integer> findPrimeNumbers(int from, int to){
        throwIfFromLargeThanTo(from, to);
        Collection<Integer> result = new LinkedList<>();
        for(int i = from; i <= to; i++){
            if(isPrime(i))
                result.add(i);
        }
        return result;
    }
    /**
     * Ищет простые числа от 1 до n
     * @param n верхняя граница(включительно)
     * @return простые числа в промежутке [1;n]
     * @throws IllegalArgumentException если не натуральное (n < 1)
     * */
    public static Collection<Integer> findPrimeNumbersFromOne(int n){
        return findPrimeNumbers(1, n);
    }

    //решение задачи 8
    /**
     * Данная функция ищет индекс в массиве, такой что сумма элементов справа равна сумме элементов слева от него
     * @return искомый индекс, или -1 если такого индекса нет
     * */
    public static int findMiddleIndex(int[] arr){
        //находим сумму всех элементов в массиве
        int sumOfElements = java.util.Arrays.stream(arr).sum();
        int leftSum = arr[0];
        //начинаем обход со второго элемента, чтобы у нас был элемент справа
        for (int i = 1; i < arr.length; i++) {
            int rightSum = sumOfElements - leftSum - arr[i];
            if(rightSum == leftSum)return i;
            else leftSum+=arr[i];
        }
        return -1;
    }
}
