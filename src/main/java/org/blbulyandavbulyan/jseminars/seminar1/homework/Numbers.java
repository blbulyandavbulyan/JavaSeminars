package org.blbulyandavbulyan.jseminars.seminar1.homework;

import java.util.Collection;

/**
 * Данный класс содержит методы для решения задач 1 и 2
 * */
public class Numbers {
    /**
     * @param from нижняя граница
     * @param to верхня граница
     * @throws IllegalArgumentException если from > to
     * */
    private static void throwIfFromLargeThanTo(int to, int from){
        if(from > to)throw new IllegalArgumentException("Нижняя граница больше верхней");
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
     * Ищет все простые числа от from до to
     * @param from нижняя граница(включительно)
     * @param to верхняя граница(включительно)
     * @return коллекцию, содержащую найденные простые числа
     * @throws IllegalArgumentException если from > to
     * */
    public static Collection<Integer> findPrimeNumbers(int from, int to){
        // FIXME: 08.06.2023 Исправить реализацию этой функции
        return null;
    }
}
