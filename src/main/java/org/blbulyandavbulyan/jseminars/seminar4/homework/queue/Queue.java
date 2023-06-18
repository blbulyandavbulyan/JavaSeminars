package org.blbulyandavbulyan.jseminars.seminar4.homework.queue;

/**
 * Данный интерфейс предоставляет мою очередь
 * @param <T> тип элемента в очереди
 */
public interface Queue<T> {
    /**
     * Помещает элемент в конец очереди
     * @param element который нужно поместить
     */
    void enqueue(T element);

    /**
     * Удаляет первый элемент из очереди
     * @return удалённый элемент
     * @throws java.util.NoSuchElementException если очередь пуста
     */
    T dequeue();

    /**
     * Находит первый элемент в очереди и не удаляет его
     * @return первый элемент
     * @throws java.util.NoSuchElementException если очередь пуста
     */
    T first();
}
