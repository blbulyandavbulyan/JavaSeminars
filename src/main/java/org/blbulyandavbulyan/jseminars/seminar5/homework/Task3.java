package org.blbulyandavbulyan.jseminars.seminar5.homework;

import org.blbulyandavbulyan.jseminars.seminar5.homework.chess.QueenSolutionFinder;

public class Task3 {
    //3) На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга
    public static void main(String[] args) {
        QueenSolutionFinder finder = new QueenSolutionFinder(8);
        finder.findSolutions(solution->{
            System.out.println(solution);
            System.out.println();
        });
    }
}
