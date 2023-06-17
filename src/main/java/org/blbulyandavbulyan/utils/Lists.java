package org.blbulyandavbulyan.utils;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Утилитный класс, который будет содержать самые часто используемые методы со списками
 * @author David Blublyan
 */
public class Lists {
    private final static Random random = new Random();

    /**
     * Генерирует изменяемый список со случайными числами в заданном диапазоне
     * @param count количество случайных чисел
     * @param fromInclusive нижняя граница диапазона генерируемых случайных чисел(включительно)
     * @param toExclusive верхняя граница диапазона генерируемых случайных чисел(исключительно)
     * @return изменяемый список длинной count со случайными числами в диапазоне [fromInclusive; toExclusive)
     */
    public static List<Integer> generateRandomNumbers(int count, int fromInclusive, int toExclusive){
        return generateRandomNumbers(count, fromInclusive, toExclusive, ArrayList::new);
    }

    /**
     * Генерирует изменяемый список заданного типа со случайными числами в заданном диапазоне
     * @param count количество случайных чисел
     * @param fromInclusive нижняя граница диапазона генерируемых случайных чисел(включительно)
     * @param toExclusive верхняя граница диапазона генерируемых случайных чисел(исключительно)
     * @param listSupplier функция, возвращающая изменяемый список, в который будут добавлены случайные числа
     * @return изменяемый список длинной count со случайными числами в диапазоне [fromInclusive; toExclusive)
     */
    public static <T extends List<Integer>> T generateRandomNumbers(int count, int fromInclusive, int toExclusive, Supplier<T> listSupplier){
        return Stream.generate(()->random.nextInt(fromInclusive, toExclusive)).limit(count).collect(Collectors.toCollection(listSupplier));
    }

    /**
     * Функция переворачивает переданный ей связанный список
     * @param list список, который нужно перевернуть
     * @return возвращает список, в котором элементы расположены в обратном порядке
     * @param <T> тип элемента в списке
     */
    public static <T> List<T> reverseList(LinkedList<T> list){
        Spliterator<T> spliterator = Spliterators.spliteratorUnknownSize(list.descendingIterator(), Spliterator.ORDERED);
        return StreamSupport.stream(spliterator, false).collect(Collectors.toList());
    }
}
