package org.blbulyandavbulyan.jseminars.seminar3.homework.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;

/**
 * Утилитный класс, который будет использоваться для решения задач со списками к домашнему заданию к 3-му семинару
 */
public class Lists {

    /**
     * Удаляет все элементы из списка, соответствующие предикату
     *
     * @param list            изменяемый список, в котором будут удаляться элементы
     * @param removePredicate предикат, по которому будут удаляться элементы
     * @param <T>             тип элемента в списке
     */
    public static <T> void removeAll(List<T> list, Predicate<T> removePredicate) {
        //как-то даже не сильно интересно получилось
        list.removeIf(removePredicate);
    }

    /**
     * Данная функция удаляет из списка чётные числа
     *
     * @param numbers список, в котором будет производиться удаление
     */
    public static void removeEvenNumbers(List<Integer> numbers) {
        removeAll(numbers, (n) -> n % 2 == 0);
    }

    /**
     * Находит минимальное, максимальное и среднее арифметическое в списке целых чисел
     *
     * @param iList список целых чисел для поиска
     * @return объект, у которого есть методы getMin, getMax и getAverage
     */
    public static MinMaxAverage findMinMaxAndAverage(List<Integer> iList) {
        //вообще наверное через стримы была не лучшая идея это делать, да и в целом как-то странно получилось
        //вся логика живёт по сути в MinMaxAverageForStreams
        return iList.stream().collect(Collector.of(MinMaxAverageForStreams::new, MinMaxAverageForStreams::putInteger, MinMaxAverageForStreams::combineToAnother));
    }

    public static void mergeSort(List<Integer> list) {

    }

    public static <T extends Comparable<T>> List<T> merge(List<T> l1, List<T> l2) {
        List<T> result = new ArrayList<>(l1.size() + l2.size());
        var firstIter = l1.iterator();
        var secondIter = l2.iterator();
        T lastNotAddedValue = null;
        {
            boolean needNextFirst = true;
            boolean needNextSecond = true;
            T first = null, second = null;
            while (firstIter.hasNext() && secondIter.hasNext()) {
                if (needNextFirst) first = firstIter.next();
                if (needNextSecond) second = secondIter.next();
                int comparingResult = first.compareTo(second);
                if (comparingResult < 0) {//first < second
                    result.add(first);
                    needNextFirst = true;
                    needNextSecond = false;
                }
                else if (comparingResult > 0) {//first > second
                    result.add(second);
                    needNextFirst = false;
                    needNextSecond = true;
                }
                else {//first == second
                    result.add(first);
                    result.add(second);
                    needNextFirst = needNextSecond = true;
                }
                //это условие нужно, если у нас внезапно закончились элементы из списка, то нам нужно добавить масимальный из двух first или second, поскольку мы добавляем всегда минимальный из first и second
                //на предыдущих шагах
                if((!firstIter.hasNext() || !secondIter.hasNext()) && comparingResult != 0){
                    lastNotAddedValue = comparingResult > 0 ? first : second;
                    if (!firstIter.hasNext() && !secondIter.hasNext()) result.add(lastNotAddedValue);
                }
            }
            var iter = firstIter.hasNext() ? firstIter : secondIter;
            while (iter.hasNext()) {
                T current = iter.next();
                int comparing = lastNotAddedValue != null ? current.compareTo(lastNotAddedValue) : -1;
                if(comparing < 0) result.add(current);
                else{
                    result.add(lastNotAddedValue);
                    result.add(current);
                    lastNotAddedValue = null;
                }
                if(!iter.hasNext() && lastNotAddedValue != null)result.add(lastNotAddedValue);
            }

        }

        return result;
    }
}
