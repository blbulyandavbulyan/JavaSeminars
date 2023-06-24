package org.blbulyandavbulyan.jseminars.seminar5.homework.chess;

public record Coordinates(int x, int y) {

    @Override
    public String toString() {
        return "{x=" + x + ", y=" + y + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x && y == that.y;
    }

}
