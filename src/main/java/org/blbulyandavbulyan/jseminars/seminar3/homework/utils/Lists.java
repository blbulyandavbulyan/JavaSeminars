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

    private static <T extends Comparable<T>> List<T> mergeSort(List<T> list, List<T> buffer) {
        // FIXME: 17.06.2023 Здесь почему-то вылетает ConcurrentModificationException
        if(list.size() > 1) {
            int middleIndex = list.size()/2;
            List<T> first = list.subList(0, middleIndex);
            List<T> second = list.subList(middleIndex, list.size());
            var firstSorted = mergeSort(first, buffer);
            first.clear();
            first.addAll(firstSorted);
            var secondSorted= mergeSort(second, buffer);
            second.clear();
            second.addAll(secondSorted);
            merge(first, second, buffer);
            list.clear();
            list.addAll(buffer);
            buffer.clear();

        }
//        else if()
        return buffer;
    }

    /**
     * Сортирует список list методом сортировки слиянием
     *
     * @param list изменяемый список для сортировки
     * @param <T>  тип элемента в списке, должен быть Comparable
     * @return отсортированный список
     */
    public static <T extends Comparable<T>> List<T> mergeSort(List<T> list) {
        return mergeSort(list, new ArrayList<>(list.size()));
    }

    /**
     * Приватная часть метода для слияния
     * @param l1 первый список
     * @param l2 второй список
     * @param buffer список, который будет содержать результат слияния
     * @param <T> тип элементов в списках
     */
    private static <T extends Comparable<T>> void merge(List<T> l1, List<T> l2, List<T> buffer) {
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
                    buffer.add(first);
                    needNextFirst = true;
                    needNextSecond = false;
                } else if (comparingResult > 0) {//first > second
                    buffer.add(second);
                    needNextFirst = false;
                    needNextSecond = true;
                } else {//first == second
                    buffer.add(first);
                    buffer.add(second);
                    needNextFirst = needNextSecond = true;
                }
                //это условие нужно, если у нас внезапно закончились элементы из списка, то нам нужно добавить масимальный из двух first или second, поскольку мы добавляем всегда минимальный из first и second
                //на предыдущих шагах
                if ((!firstIter.hasNext() || !secondIter.hasNext()) && comparingResult != 0) {
                    lastNotAddedValue = comparingResult > 0 ? first : second;
                    if (!firstIter.hasNext() && !secondIter.hasNext()) buffer.add(lastNotAddedValue);
                }
            }
            var iter = firstIter.hasNext() ? firstIter : secondIter;
            while (iter.hasNext()) {
                T current = iter.next();
                int comparing = lastNotAddedValue != null ? current.compareTo(lastNotAddedValue) : -1;
                if (comparing < 0) buffer.add(current);
                else {
                    buffer.add(lastNotAddedValue);
                    buffer.add(current);
                    lastNotAddedValue = null;
                }
                if (!iter.hasNext() && lastNotAddedValue != null) buffer.add(lastNotAddedValue);
            }

        }
    }

    /**
     * Данный метод предоставляет возможность слить два отсортированных списка в один отсортированный список
     *
     * @param l1  первый список для объединения
     * @param l2  второй список для объединения
     * @param <T> тип элемента в списках, должен быть Comparable
     * @return отсортированный список, со всеми элементами из l1 и l2, и размер которого равен l1.size() + l2.size()
     */
    public static <T extends Comparable<T>> List<T> merge(List<T> l1, List<T> l2) {
        List<T> result = new ArrayList<>(l1.size() + l2.size());
        merge(l1, l2, result);
        return result;
    }
}
