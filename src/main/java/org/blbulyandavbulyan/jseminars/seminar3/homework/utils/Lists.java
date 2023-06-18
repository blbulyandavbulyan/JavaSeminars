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
    /**
     * Сортирует список list методом сортировки слиянием
     *
     * @param list список для сортировки
     * @param <T>  тип элемента в списке, должен быть Comparable
     * @return отсортированный список
     */
    public static <T extends Comparable<T>> List<T> mergeSort(List<T> list) {
        //крайний случай рекурсии, список в котором меньше двух элементов и так отсортирован
        if(list.size() < 2){
            return list;
        }
        else{
            //на этом месте уже должно быть разбиение на половины, сортировка их, а потом слияние
            int middleIndex = list.size()/2;
            List<T> first = mergeSort(list.subList(0, middleIndex));//получаем первую половину и сортируем её
            List<T> second = mergeSort(list.subList(middleIndex, list.size()));//получаем вторую половину и сортируем её
            //поскольку first и second - две отсортированные половины, делаем слияние и возвращаем
            //на самом деле, здесь будет довольно не эффективно по памяти, т.к. каждый раз создаётся новый список, для слияния половин
            return merge(first, second);
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
        //на самом деле, слияние двух списков оказалось не такой уж тривиальной задачей, особенно написание комментариев
        List<T> result = new ArrayList<>(l1.size() + l2.size());//собственно результат, в который будут сливаться элементы
        var firstIter = l1.iterator();
        var secondIter = l2.iterator();
        //в этой переменной если null, то значит последнего не добавленного значения нет
        T lastNotAddedValue = null;//последнее не добавленное значение, тут большее всегда, поскольку мы добавляем меньшие
        {
            boolean needNextFirst = true;// нужно ли вызывать next у первого итератора
            boolean needNextSecond = true;//нужно ли вызывать next у второго итератора
            T first = null;//элемент из первого списка
            T second = null;//элемент из второго списка
            while (firstIter.hasNext() && secondIter.hasNext()) {
                //двигаем итератор по первому и по второму списку, если нужно
                if (needNextFirst) first = firstIter.next();
                if (needNextSecond) second = secondIter.next();
                int comparingResult = first.compareTo(second);//мы сравниваем два элемента
                //далее, весь смысл в том, что мы должны записать в результат меньший элемент или first или second
                //или записать оба, если они равны
                if (comparingResult < 0) {//first < second
                    result.add(first);//поскольку первый меньший, записываем его
                    //теперь, вдруг у нас в первом списке есть ещё элементы, которые меньше second
                    //мы должны на данном этапе получать только их
                    needNextFirst = true;
                    needNextSecond = false;
                } else if (comparingResult > 0) {//first > second
                    result.add(second);//записываем элемент из второго списка, поскольку он меньше
                    needNextFirst = false;
                    //далее поскольку мы записали элемент из второго списка, значит далее мы будем брать только из него
                    needNextSecond = true;
                } else {//first == second
                    //элементы из первого и второго списка равны, записываем оба
                    result.add(first);
                    result.add(second);
                    //здесь, поскольку мы оба записали, то нам нужно взять следующие элементы из двух списков сразу
                    needNextFirst = needNextSecond = true;
                }
                //это условие нужно, если у нас внезапно закончились элементы из списка, то нам нужно добавить максимальный из двух first или second, поскольку мы добавляем всегда минимальный из first и second
                //на предыдущих шагах
                //если у нас закончился один из списков, и результат сравнения first и second дал нам что они не равны, то
                if ((!firstIter.hasNext() || !secondIter.hasNext()) && comparingResult != 0) {
                    lastNotAddedValue = comparingResult > 0 ? first : second;//если comparingResult > 0 -> first > second и нам нужен first, иначе нам нужен second
                    //если закончились оба списка, то добавляем сразу
                    //это нужно для того, чтобы добавить его, т.к. наш следующий while(вставляющий оставшиеся элементы в одном из списков), который должен был его вставить в правильном месте не выполнится
                    if (!firstIter.hasNext() && !secondIter.hasNext())
                        result.add(lastNotAddedValue);
                }
            }
            //здесь мы выбираем итератор того списка, который мы обошли не до конца в результате первого цикла
            var iter = firstIter.hasNext() ? firstIter : secondIter;
            //собственно если в нём остались элементы, обходим и добавляем
            while (iter.hasNext()) {
                T current = iter.next();
                //поскольку в lastNotAddedValue может лежать последнее недобавленное значение, которое осталось в результате работы первого цикла,
                //то нам нужно добавить его здесь
                //мы считаем что у нас оно есть, если != null
                int comparing = lastNotAddedValue != null ? current.compareTo(lastNotAddedValue) : -1;
                if (comparing < 0) result.add(current);//добавляем все значения, меньшие нашего lastNotAddedValue ну или если его нет
                else {//нашли значение которое больше lastNotAddedValue
                    //добавляем сначала меньше, потом большее
                    result.add(lastNotAddedValue);
                    result.add(current);
                    lastNotAddedValue = null;//теперь у нас больше нет последнего не добавленного значения, мы его добавили
                }
                //на случай если у нас оно оказалось самым большим, то нам нужно добавить его после всех
                if (!iter.hasNext() && lastNotAddedValue != null) result.add(lastNotAddedValue);
            }

        }
        return result;
    }
}
