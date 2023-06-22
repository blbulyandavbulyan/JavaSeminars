package org.blbulyandavbulyan.jseminars.seminar5.homework.chess;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

public class HorseSolutionFinder {
    private final int N;
    private final boolean[][] visitedCells;
    private int countVisitCells = 0;
    private final ArrayList<Coordinates> foundSolution = new ArrayList<>();

    public HorseSolutionFinder(final int N) {
        this.N = N;
        visitedCells = new boolean[N][N];
    }

    public List<Coordinates> findSolution(int x, int y) {
        reset();
        markAsVisitedCell(x, y);
        boolean found = findSolution(getAvailableHorseMoves(x, y));
        if (found) {
            Collections.reverse(foundSolution);
            return foundSolution;
        } else return Collections.emptyList();
    }

    private boolean findSolution(Collection<Coordinates> availableMoves) {
        for (var availableMove : availableMoves) {
            int currentX = availableMove.getX(), currentY = availableMove.getY();
            ;
            markAsVisitedCell(currentX, currentY);
            Collection<Coordinates> availableHorseMoves = getAvailableHorseMoves(currentX, currentY);
            boolean found = findSolution(availableHorseMoves);
            if (found) {
                foundSolution.add(availableMove);
                return true;
            } else {
                markAsUnvisitedCell(currentX, currentY);
                if (availableHorseMoves.isEmpty()) return false;
            }
        }
        return countVisitCells == N * N;
    }

    private Collection<Coordinates> getAvailableHorseMoves(int currentX, int currentY) {
        return getAvailableHorseMoves(currentX, currentY, (x, y) -> x >= 0 && x < N && y >= 0 && y < N && !visitedCells[x][y]);
    }

    private void markAsVisitedCell(int x, int y) {
        visitedCells[x][y] = true;
        countVisitCells++;
    }

    private void markAsUnvisitedCell(int x, int y) {
        visitedCells[x][y] = false;
        countVisitCells--;
    }

    private static Collection<Coordinates> getAvailableHorseMoves(final int X, final int Y, BiPredicate<Integer, Integer> coordinatesValidator) {
        Collection<Coordinates> result = new ArrayList<>();
        BiConsumer<Integer, Integer> addIfValid = (x, y) -> {
            if (coordinatesValidator.test(x, y)) {
                result.add(new Coordinates(x, y));
            }
        };
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

    private void reset() {
        countVisitCells = 0;
        foundSolution.clear();
        for (var line : visitedCells) {
            Arrays.fill(line, false);
        }
    }

    public static void main(String[] args) {
        HorseSolutionFinder finder = new HorseSolutionFinder(8);
        Collection<Coordinates> result = finder.findSolution(1, 0);
        for (var coordinates : result) {
            System.out.println(coordinates);
        }
    }
}
