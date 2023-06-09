package org.blbulyandavbulyan.jseminars.seminar1.homework.core.expressionsolver;

import org.blbulyandavbulyan.jseminars.seminar1.homework.core.Calculator;

public record ExpressionSolution(int q, int w, int e, Calculator.Operation operation) {

    @Override
    public String toString() {
        return "%d %s %d = %d".formatted(q, operation.toString(), w, e);
    }
}
