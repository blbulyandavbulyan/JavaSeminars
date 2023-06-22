package org.blbulyandavbulyan.jseminars.seminar5.homework.chess;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

/**
 * Данный класс позволяет найти решения, для обхода конём шахматной доски размера NxN, таким образом, чтобы конь побывал в каждой клетке ровно один раз
 * Считается, что минимальная координата коня(из допустимых - 0, 0)
 * Отрицательных координат в данной системе не бывает
 * Начало координат расположено в каком-то углу, данному классу не важно в каком оно
 * Координатные оси направлены из начала координат по сторонам доски
 */
public class HorseSolutionFinder {
    private final int N;
    private final boolean[][] visitedCells;
    private int countVisitCells = 0;
    private final ArrayList<Coordinates> foundSolution = new ArrayList<>();

    /**
     * Создаёт экземпляр данного решателя
     * @param N размер доски
     */
    public HorseSolutionFinder(final int N) {
        this.N = N;
        visitedCells = new boolean[N][N];
    }

    /**
     * Ищет искомую последовательность ходов
     * @param x стартовая координата x коня
     * @param y стартовая координата y коня
     * @return список, содержащий последовательность ходов, для обхода всей доски(не включая стартовые координаты)
     */
    public List<Coordinates> findSolution(int x, int y) {
        reset();
        markAsVisitedCell(x, y);
        boolean found = findSolution(getAvailableHorseMoves(x, y));
        if (found) {
            Collections.reverse(foundSolution);
            return foundSolution;
        } else return Collections.emptyList();
    }

    /**
     * Приватная часть метода findSolution
     * @param availableMoves доступные ходы для коня
     * @return найдено ли решение
     */
    private boolean findSolution(Collection<Coordinates> availableMoves) {
        for (var availableMove : availableMoves) {
            int currentX = availableMove.getX(), currentY = availableMove.getY();
            markAsVisitedCell(currentX, currentY);//помечаем данную клетку как посещённую
            Collection<Coordinates> availableHorseMoves = getAvailableHorseMoves(currentX, currentY);//получаем доступные ходы из текущей клетки
            boolean found = findSolution(availableHorseMoves);//рекурсивный вызов этой же функции
            //если мы нашли решение, добавляем текущую клетку в поле, содержащее последовательность ходов и возвращаем true
            if (found) {
                foundSolution.add(availableMove);
                return true;
            } else {//решение не нашли
                markAsUnvisitedCell(currentX, currentY);//помечаем данную клетку как не посещённую
                if (availableHorseMoves.isEmpty()) return false;//если нет доступных ходов из текущей клетки возвращаем false
            }
        }
        return countVisitCells == N * N;//если мы посетили N*N клеток, возвращаем true
    }

    /**
     * Помечает заданную клетку как посещённую
     * @param x абсцисса
     * @param y ордината
     */
    private void markAsVisitedCell(int x, int y) {
        visitedCells[x][y] = true;//отмечаем клетку как посещённую
        countVisitCells++;//увеличиваем количество посещённых клеток
    }
    /**
     * Помечает заданную клетку как не посещённую
     * @param x абсцисса
     * @param y ордината
     */
    private void markAsUnvisitedCell(int x, int y) {
        visitedCells[x][y] = false;//отмечаем клетку как не посещённую
        countVisitCells--;//уменьшаем количество посещённых клеток
    }
    /**
     * Ищет доступные ходы из данной клетки для коня, с учётом посещённых клеток
     * @param X координата для коня
     * @param Y координата для коня
     * @return искомую коллекцию доступных ходов или пустую коллекцию, если их нет
     */
    private Collection<Coordinates> getAvailableHorseMoves(final int X, final int Y) {
        Collection<Coordinates> result = new ArrayList<>();
        BiPredicate<Integer, Integer> coordinatesValidator =   (x, y) -> x >= 0 && x < N && y >= 0 && y < N && !visitedCells[x][y];// эта лямбда написана таким образом, что учитывает не только границы доски, но и посещённые клетки
        //вспомогательная функция для добавления значений в результат с проверкой на валидность
        //этот трюк позволяет не создавать заведомо неверный объект координат, тем самым экономя память
        BiConsumer<Integer, Integer> addIfValid = (x, y) -> {
            if (coordinatesValidator.test(x, y)) {
                result.add(new Coordinates(x, y));
            }
        };
        //тут просто все возможные варианты для коня, достаточно нарисовать их на тетрадке,
        // чтобы понять, как зависят координаты клеток, куда конь может походить от координаты клетки в которой он сейчас
        addIfValid.accept(X + 1, Y + 2);
        addIfValid.accept(X - 1, Y + 2);
        addIfValid.accept(X + 1, Y - 2);
        addIfValid.accept(X - 1, Y - 2);

        addIfValid.accept(X + 2, Y - 1);
        addIfValid.accept(X - 2, Y - 1);
        addIfValid.accept(X + 2, Y + 1);
        addIfValid.accept(X - 2, Y + 1);
        return result;
    }

    /**
     * Сбрасывает объект поиска решений в исходное состояние
     */
    private void reset() {
        countVisitCells = 0;//сбрасываем количество посещённых клеток в исходное
        foundSolution.clear();//очищаем список найденных решений
        //сбрасываем все клетки в не посещённое состояние
        for (var line : visitedCells) {
            Arrays.fill(line, false);
        }
    }
}
