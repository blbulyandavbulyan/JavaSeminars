package org.blbulyandavbulyan.utils;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        return Stream.generate(()->random.nextInt(fromInclusive, toExclusive)).limit(count).collect(Collectors.toList());
    }
}
