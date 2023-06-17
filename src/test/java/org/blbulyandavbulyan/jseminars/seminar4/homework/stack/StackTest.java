package org.blbulyandavbulyan.jseminars.seminar4.homework.stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

public abstract class StackTest {
    abstract Stack<Integer> createStack();
    @Test
    public void emptyStackShouldThrowExceptionForPop(){
        var stack = createStack();
        Assertions.assertThrows(EmptyStackException.class, stack::pop);
    }
    @Test
    public void emptyStackShouldThrowExceptionForPeek(){
        var stack = createStack();
        Assertions.assertThrows(EmptyStackException.class, stack::peek);
    }
    @Test
    public void peek(){
        var stack = createStack();
        stack.push(1234);
        Assertions.assertEquals(1234, stack.peek());
        Assertions.assertEquals(1234, stack.peek());
    }
    @Test
    public void pushAndPop(){
        var stack = createStack();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        for (int i = 9; i >= 0; i--) {
            Assertions.assertEquals(i, stack.pop());
        }
    }
    @Test
    public void emptyTest(){
        var stack = createStack();
        stack.push(124);
        Assertions.assertFalse(stack.empty());
        stack.pop();
        Assertions.assertTrue(stack.empty());
    }
}
