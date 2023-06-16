package org.blbulyandavbulyan.jseminars.seminar3.homework.utils;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;

/**
 * Утилитный класс, который будет использоваться для решения задач со списками к домашнему заданию к 3-му семинару
 */
public class Lists {

    /**
     * Удаляет все элементы из списка, соотвествующие предикату
     * @param list изменяемый список, в котором будут удаляться элементы
     * @param removePredicate предикат, по которому будут удаляться элементы
     * @param <T> тип элемента в списке
     */
    public static<T> void removeAll(List<T> list, Predicate<T> removePredicate){
        //как-то даже не сильно интересно получилось
        list.removeIf(removePredicate);
    }

    /**
     * Данная функция удаляет из списка чётные числа
     * @param numbers список, в котором будет производиться удаление
     */
    public static void removeEvenNumbers(List<Integer> numbers){
        removeAll(numbers, (n)->n % 2 == 0);
    }
    /**
     * Находит минимальное, максимальное и среднее арифметическое в списке целых чисел
     * @param iList список целых чисел для поиска
     * @return объект, у которого есть методы getMin, getMax и getAverage
     */
    public static MinMaxAverage findMinMaxAndAverage(List<Integer> iList){
        //вообще наверное через стримы была не лучшая идея это делать, да и в целом как-то странно получилось
        //вся логика живёт по сути в MinMaxAverageForStreams
        return iList.stream().collect(Collector.of(MinMaxAverageForStreams::new, MinMaxAverageForStreams::putInteger, MinMaxAverageForStreams::combineToAnother));
    }
}
