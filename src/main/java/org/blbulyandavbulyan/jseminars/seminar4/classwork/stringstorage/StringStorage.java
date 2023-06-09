package org.blbulyandavbulyan.jseminars.seminar4.classwork.stringstorage;

import java.util.function.Consumer;

public interface StringStorage {
    /**
     * Удаляет последнюю добавленную строку из хранилища
     * Ничего не делает, если нет добавленных строк
     */
    void revert();

    /**
     * Вставляет строку в заданную позицию
     * Если хранилище пусто и position = 0, то будет добавлена первая строка в хранилище
     * @param s строка для вставки
     * @param position индекс в диапазоне [0;size()), по которому нужно вставить строку
     * @throws IndexOutOfBoundsException если position выходит за доступные пределы, при условии что, position != 0 и список не пуст
     */
    void insert(String s, int position);

    /**
     * Ищет строку по переданному индексу
     * @param index индекс в диапазоне [0;size()), по которому нужно вернуть строку
     * @return найденную строку
     * @throws IndexOutOfBoundsException если индекс выходит за диапазон
     */
    String get(int index);

    /**
     * Проходится по всему хранилищу и отдаёт все строки в stringConsumer в обратном порядке
     * Если список пуст, потребитель не будет вызван
     * @param stringConsumer потребитель строк, находящихся в хранилище
     */
    void forEachReversed(Consumer<String> stringConsumer);

    /**
     * Проверяет, пусто ли хранилище
     * @return true если пусто, иначе false
     */
    boolean isEmpty();

    /**
     * Удаляет строку из списка под заданным индексом
     * @param index индекс строки, который нужно удалить
     * @throws IndexOutOfBoundsException если индекс выходит за диапазон [0;size)
     */
    void remove(int index);
}
