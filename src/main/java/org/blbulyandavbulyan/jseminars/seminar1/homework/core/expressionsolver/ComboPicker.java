package org.blbulyandavbulyan.jseminars.seminar1.homework.core.expressionsolver;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.function.Supplier;
/**
 * Данный класс реализует перебор шаблонов с вопросиками, вида 5?47?7??,
 * где вместо вопросиков нужно подставить цифры
 * @author David Blbulyan
 * */
class ComboPicker {
    static class Digit {
        private final int initialValue;
        int digit;
        private final boolean fixed;

        public Digit(int digit, boolean fixed) {
            if(!isValidDigit(digit))throw new IllegalArgumentException("Цифра вне диапазона!");
            this.initialValue = this.digit = digit;
            this.fixed = fixed;
        }
        public void setDigit(int digit){
            if(!fixed){
                if(isValidDigit(digit)){
                    this.digit = digit;
                }
                else throw new IllegalArgumentException("Цифра вне диапазона!");
            }
            else throw new UnsupportedOperationException("Вы установили этот разряд как зафиксированный!");
        }
        public void reset(){
            digit = initialValue;
        }
        private boolean isValidDigit(int digit){
            return digit >= 0 && digit <= 9;
        }
    }

    //Первый элемент в массиве - самый младший разряд числа
    //т.к. так удобней использовать индекс в качестве степени десятки
    private final Digit[] digits;
    //данный массив будет хранить только разряды, в которых нет вопросика
    private final Digit[] notFixedDigits;

    private int nextCombination = 0;
    private final int maxValue; //с этим значением будет сравниваться десятичное число, представленное в notFixedDigits
    private final int initialValue;
    private int currentValue;
    public ComboPicker(String operand, Supplier<RuntimeException> exceptionSupplier) {
        if (!isValidOperand(operand)) throw exceptionSupplier.get();
        char[] digitsAndQuestions = operand.toCharArray();
        digits = new Digit[digitsAndQuestions.length];
        //тут нам нужно обойти наш массив с конца, чтобы правильно сформировать digits
        int startIndex = digitsAndQuestions.length - 1;
        for(int i = startIndex; i >= 0; i--){
            int digitPower = startIndex - i;
            char questionOrDigit = digitsAndQuestions[i];
            if(Character.isDigit(questionOrDigit)){
                digits[digitPower] = new Digit(questionOrDigit - '0', true);
            }
            else {
                digits[digitPower] = new Digit(i != 0 ? 0 : 1, false);
            }

            nextCombination +=digits[digitPower].digit*(int)Math.pow(10, digitPower);
        }
        notFixedDigits = Arrays.stream(digits).filter(d->!d.fixed).toArray(Digit[]::new);
        int currentMaxValue = 0;
        for (int notFixedDigitPower = 0; notFixedDigitPower < notFixedDigits.length; notFixedDigitPower++) {
            int d = (int) Math.pow(10, notFixedDigitPower);
            currentMaxValue+=9*d;
            currentValue+=notFixedDigits[notFixedDigitPower].digit*d;
        }
        this.initialValue = currentValue;
        this.maxValue = currentMaxValue;
    }
    /**
     * Проверяет, есть ли следующая комбинация
     * @return True если есть, False если нет
     * */
    public boolean hasNext(){
        return currentValue <= maxValue;
    }
    /**
     * Взять текущую комбинацию и перейти к следующей
     * @return текущая комбинация
     * @throws NoSuchElementException если нет больше комбинаций
     * */
    public int next() {
        // FIXME: 08.06.2023 Сделать чтобы возвращал следующую комбинацию
        if(hasNext()){
            int oldCombination = nextCombination;
            if(++currentValue <= maxValue){
                //в этом случае нам нужно пройтись циклом по нашему currentValue и вытащить оттуда все цифры
                //и записать их в соответсвующем порядке в notFixedDigits
                int currentNumber = currentValue;
                for (Digit notFixedDigit : notFixedDigits) {
                    notFixedDigit.digit = currentNumber % 10;
                    currentNumber /= 10;
                }
                nextCombination = calculate();
            }
            return oldCombination;
        }
        else throw new NoSuchElementException("Нет следующей комбинации!!");
    }
    private int calculate(){
        int result = 0;
        for (int powerOfDigit = 0; powerOfDigit < digits.length; powerOfDigit++) {
            result+=digits[powerOfDigit].digit*Math.pow(10, powerOfDigit);
        }
        return result;
    }
    /**
     * Сбрасывает перебиратор в начальное состояние (какое было инициализировано конструктором
     * */
    public void reset() {
        // FIXME: 08.06.2023 сделать чтобы метод сбрасывал переборщик в начальное состояние
        currentValue = initialValue;
        for (Digit notFixedDigit : notFixedDigits) {
            notFixedDigit.reset();
        }
        nextCombination = calculate();
    }

    private boolean isValidOperand(String s) {
        return s.matches("[\\d|?]+");
    }
}
