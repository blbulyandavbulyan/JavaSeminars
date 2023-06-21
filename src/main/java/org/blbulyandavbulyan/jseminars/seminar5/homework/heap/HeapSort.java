package org.blbulyandavbulyan.jseminars.seminar5.homework.heap;

import java.util.Arrays;

import static org.blbulyandavbulyan.utils.Lists.generateRandomNumbers;

/**
 * Данный класс реализует сортировку с помощью двоичной кучи
 * За основу была взята <a href="https://ru.wikipedia.org/wiki/%D0%94%D0%B2%D0%BE%D0%B8%D1%87%D0%BD%D0%B0%D1%8F_%D0%BA%D1%83%D1%87%D0%B0">статья</a>
 */
public class HeapSort {

    /**
     * Метод сортирует переданный массив с помощью двоичной кучи
     * @param arr массив, который нужно отсортировать
     */
    public static void heapSort(int[] arr) {
        buildHeap(arr);
        int heapSize = arr.length;
        for (int i = arr.length - 1; i >= 0; i--) {
            exchangeValues(arr, i, 0);
            heapify(arr, --heapSize, 0);
        }
    }

    /**
     * Данный метод строит двоичную кучу из переданного массива, по сути полный аналог метода
     * <a href="https://ru.wikipedia.org/wiki/%D0%94%D0%B2%D0%BE%D0%B8%D1%87%D0%BD%D0%B0%D1%8F_%D0%BA%D1%83%D1%87%D0%B0#%D0%9F%D0%BE%D1%81%D1%82%D1%80%D0%BE%D0%B5%D0%BD%D0%B8%D0%B5_%D0%BA%D1%83%D1%87%D0%B8">отсюда</a>
     * @param arr массив, который будет преобразован в двоичную кучу
     */
    private static void buildHeap(int[] arr) {
        for (int i = arr.length/2; i >= 0; i--) {
            heapify(arr, arr.length, i);
        }
    }

    /**
     * Метод, восстанавливающий свойства кучи
     * @param heap массив, содержащий двоичную кучу
     * @param heapSize размер двоичной кучи (может быть <= heap.length)
     * @param parentIndex индекс родительского элемента, с которого начнётся процесс восстановления
     * @throws IllegalArgumentException если heapSize не в промежутке [0; heap.length]
     * @throws IllegalArgumentException если parentIndex не в промежутке [0;heapSize)
     */
    private static void heapify(int[] heap, int heapSize, int parentIndex) {
        if (heapSize > heap.length || heapSize < 0) throw new IllegalArgumentException("heapSize must be in [0;heap.length]");
        if(parentIndex > heapSize || parentIndex < 0)throw new IllegalArgumentException("parentIndex must be in [0;heapSize)");
        int indexOfMaximumChild;//в данной переменной будет храниться индекс максимального ребёнка, если он есть у parent или -1 если нет
        int parent = parentIndex;//здесь будет индекс родителя относительно которого искался максимальный ребёнок
        //идея в чём, идея в том, чтобы если у данного родителя существует ребёнок который больше него, то нужно выбрать максимального и поменять их местами(родителя с максимальным)
        //здесь я просто на ходу присваиваю прямо в условии результат вызова функции
        //у меня были другие варианты, но там нужно было писать дополнительное условие в цикле
        while ((indexOfMaximumChild = findMaximumChildLargerThanParent(heap, heapSize, parent)) != -1){
            //если мы нашли максимальный элемент больший чем parent, то меняем их местами
            exchangeValues(heap, indexOfMaximumChild, parent);
            //переходим теперь переходим к поддереву, корнем которого был максимальный элемент
            parent = indexOfMaximumChild;
        }
    }

    /**
     * Функция меняет значения под заданными индексами местами
     * @param arr массив, в котором нужно произвести обмен
     * @param first индекс первого элемента для обмена
     * @param second индекс второго элемента для обмена
     */
    private static void exchangeValues(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    /**
     * Ищет индекс максимального ребёнка из доступных у parent, который будет больше, чем переданный родитель
     * @param heap массив, предоставляющий кучу
     * @param heapSize размер кучи
     * @param parent индекс родителя
     * @return индекс максимального ребёнка большего чем parent из доступных или -1 если нет детей, больших parent
     */
    private static int findMaximumChildLargerThanParent(int[] heap, int heapSize, int parent){
        //по сути, этот кусок кода является некоторой адаптацией кода с википедии в статье про двоичную кучу
        int largest = parent;
        int left = 2*parent + 1;
        int right = 2*parent + 2;
        if(left < heapSize && heap[left] > heap[parent]) largest = left;
        if(right < heapSize && heap[right] > heap[largest]) largest = right;
        return largest != parent ? largest : -1;
    }
}
