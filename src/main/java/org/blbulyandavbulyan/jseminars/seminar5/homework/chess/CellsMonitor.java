package org.blbulyandavbulyan.jseminars.seminar5.homework.chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Данный класс предназначен для ведения учёта посещённых или не посещённых клеток
 */
class CellsMonitor {
    /**
     * Поле, содержащее посещена ли клетка(true если посещена)
     */
    private final boolean[][] visitedCells;
    /**
     * Поле содержащее количество посещённых клеток
     */
    private int countVisitCells = 0;

    /**
     * Создаёт экземпляр класса для поля с шириной size и высотой size
     * @param size ширина и высота наблюдаемого поля
     */

    public CellsMonitor(int size) {
        this.visitedCells = new boolean[size][size];
    }

    /**
     * Помечает заданную клетку как посещённую
     * @param x абсцисса клетки
     * @param y ордината клетки
     */
    public void markAsVisitedCell(int x, int y) {
        visitedCells[x][y] = true;//отмечаем клетку как посещённую
        countVisitCells++;//увеличиваем количество посещённых клеток
    }

    /**
     * Помечает заданную клетку как не посещённую
     *
     * @param x абсцисса клетки
     * @param y ордината клетки
     */
    public void markAsUnvisitedCell(int x, int y) {
        visitedCells[x][y] = false;//отмечаем клетку как не посещённую
        countVisitCells--;//уменьшаем количество посещённых клеток
    }

    /**
     * Проверяет посещена ли заданная клетка
     * @param x абсцисса клетки
     * @param y ордината клетки
     * @return true если посещена
     */
    public boolean isCellVisited(int x, int y) {
        return visitedCells[x][y];
    }

    /**
     * @return количество посещённых клеток
     */
    public int getCountVisitCells() {
        return countVisitCells;
    }

    /**
     * Метод сбрасывает объект в начальное состояние, которое было при создании
     */
    public void reset() {
        //сбрасываем все клетки в не посещённое состояние
        for (var line : visitedCells) {
            Arrays.fill(line, false);
        }
        countVisitCells = 0;//сбрасываем количество посещённых клеток в исходное
    }

    /**
     * Получает координаты всех не посещённых клеток
     * @return коллекцию координат всех непосещёных клеток
     */
    public Collection<Coordinates> getAllUnvisitedCells(){
        Collection<Coordinates> result = new ArrayList<>();
        for(int x = 0; x < visitedCells.length; x++){
            for(int y = 0; y < visitedCells[x].length; y++){
                if(!isCellVisited(x, y))result.add(new Coordinates(x, y));
            }
        }
        return result;
    }
}
