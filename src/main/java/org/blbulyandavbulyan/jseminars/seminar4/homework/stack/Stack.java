package org.blbulyandavbulyan.jseminars.seminar4.homework.stack;

/**
 * Предоставляет интерфейс для стека
 * @param <T> тип значения, хранимое в стеке
 */
public interface Stack <T>{
    /**
     * Получить размер стека
     * @return возвращает количество элементов, хранимых на данный момент в стеке
     */
    int size();

    /**
     * Проверяет, пуст ли стек
     * @return true если пуст, иначе false
     */
    boolean empty();

    /**
     * Помещает элемент в стек
     * @param element который нужно добавить
     * @return предыдущее значение(если оно там было) или null
     */
    T push(T element);

    /**
     * Удаляет верхний элемент из стека
     * @return удалённый элемент
     * @throws java.util.EmptyStackException если стек пуст
     */
    T pop();

    /**
     * Получает верхний элемент в стеке
     * @return верхний элемент в стеке
     * @throws java.util.EmptyStackException если стек пуст
     */
    T peek();
}
