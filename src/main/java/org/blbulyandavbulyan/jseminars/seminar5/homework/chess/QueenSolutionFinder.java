package org.blbulyandavbulyan.jseminars.seminar5.homework.chess;

import java.util.*;
import java.util.function.Consumer;

/**
 * Данный класс ищет решения задачи расстановки 8 ферзей на доске размером NxN, так чтобы они друг друга не били
 */
public class QueenSolutionFinder {
    /**
     * Текущее рассматриваемое решение
     */
    private Collection<Coordinates> currentSolutionStorage;
    /**
     * Множество найденных решений, нужно для того чтобы не рассматривать дубликаты
     */
    private final Set<Collection<Coordinates>> foundSolutions;
    /**
     * Монитор клеток
     */
    private final CellsMonitor cellsMonitor;
    /**
     * Создаёт экземпляр решателя для доски размером NxN
     * @param N размер доски
     */
    public QueenSolutionFinder(int N){
        foundSolutions = new HashSet<>();
        currentSolutionStorage = new ArrayList<>();
        cellsMonitor = new CellsMonitor(N);
    }

    /**
     * Метод ищет решения для данной задачи
     * @param solutionConsumer
     */
    public void findSolutions(Consumer<Collection<Coordinates>> solutionConsumer){
        //идея должна быть примерно такая, берём все доступные у нас клетки, ставим на первую из них королеву,
        // берём следующие все доступные клетки, перед тем как поставить туда королеву сначала проверяем,
        // не атакует ли эта королева, которую мы ставим уже имеющиеся, если атакует, откатываемся назад и берём следующую свободную клетку
        //если мы нашли вариант, при котором на доске будет стоять восемь королев, отдаём коллекцию из них в solutionConsumer
        if(currentSolutionStorage.size() == 8){
            //добавляем решение только в том случае, если мы такого ещё не находили
            if(!foundSolutions.contains(currentSolutionStorage)){
                //мы нашли решение, передаём решение нашему потребителю решений и меняем хранилище текущего решение на новое
                var unmodifiable = Collections.unmodifiableCollection(currentSolutionStorage);//оборачиваем решение в неизменяемую коллекцию
                foundSolutions.add(unmodifiable);//добавляем решение в найденные
                solutionConsumer.accept(unmodifiable);//ну и отдаём потребителю
                currentSolutionStorage = new ArrayList<>();
            }
        }
        else {
            //значит у нас не 8 ферзей
            Collection<Coordinates> emptyCells = cellsMonitor.getAllUnvisitedCells();
            for(Coordinates coordinates : emptyCells){
                //здесь нам нужен ещё одна проверка, которая покажет, можем ли мы поставить ферзя с данными координатами на доску, чтоб он никого не бил
                if(currentSolutionStorage.stream().noneMatch(addedCoordinates -> isQueenAttackAnotherFigure(coordinates, addedCoordinates))){
                    //наш ферзь никого не атакует на доске, ставим
                    cellsMonitor.markAsVisitedCell(coordinates.x(), coordinates.y());//помечаем клетку посещённой
                    currentSolutionStorage.add(coordinates);
                    findSolutions(solutionConsumer);//запускаем себя опять
                    cellsMonitor.markAsUnvisitedCell(coordinates.x(), coordinates.y());//распосещаем клетку
                    currentSolutionStorage.remove(coordinates);
                }
                //если атакует, то мы берём следующие координаты
            }
        }

    }

    /**
     * Проверяет, атакует ли королева другую фигуру
     * @param queenCoordinates координаты королевы
     * @param anotherFigureCoordinates координаты другой фигуры
     * @return true если атакует
     */
    private boolean isQueenAttackAnotherFigure(Coordinates queenCoordinates, Coordinates anotherFigureCoordinates){
        //проверка вертикальных и горизонтальных линий
        final int queenX = queenCoordinates.x();
        final int queenY = queenCoordinates.y();
        final int anotherX = anotherFigureCoordinates.x();
        final int anotherY = anotherFigureCoordinates.y();
        //проверка вертикальных и горизонтальных линий
        if(queenX == anotherX || queenY == anotherY)return true;
        //проверка диагоналей
        //я посчитал очень просто, тут наверное стоит объяснить что это за манипуляции
        //у уравнения прямой f(x) = ax+b есть коэффициент a, который показывает наклон прямой
        //через любые две точки можно провести прямую, а нас интересует чтобы коэффициент a у данной прямой через королеву и атакуемую фигуру
        //был -1 или 1, в этом случае прямая будет проходить по диагонали
        //так же тут есть ещё хитрые манипуляции, чтобы избежать появления так мною не любимого типа double
        //формула, которая получилась у меня для вычисления коэффициента a: a= (Qy - Fy)/(Qx - Fx), где Q - точка, в которой королева, а F - атакуемая фигура
        int dy = queenY - anotherY;//это ничто иное как разность Y координат королевы и атакуемой фигуры
        int dx = queenX - anotherX;//разность X координат королевы и атакуемой фигуры
        return ((dy % dx == 0) && ((dy/dx == -1)|| (dy / dx == 1)));
    }
}
