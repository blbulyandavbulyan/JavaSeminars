package org.blbulyandavbulyan.jseminars.seminar1.homework.core.expressionsolver;

class Digit {
    private final int initialValue;
    private int digit;
    private final boolean fixed;

    public Digit(int digit, boolean fixed) {
        if (!isValidDigit(digit)) throw new IllegalArgumentException("Цифра вне диапазона!");
        this.initialValue = this.digit = digit;
        this.fixed = fixed;
    }

    public void setDigit(int digit) {
        if (!fixed) {
            if (isValidDigit(digit)) {
                this.digit = digit;
            } else throw new IllegalArgumentException("Цифра вне диапазона!");
        } else throw new UnsupportedOperationException("Вы установили этот разряд как зафиксированный!");
    }

    public int getDigit() {
        return digit;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void reset() {
        digit = initialValue;
    }

    private boolean isValidDigit(int digit) {
        return digit >= 0 && digit <= 9;
    }
}
