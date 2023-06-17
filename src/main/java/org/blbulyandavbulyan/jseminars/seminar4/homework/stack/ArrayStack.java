package org.blbulyandavbulyan.jseminars.seminar4.homework.stack;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Предоставляет реализацию стека, на основе ArrayList
 * @param <T> тип элемента, хранимый в стеке
 */
public class ArrayStack<T> implements Stack<T>{
    private T[] array;
    private int size = 0;
    private Function<Integer, T[]> arrayCreator;

    /**
     * Создаёт пустой стек
     * @param arrayCreator функция, создающая массив требуемого типа заданного размера
     */
    public ArrayStack(Function<Integer, T[]> arrayCreator){
        this.arrayCreator = arrayCreator;
        //несмотря на то, что создание пустого массива может показаться странным, но в данном случае это довольно удобно
        this.array = arrayCreator.apply(0);
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean empty() {
        return size() == 0;
    }

    @Override
    public T push(T element) {
        //значит нам некуда добавить новый элемент
        T result = null;
        if(size == array.length){
            if(array.length > 0){
                T[] copyOfArray = Arrays.copyOf(array, array.length);
                array = arrayCreator.apply(array.length * 2);
                System.arraycopy(copyOfArray, 0, array, 0, copyOfArray.length);
                array[copyOfArray.length] = element;
                size = copyOfArray.length + 1;
                result = array[copyOfArray.length - 1];
            }
            else{
                array = arrayCreator.apply(4);
                array[size++] = element;
            }

        }
        else if(size < array.length){
            result = array[size - 1];
            array[size++] = element;
        }
        return result;
    }

    @Override
    public T pop() {
        if(size == 0)throw new EmptyStackException();
        else if(size > 0) return array[--size];
        else throw new IllegalStateException("Размер стэка меньше нуля!");
    }

    @Override
    public T peek() {
        if(size == 0)throw new EmptyStackException();
        else if(size > 0)return array[size - 1];
        else throw new IllegalArgumentException("Размер стэка меньше нуля!");
    }
}
