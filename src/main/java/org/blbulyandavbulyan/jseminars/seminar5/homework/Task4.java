package org.blbulyandavbulyan.jseminars.seminar5.homework;

import org.blbulyandavbulyan.jseminars.seminar5.homework.chess.Coordinates;
import org.blbulyandavbulyan.jseminars.seminar5.homework.chess.HorseSolutionFinder;

import java.util.Collection;

public class Task4 {
    //4) Шахматную доску размером NxN обойти конём так, чтобы фигура в каждой клетке была строго один раз
    public static void main(String[] args) {
        HorseSolutionFinder finder = new HorseSolutionFinder(8);
        Collection<Coordinates> result = finder.findSolution(3, 3);
        for (var coordinates : result) {
            System.out.println(coordinates);
        }
    }
}
