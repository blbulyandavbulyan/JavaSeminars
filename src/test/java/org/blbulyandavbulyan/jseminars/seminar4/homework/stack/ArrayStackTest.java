package org.blbulyandavbulyan.jseminars.seminar4.homework.stack;

public class ArrayStackTest extends StackTest{
    @Override
    Stack<Integer> createStack() {
        return new ArrayStack<>(Integer[]::new);
    }
}
